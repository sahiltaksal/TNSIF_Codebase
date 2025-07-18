package com.day4;

import java.util.Scanner;

public class Constructordemo {

	public static void main(String[] args) {


		Scanner scanner=new Scanner(System.in);
		String name;
		String city;
		int id;
		
		System.out.println("enter id");
		id=scanner.nextInt();
	
		System.out.println("Enter name");
		name=scanner.next();
		
	System.out.println("Enter city");
	city=scanner.next();
	
	Customer c1=new Customer();
 c1.setCustomerId(id);
 c1.setCustomerName(name);
c1.setCustomerCity(city);

System.out.println(c1);

Customer c2=new Customer(name, id, city);
c2.setCustomerCity(city);
	}

}
