package src.com.tnsif.day11.synchronizationDemo;

public class SynchronizeDriver {
	public static void main(String[] args) {
		Account heti=new Account(1001, 45000, "Heti");
		
		System.out.println(heti);
//		heti.withdraw(10000);
		
		AccountThread t[] =new AccountThread[10];
		
		for (int i = 0; i < 10; i++) {
			t[i]=new AccountThread(heti, 1000*(i+1));
		}
		try {
			for (int i = 0; i < 10; i++) {
				t[i].join();
			}
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
		System.err.println("_------------------------------------");
		System.out.println(heti);
	}

}
