package com.tnsif.bankingsystem.model;


public class Account {
    private int accountId;
    private int customerId;
    private String type;
    private double balance;

    public Account() {}

    public Account(int accountId, int customerId, String type, double balance) {
        this.accountId = accountId;
        this.customerId = customerId;
        this.type = type;
        this.balance = balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account ID: " + accountId +
               ", Customer ID: " + customerId +
               ", Type: " + type +
               ", Balance: " + balance;
    }
}

