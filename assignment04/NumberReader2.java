package assignment04;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

public class NumberReader2{
	private static List<Integer> readString2(String line){ //line contains integers separated by spaces
		List<Integer> retVal = new ArrayList<Integer>(); 
		try(var lineScan = new Scanner(line)){
			while(lineScan.hasNextInt()){
				retVal.add(lineScan.nextInt());
			}
		}// returns an ArrayList version of the array returned by readString in the class NumberReader
		

		
		return retVal;
		
		
	}
	public static List<List<Integer>> readList2(String fileName) throws FileNotFoundException {

		List<List<Integer>> retVal = new ArrayList<>();
		try(var scan = new Scanner(new File(fileName))){
			while(scan.hasNextLine()){
				retVal.add(readString2(scan.nextLine()));
			}
		}
		return retVal;
	}
	
	public static List<Integer> flatten2(List<List<Integer>> list){//make a single list from the list of lists
		//do not have to compute the total length of the output before copying over the elements of the rows into the output.
		
		List<Integer> retVal = new ArrayList<>();
        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                retVal.add(integer);
            }
        }
        return retVal;
		
	}
	public static boolean compare(List<List<Integer>> list, String filename) throws FileNotFoundException{
        var flat = flatten2(list);
        var index = 0;
        boolean retVal = true;
        try(var scann = new Scanner(new File(filename))) {
            while (scann.hasNextInt()) {
                if (index >= flat.size() || flat.get(index) != scann.nextInt()) {
                    retVal = false;
                    break;
                }
                index++;
            }
        }
        return retVal;
	}

    public static void main(String[] args) throws FileNotFoundException {
    }

	
}