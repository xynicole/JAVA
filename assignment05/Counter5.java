package assignment05;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class Counter5{
	public static int[] counter(String[] strings, char ch) {
		//The first counter method returns null if strings is null and otherwise an array retVal of length 3
		int[] retVal = new int[3];
		
		retVal[0] = 0;  //retVal[0] is the number of null Strings in the array strings
		retVal[1] = 0;  //retVal[1] is the number of empty Strings in strings
		retVal[2] = 0;  // total number times the char ch in upper or lower case occurs in all the Stings in strings
		
		if(strings == null){
			return null;
		}else {
			for (var str:strings) {
				if(str == null) {
					retVal[0]++;
				}else if(str == ""){
					retVal[1]++;
				}else {
					for (var c: str.toCharArray()) {
						if(Character.toUpperCase(c)==Character.toUpperCase(ch)) {
							retVal[2]++;
						}
					}
				}
			}
		}
		return retVal;
	}
	
	
	public static List<Integer> counter(List<String> strings, char ch){
		// The return value List<Integer> retVal is an ArrayList, which is null if strings is null, 
		//otherwise retVal.get(0), retVal.get(1), retVal.get(2) are respectively 
		//the number of null Strings, the number of empty Strings 
		//and the number of upper or lower case occurrences of ch in all the Strings in strings
		
		List<Integer> retVal = new ArrayList<>();
		retVal.add(0);
		retVal.add(0);
		retVal.add(0);
		if(strings == null){
			return null;
		}else{
			
			for (var str:strings) {
				if(str == null) {
					retVal.set(0,retVal.get(0)+1);
				}else if(str == ""){
					retVal.set(1, retVal.get(1)+1);
				}else {
					for (var c: str.toCharArray()) {
						if(Character.toUpperCase(c)==Character.toUpperCase(ch)) {
							retVal.set(2, retVal.get(2)+1);
						}
					}
				}
			}
		
		}
		return retVal;
	}
}