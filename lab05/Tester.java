package lab05;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Tester {

    public static void main(String[] args) {
    	testDivision();
    	testFunWithStrings();
        testZipper();
    }

    public static void testDivision() {
    	Division set = new Division(new double[]{1,2,3,0,4,5,0,6,0,7,8,9,0});
        set.removeZeroes();
        set.divide(2);
        System.out.println("Expecting [0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5]");
        System.out.println("Received  " + set + "\n");
        
      
        System.out.println("Expecting cannot divide by zero");
        try{
            set.divide(0);
        }catch(IllegalArgumentException e){
            System.out.println("Received "+e.getMessage()+"\n");
        }
        
        
        System.out.println("Expecting need to enter an array with at least one double");
        try{
            Division set1 = new Division(null);
        }catch(IllegalArgumentException e){
            System.out.println("Received "+e.getMessage()+"\n");
        }
        
      
        System.out.println("Expecting need to enter an array with at least one double");
        try{
            Division set2 = new Division(new double[]{});
        }catch(IllegalArgumentException e){
            System.out.println("Received "+e.getMessage()+"\n");
        }
        

        
    }

    public static void testFunWithStrings() {
    	List<String> list1 = new ArrayList<String>(Arrays.asList("to", "cellphone", "truck", "fire"));
    	List<String> list2 = new ArrayList<String>(Arrays.asList("delicious", "copper", "blue", "red"));
    	FunWithStrings.swapMaxes(list1, list2);
        System.out.println("Expecting [to, delicious, truck, fire] [cellphone, copper, blue, red]");
        System.out.println("Received  " + list1 + " " + list2 + "\n");
        
       
        List<String> list3 = new ArrayList<String>(Arrays.asList("to", "cellphone", "truck", null));
    	List<String> list4 = new ArrayList<String>(Arrays.asList("delicious", "copper", "blue", null));
    	System.out.println("Expecting [to, delicious, truck, null] [cellphone, copper, blue, null]");
        	FunWithStrings.swapMaxes(list3, list4);
    		System.out.println("Received  " + list3 + " " + list4 + "\n");
    	
    	
    	
    	
    	System.out.println("Expecting cannot swap maxes of empty lists, null lists, or lists with all null elements");
        try{
        	List<String> list5 = null;
        	List<String> list6 = null;
        	FunWithStrings.swapMaxes(list5, list6);
        }catch(IllegalArgumentException e){
            System.out.println("Received  " +e.getMessage()+"\n");
        }
         
        System.out.println("Expecting cannot swap maxes of empty lists, null lists, or lists with all null elements");
        try{
        	List<String> list7 = new ArrayList<String>(Arrays.asList( ));
        	List<String> list8 = new ArrayList<String>(Arrays.asList( ));
        	FunWithStrings.swapMaxes(list7, list8);
        }catch(IllegalArgumentException e){
            System.out.println("Received  " +e.getMessage()+"\n");
        }
    	
    }

    public static void testZipper() {
    	int ret[] = Zipper.zip(new int[]{1, 2, 3, 4}, new int[]{5, 6, 7, 8});
        System.out.println("Expecting [1, 5, 2, 6, 3, 7, 4, 8]");
        System.out.println("Received  " + Arrays.toString(ret)+"\n");
        
        
        System.out.println("Expecting bad input");
        try{
            int ret1[] = Zipper.zip(new int[]{1, 2, 3, 4}, new int[]{5, 6, 7, 8, 9, 10});
        }catch(IllegalArgumentException e){
            System.out.println("Received  " +e.getMessage()+"\n");
        }
        
 
        int ret2[] = Zipper.zip(new int[]{}, new int[]{});
        System.out.println("Expecting []");
        System.out.println("Received  " + Arrays.toString(ret2)+"\n");
        
      
        System.out.println("Expecting bad input");
        try{
            int ret3[] = Zipper.zip(null, null); 
        }catch(IllegalArgumentException e){
            System.out.println("Received "+e.getMessage()+"\n");
        }
    }
}