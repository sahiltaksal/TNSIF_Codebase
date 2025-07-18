package com.tnsif.day13.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetDemo {
	
	public static void main(String[] args) {
		Set<Integer> s1=new HashSet<Integer>();
		s1.add(11);
		s1.add(25);
		s1.add(20);
		s1.add(96);
		s1.add(35);
		s1.add(28);
		s1.add(59);
		
		System.out.println(s1);
		
		System.out.println(s1.contains(20));
		
		System.out.println(s1.isEmpty());
		
		s1.remove(20);
		System.out.println(s1);
		
		Iterator<Integer> i=s1.iterator();
		while(i.hasNext())
		{
			System.out.print(i.next()+" ");
		}
	}

}
