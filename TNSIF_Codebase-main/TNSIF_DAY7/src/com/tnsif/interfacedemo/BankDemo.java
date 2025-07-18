package com.tnsif.interfacedemo;

public class BankDemo {

	public static void main(String[] args) {
		
		SavingAccount s1 =new SavingAccount(121, 500000, "sahil", "pune");
		
		System.out.println(s1);
		s1.deposit(10000);
		System.out.println(s1);
		
		s1.withdraw(510000000f);
		System.out.println(s1);
	}
	

}
