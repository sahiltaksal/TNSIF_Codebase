package com.tnsif.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayListDemo {
 public static void main(String[] args) {

	 ArrayList<Object> list =new ArrayList<Object>();
	 
	 System.out.println(list.isEmpty());
	 
	 list.add(10);
	 list.add(20);
	 list.add("sahil");
	 list.add(true);
	 list.add(false);
	 list.add(1020.2);
	// Duplicate are allowed in list
	 list.add(10);
	 System.out.println("List is: "+list);
	 System.out.println(list.size());
	 System.out.println(list.isEmpty());
	 System.out.println(list.contains(10));
	 System.out.println(list.contains(1455));
	 //remove by index number
	 list.remove(3);
	 System.out.println(list);
	 //remove by value
	 list.remove(false);
	 System.out.println(list);
	 //Returns the index of the first occurrence of the specified elementin this list, or -1 if this list does not contain the element.
	 System.out.println(list.indexOf(20));
	 
	 //Generics
	 
	List<String> names=new ArrayList<String>();
	
	names.add("sahil");
// integer not allowed 	names.add("3")
	names.add("mahesh");
	names.add("dattta");
	names.add("raju");
	names.add("ayan");
	// for reverse 
	Collections.reverse(names);
	System.out.println(names);
	// for sort
	Collections.sort(names);
	System.out.println(names);
	//traversing in list
	
	Iterator<String> iterator=names.iterator();
	while (iterator.hasNext()) {
		String string = (String) iterator.next();
		System.out.println(string);
	}
	System.out.println();
	System.out.println(names);
	
	//reverse
	ListIterator<String> listIterator=names.listIterator(names.size());
	while (listIterator.hasPrevious()) {
		String string = (String) listIterator.previous();
		System.out.println(string);
	}
	 
 }
 
}
