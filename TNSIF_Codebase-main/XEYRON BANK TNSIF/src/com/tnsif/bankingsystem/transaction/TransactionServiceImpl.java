package com.tnsif.bankingsystem.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tnsif.bankingsystem.util.DatabaseManager;

public class TransactionServiceImpl implements TransactionService {

    private Connection conn;

    public TransactionServiceImpl() {
        this.conn = DatabaseManager.getConnection();
    }

    @Override
    public boolean deposit(int accountId, int customerId, double amount) {
        try {
            // Check ownership
            PreparedStatement psCheck = conn.prepareStatement(
                "SELECT customer_id FROM accounts WHERE account_id = ?"
            );
            psCheck.setInt(1, accountId);
            ResultSet rs = psCheck.executeQuery();
            if (!rs.next()) {
                return false; // Account does not exist
            }
            int ownerId = rs.getInt("customer_id");
            if (ownerId != customerId) {
                return false; // Not your account
            }

            // Update balance
            PreparedStatement ps = conn.prepareStatement(
                "UPDATE accounts SET balance = balance + ? WHERE account_id = ?"
            );
            ps.setDouble(1, amount);
            ps.setInt(2, accountId);
            ps.executeUpdate();

            // Record transaction
            PreparedStatement tx = conn.prepareStatement(
                "INSERT INTO transactions (account_id, type, amount) VALUES (?, 'Deposit', ?)"
            );
            tx.setInt(1, accountId);
            tx.setDouble(2, amount);
            tx.executeUpdate();

            return true;
        } catch (SQLException e) {
        	System.out.println("An error occurred while processing your request. Please try again later.");
            return false;
        }
    }

    @Override
    public boolean withdraw(int accountId, int customerId, double amount) {
        try {
            // Check ownership and balance
            PreparedStatement psCheck = conn.prepareStatement(
                "SELECT customer_id, balance FROM accounts WHERE account_id = ?"
            );
            psCheck.setInt(1, accountId);
            ResultSet rs = psCheck.executeQuery();
            if (!rs.next()) {
                return false; // Account does not exist
            }
            int ownerId = rs.getInt("customer_id");
            double balance = rs.getDouble("balance");
            if (ownerId != customerId) {
                return false; // Not your account
            }
            if (balance < amount) {
                return false; // Insufficient funds
            }

            // Update balance
            PreparedStatement ps = conn.prepareStatement(
                "UPDATE accounts SET balance = balance - ? WHERE account_id = ?"
            );
            ps.setDouble(1, amount);
            ps.setInt(2, accountId);
            ps.executeUpdate();

            // Record transaction
            PreparedStatement tx = conn.prepareStatement(
                "INSERT INTO transactions (account_id, type, amount) VALUES (?, 'Withdrawal', ?)"
            );
            tx.setInt(1, accountId);
            tx.setDouble(2, amount);
            tx.executeUpdate();

            return true;
        } catch (SQLException e) {
        	System.out.println("An error occurred while processing your request. Please try again later.");
            return false;
        }
    }

    @Override
    public boolean transfer(int fromAccountId, int customerId, int toAccountId, double amount) {
        try {
            conn.setAutoCommit(false); // Begin transaction

            // 1. Check ownership and balance
            PreparedStatement psCheck = conn.prepareStatement(
                "SELECT customer_id, balance FROM accounts WHERE account_id = ?"
            );
            psCheck.setInt(1, fromAccountId);
            ResultSet rs = psCheck.executeQuery();
            if (!rs.next()) {
                conn.rollback();
                return false; // From account does not exist
            }
            int ownerId = rs.getInt("customer_id");
            double balance = rs.getDouble("balance");
            if (ownerId != customerId) {
                conn.rollback();
                return false; // Not your account
            }
            if (balance < amount) {
                conn.rollback();
                return false; // Insufficient funds
            }

            // 2. Deduct from source account
            PreparedStatement psWithdraw = conn.prepareStatement(
                "UPDATE accounts SET balance = balance - ? WHERE account_id = ?"
            );
            psWithdraw.setDouble(1, amount);
            psWithdraw.setInt(2, fromAccountId);
            psWithdraw.executeUpdate();

            // 3. Credit to target account
            PreparedStatement psDeposit = conn.prepareStatement(
                "UPDATE accounts SET balance = balance + ? WHERE account_id = ?"
            );
            psDeposit.setDouble(1, amount);
            psDeposit.setInt(2, toAccountId);
            int rowsAffected = psDeposit.executeUpdate();
            if (rowsAffected == 0) {
                conn.rollback();
                return false; // To account does not exist
            }

            // 4. Record transfer transaction
            PreparedStatement tx = conn.prepareStatement(
                "INSERT INTO transactions (account_id, type, amount) VALUES (?, 'Transfer', ?)"
            );
            tx.setInt(1, fromAccountId);
            tx.setDouble(2, amount);
            tx.executeUpdate();

            conn.commit();
            return true;
        } catch (SQLException e) {
            try { conn.rollback(); } catch (SQLException ignored) {}
            System.out.println("An error occurred while processing your request. Please try again later.");
            return false;
        } finally {
            try { conn.setAutoCommit(true); } catch (SQLException ignored) {}
        }
    }
}
