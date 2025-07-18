package com.tnsif.array;

class MlArray{
	
	static void printArray(int c[][]) {
		
		System.out.println("array of elements are as follows");
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				System.out.println(c[i] [j]+" ");
				
			}
			System.out.println();
		}
		
	}
}

public class MultiDimension {
	public static void main(String[] args) {
		
		int c [] []= {{12,34,52},{52,78,98},{1,2,3}};
		System.out.println("no of row in c array : "+c.length);
		MlArray.printArray(c);
	}

}
