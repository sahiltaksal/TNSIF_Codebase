package com.secondpackage;

import java.util.Base64;

import com.accessspecifiers.Base;

public class Exeuctor extends Base {

	public static void main(String[] args) {
		
		
		Base b1=new Base();
		b1.methodpublic();
		b1.varPublic=3554;
		b1.methodpublic();
		
		
		
		
/////////  if we extend the class from parent class then only we can access the protected method or variables.....
//          because  protected can accessible in another package if they are sub class
		Exeuctor e1=new Exeuctor();
		e1.varProtected=100;
		e1.methodprotected();
	}

}
