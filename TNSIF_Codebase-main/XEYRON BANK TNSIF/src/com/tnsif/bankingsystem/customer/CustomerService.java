package com.tnsif.bankingsystem.customer;

import com.tnsif.bankingsystem.model.Account;
import com.tnsif.bankingsystem.model.Beneficiary;
import com.tnsif.bankingsystem.model.Transaction;
import java.util.List;


public interface CustomerService {

    boolean registerCustomer(int customerId, String name, String address, String contact, String password);

    boolean authenticateCustomer(int customerId, String password);

    boolean isCustomerVerified(int customerId);

    boolean createAccount(Account account);

    List<Account> getAccountsByCustomer(int customerId);

    boolean addBeneficiary(Beneficiary beneficiary);

    List<Beneficiary> getBeneficiariesByCustomer(int customerId);

    List<Transaction> getTransactionsByAccount(int accountId);
    
    List<Transaction> getTransactionsByCustomerAndType(int customerId, String type);

}
