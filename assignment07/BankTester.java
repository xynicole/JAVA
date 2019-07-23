package assignment07;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

class BankTester {
	Bank testBank;
	String[] names = {"Jane Devon","John CornWall", "Jean Dorset", "James Hampshire"};

	@BeforeEach
	void initialize(){
		testBank = new Bank("NewNYBank");
		testBank.setBaseCheckLimit(5);
		testBank.setBaseRate(2);
		testBank.setCheckFee(1.50);
		testBank.addCustomer(names[0], 0, 200);
		testBank.addCustomer(names[1], 200, 99);
		testBank.addCustomer(names[2], 200, 300);
		testBank.addCustomer(names[3], 100000, 2000);
	}

	@AfterEach
	void resetIdNum(){
		testBank.reset();		
	}

	@Test
	@DisplayName("Check that all the accounts are set up correctly in the Bank")
	void testBankCustomerList() {
		Customer test0 = testBank.getCustomer(10000);
		Customer test1 = testBank.getCustomer(10001);
		Customer test2 = testBank.getCustomer(10002);
		Customer test3 = testBank.getCustomer(10003);
		Customer test4 = testBank.getCustomer(10004);
		try {
			assertAll(
					() -> assertNull(test0),
					() -> assertEquals(names[0], test1.getName()),
					() -> assertEquals(names[1], test2.getName()),
					() -> assertEquals(names[2], test3.getName()),
					() -> assertEquals(names[3], test4.getName()),
					() -> assertThrows(UnsupportedOperationException.class,
							() -> test1.getMySavingsBalance()),
					() -> assertEquals(200, test2.getMySavingsBalance(), 1e-6),
					() -> assertEquals(200, test3.getMySavingsBalance(), 1e-6),
					() -> assertEquals(100000, test4.getMySavingsBalance(), 1e-6),
			// ADD CORRESPONDING ASSERTS FOR THE checking account balances or the exception	
			
					() -> assertEquals(200, test1.getMyCheckingBalance(), 1e-6),
					() -> assertThrows(UnsupportedOperationException.class,
							() -> test2.getMyCheckingBalance()),
					() -> assertEquals(300, test3.getMyCheckingBalance(), 1e-6),
					() -> assertEquals(2000, test4.getMyCheckingBalance(), 1e-6));
		} catch(AssertionError e){
			System.out.println("The Bank Customers were no set up correctly: " + e.getMessage());
			throw e;
		}
	}

	@Test
	@DisplayName("Tests deposit method of a savings account")
	void testSavingsDeposit() {
		SavingsAccount test = new SavingsAccount(200, 5);
		test.deposit(500);
		try {
			assertEquals(700.00, test.getBalance(), 1e-6);
		} catch(AssertionError e){
			System.out.println("deposit() method in savings failed: " + e.getMessage());
			throw e;
		}
	}
//
	@Test
	@DisplayName("Tests deposit method of a checking account")
	void testCheckingDeposit() {
		CheckingAccount test = new CheckingAccount(200, 5);
		test.deposit(500);
		try {
			assertEquals(700.00, test.getBalance(), 1e-6);
		} catch(AssertionError e){
			System.out.println("deposit() method in checking failed: " + e.getMessage());
			throw e;
		}
	}

	@Test
	@DisplayName("Tests that the deposit method of a savings account throws " +
			"illegal argument exception when argument is negative")
	void testSavings1Deposit() {
		SavingsAccount test = new SavingsAccount(200, 5);
		try {
			assertThrows(IllegalArgumentException.class,
					() -> {test.deposit(-10);});
		} catch(AssertionError e){
			System.out.println("deposit() method in savings failed: " + e.getMessage());
			throw e;
		}
	}
//
	@Test
	@DisplayName("Tests that the deposit method of a checking account throws " +
			"illegal argument exception when argument is negative")
	void testChecking1Deposit() {
		CheckingAccount test = new CheckingAccount(200, 5);
		try {
			assertThrows(IllegalArgumentException.class,
					() -> {test.deposit(-10);});
		} catch(AssertionError e){
			System.out.println("deposit() method in checking failed: " + e.getMessage());
			throw e;
		}
	}

	@Test
	@DisplayName("Tests deposit method of mySavings in a Customer with only a savings account")
	void testCustomer1SavingsDeposit() {
		Customer test = new Customer("Name", 1, new SavingsAccount(200, 5), null);
		test.depositSavings(500);
		try {
			assertEquals(700.00, test.getMySavingsBalance(), 1e-6);
		} catch(AssertionError e){
			System.out.println("depositSavings() method in customer failed: " + e.getMessage());
			throw e;
		}
	}
//
	@Test
	@DisplayName("Tests deposit method of myChecking in a Customer with only a saving account")
	void testCustomer1CheckingDeposit() {
		Customer test = new Customer("Name", 1, new SavingsAccount(200, 5), null);
		try {
			assertThrows(UnsupportedOperationException.class,
					() -> {test.depositChecking(500);});
		} catch(AssertionError e){
			System.out.println("depositChecking() method in customer failed: " + e.getMessage());
			throw e;
		}
	}

