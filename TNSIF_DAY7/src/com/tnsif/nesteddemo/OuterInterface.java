package com.tnsif.nesteddemo;

public interface OuterInterface {
	
	void area();
	
	interface Innerinterface{
		
		int id=20;
		void print();
	}

}
