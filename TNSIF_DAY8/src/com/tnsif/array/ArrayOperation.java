package com.tnsif.array;

public class ArrayOperation {
	public static void printArray(int [] arr) {
		for (int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	public static int getSum(int ... arr) {
	int sum=0;
	for (int i : arr) {
		sum+=i;
	}
	return sum;
	}
	
	public static int getOddCount (int b[]) {
		int cnt=0;
		for (int i : b) {
			if (i%2!=0) {
				cnt++;
			}
		}
		return cnt;
	}
	public static int getEvenCount (int b[]) {
		
		return b.length-getOddCount(b);
	}
}
