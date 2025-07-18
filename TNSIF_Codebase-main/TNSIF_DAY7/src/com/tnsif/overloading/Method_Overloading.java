package com.tnsif.overloading;

public class Method_Overloading {
	
	public static int addition (int a,int b) {
		return a+b;
		
		
	}
	
	public static float addition (Float a,Float b) {
		return a+b;
		
		
	}
	public static float addition (Float a,int b) {
		return a+b;
		
		
	}
	public static float addition (int a, Float b) {
		return a+b;
		
		
	}
	public static int addition (int a,int b,int c) {
		return a+b+c;
		
		
	}

}
