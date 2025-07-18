package com.tnsif.bankingsystem.admin;

import com.tnsif.bankingsystem.customer.*;
import com.tnsif.bankingsystem.model.*;
import com.tnsif.bankingsystem.util.DatabaseManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AdminServiceImpl implements AdminService {

    private Connection conn = DatabaseManager.getConnection();
    
    private CustomerService customerService = new CustomerServiceImpl();


    @Override
    public boolean verifyCustomer(int customerId) {
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "UPDATE CUSTOMERS SET verified = ? WHERE customer_id = ?"
            );
            ps.setBoolean(1, true);
            ps.setInt(2, customerId);
            int updated = ps.executeUpdate();
            return updated > 0;
        } catch (SQLException e) {
        	System.out.println("An error occurred while processing your request. Please try again later.");
            return false;
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM CUSTOMERS");
            while (rs.next()) {
                customers.add(new Customer(
                        rs.getInt("customer_id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("contact"),
                        rs.getString("password"),
                        rs.getBoolean("verified")
                ));
            }
        } catch (SQLException e) {
        	System.out.println("An error occurred while processing your request. Please try again later.");
        }
        return customers;
    }

    @Override
    public Customer getCustomerById(int customerId) {
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM CUSTOMERS WHERE customer_id = ?"
            );
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Customer(
                        rs.getInt("customer_id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("contact"),
                        rs.getString("password"),
                        rs.getBoolean("verified")
                );
            }
        } catch (SQLException e) {
        	System.out.println("An error occurred while processing your request. Please try again later.");
        }
        return null;
    }
    
    
    @Override
    public List<Account> getAccountsByCustomer(int customerId) {
        return customerService.getAccountsByCustomer(customerId);
    }

    @Override
    public List<Beneficiary> getBeneficiariesByCustomer(int customerId) {
        return customerService.getBeneficiariesByCustomer(customerId);
    }


    @Override
    public List<Transaction> getTransactionsByCustomerAndType(int customerId, String type) {
        return customerService.getTransactionsByCustomerAndType(customerId, type);
    }

}