	@Test
	@DisplayName("Tests deposit method of mySavings in a Customer with savings and checking account")
	void testCustomer2SavingsDeposit() {
		Customer test = new Customer("Name", 1, new SavingsAccount(200, 5), new CheckingAccount(200, 5));
		test.depositSavings(500);
		try {
			assertEquals(700.00, test.getMySavingsBalance(), 1e-6);
		} catch(AssertionError e){
			System.out.println("depositSavings() method in customer failed: " + e.getMessage());
			throw e;
		}
	}
//
	@Test
	@DisplayName("Tests deposit method of myChecking in a Customer with savings and checking account")
	void testCustomer2CheckingDeposit() {
		Customer test = new Customer("Name", 1, new SavingsAccount(200, 5), new CheckingAccount(200, 5));
		test.depositChecking(500);
		try {
			assertEquals(700.00, test.getMyCheckingBalance(), 1e-6);
		} catch(AssertionError e){
			System.out.println("depositChecking() method in customer failed: " + e.getMessage());
			throw e;
		}
	}

	@Test
	@DisplayName("Tests deposit method of mySavings in Customer with only checking account")
	void testCustomer3SavingsDeposit() {
		Customer test = new Customer("Name", 1, null, new CheckingAccount(200, 5));
		// there is no savings account so we check the correct exception occurs
		try {
			assertThrows(UnsupportedOperationException.class,
					() -> {test.depositSavings(500);});
		} catch(AssertionError e){
			System.out.println("depositC() method failed to throw exception: " + e.getMessage());
			throw e;
		}
	}
//
	@Test
	@DisplayName("Tests deposit method of myChecking in Customer with only checking account")
	void testCustomer3CheckingDeposit() {
		Customer test = new Customer("Name", 1, null, new CheckingAccount(200, 5));
		// there is no savings account so we check the correct exception occurs
			test.depositChecking(500);
			try {
				assertEquals(700.00, test.getMyCheckingBalance(), 1e-6);
					
		} catch(AssertionError e){
			System.out.println("depositChecking() method failed to throw exception: " + e.getMessage());
			throw e;
		}
	}

	@Test
	@DisplayName("Tests withdraw method of a savings account")
	void testSavingsWithdraw() {
		SavingsAccount test = new SavingsAccount(200, 5);
		double retVal = test.withdraw(50);
		try {
			assertAll(
					() -> assertEquals(150.00, test.getBalance(), 1e-6),
					() -> assertEquals(50.00, retVal, 1e-6)
					);
		} catch(AssertionError e){
			System.out.println("withdraw() method in savings failed: " + e.getMessage());
			throw e;
		}
	}
//
	@Test
	@DisplayName("Tests withdraw method of a checking account")
	void testCheckingWithdraw() {
		CheckingAccount test = new CheckingAccount(200, 5);
		double retVal = test.withdraw(50);
		try {
			assertAll(
					() -> assertEquals(150.00, test.getBalance(), 1e-6),
					() -> assertEquals(50.00, retVal, 1e-6)
					);
		} catch(AssertionError e){
			System.out.println("withdraw() method in checking failed: " + e.getMessage());
			throw e;
		}
	}

