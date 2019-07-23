package assignment07;

public class Customer {
	private String name;
	private int idNum;
	private BankAccount mySavings;
	private BankAccount myChecking;
	
	public Customer(String nm, int id, SavingsAccount savings, CheckingAccount checking) {
		name = nm;
		idNum = id;
		mySavings =savings;
		myChecking =checking;
		
	}

	public String getName() {
		return name;
	}

	public int getIdNum() {
		return idNum;
	}
	
	public double getMySavingsBalance() throws UnsupportedOperationException{
		if (mySavings == null) {
			throw new UnsupportedOperationException("Saving Account can't be null");	
		}
		return mySavings.getBalance(); //return the balances in mySavings
	}
	
	public double getMyCheckingBalance()throws UnsupportedOperationException{
		if (myChecking == null) {
			throw new UnsupportedOperationException("Checking Account can't be null");	
		}
		return myChecking.getBalance(); //return the balances in myChecking
	}
	
	public void monthlyAdjustment() { //calls monthlyAdjustment() on its non-null account fields
		if(null != mySavings){
			mySavings.monthlyAdjustment();
		}

		if(null != myChecking){
			 myChecking.monthlyAdjustment();
		}
			
	}
	
	public boolean hasSavingsAccount() {
		if(mySavings!= null) {
			return true;
		}	
		return false;
	}
	
	public boolean hasCheckingAccount() {
		if(myChecking!= null) {
			return true;
		}	
		return false;
	}
	public void depositSavings(double amount) throws UnsupportedOperationException {
		if (mySavings !=null) {
			mySavings.deposit(amount);	
		}else {
			throw new UnsupportedOperationException("account can't be null");
		}
		
	}
	
	public void depositChecking(double amount)throws UnsupportedOperationException {
		if (myChecking !=null) {
			myChecking.deposit(amount);	
		}else {
			throw new UnsupportedOperationException("account can't be null");
		}
		
	}
	
	public double withdrawSavings(double amount)throws UnsupportedOperationException {
		if (mySavings !=null) {
			return mySavings.withdraw(amount);	
		}else {
			throw new UnsupportedOperationException("Saving account can't be null");
		}
	}
	
	public double writeCheck(double amount)throws UnsupportedOperationException {
		if (myChecking !=null) { //need a cast to CheckingAccount
			return ((CheckingAccount) myChecking).writeCheck(amount);	
		}else {
			throw new UnsupportedOperationException("Checking account can't be null");
		}
	}
	public String toString() {
		/*Customer id: 100002, Jennifer Smith
     		Savings Account: none
     		Checking Account Balance: $300.56
     */
		StringBuilder someCustomer = new StringBuilder();
		someCustomer.append("Customer id: ");
		someCustomer.append(idNum);
		someCustomer.append(", ");
		someCustomer.append(name);
		someCustomer.append("\n\t");
		someCustomer.append("Savings Account: ");
		someCustomer.append(getMySavingsBalance());
		someCustomer.append("\n\t");
		someCustomer.append("Checking Account Balance: ");
		someCustomer.append(String.format("$%.2f",getMyCheckingBalance()));
		System.out.println(someCustomer);
		return(someCustomer.toString());
		
	}
	// return myChecking.getWithdrawCount() 
	//and myChecking.getNextCheckNum() if myChecking is non null
	int getWithdrawCount() {
		if(myChecking !=null) {
			//we need to downcast so it treats myChecking as if it is a CheckingAccount object
			return ((CheckingAccount)myChecking).getWithdrawCount();
		}else {
			throw new UnsupportedOperationException("the account is null");
		}
	}
	int getNextCheckNum() {
		if(myChecking !=null) {
			 return ((CheckingAccount) myChecking).getNextCheckNum();
		}else {
			throw new UnsupportedOperationException("the account is null");
		}
	}
	
	
	
	
	
}


