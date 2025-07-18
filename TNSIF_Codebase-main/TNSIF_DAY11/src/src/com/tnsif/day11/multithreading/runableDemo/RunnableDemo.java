package src.com.tnsif.day11.multithreading.runableDemo;

public class RunnableDemo {
	
	public static void main(String[] args) {
		Runnable runnable =new UsingRunnable( 10, 1, "Hii");
		
		Thread t1= new Thread(runnable);
		t1.start();
		
		Runnable r1 =()->System.out.println("Runnable with lambda expression");
		new Thread(r1).start();
	}

}
