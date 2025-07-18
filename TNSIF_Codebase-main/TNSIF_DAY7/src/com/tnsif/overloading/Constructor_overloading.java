package com.tnsif.overloading;

public class Constructor_overloading {

	public Constructor_overloading() {
	
		System.out.println("Default constructor");
	}

	public Constructor_overloading(int a) {
		
		System.out.println("Constructor with one parameter");
		System.out.println(a);
	}

	public Constructor_overloading(int a,int b) {

		System.out.println(a);
		System.out.println(b);
		System.out.println("Constructor with two parameter");
		
	}

	
	
}
