package com.tnsif.exceptionhandling;

public class UnCheckedException {
public static void main(String[] args) {
	

	int x[];
	
	try {
		x=new int[]	{1,2,3,5,6,4,5	} ;
		
		System.out.println(x[2]);
		System.out.println(x[8]);
	}
		catch (ArrayIndexOutOfBoundsException e) {
		System.err.println("specified index not defined in array");
	}
}
}