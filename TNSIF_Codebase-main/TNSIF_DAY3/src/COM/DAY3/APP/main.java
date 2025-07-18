package COM.DAY3.APP;

import java.util.Scanner;

public class main {
   public static void main (String args[]) {
	   
	   Scanner sc=new Scanner(System.in);
	   String name;
	   System.out.println("Enter a Person name ");
	   name =sc.next();
	   System.out.println("Enter Person Age");
	   int age=sc.nextInt();
	   System.out.println("Enter Gender");
	   String gender=sc.next();
	   System.out.println("Enter a Mobile number");
	   long mobilenumber=sc.nextLong();
	   System.out.println("Enter Income");
	   int income=sc.nextInt();
	   
	   
	   //person object 
	   Person person=new Person();
	   person.setName(name);
	   person.setAge(age);
	   person.setGender(gender);
	   person.setIncome(income);
	   person.setMobilenumber(mobilenumber);
	   
	   //by using getter method i m reading the data 
	   
	   System.out.println(person.getName());
	   System.out.println(person.getAge());
	   System.out.println(person.getGender());
	   System.out.println(person.getIncome());
	   System.out.println(person.getMobilenumber());
	   System.out.println(person.getTax());
	   
	   //display person detail 
	   System.out.println(person);
	   
	   TaxCalculation cal=new TaxCalculation();
	   cal.calculateTax(person);
	   
	   System.out.println("After TaxCalculation "+person);
   }

}
