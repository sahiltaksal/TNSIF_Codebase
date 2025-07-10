package com.tnsif.multithreading;


public class ChildThread extends Thread{

	
	int n;
	String msg;
	public ChildThread(int n, String msg) {
		this.n = n;
		this.msg = msg;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < n; i++) {
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
			System.out.println(i +" " + msg);
		}
	}
	
}