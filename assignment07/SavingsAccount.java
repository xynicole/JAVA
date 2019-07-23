package assignment07;

public class SavingsAccount extends BankAccount{
	private double rate;

	public SavingsAccount(double balance, double rate) throws IllegalArgumentException {
		super(balance);
		if(rate <1) {
			throw new IllegalArgumentException("rate cannot be negative!");
		}
		this.rate = rate;
				
	}
	
	/*@Override
	public void deposit(double amount) {
		super.deposit(amount+(rate*amount));
	}*/ 

	public double getRate() {
		return rate;
	}
	
	@Override
	public String toString() {
		return super.toString() + " @ " + rate * 100 +"%";
		

	}

	@Override
	public void monthlyAdjustment() {
		// TODO Auto-generated method stub
		//for every $10000 in the account it increases the value of rate by 1%
		//for example if the account has $36700.25, and the rate is 5%, 
		//it is changed to 5.15% for that month's calculation
		if(getBalance()>=10000) {
			int i=0;
			i =(int) (getBalance()/10000);
			rate = rate + rate *0.01 *i;	
		}
		
		super.deposit((rate/1200.0) * getBalance());
	}
	
	
	
}
