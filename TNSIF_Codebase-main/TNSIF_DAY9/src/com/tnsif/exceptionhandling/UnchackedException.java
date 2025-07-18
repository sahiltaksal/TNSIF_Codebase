package com.tnsif.exceptionhandling;


public class UnchackedException {
	public static void main(String[] args) {
		
		int x[];
		
		try {
			x=new int[] {1,2,3,4,5,6};
			
			System.out.println(x[2]);
			System.out.println(x[0]);
			System.out.println(x[8]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Specified index does not exist: "+ e.getMessage());
		}
	}

}