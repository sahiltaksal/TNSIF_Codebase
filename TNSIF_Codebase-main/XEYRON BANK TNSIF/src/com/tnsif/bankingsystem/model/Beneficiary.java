package com.tnsif.bankingsystem.model;


public class Beneficiary {
    private int beneficiaryId;
    private int customerId;      // Who added this beneficiary
    private String name;
    private int accountNumber;   // Beneficiary account number
    private String bankDetails;  // Optional (e.g., Bank Name)

    public Beneficiary() {}

    public Beneficiary(int beneficiaryId, int customerId, String name, int accountNumber, String bankDetails) {
        this.beneficiaryId = beneficiaryId;
        this.customerId = customerId;
        this.name = name;
        this.accountNumber = accountNumber;
        this.bankDetails = bankDetails;
    }

    public int getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(int beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
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

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(String bankDetails) {
        this.bankDetails = bankDetails;
    }

    @Override
    public String toString() {
        return "Beneficiary ID: " + beneficiaryId +
               ", Name: " + name +
               ", Account No: " + accountNumber +
               ", Bank: " + bankDetails;
    }
}
