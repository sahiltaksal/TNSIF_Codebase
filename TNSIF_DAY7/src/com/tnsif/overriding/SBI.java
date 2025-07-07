package com.tnsif.overriding;

public class SBI extends RBI {
	
	@Override
	public float getRateofInterest() {

		System.out.println("After charges");
		
		return 7.0f;
	}

}
