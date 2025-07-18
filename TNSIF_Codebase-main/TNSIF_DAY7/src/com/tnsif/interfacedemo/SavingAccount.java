package com.tnsif.interfacedemo;

public class SavingAccount extends Customer implements Bank {

	private int AcNO;
	private float balance;
	
	
	public SavingAccount(int acNO, float balance,String name, String city) {
		super(name,city);
		AcNO = acNO;
		this.balance = balance;
	}

	@Override
	public void deposit(float amount) {
		
		if (amount<0 || amount > Deposit_Limit) {
			System.out.println("Please deposit valid amount");
			
		}
		else {
			
			balance+=amount;
			System.out.println("RS :"+ amount +"is deposited......." );
		}
	}

	@Override
	public void withdraw(float amount) {
		if (amount <= balance-MinBal) {
			
			balance-=amount;
			System.out.println("Rs : "+amount+"Withdrawal ");
			
		}
		else {
			System.out.println("Insufficient Balance");
		}
		
		
	}
	

	@Override
	public String toString() {
		return "SavingAccount [AcNO=" + AcNO + ", balance=" + balance + ", Name=" + getName() + ", City="
				+ getCity() + "]";
	}
	
	

}
