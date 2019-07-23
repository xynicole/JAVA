package lab04;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.util.Arrays;
import java.io.FileNotFoundException;
import java.util.Iterator;

public class FileExtractorTester {


    public static void main(String[] args) {
        try {
            if(args.length<1) {
                throw new IllegalArgumentException("The program requires exactly 1 argument, the name of a file to be opened");
            }

        }
        catch(IllegalArgumentException e){
            System.out.println(e.toString());
        }
        // the args[0] is fileName
        String fileName = args[0];
        FileExtractor value  = new FileExtractor(fileName);
        System.out.println(value.toString());
        value.removeOddElement();
        value.removeEvenElements();
        System.out.println(value.toString());
        int[] array = new int[5];
        System.out.println(Arrays.toString(array));
        int n = 0;
        for (int i : array) {
            i = n;
            n++; // shorthand to increment by 1
        }

        System.out.println(Arrays.toString(array));
        String str1 = "Apple";
        String str2 ="Google";
        String str3 = "Facebook";
        String str4 ="Alibaba";
        String[]strArray = new String[]{str1,str2,str3,str4};
        for(String i:strArray) {
            System.out.println(i+" "+i.length());
        }

    }
}
