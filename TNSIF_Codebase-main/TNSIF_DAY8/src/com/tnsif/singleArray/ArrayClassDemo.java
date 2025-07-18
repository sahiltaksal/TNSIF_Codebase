package com.tnsif.singleArray;

import java.util.Arrays;

public class ArrayClassDemo {
	
	public static void main(String[] args) {
		
		//get the array
		
		int intarr[]= {20,30,40,52,62,22,5};
		//print array
		
		System.out.println(Arrays.toString(intarr));
		
		//sort
		
	Arrays.sort(intarr);
	System.out.println(Arrays.toString(intarr ));

	long[] intarr2 = null;
	//fill method
	Arrays.fill(intarr2, 7);
	}

}
