package com.accessspecifiers;

public class Executor {

	public static void main(String[] args) {
		
		//accesing same package class
		Base b1=new Base();
		b1.methoddefault();
		b1.methodprotected();
		b1.methodpublic();
		//b1.methodprivate();
		
	b1.varDefault=10;
	b1.methoddefault();
	
	b1.varProtected=1001;
	b1.methodprotected();
	}

}
