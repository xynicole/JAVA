package exam01;

public class Tester {
	public static void main(String[] args) {
		int[] test1 = null;
		int[] test2 = {};
		int[] test3 = {5, 2, -2, 7, -5, 2};
		 
		System.out.println(new Top(test1).average());
	 
		System.out.println(new Top(test3).average());

		System.out.println(new Lower(test3, test2).average());

		System.out.println(new Lower(test2, test3).average());

		System.out.println(new Top(test3).max());

		System.out.println(new Lower(test2, test2).max());
	
		System.out.println(new Lower(test2, test3).max());
	}
}
