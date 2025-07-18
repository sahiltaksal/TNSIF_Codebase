package com.tnsif.bankingsystem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseManager {

    private static final String URL = "jdbc:mysql://localhost:3306/bankingsystemdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static Connection connection;

    public static void initialize() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = connection.createStatement();

            // Create CUSTOMERS table
            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS CUSTOMERS (
                    customer_id INT PRIMARY KEY,
                    name VARCHAR(100),
                    address VARCHAR(200),
                    contact VARCHAR(50),
                    password VARCHAR(100),
                    verified BOOLEAN
                )
            """);

            // Create ACCOUNTS table
            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS ACCOUNTS (
                    account_id INT PRIMARY KEY,
                    customer_id INT,
                    type VARCHAR(20),
                    balance DOUBLE,
                    FOREIGN KEY (customer_id) REFERENCES CUSTOMERS(customer_id)
                )
            """);

            // Create TRANSACTIONS table
            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS TRANSACTIONS (
                    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
                    account_id INT,
                    type VARCHAR(20),
                    amount DOUBLE,
                    timestamp TIMESTAMP,
                    FOREIGN KEY (account_id) REFERENCES ACCOUNTS(account_id)
                )
            """);

            // Create BENEFICIARIES table
            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS BENEFICIARIES (
                    beneficiary_id INT PRIMARY KEY,
                    customer_id INT,
                    name VARCHAR(100),
                    account_number INT,
                    bank_details VARCHAR(100),
                    FOREIGN KEY (customer_id) REFERENCES CUSTOMERS(customer_id)
                )
            """);

            stmt.close();
            System.out.println("✅ Database initialized successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void close() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("✅ Database connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
