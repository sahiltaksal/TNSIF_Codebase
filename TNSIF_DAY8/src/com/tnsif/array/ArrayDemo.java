package com.tnsif.array;

import java.util.Arrays;

public class ArrayDemo {
	public static void main(String[] args) {
		// get the array
		int[] intArr = { 69, 20, 12, 40, 35 };
		System.out.println(Arrays.toString(intArr));

		for (int i : intArr) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		
		// Sort
		Arrays.sort(intArr);
		System.out.println(Arrays.toString(intArr));
		
		// binary search
		System.out.println(Arrays.binarySearch(intArr, 69));  // If not found then give where it can be added in sorted array
		System.out.println(Arrays.binarySearch(intArr, 9));
		
		int  intArr1[]={69, 20, 12, 40, 35};
		Arrays.sort(intArr1);
		
		
		//  Compare
		if(Arrays.compare(intArr, intArr1)==0){
			System.out.println("Both array are same");
		}
		else {
			System.out.println("Both array are not same");
		}
		// Copy Array
		int intArr2[]=Arrays.copyOf(intArr1, 3);
		System.out.println(Arrays.toString(intArr2));
		int intArr3[]=Arrays.copyOfRange(intArr1, 3, 5);
		System.out.println(Arrays.toString(intArr3));
		int []  intArr4= new int[5];
		Arrays.fill(intArr4, 7);
		System.out.println(Arrays.toString(intArr4));

	}

}