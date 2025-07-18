package com.tnsif.overriding;

public class ICICI extends SBI{

	
	@Override
	public float getRateofInterest() {
		
		System.out.println("ICICI");
		return 7.5f;
	}
}
