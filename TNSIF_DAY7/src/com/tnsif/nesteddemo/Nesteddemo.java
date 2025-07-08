package com.tnsif.nesteddemo;

public class Nesteddemo implements OuterInterface,OuterInterface.Innerinterface {

	@Override
	public void area() {
	
		System.out.println("Outer Interface");
		
	}

	@Override
	public void print() {
		System.out.println("Hi");
		
	}

}
