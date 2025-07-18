package com.tnsif.overriding;

public class Overriding_Main_Class {
	public static void main(String[] args) {
		
		RBI rbi;
		//Dynamic dispatch
		
		rbi=new SBI();
		System.out.println(rbi.getRateofInterest());
		rbi=new HDFC();
		System.out.println(rbi.getRateofInterest());
	}

}
