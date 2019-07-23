# Lab02 

<h1>Due tonight by 11:59 pm</h1>  

<h1>A word about Eclipse</h1>
We will be learning and using the Eclipse IDE for Java development later in the semester. You are of course allowed to use it now as some of you already know it, however there will be in-lab exams, the first of which will require the unassisted use of the command line and forbid Eclipse. If you are unfamiliar with Eclipse, its probably best to wait to use it.  
<h1>Refresher</h1>
You will probably want to <b>cd</b> into your <b>cs140/labs</b>. From now on, all future links for accepting assignments and labs will be set directly to your email. 

Accept your invitation via the email sent out. Then hit the green <b>cloan or download</b> button, copying the URL.  
Back in the terminal, run the command:  
<b>git clone URL</b>  

Recall that it is <b>javac -d . *.java</b> to compile and <b>java lab02.X</b> where <b>X</b> is the name of the class whose main method you wish to run.  
  
All classes should be in the <b>package lab02</b>  
  
You can create new files via the command line by running <b>gedit fileName.java&</b> where fileName is the name of the class.
<h1>A simple class</h1>
Create a class, <b>Book</b> which will model a printed book.   
Give the class two private instance variables, <b>title</b> of String type and <b>numPages</b> of int type.  
  
Copy/paste this constructor as the Book constructor and fill in the missing two lines such that <b>aTitle</b> is assigned to <b>title</b> and similarly for <b>numPages</b>.  

```java
public Book (String aTitle, int aNumPages) {

}
```  
  
Provide getter methods for <b>title</b> and <b>numPages</b>. Remember the method return type must match the variable type and the method name comes from prepending the word 'get' to the capitalized variable name.  
  
Compile the Book class with <b>javac -d . *.java</b> to make sure its correct before moving on.   
<h1>Introduction to Arrays</h1>
When we want to hold an arbitrary number of things together, Java offers the <b>array data structure</b>. Arrays are fixed-length meaning once you pick its length, it cannot change. They can also only hold things of the same type. The following code chunks are for demo only, you don't need to copy them anywhere.  
To declare an array of 3 integers:  
  
```java
int[] someInts = new int[3]; // holds {0, 0, 0}
```  

This only declares the space for 3 ints, it doesn't initialize any of the slots so they default to 0.  
  
If you know the elements you want your array to have  
  
```java
int[] myInts = {1, 2, 3};
```  
  
you just list them in between curly braces as above.  
  
Array elements can be retrieved or set using square braces ([]).  
  
```java
System.out.println(myInts[0]); // prints 1
myInts[1] = 5;
myInts[2] = 1;
System.out.println(myInts[2]); // prints 1
```  
  
Notice that array indices, like most other programming languages, start at 0 and go up to one less than the array's length. In Java, array indices must be positive.  
  
To retrieve an array's length (which can never change), use length (without parentheses). So, to print the last element of an array of any length:  
  
```java
System.out.println(unknownArray[unknownArray.length-1])
```  
  
Remember the elements of an array must all be the same type. It would be illegal to add a double or a String to <b>myInts</b>.  
  
The <b>for loop</b> is a natural way to visit each element of an array in linear order.  
  
```java
for (int i = 0; i < myInts.length; i++) {
    System.out.println(myInts[i]); // print ith element of myInts
}
```  
  
More about arrays can be found <a href ="http://cs.binghamton.edu/~mhems1/cs140s17/pitfalls/arrays.html">here</a>.  
<h1>A library of Books</h1>
Create a class <b>Library</b> with a main method. Recall the main method is written  
  
```java
public static void main(String[] args) {

}
```  
  
In the main method, declare an array named <b>library</b> to hold three (3) <b>Book</b>s. Set each book in the array to a new Book with a title and number of pages you choose. Use a for loop to print out only the title of each book.  
  
There is another way to write a for loop, called the enhanced for loop. If we wanted to loop through myInts:  
  
```java
// format is type of single element in array, dummy variable name, name of array
for (int currentElement : myInts) {
    System.out.println(currentElement);
}
```  
  
After you print the book titles using the regular for loop, print out the number of pages of each book using the enhanced for loop.  
  
Write the method <b>public static int numPagesInLibrary(Book[] books)</b> inside the <b>Library</b> class. The method takes in an array of books and should return the total number of pages in all books. Use either for loop style.  
Once that method is written, jump back to the main method to test it. First print out the number you expect would be returned by the method based on how you created your books. Then print the result of calling <b>numPagesInLibrary</b> when <b>library</b> is passed in.    
Write the method <b>public static int mostPages(Book[] books)</b> inside the <b>Library</b> class. The method takes in an array of books and should return the maximum number of pages among all books in books. In the main method, print out the number you expect (i.e. the number of pages of the longest book you created). Then, again in the main method, print out the result of calling mostPages when library is passed in.  
  
Compile and run the <b>Library</b> class. Make sure the output matches with what is expected. Recall the command to run is <b>java lab02.Library</b>.  
<h1>Push to GitHub and Submit Commit Hash to MyCourses</h1>

When you are finished, make sure you are in your git directory. You can then add and commit your work by using: 
<b>git add -A </b>  
<b>git commit -m "completed lab02"</b>  
<b>git push</b>  

Remember that we will only grade your submission that corresponds to the commit hash you give us in MyCourses. To get your latest commit hash, run:  
<b>git rev-parse HEAD</b>  
 
 Submit the corresponding commit hash to MyCourses, under the lab02 submission link.
