package com.tnsif.multithreading;

import java.awt.geom.Point2D;

public class ThreadMetthodDemo {
	public static void main(String[] args) {
		

	ChildThread t1=new ChildThread(5, "first");
	ChildThread t2=new ChildThread(10, "Second");

	t1.start();
	t2.start();
	Thread.currentThread().setName("Parent Thread");
	Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
	
	System.out.println(Thread.currentThread());

	
	try {
		t1.join();	// Wait current thread until t1 is dead 
		t2.join();	// Wait current thread until t2 is dead 
	}catch (InterruptedException e) {
		Thread.currentThread().interrupt();
	System.err.println("Thread Interrupted " + e.getMessage());
	
	}
	System.out.println("-------- End of program----------------");
	
}
}