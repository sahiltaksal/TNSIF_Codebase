package com.tnsif.day13.map;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Set;

public class HashMapTableDemo {
	
	public static void main(String[] args) {
		
		Hashtable<Integer,	 String> t=new Hashtable<Integer, String>();
		
		t.put(101, "Mumbai");
		t.put(104, " New Mumbai");
		t.put(103, "Pune");
		t.put(102, "NSK");
		t.put(105, "Aurangabad");
		System.out.println(t);
		t.put(105, "Chhatrapati Sambhajinagar");
		
		System.out.println(t);
		
		t.put(104, "PCMC");
		
		t.put(106, "NGR");
		System.out.println(t);
		
		System.out.println(t.get(105));
		
		System.out.println(t.replace(102, "Nashik"));
		System.out.println(t);
		
		t.clone();
		System.out.println(t);
		Set set=t.keySet();
		System.out.println(set);
		
		Collection<String> collection=t.values();
		System.out.println(collection);
	}

}
