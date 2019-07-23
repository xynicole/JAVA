package assignment05;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class TwoDimNumArr{
	private int[][] array;
	
	public TwoDimNumArr(String fileName) throws FileNotFoundException{
		var count =0; 
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
		array = retVal;
						
	}
	
	
	private static int[] readString(String line) {
		// first count how many integers are in the line
		var count = 0;
		try(var lineScan = new Scanner(line)){ 
							 
			while(lineScan.hasNextInt()) {
				count ++;// increase count
				lineScan.nextInt();// use nextInt() to move to the next integer
			}
		}
		// make an array with length count
		var retVal = new int[count];
		try(var lineScan = new Scanner(line)){  
			for(int i=0;i<count;i++ ){ 
				retVal[i] = lineScan.nextInt();  
			}
			
		}		
		return retVal;
	}
	
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(var row : array) {
	        for(var num : row) {
	            //look up the append method of StringBuffer to append (num + " ") to sb
	        	sb.append(num + " ");
	        	
	        }
		    // set the length of sb to sb.length()-1 to get rid of last space on the line
		    //Hint: you will need StringBuilder's setLength() method, see the API mentioned in the link above
		    // append a new line character "\n"
	        
	        sb.setLength(sb.length()-1);
	        sb.append("\n");
		}
		return sb.toString();
	}
		
	
	public boolean compare(String filename) throws FileNotFoundException{
		var flat = flatten(array);
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
	
	public int compareTo(TwoDimNumArr other) {
		return  Arrays.compare(flatten(this.array), flatten(other.array));
		/*if a.compareTo(b) returns a negative value, that means that a is considered strictly less than b.
		if a.compareTo(b) returns a positive value, that means that a is considered strictly greater than b.
		if a.compareTo(b) returns zero, that means a is considered equal to b.
		 */
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
	
	
	
}