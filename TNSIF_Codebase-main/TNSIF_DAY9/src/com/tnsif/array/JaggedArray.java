package com.tnsif.array;

public class JaggedArray {
	static void printarray(int c[][]) {
		System.out.println("array elements are as follow");
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				
				System.out.println(c[i] [j]+" ");
				
			}
			System.out.println();
		}
		
		
	}

}
