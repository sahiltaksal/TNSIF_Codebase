package com.tnsif.exceptionhandling;


public class NestedTryCatch {

	public static void check() throws NullPointerException {
		String string = "TNS";
		int stringLength = string.length();

		System.out.println("String Length: " + stringLength);

		String string2 = null;
		int y = 6;
		try {
			try {
				System.out.println(string.charAt(y));
			} catch (StringIndexOutOfBoundsException e) {
				System.err.println("Invalid index " + e.getMessage());

			}
			System.out.println("String length: "+string2.length());

		} catch (Exception e) {
			System.err.println(e.getMessage());
			
		}

	}
}