package exam01;
import java.util.ArrayList;
import java.util.List;

public class Top {
	private int[] arr;
	

	public int[] getArr() {
		return arr;
	}
	public void setArr(int[] arr) {
		this.arr = arr;
	}
	public Top(int[] a) {
		arr = a;
	}
	public double average() {
		if(arr ==null || arr.length ==0) {
			return 0;
		}
		double sum = 0;
		double aver =0;
		for (int i:arr) {
			sum += i;
		}
		aver = sum/arr.length;
		return aver;
		
	}
	
	public int max() {
		if(arr ==null || arr.length ==0) {
			return Integer.MIN_VALUE ;
		}
		int max = 0;
		for (int i=0; i<arr.length ; i++) {
			if(arr[i] >arr[max]) {
				max=i;
			}
		}
		return arr[max];
	}
	
	
}
