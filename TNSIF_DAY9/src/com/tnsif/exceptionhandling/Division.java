package com.tnsif.exceptionhandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Division {

			public static void divide() {
				
				int a,b,c;
				
				Scanner scanner=new Scanner(System.in);
				
				System.out.println("Enter two number");
				
				try {
					a=scanner.nextInt();
					b=scanner.nextInt();
					c=a/b;
					System.out.println("Division is : "+c);
				} catch (InputMismatchException e) {
					System.err.println("Wrong Input"+e.getMessage());
				}
				catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
				System.out.println(e.getMessage());
				}
				finally {
					{
						System.out.println("End of program...............");
					}
				}
			}
	}
