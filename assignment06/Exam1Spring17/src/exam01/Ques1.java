package exam01;
import java.util.ArrayList;

public class Ques1 {
	private int n;

	public Ques1(int n1) {
		n = n1;
		if(n1<0) {
			n=-n1;
		}
	}
	public int small() {
		if(n==0|| n==1) {
			return n;
		}
		for(int i=2; i<=n; i++) {
			if(n%i ==0) {
				break;
			}		
		}
		return n;
	}
	
	public ArrayList<Integer> factorize(){
		int temp =n;
		ArrayList<Integer> al = new ArrayList<Integer>();
		while(n>1) {
			int x = small();
			al.add(x);
			n = n/x;
			
		}
		n=temp;
		return al;
	}
	
	public String toString(){
		if(n==0) {
			String a = ("0 = 0");
			return a;
		}else if(n==1) {
			String b = ("1 = 1");
			return b;
		}
		
		String str  = n +" = " + factorize();
		str =str.replace(",", " x");
		str = str.replace("[", "");
		
		return str;
		
	}
	

	
	
	
}
