package assignment04;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
public class Tester {
    public static void main(String[] args) throws FileNotFoundException {
        testReadArray();
        testReadList();
        testFlatten1();
        testFlatten2();
        testCompare();
       
    }

    public static void testReadArray() throws FileNotFoundException {
        int[][] arrays = NumberReader.readArray("test.txt");

        System.out.println(Arrays.deepToString(arrays));
    }



    public static void testFlatten1() throws FileNotFoundException {
        int[] array = NumberReader.flatten(NumberReader.readArray("test.txt"));

        System.out.println(Arrays.toString(array));
    }



    public static void testReadList() throws FileNotFoundException {
        System.out.println(Arrays.deepToString(NumberReader2.readList2("test.txt").toArray()));
    }

    public static void testFlatten2() throws FileNotFoundException {
        System.out.println(Arrays.toString(NumberReader2.flatten2(NumberReader2.readList2("test.txt")).toArray()));
    }

    public static void testCompare() throws FileNotFoundException {

        System.out.println(NumberReader.compare(NumberReader.readArray("test.txt"), "test.txt"));

        System.out.println(NumberReader.compare(NumberReader.readArray("test.txt"), "test1.txt"));

        System.out.println(NumberReader.compare(NumberReader.readArray("test.txt"), "test2.txt"));

        System.out.println(NumberReader.compare(NumberReader.readArray("test.txt"), "test3.txt"));


        System.out.println(NumberReader2.compare(NumberReader2.readList2("test.txt"), "test.txt"));

        System.out.println(NumberReader2.compare(NumberReader2.readList2("test.txt"), "test1.txt"));
  
        System.out.println(NumberReader2.compare(NumberReader2.readList2("test.txt"), "test2.txt"));
     
        System.out.println(NumberReader2.compare(NumberReader2.readList2("test.txt"), "test3.txt"));

    }
}
