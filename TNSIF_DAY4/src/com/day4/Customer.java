package com.day4;

import java.lang.invoke.StringConcatFactory;

public class Customer {

	
	private String customerName;
	private int customerId;
	private String customerCity;
	
	//Default constructor
	public Customer() {
		
		System.out.println("Hello this is Default constructor......!");
	}
    //Parameterized constructor
	public Customer(String customerName, int customerId, String customerCity) {
	this();
	
	 System.out.println("Hello this is parameterized constructor");
		this.customerName = customerName;
		this.customerId = customerId;
		this.customerCity = customerCity;
	}
	
	
	//getter setter
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerCity( ) {
		return customerCity;
	}
	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}
	//to string
	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", customerId=" + customerId + ", customerCity="
				+ customerCity + "]";
	}
	
	
}
