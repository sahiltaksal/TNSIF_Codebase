package com.tnsif.abstraction;

public abstract class Shape {
	
	protected float area;
	
	//abstract method
	
	public abstract void calarea();
	
	public void show() {
		System.out.println("Area is : "+area);
		

	}

}
