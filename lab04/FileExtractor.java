package lab04;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.util.Arrays;
import java.io.FileNotFoundException;
import java.util.Iterator;
class FileExtractor{
    private int[] array;
    private List<Integer> list;
    public FileExtractor(String fileName){
        list = new ArrayList<Integer>();
        // try-with-resources block (sc is the resource we are trying to use)
        try(Scanner sc = new Scanner(new File(fileName))){
            while(sc.hasNext()){
                int a =  sc.nextInt();
                try {
                    //  Integer a = Integer.parseInt(oneElement);
                    list.add(a);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            //now list is ready
            array = new int[list.size()];
            for(int i = 0;i<list.size();i++)
            {
                array[i] = list.get(i);
            }//copy ready

        }
        catch(FileNotFoundException e){
            // make array is empty array
            array = new int[0];
            System.out.println("File '" + fileName + "' not found, initializing both 'list' and 'array' to be empty\n");
        }
        catch(Exception e){
            System.out.println("Error occurred while extracting data:\n");
            e.printStackTrace();
        }
    }
    public String toString() {
        String res = "array: " + Arrays.toString(array) + "\nlist: " + list.toString();
        return res;

    }
    public void removeOddElement () {
        //create a arrary
        int evenNum = 0;
        for(int i:array) {
            if(i%2 == 0)
                evenNum++;
        }
        int[]temp  = new int[evenNum];
        int index  =0;
        for(int i:array) {
            if(i%2 == 0){
                temp[index++] = i;
            }
        }
        array = temp;
    }
    public void removeEvenElements() {
        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext()) {
            Integer i = iter.next();
            if(i % 2 == 0) iter.remove();
        }

    }
}