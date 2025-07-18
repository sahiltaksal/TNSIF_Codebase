package com.tnsif.multithreading;

public class ChildDemo {

	public static void main(String[] args) {
		 ChildThread childThread =new ChildThread(10, "Hello");
		 ChildThread childThread1 =new ChildThread(10, "TNSIF");
		 childThread.start();
		 childThread1.start();
		 System.out.println("End of program");
	}
}