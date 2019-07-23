package assignment07;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	private String bankName;
	private int nextAccNum = 10001;
	List<Customer> customers = new  ArrayList<>();
	private double baseRate;
	private int baseCheckLimit;
	private double checkFee;
	
	public Bank(String bankName) {
		super();
		this.bankName = bankName;
	}
	public double getBaseRate() {
		return baseRate;
	}
	public void setBaseRate(double baseRate) throws IllegalArgumentException {
		if(baseRate<0) {
			throw new IllegalArgumentException("cannot be negative!");
		}
		this.baseRate = baseRate;
	}
	public int getBaseCheckLimit() {
		return baseCheckLimit;
	}
	public void setBaseCheckLimit(int baseCheckLimit)throws IllegalArgumentException { 
		if(baseCheckLimit<0) {
			throw new IllegalArgumentException("cannot be negative!");
		}
		this.baseCheckLimit = baseCheckLimit;
	}
	public double getCheckFee() {
		return checkFee;
	}
	public void setCheckFee(double checkFee)throws IllegalArgumentException  {
		if(checkFee<0) {
			throw new IllegalArgumentException("cannot be negative!");
		}
		this.checkFee = checkFee;
	}

	public void reset() {
		nextAccNum = 10001;
		customers.clear();
	}
	public void addCustomer(String name, double savingsInit, double checkingInit) {
		SavingsAccount sa = null;
		CheckingAccount ca = null;
		if(savingsInit >= 100) {
			sa = new SavingsAccount(savingsInit, baseRate);
		}
			//makes a SavingsAccount with initial balance savingsInit
		if(checkingInit >= 100){
			ca = new CheckingAccount(checkingInit, baseCheckLimit);
		}
		/*
		 *  it adds a new Customer to its List of customers, 
		 *  where the Customer will have the name equal to name, 
		 *  id equal to nextAccNum, the SavingsAccount just made or null, 
		 *  and the CheckingAccount just made or null. 
		 *  Note the accounts could be null if the Customer doesn't have enough initial money 
		 *  to open an account. If the CheckingAccount is not null, 
		 *  set its checkFee to the Bank's checkFee. 
		 *  Finally nextAccNum increased by 1.*/
		Customer customer = new Customer(name, nextAccNum, sa, ca);
		customers.add(customer);
		if(ca !=null) {
			ca.setCheckFee(checkFee);
		}
		nextAccNum++;
	}
	
	
	public void doMonthlyAdjustment() {//It goes through all its Customers in the List and calls monthlyAdjustment() on each one.
		for(Customer i:customers) {
			i.monthlyAdjustment();
		}
	}
	
	public Customer getCustomer(int accId) {// returns the Customer from customers that has the given account id. 
		for(Customer i:customers) {
			if(i.getIdNum() == accId) {
				return i;
			}
		}
		return null;
	}
	public void report() {
		for(Customer i:customers) {
		System.out.println(i);
		}
	}
	
	
}
