package assignment07;

public abstract class BankAccount{
	private double balance;
	//private int idNum;
	//private static int numAccounts=0;

	public BankAccount(double balance) throws IllegalArgumentException {
		this.balance =balance;
		if (balance <0) {
			throw new IllegalArgumentException("Balance can't be negative!");
		}
		
		/*idNum =numAccounts;
		numAccounts++;*/
			
	}
	
	public abstract void monthlyAdjustment();
	
	

	public double getBalance() {
		return balance;
	}

	/*public int getIdNum() {
		return idNum;
	}
	
	static void reset() {
		numAccounts =0;
	}*/
	
	@Override // good habit to include
	public String toString() {
	
		return String.format("Acct. has $%.2f", balance);
	}
	
	public void deposit(double amount) throws IllegalArgumentException{
	
		if(amount < 0) {
			throw new IllegalArgumentException("deposits must be done with positive values!");
		}else {
			balance += amount;	
		}		
		
	}
	
	public double withdraw(double amount) throws IllegalArgumentException{
		
		if(amount < 0) {
			throw new IllegalArgumentException("withdrawals must be done with positive values!");
		}else if(amount>balance){
			amount= balance;
			balance =0.0;
			return amount;
			
			//throw new IllegalArgumentException("withdrawals amount cannot be greater than balance!");
		}else {	
		balance -= amount;	
		return amount;
		}
	} 
		
	
}
