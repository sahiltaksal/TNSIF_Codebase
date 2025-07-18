package com.tnsif.string;

import org.w3c.dom.ls.LSOutput;

public class StringDemo {
	
	public static void main(String[] args) {
		
	
	
	char c[]= {'s','a','h','i','l'};
	
	String s1=new String(c);
	

	
		System.out.println(s1);
	String s2=s1.toUpperCase();
	
	System.out.println(s2);
	
	//string comparison
	//== -------> memory reference or object reference
	//equal ---------> data check  compare 
	s2=new String(s1);
	System.out.println("case 1: "+ s1.equals(s2));
	System.out.println("case 2: "+ s1==s2);
	
	
}
}