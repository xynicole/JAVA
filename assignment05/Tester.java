package assignment05;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.util.List;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;

public class Tester{
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("======TwoDimNumArr compare to=======");
		var v1 = new TwoDimNumArr("test1.txt"); 
		var v2 = new TwoDimNumArr("test2.txt"); 
		var v3 = new TwoDimNumArr("test3.txt");
		System.out.println(v1.compareTo(v2)); // prints a negative number
		System.out.println(v1.compareTo(v3)); // prints 0 but test1.txt and text2.txt have different numbers of rows
		System.out.println(v2.compareTo(v3)); // prints a positive number
		System.out.println("======TwoDimNumArr input.txt=======");
		var test = new TwoDimNumArr("input.txt"); 
		System.out.println(test);
		
		System.out.println("======Locations lessEQ=======");
		
		Locations lo = new Locations();
	
		int[] empty = new int[0];
		int[] arr =new int[] {1000,100,10};


		System.out.println("Test null test array, expected: null");
		System.out.println(Arrays.toString(lo.lessEQ(null)));
		System.out.println("Test empty test array, expected ");
		System.out.println(Arrays.toString(lo.lessEQ(empty)));
		System.out.println("Test non-empty test array ");
		System.out.println(Arrays.toString(lo.lessEQ(arr)));

		
		
		System.out.println("======DiaryEntry=======");
		DiaryEvent[] de = new DiaryEvent[16];
		de[0]  = new DiaryEvent("event1",2018,1,1,1,30,10);
		de[1]  = new DiaryEvent("event1",2018,2,2,2,30,13);
		de[2]  = new DiaryEvent("event1",2018,3,3,3,40,32);
		de[3]  = new DiaryEvent("event1",2018,4,4,1,50,12);
		de[4]  = new DiaryEvent("event1",2018,5,11,6,30,14);
		de[5]  = new DiaryEvent("event1",2018,6,9,1,10,10);
		de[6]  = new DiaryEvent("event1",2018,6,3,1,30,11);
		de[7]  = new DiaryEvent("event1",2018,7,6,2,30,31);
		de[8]  = new DiaryEvent("event1",2018,7,4,5,20,21);
		de[9]  = new DiaryEvent("event1",2018,8,8,1,30,41);
		de[10]  = new DiaryEvent("event1",2018,8,2,1,30,51);
		de[11]  = new DiaryEvent("event1",2018,9,5,5,30,41);
		de[12]  = new DiaryEvent("event1",2018,9,1,1,30,21);
		de[13]  = new DiaryEvent("event1",2018,10,4,3,30,51);
		de[14]  = new DiaryEvent("event1",2018,10,9,4,50,11);
		de[15]  = new DiaryEvent("event1",2018,10,11,1,30,21);
		System.out.println(Arrays.toString(DiaryEvent.monthBreakdown(de)));
		System.out.println(de[9].toString());
		
		System.out.println("======Counter5=======");
		
		String[] strs = new String[]{null,"","abc","b","","haha"};
		System.out.println("expected: [1, 2, 3]");
		System.out.println(Arrays.toString(Counter5.counter(strs,'a')));
		String[] strs1 = null;//null
		System.out.println("expected: null");
		System.out.println(Arrays.toString(Counter5.counter(strs1, 'a')));
		
		
		List<String> list1 = new ArrayList<String>(Arrays.asList(null,"","abc","b","","haha"));
		System.out.println("expected: [1, 2, 3]");
		System.out.println(Counter5.counter(list1,'a'));
		List<String> list2 = null;
		System.out.println("expected: null");
		System.out.println(Counter5.counter(list2,'a'));
		
	}
	
	
}