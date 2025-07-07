package com.tnsif.abstraction;

public class MainClass {
	
	public static void main(String[] args) {
		Shape s;
		
			s=	new Rectangular(1f,2f);
			s.calarea();
			s.show();
			
			s=new Square(2f);
			s.calarea();
			s.show();
			
			
	}

}
