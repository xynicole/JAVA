package exam01;
import java.util.ArrayList;
import java.util.List;

public class Lower extends Top {
	private int[] arr1;
	
	public Lower(int[] arr, int[] arr2) {
		super(arr);
		arr1 =arr2;
	}
	public double average() {
		Top t = new Top(arr1);
		return t.average();
		
	}
	
	public int max() {
		
		if(arr1 == null && super.getArr()== null) {
			return Integer.MIN_VALUE;
		}
		if(arr1.length==0 && super.getArr().length==0) {
			return Integer.MIN_VALUE;
		}
		
		int r1 = new Top(arr1).max();
		int r2 = super.max();
		if(r1>=r2) {
			return r1;	
		}
		return r2;
		
	}

}
