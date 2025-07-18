package com.tnsif.day13.set;

import java.util.HashSet;
import java.util.Set;

public class StudentDemo {
	
	public static void main(String[] args) {
		
	Set <Student> set=new HashSet<Student>();
	
	set.add(new Student(101,"Mahesh",78.0d));
	set.add(new Student(102,"Sahil",95.0d));
	set.add(new Student(103,"Datta",98.0d));
	set.add(new Student(104,"Rajesh",90.0d));
	set.add(new Student(105,"Mahesh",78.0d));  // Duplicate
	
	System.out.println(set);
	}

}
