package src.com.tnsif.day11.synchronizationDemo;

public class InsufficientBalanceException extends Exception {

	public InsufficientBalanceException() {
		super("Insufficient balance");
		
	}

	public InsufficientBalanceException(String message) {
		super(message);
		
	}
	
	

}
