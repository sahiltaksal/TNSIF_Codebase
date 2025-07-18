package src.com.tnsif.day11.synchronizationDemo;

public class Account implements Bank{
	private int accNo;
	private int bal;
	private String name;
	
	
	public Account(int accNo, int bal, String name) {
		super();
		this.accNo = accNo;
		this.bal = bal;
		this.name = name;
	}


	public Account() {

	}


	public int getAccNo() {
		return accNo;
	}


	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}


	public int getBal() {
		return bal;
	}


	public void setBal(int bal) {
		this.bal = bal;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", bal=" + bal + ", name=" + name + "]";
	}
	
	@Override
	public void deposite(int amt) throws DepositeLimitException {
		if (amt>Deposite_Limit) {
			throw new DepositeLimitException("Daily deposite limit exceeded");
		}
		else {
			bal+=amt;
			System.out.println("RS "+ amt+" Depsited succesfully, Balance: "+bal);
		}
		
	}
	
	@Override
	public synchronized void  withdraw(int amt) throws InsufficientBalanceException {
	
		if (bal - amt < MIN_BAL) {
			throw new InsufficientBalanceException ("Insufficient balance");
		}
		else {
			bal-=amt;
			System.out.println("RS "+amt+" withdraw, Balance: "+bal);
		}
		
	}
	
	
}
