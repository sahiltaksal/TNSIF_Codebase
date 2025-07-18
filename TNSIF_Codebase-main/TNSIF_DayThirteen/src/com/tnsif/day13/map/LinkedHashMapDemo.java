package com.tnsif.day13.map;

import java.util.LinkedHashMap;

public class LinkedHashMapDemo {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		LinkedHashMap h=new LinkedHashMap();
		
		h.put(101, 1000);
		h.put(1012, 23.34);
		h.put(303, "Pune");
		h.put(501, 10);
		h.put(601, 3000);
		h.put(101, 3000);
		
		
		System.out.println(h);
		
	}

}
