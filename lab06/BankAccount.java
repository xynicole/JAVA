package lab06;

public class BankAccount {
	private double balance;
	private int idNum;
	private static int numAccounts=0;

	public BankAccount(double balance) throws IllegalArgumentException {
		this.balance =balance;
		if (balance <0) {
			throw new IllegalArgumentException("Balance can't be negative!");
		}
		
		idNum =numAccounts;
		numAccounts++;
			
	}

	public double getBalance() {
		return balance;
	}

	public int getIdNum() {
		return idNum;
	}
	
	static void reset() {
		numAccounts =0;
	}
	
	@Override // good habit to include
	public String toString() {
	    // should return the string "Acct. #3 has $50.0" for an account with idNum = 3 and balance = 50
	
		return("Acct. #"+idNum+ " has $" + balance);
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
			return balance;
			
			//throw new IllegalArgumentException("withdrawals amount cannot be greater than balance!");
		}else {	
		balance -= amount;	
		return amount;
		}
	} 
		
	
}
