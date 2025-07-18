package com.tnsif.bankingsystem.model;

import java.time.LocalDateTime;


public class Transaction {
    private int transactionId;
    private int accountId;
    private String type; // Deposit, Withdrawal, Transfer
    private double amount;
    private LocalDateTime timestamp;

    public Transaction() {}

    public Transaction(int transactionId, int accountId, String type, double amount, LocalDateTime timestamp) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public Transaction(int accountId, String type, double amount) {
        this.accountId = accountId;
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Transaction ID: " + transactionId +
               ", Type: " + type +
               ", Amount: " + amount +
               ", Timestamp: " + timestamp;
    }
}