	@Test
	@DisplayName("Tests withdraw method of a savings account when amount > balance")
	void testSavingsWithdraw1() {
		SavingsAccount test = new SavingsAccount(200, 5);
		double retVal = test.withdraw(250);
		try {
			assertAll(
					() -> assertEquals(0.00, test.getBalance(), 1e-6),
					() -> assertEquals(200.00, retVal, 1e-6)
					);
		} catch(AssertionError e){
			System.out.println("withdraw() method in savings failed: " + e.getMessage());
			throw e;
		}
	}
//
	@Test
	@DisplayName("Tests withdraw method of a checking account when amount > balance")
	void testCheckingWithdraw1() {
		CheckingAccount test = new CheckingAccount(200, 5);
		double retVal = test.withdraw(250);
		try {
			assertAll(
					() -> assertEquals(0.00, test.getBalance(), 1e-6),
					() -> assertEquals(200.00, retVal, 1e-6)
					);
		} catch(AssertionError e){
			System.out.println("withdraw() method in checking failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	@DisplayName("Tests that the withdraw method of a savings account throws " +
			"illegal argument exception when argument is negative")
	void testSavings1Withdraw() {
		SavingsAccount test = new SavingsAccount(200, 5);
		try {
			assertThrows(IllegalArgumentException.class,
					() -> test.withdraw(-10));
		} catch(AssertionError e){
			System.out.println("withdraw() method in savings failed to throw exception: " + e.getMessage());
			throw e;
		}
	}
//
	@Test
	@DisplayName("Tests that the withdraw method of a checking account throws " +
			"illegal argument exception when argument is negative")
	void testChecking1Withdraw() {
		CheckingAccount test = new CheckingAccount(200, 5);
		try {
			assertThrows(IllegalArgumentException.class,
					() -> test.withdraw(-10));
		} catch(AssertionError e){
			System.out.println("withdraw() method in savings failed to throw exception: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	@DisplayName("Tests withdraw method of mySavings in a Customer with only a savings account")
	void testCustomer1SavingsWithdraw() {
		Customer test = new Customer("Name", 1, new SavingsAccount(200, 5), null);
		double retVal = test.withdrawSavings(50);
		try {
			assertAll(
					() -> assertEquals(150.00, test.getMySavingsBalance(), 1e-6),
					() -> assertEquals(50.00, retVal, 1e-6)
					);
		} catch(AssertionError e){
			System.out.println("withdrawSavings() method in customer failed: " + e.getMessage());
			throw e;
		}
	}
//
	@Test
	@DisplayName("Tests withdraw method of myChecking in a Customer with only a savings account")
	void testCustomer1CheckingWithdraw() {
		Customer test = new Customer("Name", 1, new SavingsAccount(200, 5), null);
		try {
			assertThrows(UnsupportedOperationException.class,
					() -> test.writeCheck(100));
		} catch(AssertionError e){
			System.out.println("writeCheck() method in customer failed: " + e.getMessage());
			throw e;
		}
	}

	@Test
	@DisplayName("Tests withdraw method of mySavings in a Customer with only a savings account"
			+ "when amount > balance")
	void testCustomer1SavingsWithdraw1() {
		Customer test = new Customer("Name", 1, new SavingsAccount(200, 5), null);
		double retVal = test.withdrawSavings(250);
		try {
			assertAll(
					() -> assertEquals(0.00, test.getMySavingsBalance(), 1e-6),
					() -> assertEquals(200.00, retVal, 1e-6)
					);
		} catch(AssertionError e){
			System.out.println("withdrawSavings() method in customer failed: " + e.getMessage());
			throw e;
		}
	}
//
	@Test
	@DisplayName("Tests withdraw method of myChecking in a Customer with only a savings account"
			+ "when amount > balance")
	void testCustomer1CheckingWithdraw1() {
		Customer test = new Customer("Name", 1, new SavingsAccount(200, 5), null);
		try {
			assertThrows(UnsupportedOperationException.class,
					() -> test.writeCheck(100));
		} catch(AssertionError e){
			System.out.println("writeCheck() method in customer failed: " + e.getMessage());
			throw e;
		}
	}
	@Test
	@DisplayName("Tests withdraw method of mySavings in a Customer with savings and checking account")
	void testCustomer2SavingsWithdraw() {
		Customer test = new Customer("Name", 1, new SavingsAccount(200, 5), new CheckingAccount(200, 5));
		double retVal = test.withdrawSavings(50);
		try {
			assertAll(
					() -> assertEquals(150.00, test.getMySavingsBalance(), 1e-6),
					() -> assertEquals(50.00, retVal, 1e-6)
					);
		} catch(AssertionError e){
			System.out.println("withdrawSavings() method in customer failed: " + e.getMessage());
			throw e;
		}
	}
//
	@Test
	@DisplayName("Tests withdraw method of myChecking in a Customer with savings and checking account")
	void testCustomer2CheckingWithdraw() {
		Customer test = new Customer("Name", 1, new SavingsAccount(200, 5), new CheckingAccount(200, 5));
		double retVal = test.writeCheck(50);
		try {
			assertAll(
					() -> assertEquals(150.00, test.getMyCheckingBalance(), 1e-6),
					() -> assertEquals(50.00, retVal, 1e-6)
					);
		} catch(AssertionError e){
			System.out.println("writeCheck() method in customer failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	@DisplayName("Tests withdraw method of mySavings in Customer with only checking account")
	void testCustomer3SavingsWithdraw() {
		Customer test = new Customer("Name", 1, null, new CheckingAccount(200, 5));
		// there is no savings account so we check the correct exception occurs
		try {
			assertThrows(UnsupportedOperationException.class,
					() -> test.withdrawSavings(500));
		} catch(AssertionError e){
			System.out.println("withdrawSavings() method failed to throw exception: " + e.getMessage());
			throw e;
		}
	}
//
	@Test
	@DisplayName("Tests withdraw method of myChecking in Customer with only checking account")
	void testCustomer3CheckingWithdraw() {
		Customer test = new Customer("Name", 1, null, new CheckingAccount(200, 5));
		// there is no savings account so we check the correct exception occurs
		double retVal = test.writeCheck(10);
		try {
			assertAll(
					() -> assertEquals(190.00, test.getMyCheckingBalance(), 1e-6),
					() -> assertEquals(10.00, retVal, 1e-6)
					);
		} catch(AssertionError e){
			System.out.println("writeCheck() method failed to throw exception: " + e.getMessage());
			throw e;
		}
	}


	@Test
	@DisplayName("Testing doMonthlyAdjustment in Bank and thereby testing all the monthlyAdjustment methods"
			+ "in Customer, Checking") 
	void testBankDoMonthlyAdjustment() {
		//Bank was set up in Initialize() above
		//YOU MUST ADD TEST FOR CHECHKING, SO DO 
		// writeCheck with small amounts, 10 times
/*in the test testBankDoMonthlyAdjustment() you need to insert a series of "writeCheck" 
 * calls to the customers that have CheckingAcounts and then put in asserts for the new account balances 
 * and a check that the withdrawCount is reset to 0.
 For every one of the 12 other tests, write a corresponding test for the CheckingAccount--
 in this case you also check that withdrawCount is increased.
*/
		Customer test1 = testBank.getCustomer(10001);
		Customer test2 = testBank.getCustomer(10002);
		Customer test3 = testBank.getCustomer(10003);
		Customer test4 = testBank.getCustomer(10004);
		
	
		try {
			assertAll(
					
					() -> assertEquals(10, test1.writeCheck(10), 1e-6),
					() -> assertEquals(20, test1.writeCheck(20), 1e-6),
					() -> assertEquals(30, test1.writeCheck(30), 1e-6),
					() -> assertEquals(40, test3.writeCheck(40), 1e-6),
					() -> assertEquals(50, test3.writeCheck(50), 1e-6),
					() -> assertEquals(60, test3.writeCheck(60), 1e-6),
					() -> assertEquals(10, test3.writeCheck(10), 1e-6),
					() -> assertEquals(10, test3.writeCheck(10), 1e-6),
					() -> assertEquals(10, test3.writeCheck(10), 1e-6),
					() -> assertEquals(70, test4.writeCheck(70), 1e-6),
					() -> assertEquals(80, test4.writeCheck(80), 1e-6),
					() -> assertEquals(90, test4.writeCheck(90), 1e-6),
					() -> assertEquals(10, test4.writeCheck(10), 1e-6),
					() -> assertEquals(10, test4.writeCheck(10), 1e-6),
					() -> assertEquals(10, test4.writeCheck(10), 1e-6),
					() -> assertEquals(10, test4.writeCheck(10), 1e-6),
					() -> assertEquals(10, test4.writeCheck(10), 1e-6),
					() -> assertEquals(10, test4.writeCheck(10), 1e-6),
					() -> assertEquals(100, test4.writeCheck(100), 1e-6));
		} catch(AssertionError e){
			System.out.println("The Bank writecheck were no set up correctly: " + e.getMessage());
			throw e;
		}
		
		testBank.doMonthlyAdjustment();
		try {
			assertAll(
					//test 1 does not have a savings account
					() -> assertEquals(200.333333, test2.getMySavingsBalance(), 1e-3),
					() -> assertEquals(200.333333, test3.getMySavingsBalance(), 1e-3),
					() -> assertEquals(100183.333333, test4.getMySavingsBalance(), 1e-3),
					// INSERT SIMILAR TESTS THAT THE BALANCES ARE CORRECT
					// AND THE withdrawCount IS BACK TO 0 FOR EACH test1, test3, test4
					() -> assertEquals(140.00, test1.getMyCheckingBalance(), 1e-3),
					() -> assertEquals(118.5, test3.getMyCheckingBalance(), 1e-3),
					() -> assertEquals(1594, test4.getMyCheckingBalance(), 1e-3),
					() -> assertEquals(0, test1.getWithdrawCount()),
					() -> assertEquals(0, test3.getWithdrawCount()),
					() -> assertEquals(0, test4.getWithdrawCount())
					);
			
		} catch(AssertionError e){
			System.out.println("doMonthlyAdjustment in Bank failed: " + e.getMessage());
			throw e;
		}
	}
}
