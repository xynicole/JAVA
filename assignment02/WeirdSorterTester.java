package assignment02;
import java.util.Arrays;

public class WeirdSorterTester{
	
	public static void main(String[] args) {
		 	int[] test = {3,7,9,10,2,6,3,1,2};
	        WeirdSorter ws = new WeirdSorter(test);
	        
	        System.out.println(Arrays.toString(test));
	        System.out.println(Arrays.toString(ws.sorted()));

		
	}
}