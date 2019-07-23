package lab06;

public class SavingsAccount extends BankAccount{
	private double rate;

	public SavingsAccount(double balance, double rate) throws IllegalArgumentException {
		super(balance);
		if(rate <0) {
			throw new IllegalArgumentException("rate cannot be negative!");
		}
		this.rate = rate;
				
	}
	
	@Override
	public void deposit(double amount) {
		super.deposit(amount+(rate*amount));
	}

	public double getRate() {
		return rate;
	}
	
	@Override
	public String toString() {
		return super.toString() + " @ " + rate * 100 +"%";

	}
	
	
	
}
