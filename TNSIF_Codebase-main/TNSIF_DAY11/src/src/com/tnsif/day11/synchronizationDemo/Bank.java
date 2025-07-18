package src.com.tnsif.day11.synchronizationDemo;

public interface Bank {
	
	static final int MIN_BAL=1000;
	static final int Deposite_Limit=25000;
	
	
	public void deposite(int amt)throws DepositeLimitException;
	public void withdraw(int amt) throws InsufficientBalanceException;

}
