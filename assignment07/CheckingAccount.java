package assignment07;

public class CheckingAccount extends BankAccount {
	private int withdrawLimit;
	private int withdrawCount=0;
	private int nextCheckNum = 101;
	private double checkFee;
	
	public CheckingAccount(double balance, int limit) throws IllegalArgumentException {
		super(balance);
		if(limit <1) {
			throw new IllegalArgumentException("Withdrawl limit must be positive!");
		}
		withdrawLimit = limit;
	}
	
	public int getWithdrawLimit() {
		return withdrawLimit;
	}
	public int getWithdrawCount() {
		return withdrawCount;
	}
	
	@Override
	public String toString() {
		return super.toString() + " (" + withdrawCount + "/" + withdrawLimit + ")";
	}
	
	/*@Override
	public double withdraw(double amount) {
		double returnAmount = 0;
		if(withdrawCount<withdrawLimit) {
			withdrawCount++;
			return super.withdraw(amount);
			
		}else {
			return returnAmount;
		}
	}*/
	
	public int reset() {
		return nextCheckNum = 101;
	}

	public void setCheckFee(double checkFee) {
		this.checkFee = checkFee;
	}
	
	public double writeCheck(double amount)throws IllegalArgumentException{
		if(amount <0) {
			throw new IllegalArgumentException("amount must be positive!");
		}
		nextCheckNum ++;
		withdrawCount ++;
		return super.withdraw(amount);
		
		
	}
	 int getNextCheckNum() {
		return nextCheckNum;
	}

	@Override
	public void monthlyAdjustment() {
		// TODO Auto-generated method stub
		//in all cases, sets withdrawCount back to 0. 
		//for every $1000 in the account it increases the withdrawLimit by 1 
		//before doing this calculation for this month. 

		
			
		int i=0;
		i = (int)(getBalance()/1000);
		withdrawLimit +=i;

	
		
		if(withdrawCount > withdrawLimit) {
			
			withdraw(checkFee * (withdrawCount-withdrawLimit));	
			
			
		}
		withdrawCount=0;
		
	
	}
	
	
	
}
