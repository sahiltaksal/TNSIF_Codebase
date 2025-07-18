package com.tnsif.bankingsystem.customer;

import com.tnsif.bankingsystem.model.Account;
import com.tnsif.bankingsystem.model.Beneficiary;
import com.tnsif.bankingsystem.model.Transaction;
import com.tnsif.bankingsystem.util.DatabaseManager;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class CustomerServiceImpl implements CustomerService {

    private Connection conn = DatabaseManager.getConnection();

    @Override
    public boolean registerCustomer(int customerId, String name, String address, String contact, String password) {
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO CUSTOMERS (customer_id, name, address, contact, password, verified) VALUES (?, ?, ?, ?, ?, ?)"
            );
            ps.setInt(1, customerId);
            ps.setString(2, name);
            ps.setString(3, address);
            ps.setString(4, contact);
            ps.setString(5, password);
            ps.setBoolean(6, false); // Not verified initially
            int inserted = ps.executeUpdate();
            return inserted > 0;
        } catch (SQLException e) {
        	System.out.println("An error occurred while processing your request. Please try again later.");
            return false;
        }
    }

    @Override
    public boolean authenticateCustomer(int customerId, String password) {
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM CUSTOMERS WHERE customer_id = ? AND password = ? AND verified = ?"
            );
            ps.setInt(1, customerId);
            ps.setString(2, password);
            ps.setBoolean(3, true);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
        	System.out.println("An error occurred while processing your request. Please try again later.");
            return false;
        }
    }

    @Override
    public boolean isCustomerVerified(int customerId) {
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT verified FROM CUSTOMERS WHERE customer_id = ?"
            );
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getBoolean("verified");
            }
        } catch (SQLException e) {
        	System.out.println("An error occurred while processing your request. Please try again later.");
        }
        return false;
    }

    @Override
    public boolean createAccount(Account account) {
        try {
            // Check if account ID already exists
            PreparedStatement check = conn.prepareStatement(
                    "SELECT * FROM ACCOUNTS WHERE account_id = ?"
            );
            check.setInt(1, account.getAccountId());
            ResultSet rs = check.executeQuery();
            if (rs.next()) {
                return false; // Account already exists
            }

            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO ACCOUNTS (account_id, customer_id, type, balance) VALUES (?, ?, ?, ?)"
            );
            ps.setInt(1, account.getAccountId());
            ps.setInt(2, account.getCustomerId());
            ps.setString(3, account.getType());
            ps.setDouble(4, account.getBalance());
            int inserted = ps.executeUpdate();
            return inserted > 0;
        } catch (SQLException e) {
        	System.out.println("An error occurred while processing your request. Please try again later.");
            return false;
        }
    }

    @Override
    public List<Account> getAccountsByCustomer(int customerId) {
        List<Account> accounts = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM ACCOUNTS WHERE customer_id = ?"
            );
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                accounts.add(new Account(
                        rs.getInt("account_id"),
                        rs.getInt("customer_id"),
                        rs.getString("type"),
                        rs.getDouble("balance")
                ));
            }
        } catch (SQLException e) {
        	System.out.println("An error occurred while processing your request. Please try again later.");
        }
        return accounts;
    }

    @Override
    public boolean addBeneficiary(Beneficiary beneficiary) {
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO BENEFICIARIES (beneficiary_id, customer_id, name, account_number, bank_details) VALUES (?, ?, ?, ?, ?)"
            );
            ps.setInt(1, beneficiary.getBeneficiaryId());
            ps.setInt(2, beneficiary.getCustomerId());
            ps.setString(3, beneficiary.getName());
            ps.setInt(4, beneficiary.getAccountNumber());
            ps.setString(5, beneficiary.getBankDetails());
            int inserted = ps.executeUpdate();
            return inserted > 0;
        } catch (SQLException e) {
        	System.out.println("An error occurred while processing your request. Please try again later.");
            return false;
        }
    }

    @Override
    public List<Beneficiary> getBeneficiariesByCustomer(int customerId) {
        List<Beneficiary> beneficiaries = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM BENEFICIARIES WHERE customer_id = ?"
            );
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                beneficiaries.add(new Beneficiary(
                        rs.getInt("beneficiary_id"),
                        rs.getInt("customer_id"),
                        rs.getString("name"),
                        rs.getInt("account_number"),
                        rs.getString("bank_details")
                ));
            }
        } catch (SQLException e) {
        	System.out.println("An error occurred while processing your request. Please try again later.");
        }
        return beneficiaries;
    }

    @Override
    public List<Transaction> getTransactionsByAccount(int accountId) {
        List<Transaction> transactions = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM TRANSACTIONS WHERE account_id = ? ORDER BY timestamp DESC"
            );
            ps.setInt(1, accountId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Timestamp ts = rs.getTimestamp("timestamp");
                LocalDateTime time = (ts != null) ? ts.toLocalDateTime() : LocalDateTime.now();

                Transaction t = new Transaction(
                    rs.getInt("transaction_id"),
                    rs.getInt("account_id"),
                    rs.getString("type"),
                    rs.getDouble("amount"),
                    time
                );
                transactions.add(t);
            }

        } catch (SQLException e) {
        	System.out.println("An error occurred while processing your request. Please try again later.");
        }
        return transactions;
    }
    
    @Override
    public List<Transaction> getTransactionsByCustomerAndType(int customerId, String type) {
        List<Transaction> transactions = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(
                "SELECT t.* FROM TRANSACTIONS t " +
                "JOIN ACCOUNTS a ON t.account_id = a.account_id " +
                "WHERE a.customer_id = ? AND t.type = ? " +
                "ORDER BY t.timestamp DESC"
            );
            ps.setInt(1, customerId);
            ps.setString(2, type);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Timestamp ts = rs.getTimestamp("timestamp");
                LocalDateTime time = (ts != null) ? ts.toLocalDateTime() : LocalDateTime.now();
                transactions.add(new Transaction(
                    rs.getInt("transaction_id"),
                    rs.getInt("account_id"),
                    rs.getString("type"),
                    rs.getDouble("amount"),
                    time
                ));
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while fetching transactions.");
        }
        return transactions;
    }

}
