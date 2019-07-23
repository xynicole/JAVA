package lab08;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tester {
	@Test
	@DisplayName("factorial test base case =0")
	public void testFactorial0() {
		try {
			
			assertEquals(1, Recursion.factorial(0),1e-6);
		} 
		catch(AssertionError e){
			System.out.println("factorial test base case =0 failed: " + e.getMessage());
			throw e;
		}
			
	}
	
	@Test
	@DisplayName("factorial test base case =1")
	public void testFactorial1() {
		try {
			
			assertEquals(1, Recursion.factorial(1),1e-6);
		} 
		catch(AssertionError e){
			System.out.println("factorial test base case =1 failed: " + e.getMessage());
			throw e;
		}
			
	}

	@Test
	@DisplayName("factorial test non-base case")
	public void testFactorialNon() {
		try {
			
			assertEquals(24, Recursion.factorial(4),1e-6);
		} 
		catch(AssertionError e){
			System.out.println("factorial test non-base case failed: " + e.getMessage());
			throw e;
		}
			
	}
	
	
	@Test
	@DisplayName("squareRoot test 1")
	public void testSquareRoot1() {
		try {
			
			assertEquals(1.0, Recursion.squareRoot(1.0),1e-6);
		} 
		catch(AssertionError e){
			System.out.println("squareRoot test 1 failed: " + e.getMessage());
			throw e;
		}
			
	}
	@Test
	@DisplayName("squareRoot test 0")
	public void testSquareRoot0() {
		try {
			
			assertEquals(0.0, Recursion.squareRoot(0.0),1e-6);
		} 
		catch(AssertionError e){
			System.out.println("squareRoot test 0 failed: " + e.getMessage());
			throw e;
		}
			
	}
	
	@Test
	@DisplayName("squareRoot test a perfect square")
	public void testSquareRootPerfect() {
		try {
			
			assertEquals(2.0, Recursion.squareRoot(4.0),1e-6);
		} 
		catch(AssertionError e){
			System.out.println("squareRoot test a perfect square failed: " + e.getMessage());
			throw e;
		}
			
	}
	
	@Test
	@DisplayName("test one arraylist of 3 non-null ints")
	public void testArraylist() {
		List<Integer> nums = new ArrayList<Integer>();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		try {
			
			assertEquals(6, Recursion.sum(nums),1e-6);
		} 
		catch(AssertionError e){
			System.out.println("test one arraylist of 3 non-null ints failed: " + e.getMessage());
			throw e;
		}
			
	}
	
	@Test
	@DisplayName("test one array of 3 ints")
	public void testArray() {
		int[]nums = {1,2,3};
		try {
			
			assertEquals(6, Recursion.sum(nums),1e-6);
		} 
		catch(AssertionError e){
			System.out.println("test one array of 3 ints failed: " + e.getMessage());
			throw e;
		}
			
	}
	
	@Test
	@DisplayName("test binomialCoefficient k < n/2 and n > 2")
	public void testBinomial1() { //n,k
		
		try {
			
			assertEquals(15, Recursion.binomialCoefficient(6,2),1e-6);
		} 
		catch(AssertionError e){
			System.out.println("test binomialCoefficient k < n/2 and n>2 failed: " + e.getMessage());
			throw e;
		}
			
	}
	
	@Test
	@DisplayName("test binomialCoefficient k > n/2 and n > 2")
	public void testBinomial2() { //n,k
		
		try {
			
			assertEquals(56, Recursion.binomialCoefficient(8,5),1e-6);
		} 
		catch(AssertionError e){
			System.out.println("test binomialCoefficient k < n/2 and n>2 failed: " + e.getMessage());
			throw e;
		}
			
	}
	
	
}
