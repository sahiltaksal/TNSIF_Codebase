package com.tnsif.string;

import java.lang.classfile.instruction.NewMultiArrayInstruction;

public class StringOperationDemo {

	public static void main(String[] args) {
		
		
		//creating string using literals //pool memory
		
		String s1 ="TNSIF";
		String s2="TNSIF";
		
		//Creating new string operator // heap memory
		
		
		String s3= new String("TNSIF");
		String S4= new String("TNSIF");
		
		
		//== EQUALS
		
		
		System.out.println("case 1: "+ (s1==s2));
		System.out.println("case 2: "+ (s1==s3));
		System.out.println("case 3: "+ (s2.equals(s1)));
		System.out.println("case 4: "+ (s2.equals(S4)));
		System.out.println("case 5: "+(s3==S4));
		System.out.println("case 6: "+(s3.equals(S4)));
		
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		
		//compare by using compareTO
		
		System.out.println(s1.compareTo(S4));
		System.out.println(s1.compareToIgnoreCase(S4));
		
		
	}

}
