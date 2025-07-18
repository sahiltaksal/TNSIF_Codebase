package src.com.tnsif.day11.multithreading.runableDemo;

public class UsingRunnable implements Runnable {

	Thread thread;
	int end, start;
	String msg;

	public UsingRunnable() {

	}

	public UsingRunnable( int end, int start, String msg) {
		super();
		this.thread = thread;
		this.end = end;
		this.start = start;
		this.msg = msg;
	}

	@Override
	public void run() {
		for (int i = end; i > start; i--) {

			try {
				Thread.sleep(1000);

			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			System.out.println(msg+" "+i);

		}
	}

}
