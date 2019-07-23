package assignment05;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Random;

public class Locations{
	private int[] array;
	public static final Random rand = new Random();
	
	public Locations(int[] ar) {
		array = ar;
		
	}
	
	public Locations() {
		//make an int len with the value 10+rand.nextInt(50);
		//set array to be an int array with length len
		//in a for loop set each array[i] to some randome value: rand.nextInt(100);
		
		int len = 10+rand.nextInt(50);
		array = new int[len];
		for(int i=0;i<array.length;i++) {
			array[i]=rand.nextInt(100);
		}
		
	}
	
	public int[] getArray() {
		return array;
	}
	
	public int[] lessEQ(int[] test) {
		List<Integer>list = new ArrayList<>();
	
		if(array ==null || test ==null) {
			//if(array==null) System.out.println(3);
			return null;
		}else if(array.length ==0 || test.length ==0) {
			return new int[0];	
		}
		
		for(int i=0; i<array.length &&i<test.length; i++) {
			if(array[i] <= test[i]) {
				list.add(i);
			}
		}
		
		int[] retVal = new int[list.size()];
		//System.out.println(Arrays.toString(retVal));
		//copy the elements of the list into this retVal
		for(int i=0; i<retVal.length; i++) {
			retVal[i]=list.get(i);
			//System.out.println(2);
		}
		
		return retVal;
		
		
		
		
	}
	
	
}