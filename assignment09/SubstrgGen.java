package assignment09;
import java.util.*;
public class SubstrgGen {
	
	public static void main(String[]args) {
		String str = "rum";
		Set<String> subStrs = subStrs(str);
		System.out.println(subStrs);
		
		List<String> subStr1 = subStr1(str);
		System.out.println(subStr1);
	}
	
	
	public static Set<String> subStrs(String starter){
		Set<String> substr= new TreeSet<String>(); //create a empty set named substr
		for (int n=0;n<=starter.length();n++ ) {
			for (int j =n; j<=starter.length();j++) {
				String subs = starter.substring(n,j);
				substr.add(subs);
			}
			/*String subs = starter.substring(n);
			substr.add(subs);
			for (int i=0; i<subs.length();i++) {
				substr.add(subs.substring(0,i+1));
				
			}*/
			
		}
		return substr;
	}
	
	public static List<String> subStrHelper(String starter, List<String> temp){
		
		if (starter.length()==0){
			temp.add(starter);
			return temp;
		}
		for(int i = 1; i<= starter.length(); i++) {
			String tem = starter.substring(0,i);
			temp.add(tem);
		}
		return subStrHelper( starter.substring(1),temp);
		
	}
	
	public static List<String> subStr1(String starter){
		return subStrHelper(starter,new ArrayList<>());
	}
	
	
	


}
