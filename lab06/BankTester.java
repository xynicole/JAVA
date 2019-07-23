package lab06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BankTester {
	List<BankAccount> accounts;
	List<Object> objects;
	//we can initialize some objects to be used in later tests
	//using the BeforeEach keyword ensures this method is called before 
	//the test methods are called
	
	//Please note that this method is rerun before the start of each test,
	//which means the BankAccounts will have their numId's increased 
	//each time the account is called.
	
	//we will fix this issue by adding an @AfterEach method, which is run 
	//after each test ends
	@BeforeEach
	void initialize(){
		//NEEDS TO BE FILLED IN AS SPECIFIED
		accounts = new ArrayList<>();
		BankAccount acc1 = new BankAccount(500);
		BankAccount acc2 = new BankAccount(1000);
		
		SavingsAccount sac1 = new SavingsAccount(200, 0.1);
		SavingsAccount sac2 = new SavingsAccount(320, 0.2);
		
		CheckingAccount cac1= new CheckingAccount(300,50);
		CheckingAccount cac2= new CheckingAccount(430,100);
		
		accounts.add(acc1);
		accounts.add(acc2);
		accounts.add(sac1);
		accounts.add(sac2);
		accounts.add(cac1);
		accounts.add(cac2);
		
		objects = new ArrayList<>();
		
		objects.add(Arrays.toString(new int[] {1,2,3,4,5}));
		objects.add(true);
		objects.add("Hello");
		objects.add(13);
		objects.add(new BankAccount(1314));
		objects.add(new CheckingAccount(1800, 4));
		objects.add(null);
		objects.add(3.1415926535);
		
		
		
	}

	@AfterEach
	void resetIdNum(){
		BankAccount.reset();
		accounts.clear();
	}
	
	
	//the @Test is necessary, without it the test will not be run
	@Test
	@DisplayName("Tests deposit method of bank account")
	void testBankAccDeposit() {
		BankAccount bacc = new BankAccount(700.00);
		bacc.deposit(100);
		try {
			//when comparing two doubles, we need to give it some small value for it to see 
			//if the expected and actual value are close enough to equaling one another
			assertEquals(800.00, bacc.getBalance(), 1e-6);
		}
		//here if there is an assertion error, we can catch it 
		//and print the error message out, then throw the AssertionError
		//so that the test still fails. 
		catch(AssertionError e){
			System.out.println("BankAccount's deposit() method failed: " + e.getMessage());
			throw e;
		}
	}
	@Test
	@DisplayName("Tests withdraw method of checking account")
	void testCheckingAccWithdraw(){
		CheckingAccount checking = new CheckingAccount(1000.00, 10);
		for(int i = 0; i < 3; i++) checking.withdraw(100);
		try {
			//when comparing two doubles, we need to give it some small value for it to see 
			//if the expected and actual value are close enough to equaling one another
			assertEquals(700.00, checking.getBalance(), 1e-6);
		}
		//here if there is an assertion error, we can catch it 
		//and print the error message out, then throw the AssertionError
		//so that the test still fails. 
		catch(AssertionError e){
			System.out.println("CheckingAccount's withdraw() method failed: " + e.getMessage());
			throw e;
		}
	}
	@Test
	@DisplayName("Tests getter for withdrawCount of a CheckingAccount")
	void testCheckingAccGetWithdrawCount(){
		CheckingAccount checking = new CheckingAccount(1000.00, 10);
		for(int i = 0; i < 3; i++) checking.withdraw(100);
		try {
			//when comparing two integers, we don't need a third argument 
			//since ints can be checked for equality
			assertEquals(3, checking.getWithdrawCount());
		}
		//here if there is an assertion error, we can catch it 
		//and print the error message out, then throw the AssertionError
		//so that the test still fails. 
		catch(AssertionError e){
			System.out.println("CheckingAccount's getWithdrawCount() method failed: " + e.getMessage());
			System.out.println("Make sure you adjust the withdrawCount in your CheckingAccount's withdraw() method!");
			throw e;
		}
	}
	//TODO: Add some of your own additional tests. Keep each test in a separate test function.
	//This isolates testing a single method or case to a single testing method. Otherwise, 
	//if you try to do too much testing in one tester method, you could throw an error
	//for a test and never find the errors of the other tests you put in that method. 
	
	@Test
	@DisplayName("Tests withdraw method of bank account")
	void testBankAccWithdraw() {
		BankAccount bacc = new BankAccount(700.00);
		bacc.withdraw(100);
		try {
			assertEquals(600.00, bacc.getBalance(), 1e-6);
		} 
		catch(AssertionError e){
			System.out.println("BankAccount's withdraw() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	@DisplayName("Tests balance method of bank account")
	void testBankAccBalance() {
		BankAccount bacc = new BankAccount(800.00);
		bacc.getBalance();
		try {
			assertEquals(800.00, bacc.getBalance(), 1e-6);
		} 
		catch(AssertionError e){
			System.out.println("BankAccount's balance() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	
	@Test
	@DisplayName("Tests deposit method of saving account")
	void testSavingAccDeposit() {
		SavingsAccount sacc = new SavingsAccount(700.00,0.1);
		sacc.deposit(100);
		try {
			assertEquals(810.00, sacc.getBalance(), 1e-6);
		} 
		catch(AssertionError e){
			System.out.println("SavingsAccount's deposit() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	@DisplayName("Tests getWithdrawLimit method of checking account")
	void testCheckingAccLimit() {
		CheckingAccount cacc = new CheckingAccount(700.00,10);
		cacc.getWithdrawLimit();
		try {
			assertEquals(10, cacc.getWithdrawLimit(), 1e-6);
		} 
		catch(AssertionError e){
			System.out.println("CheckingAccount's getWithdrawLimit() method failed: " + e.getMessage());
			throw e;
		}
	}

	
	
	
	@Test
	@DisplayName("Tests deposit behavior of each class")
	public void testDeposit() {
		for (BankAccount elements : accounts) {
			elements.deposit(280);
		}
		try {
		assertEquals(780.00, accounts.get(0).getBalance(), 1e-6);
		assertEquals(1280.00, accounts.get(1).getBalance(), 1e-6);
		assertEquals(508.00, accounts.get(2).getBalance(), 1e-6);
		assertEquals(656.00, accounts.get(3).getBalance(), 1e-6);
		assertEquals(580.00, accounts.get(4).getBalance(), 1e-6);
		assertEquals(710.00, accounts.get(5).getBalance(), 1e-6);
		}
		catch(AssertionError e){
			System.out.println("Deposit behavior of each class failed: " + e.getMessage());		
			throw e;
		}
			
	}

	@Test
	@DisplayName("Tests withdraw behavior of each class")
	public void testWithdraw() {
		for(BankAccount elements : accounts) {
			for(int i = 0; i < 7; i++) {
				elements.withdraw(100.0);
			}
		}
		try {
		assertEquals(0.0, accounts.get(0).getBalance(), 1e-6);
		assertEquals(300.0, accounts.get(1).getBalance(), 1e-6);
		assertEquals(0.0, accounts.get(2).getBalance(), 1e-6);
		assertEquals(20.0, accounts.get(3).getBalance(), 1e-6);
		assertEquals(0.0, accounts.get(4).getBalance(), 1e-6);
		assertEquals(30.0, accounts.get(5).getBalance(), 1e-6);
		}
		catch(AssertionError e){
			System.out.println("Withdraw behavior of each class failed: " + e.getMessage());		
			throw e;
		}
		
	}
	
	
	
	
	
	
	@Test
	@DisplayName("Tests deposit method of bank account")
	void dynamicDispatchPrinting(){
		//FILL IN AS SPECIFIED
		for(BankAccount b : accounts){
			if(b instanceof SavingsAccount){
				System.out.println("SavingsAccount: ");
			}
			else if(b instanceof CheckingAccount){
				System.out.println("CheckingAccount: ");
			}
			//note that we do this as an else block
			//since SavingsAccount and CheckingAccounts are also
			//considered to be instances of BankAccount
			//since they are subclasses of BankAccount.
			else{
				System.out.println("BankAccount: ");
			}
			System.out.println(b);
			
		}
		for(Object b : objects) {
			System.out.println(b);
		}
	}

}
