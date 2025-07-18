package com.tnsif.array;

public class NewArrayDemo {
	public static void main(String[] args) {

		int a[];
		a = new int[10];
		
		for (int i = 0; i < a.length; i++) {
			a[i]=5*i
;		}
		ArrayOperation.printArray(a);
		int b[]= {10,30,30,40,50};
		ArrayOperation.printArray(b);
		System.out.println("Sum of arrays is: "+ArrayOperation.getSum(b));
		
		
		int c[]= {11,32,33,44,50};
		
		ArrayOperation.printArray(c);
		System.out.println("Toatal Even Number: "+ArrayOperation.getEvenCount(c));
		System.out.println("Toatal Odd Number: "+ArrayOperation.getOddCount(c));
		

		
		
		
	}
}