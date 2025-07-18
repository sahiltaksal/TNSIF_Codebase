package com.tnsif.bankingsystem.admin;

import com.tnsif.bankingsystem.model.*;

import java.util.List;


public interface AdminService 
{
    boolean verifyCustomer(int customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerById(int customerId);

    List<Account> getAccountsByCustomer(int customerId);

    List<Beneficiary> getBeneficiariesByCustomer(int customerId);

    List<Transaction> getTransactionsByCustomerAndType(int customerId, String type);

}
