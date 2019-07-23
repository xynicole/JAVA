# Lab04

<h1>Due tonight at 11:59pm</h1>
All packages in package lab04.



<h1>Command-line Arguments</h1>

When you input the command: 

><b>javac -d . *.java</b>  

Everything after the javac command is said to be its arguments. Java lets us write programs that accept and handle command-line arguments too, that is exactly what String[] args are in the main methods you write.
  
The following class, EchoArgs.java has been provided for you:  
  
```java
package lab03;

import java.util.Arrays;

/* YOUR ANSWERS HERE:
 * ------------------
 * 1.
 * 2.
 * 3.
 * 4.
 * 5.
 */

public class EchoArgs {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
    }
}
```  

This program simply prints any command line arguments you give to it. In the given comment block, fill in what gets print out when you execute (copy/paste each command)

>java lab04.EchoArgs

>java lab04.EchoArgs hello

>java lab04.EchoArgs hello world

>java lab04.EchoArgs "hello world"

>java lab04.EchoArgs *

Your answers in the comment will be graded.

<h1>Exceptions</h1>

You may have encountered <b>Exceptions</b> in doing previous assignments but we are now going to formally introduce them. 
Simply put, exceptions are the way for signalling and handling when things go wrong during a program's runtime. 
When working with an array, one exception we could come across is <b>`ArrayIndexOutOfBoundsException`</b>. 
This will happen when accessing an element with an index less than zero or an index greater than or equal to the array's <b>length</b>.

```java

package lab04;

public class ArrayExample{
	public static void main(String[] args){
		double[] array = new double[10];
		
		//insert the numbers 1 through 10
    		//is this loop okay?
		for(int i = 1; i <= array.length; i++){
			array[i-1] = i;
		}

    		//if there was no issue above, do you see an issue here?
		for(int i = 0; i < array.length; i++){
			System.out.println(array[i-1]);
		}
	}
}
```


A more common exception is <b>`NullPointerException`</b> which happens whenever you try to do something with nothing. 
While primitive (basic) types like <b>int</b> have predefined default values like 0, arrays' and <b>Objects</b>' default value is <b>null</b>.  
  
If you don't initialize an <b>Object</b>, it remains <b>null</b>. If you then try and call a method on that Object, you will get a 
`NullPointerException` for trying to do something (call a method) on nothing (the null Object). See if you can spot the bug in the 
following code:

```java
class BadClass {
    private int[] myArray;

    public BadClass() {
        System.out.println("There are " + myArray.length + " elements");
    }
    
    public static void main(String[] args){
        BadClass breaks = new BadClass();
    }
}
```

Recall exceptions are for signalling and handling errors. To signal an error (i.e. exception) we <b>`throw`</b> a new Exception object. 
Once you signal an error, the function caller can choose to either handle or ignore the exception. 
The <b>`IllegalArgumentException`</b> class is commonly used to tell the method caller they have provided an 
illegal argument to the method.

```java
public double factorial(int num) {
    if (num < 0) {
        throw new IllegalArgumentException("Cannot take factorial of negative number");
    }
    // ...
}
```

A common error that might occur when doing input/output with files is that the file might not be there. 
This is what the <b>`FileNotFoundException`</b> class represents. To handle the possibility of an error, we try to do the 
dangerous code, and if anything goes wrong we catch it.

```java
    try{
    		FileReader myFile = new FileReader("file_that_doesnt_exist.txt");
		} 
		catch(FileNotFoundException e) {
    		System.out.println("That file does not exist!");
		}
```
All the above examples can be found in the folder <b>Exception_Examples</b>. Feel free to compile and run them for yourself to see the exceptions occur first hand.
  
Armed with knowledge of how to use command-line arguments and exceptions, let's do some coding.


<h1>Reading from text file</h1>
  
Create a class, <b>FileExtractor</b> with two private fields, an <b>`int[]`</b> named <b>`array`</b> and <b>`List<Integer>`</b> named <b>`list`</b>. The idea of this class is to hold an array and list whose elements it reads from a given file.  
  
Import the following:  
> import java.util.List;  
> import java.util.ArrayList;  
> import java.io.File;  
> import java.util.Scanner;  
> import java.util.Arrays;  
> import java.io.FileNotFoundException;  

Create a constructor that accepts a <b>String fileName</b>. The constructor will populate <b>`array`</b> and <b>`list`</b> with integers read from the file with name <b>`fileName`</b>. The body of your constructor will start off with

