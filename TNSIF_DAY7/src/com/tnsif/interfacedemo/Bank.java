package com.tnsif.interfacedemo;

public interface Bank {
	
	final static float MinBal=5000;
	final static float Deposit_Limit=25000;
	
	
	public void deposit(float amount);
	public void withdraw(float amount);

}
