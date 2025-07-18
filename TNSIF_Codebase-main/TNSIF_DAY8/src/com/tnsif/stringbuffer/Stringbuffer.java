package com.tnsif.stringbuffer;

import java.nio.Buffer;
import java.nio.BufferUnderflowException;

public class Stringbuffer {

	public static void main(String[] args) {
		
		
		//string buffer length
		StringBuffer buffer=new StringBuffer("Hello");
		System.out.println(buffer);
		
		System.out.println(buffer.length());
		System.out.println(buffer.capacity());
		
		// appending and inserting into buffer
		
		String s;
		int a=42;
		
		buffer=new StringBuffer(40);
		
		s=buffer.append("a=").append(a).append("!").toString();
		System.out.println(s);
		System.out.println(buffer);
		
		buffer=new StringBuffer("I java");
		buffer.insert(2,"like");
		
		System.out.println(buffer);
		
		buffer.reverse();
		System.out.println(buffer);
		
	

	}

}
