# lab05 (practice in-lab test): Due tonight at midnight

Next week's lab, September 27th, we will have the first in-lab exam.

<h1>Directions [IMPORTANT]</h1>
  
This lab is just a practice in-lab exam, it will be graded as a lab under the lab category.
  
This lab will serve as practice for next week's in-lab programming test. In next week's test, you must use the lab machines and may not use the internet nor eclipse, only a text-editor and the command-line. This does not include the github page associated with the exam and myCourses for submission. You are strongly encouraged to try to complete this lab under such an environment, but of course you don't have to this week.
  
The format, and difficulty will be relatively similar to that of this week's lab. Keep in mind that next week's exam is in-lab, meaning you only have the 85 minutes to start, finish, and submit the exam.
  
All classes below go into `package lab05 `. Points deducted otherwise.
  
<h1>Warning About Non-Compiling Code</h1>
  
Submitting non-compiling code will be heavily penalized as we are unable to run (test) code that doesn't compile. If you're unable to get a particular piece of code to compile, comment it out such that your program compiles. Implement the classes and methods as is, do not change their names, or change the function signatures. Do not add any methods not asked for.
  
A Tester is provided to you at the bottom of the directions for you to run your attempts at. Be aware though that the tests are basic; passing all the tests does not imply a 100% grade. There are cases the Tester does not test that you are required to fulfill. Therefore, you are encouraged to add your own tests to the Tester to better test your solutions.

<h1>Question 1</h1>

Create a class `Division` with one private field: a `List<Double>` named `list`.
Initialize `list` to an empty ArrayList in the declaration
  
Create a constructor that takes in `double[] array` as a parameter and adds each double in `array` to `list`
if `array` is `null` or empty, throw an `IllegalArgumentException` with a message `"need to enter an array with at least one double"`
  
Create a method `public void removeZeroes()` which removes all zeroes from `list`. Think about the correct way to do this, remembering that removing from a data structure which dynamically changes in size can be tricky. 
  
Create a method `public void divide(int divisor)`
Replaces each entry in `list` with that entry divided by `divisor`
if `divisor` is zero, throw an `IllegalArgumentException` with a message `"cannot divide by zero"`
For example, if `list` is `[1,2,3,4,5,6,7,8,9]` and `divisor` is `2`, after the call `list` will be `[0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5]`
  
Override the `toString` method that returns `list.toString();`
  
<h1>Question 2</h1>
   
Create a class `FunWithStrings` with no fields
  
Implement the method `public static void swapMaxes(List<String> list1, List<String> list2)`
if either `list1` or `list2` are `null` or empty, or a list contains only `null` elements, throw an `IllegalArgumentException` saying `"cannot swap maxes of empty lists, null lists, or lists with all null elements"`
you can assume that each non-null `String` in `list1` and `list2` will all have different lengths
if a `String` contained in either `List` is `null`, ignore it and continue searching for the longest `String`
find the longest `String` in `list1` (need a way to store the String and the index it is at)
find the longest `String` in `list2` (need a way to store the String and the index it is at)
swap the longest `String`s between the two `List`s
For Example, given `["to", "cellphone", "truck", "fire"]` and `["delicious", "copper", "blue", "red"]`, after this method is called `list1` will be `["to", "delicious", "truck", "fire"]` and `list2` will be `["cellphone", "copper", "blue", "red"]`
  
<h1>Question 3</h1>
  
Create a class `Zipper` with no fields.
  
Implement the method `public static int[] zip(int[] arr1, int[] arr2)`
If either `arr1` or `arr2` is `null`, or they do not have the same `length`, throw an `IllegalArgumentException` with a message `"bad input"`
This method should return an array that alternates between the elements of `arr1` and `arr2` in the order they appear in their arrays.
For example, given `{1, 2, 3, 4}` and `{5, 6, 7, 8}`, `{1, 5, 2, 6, 3, 7, 4, 8}` should be returned
Return an empty array if empty arrays are given.

<h1>Tester</h1>

Below is a minimal `Tester` class, you can use as is. However, it only tests the most basic cases, you should add your own cases to make sure all aspects of your methods are correct.

```java
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
        
    }

    public static void testFunWithStrings() {
    	List<String> list1 = new ArrayList<String>(Arrays.asList("to", "cellphone", "truck", "fire"));
    	List<String> list2 = new ArrayList<String>(Arrays.asList("delicious", "copper", "blue", "red"));
    	FunWithStrings.swapMaxes(list1, list2);
        System.out.println("Expecting [to, delicious, truck, fire] [cellphone, copper, blue, red]");
        System.out.println("Received  " + list1 + " " + list2 + "\n");
    }

    public static void testZipper() {
        int ret[] = Zipper.zip(new int[]{1, 2, 3, 4}, new int[]{5, 6, 7, 8});
        System.out.println("Expecting [1, 5, 2, 6, 3, 7, 4, 8]");
        System.out.println("Received  " + Arrays.toString(ret));
    }
}
```
