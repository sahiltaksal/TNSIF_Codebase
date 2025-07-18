package com.tnsif.multithreading;

public class ThreadLifeCycleDemo extends Thread{

	
	
	@Override
	public void run() {
		System.out.println("in Side run() thread is alive or not "+ this.isAlive());
		int num=0;
		while(num<4) {
			num++;
			System.out.println("num : "+num);
		}
		try {
			Thread.sleep(500);
			System.out.println("in not runnable state thread is alive or not "+ this.isAlive());
		} catch (InterruptedException e) {
			System.err.println("Thread interrupted ..."+e.getMessage());
		}
	}
}