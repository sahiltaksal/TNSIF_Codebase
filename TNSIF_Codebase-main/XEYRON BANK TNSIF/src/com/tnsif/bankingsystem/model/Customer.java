package com.tnsif.bankingsystem.model;


public class Customer {
    private int customerId;
    private String name;
    private String address;
    private String contact;
    private String password;
    private boolean verified;

    public Customer() {}

    public Customer(int customerId, String name, String address, String contact, String password, boolean verified) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.password = password;
        this.verified = verified;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    @Override
    public String toString() {
        return "Customer ID: " + customerId + ", Name: " + name + ", Verified: " + verified;
    }
}
