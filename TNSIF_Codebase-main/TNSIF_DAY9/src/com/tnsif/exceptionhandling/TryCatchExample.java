package com.tnsif.exceptionhandling;

public class TryCatchExample {
	
	public static void performDivision(int x,int y) {
		
		System.out.println("i am method");
		try {
			System.out.println("i am try block");
		int z=	 x/ y;
		System.out.println("Division of two number "+z);
		} catch (Exception e) {
			System.out.println("cannot divide by zero");
		}
	}

}