```java
	public FileExtractor(String fileName){
		list = new ArrayList<Integer>();
    		// try-with-resources block (sc is the resource we are trying to use)
		try(Scanner sc = new Scanner(new File(fileName))){
		
		}
		catch(Exception e){

		}
	}
```

The <b>`Scanner`</b> class is for scanning files and reading their data. We will try to read integers from 
it and if anything goes wrong, we will catch the error. The format of the files you will be reading from is:

>num_1  
num_2  
.  
.  
.  
num_N  

where each integer that is to be included in `list` and `array` are on their own line. With our scanner named <b>sc</b>, 
we can retrieve the next integer from the file by calling the method <b>`nextInt()`</b> on our <b>`Scanner sc`</b>. 

In the `try` block, while there is a next integer to scan (you can check if there is more to scan using Scanner's `hasNext()` method), add the next integer to `list`. Once you have added all the integers to `list`, initalize `array` so that it has the same length as the size of `list`. Finally, copy over each int from `list` to `array` using a for loop.

Notice that we have a catch block that catches any Exception. However, we want to handle a FileNotFoundException in a specialized way. To do this, add another catch block between the try block and the catch block provided:  
  
```java
catch(FileNotFoundException e){

}
```  

<b>PLEASE NOTE: The order you place these two catch blocks matters. In general, you want to start with the most specialized Exception and then add more catch blocks for more general Exceptions.</b>  
  
In the `FileNotFoundException` catch block, assign <b>`array`</b> to an empty array, that is, an array of length 0. If anything wrong occurs, this leaves the array empty and not <b>null</b>. Note that `list` was already initialized to an empty ArrayList, so we don't have to do anything for `list` in this catch block. Additionally, add the following to the `FileNotFoundException` catch block:  

>`System.out.println("File '" + fileName + "' not found, initializing both 'list' and 'array' to be empty\n");`  

In the `Exception` catch block, which will catch all other errors, add the following:

>`System.out.println("Error occurred while extracting data:\n");`  
`e.printStackTrace();`  
  
Next, create getter methods for <b>`array`</b> and <b>`list`</b> as well as a <b>toString</b> method that returns:  
  
>`"array: " + Arrays.toString(array) + "\nlist: " + list.toString();`  
  
Now to test your <b>FileExtractor</b> implementation, create a class called <b>FileExtractorTester</b> with a main method. 
In the main method, check how many arguments you were passed in through the command-line. If you have not received exactly 1 argument, throw an <b>IllegalArgumentException</b> with the following message:  
  
> "The program requires exactly 1 argument, the name of a file to be opened"  
  
Otherwise, create a new <b>FileExtractor</b> object, passing in the single command-line argument to the constructor. Print out a statement detailing what you expect to be printed out (see below). Then print out the <b>FileExtractor</b> object you created. You can just print the object, since we implemented the `toString()` method in the FileExtractor class.  
  
The following file, <b>`input.txt`</b> has already been provided for you:

>5  
20  
8  
13  
46  
7  
  
Run the FileExtractorTester with input.txt as a command line argument. Test that your program's output statements match.  
  
<h1>More with the enhanced for loop</h1>
  
Back in the <b>FileExtractor</b> class, create a method <b>public void removeOddElements()</b>. This method has two for loops, 
they must both be enhanced for loops or no credit. The void means that the method returns nothing. This method will have the effect 
of removing the odd elements of <b>array</b>, or from another perspective, only keeping the even elements.  

First, we must know how many even elements are in the array so use an enhanced for-loop to count the number of even ints in <b>`array`</b>. An int is even if that int divided by 2 has remainder 0, or in Java/C/Python `i % 2 == 0`. Make a temporary array whose <b>`length`</b> is the number of even ints in <b>`array`</b>.  
    
Make an <b>`int index`</b> variable, initialized to 0, to track which index in the temporary array we are at. 
Use an enhanced for loop to go through <b>`array`</b> once more. If the current int is even, copy it to the `index` slot in the 
temporary array and increment <b>`index`</b>. After the for loop, we must assign the temporary array to <b>`array`</b> to make our changes persist after the method.  
  
Back in the main method of <b>FileExtractorTester</b>, after you create the <b>FileExtractor</b> object and print it, call the 
<b>removeOddElements()</b> method on it. Print out what you expect to be printed out as well as the 
<b>FileExtractor</b> object after removal to verify your method works.  
  
Still in this main method, but at the end, declare an int array of length 5. Print it out using Arrays.toString(). Note each element gets int's default of 0. Copy/paste the following enhanced for loop code:
  
```
int n = 0;
for (int i : array) {
    i = n;
    n++; // shorthand to increment by 1
}
```
  
Print out the array again. What do you see? What you expected? The array still has all zeroes because of how the enhanced for loop works. When we said for (int i : array), we made i a reference variable (pointer in C-speak) that refers to each element. So when we assign n to i, it is not the array element we are overwriting but the reference to the array element. <b>Regular for loops must be used if you need to assign values to elements.</b>
  
Enhanced for loops are best when you don't care about the indices of the element and you're only reading elements (not writing as we saw above).
  
Still in the main method, make an array of Strings with four strings of your choice. Use an enhanced for loop to print out each string and each string's length (number of characters), separated by a space (" "). A String's length is given by the length method (e.g. myString.length()). Make sure what is printed out makes sense.  

<h1>Highlighting some Tricky Aspects of ArrayLists</h1>
  
Back in <b>FileExtractor</b>, create a method <b>public void removeEvenElements()</b>. Unlike removeOddElements(), which modified the field `array`, this method will modify our field `list`. Add the following enhanced for loop, which looks slick compared to the work we had to do in removeOddElements above:  
  
```
for(Integer i : list){
    //note i is not an index here, it is an Integer object found in list
    if(i % 2 == 0) list.remove(i);
}
```
  
Recall that last lab we told you there was a remove() method that takes the index of the element in a List that you want to remove. 
It turns out there is another remove() method that will allow you to remove an object from the list (in this case one of the Integers). This means the above code will compile.  
  
Back in <b>FileExtractorTester</b>, add a call to removeEvenElements() on the FileExtractor object, immediately after the removeOddElements() call. Compile and run the class.  
  
What happened? You should now see that you get a `ConcurrentModificationException`. It turns out you cannot use enhanced for loops when you are trying to remove elements from a list. The reason is that enhanced for loops are syntatic sugar for using an Iterator, but you are still trying to call the remove() method of `list` rather than explicitly using the `remove()` method of an Iterator. <a href="https://javarevisited.blogspot.com/2016/02/how-does-enhanced-for-loop-works-in-java.html"> You can read more about this here</a>, and we will describe Iterators below.
  
So what can we do instead? One thing that works is something like the following, using a traditional for loop:  
  
```
for(int i = 0; i < list.size(); i++){
	//we can post decrement i, so after remove is called, i is adjusted for
	//the shift of elements
	if(list.get(i) % 2 == 0) list.remove(i--);
}
```
  
Notice that since a list shrinks, if we remove an element, then we need to shift i to the left, so we don't skip elements. The above will compile, and in fact work, but it is a bit janky. <b>Do NOT use the traditional for loop shown here, even though it works, it is considered bad practice. Points will be taken off if you include it.</b>  
  
What is considered the best approach? We can use an <b>Iterator</b>. Add the import `java.util.Iterator` to <b>FileExtractor</b>. An Iterator is used to iterate over a data structure, in this case, our `list`. List has an `iterator()` method built in, which will return an Iterator that we can use to iterate over our `list`. 
In `removeEvenElements()`, add the following line of code:  
  
> Iterator<Integer> iter = list.iterator();  
  
Notice that `iter` an `Iterator<Integer>` because `list` holds `Integer`s. We can check if the `Iterator<Integer> iter` has more elements to iterate over in `list` using the method `hasNext()`, which returns true if there is more Integers for `iter` to iterate over, and false otherwise. So, while `iter` has more elements to iterate over, we can grab the next Integer i using the line:  

> Integer i = iter.next();  
  
Calling the `next()` method will not only grab the next Integer in `list`, but `iter` will keep track internally, so that when you call `next()` again, it will return the element that comes after the one returned by `next()` previously. We can remove Integer i if it is even, by calling:

>iter.remove();  

The  `remove()` method for Iterator `iter` will remove the last element that was returned when `iter.next()` was called. Additionally, it will automatically account for `list` shrinking, which means you do not have to account for elements being shifted around as you remove from `list`. All of that is handled for you internally. This is why Iterators are a preferred method for removing elements from an ArrayList, such as `list`.  The final code in removeEvenElements() should now be:
  
```
Iterator<Integer> iter = list.iterator();
while(iter.hasNext()){
	Integer i = iter.next();
	if(i % 2 == 0) iter.remove();
}
```  
Go ahead and rerun <b>FileExtractorTester</b> and confirm you get the correct output. `array` should hold all the even elements, and `list` should hold all the odd elements from the original input.txt file.  

<h1>Submit to GitHub and myCourses</h1>  
  
>git add -A  
>git commit -m "completed lab04"  
>git push  
>git rev-parse HEAD
  
Submit the commit hash to myCourses.
