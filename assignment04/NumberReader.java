package assignment04;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class NumberReader{
	
	private static int[] readString(String line) {
		// first count how many integers are in the line
		var count = 0; // in Java 10 we can use "var" and Java infers the type.
		try(var lineScan = new Scanner(line)){ // this is "try with resources"
							// the Scanner will be closed automatically
							// if anything goes wrong
			while(lineScan.hasNextInt()) {
				count ++;// increase count
				lineScan.nextInt();// use nextInt() to move to the next integer
			}
		}
		// make an array with length count
		var retVal = new int[count];
		try(var lineScan = new Scanner(line)){ // open the scanner again from the start
			for(int i=0;i<count;i++ ){// in a for loop with i from 0 up to but not including count
				retVal[i] = lineScan.nextInt(); // set retVal[i] = lineScan.nextInt();
			}
			
		}		
		return retVal;
	}
	
	
	//will store all the numbers from your test file in an array of arrays (a 2-dimensional array   Arrays.deepToString()
	public static int[][] readArray(String fileName) throws FileNotFoundException{
		var count =0; //Make a counter count
		try(var scan = new Scanner(new File(fileName))) { //this is the line that could throw FileNotFoundException
			
			while (scan.hasNextLine()) {
	            count++;
	            scan.nextLine(); //add 1 to the counter and move to the next line

	    	}		
		}	
		
		var retVal = new int[count][]; //Now make a 2 dimensional array for the return value
		try(var scan = new Scanner(new File(fileName))) { //Reopen the scanner
			for(int i=0;i<count;i++) {
				retVal[i] = readString(scan.nextLine()); //with i from 0 up to but not including count set retVal[i] = readString(scan.nextLine())
			}
			
		}
		return retVal;
					
	}
		
	public static int[] flatten(int[][] arrays) {
	//makes one long one-dimensional array by joining together all the rows of the two dimensional array
		//add up all the lenghts of the rows
		int count=0;
		for(var arr : arrays) {
			count += arr.length;
		}
		var retVal = new int[count];
		count = 0;
		for(var array : arrays) {
			for (int i : array) {
				retVal[count] = i;
				count++;
			}
		}
		
		return retVal;
		
	}	

	public static boolean compare(int[][] arrays, String filename) throws FileNotFoundException{
		// compares the sequence of all the numbers in the file to all the numbers in the rows of the 2-dimensional array
		var flat = flatten(arrays);
		var index=0;
		boolean revVal = true;
		
		try(var scann = new Scanner(new File(filename))){
			while(scann.hasNextInt()){
				if(index >= flat.length || flat[index] != scann.nextInt()){
					revVal=false;
					break;	
				}
				index++;				
			}	
		
		}
		
		return revVal;
		
		
	}

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(compare(readArray("test.txt"), "test.txt"));
    }
	

	
	
}
