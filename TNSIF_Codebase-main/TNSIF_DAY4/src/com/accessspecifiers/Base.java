package com.accessspecifiers;

public class Base {
	
	int varDefault=10;
	public int varPublic =20;
	private int varPrivate=30;
	protected int varProtected=40;
	
	void methoddefault() {
		
		System.out.println("default access base class ");
		System.out.println("default variable "+varPublic);
	}
	
	public void methodpublic() {
		
		System.out.println("public access base class ");
		System.out.println("public access base class "+varPublic);
		
		
	}
	private void methodprivate() {
		
		System.out.println("private access base class ");
		System.out.println("private access base class "+varPrivate);
	}
	
	protected void methodprotected() {
		
		System.out.println("protected access base class ");
		System.out.println("protected access base class "+varProtected);
	}

}
