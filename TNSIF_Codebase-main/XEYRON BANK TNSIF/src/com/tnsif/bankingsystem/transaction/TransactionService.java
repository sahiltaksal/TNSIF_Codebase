package com.tnsif.bankingsystem.transaction;


public interface TransactionService {

    boolean deposit(int accountId, int customerId, double amount);

    boolean withdraw(int accountId, int customerId, double amount);

    boolean transfer(int fromAccountId, int customerId, int toAccountId, double amount);
}
