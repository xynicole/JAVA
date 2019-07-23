# lab10 - Due 11/8/2018 at 11:59 pm

<h1>Streams</h1>

Streams were introduced in Java 8, and help us process sequences of elements. They can be used effectively in multi-threading, and are compact to use.

You may need the import `java.util.stream.*`. As you will see, we can do many different operations on them to help process data quickly. 

<h1>Stream Creation</h1>

Streams can be created from different sources, such as arrays or collections, such as Lists. Consider the following examples which create streams using the built in `Arrays.stream()` method or the `Stream.of()` method. Note that there is also the method `parallelStream()` which allows the creation of parallel streams rather than sequential streams. Parallel streams could lead to faster performance.

```java
//create a Stream from an existing array and the Arrays.stream() method
String[] arr = {"apple", "banana", "carrot"};
Stream<String> stream1 = Arrays.stream(arr);

//create a stream using the Stream.of() method
Stream<String> stream2 = Stream.of("apple", "banana", "carrot");
		
//create a stream using the Collection.stream() method
//note that List is a Collection, so it inherits this method
List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
Stream<Integer> stream3 = list.stream();
```

<h1>Stream Operations</h1>

There are some cool operations we can use on streams. First, there are <b>intermediate operations</b>, which return a `new Stream<T>`, and <b>terminal operations</b>, which return a result of a <b>definite type</b>, which could be primitive value, a concrete value, or void. Intermediate operations allow <b>chaining</b>. Another nice feature is that stream operations do not change the source. Terminal operations must be the last operation called on a Stream. You cannot do chaining with more stream operations after a terminal operation is called.

 
Consider the following example:

```java
List<Integer> list2 = new ArrayList<>(Arrays.asList(1,1,2,2,3,4,5));
long count = list2.stream().distinct().count();
System.out.println(count); //prints out 5
```

Above, the first thing we do is turn `list2` into a stream, then we take that stream and turn it into another stream, using the intermediate operation `distinct()`. This `distinct` method will make a new stream from the previous one, where it only keeps the distinct elements once, eliminating duplicates.

This means a 1 and 2 will be discarded from the first stream. `count()` is a terminal operation, which returns how many elements are found in the stream that was returned by `distinct()`. In this case, there was 1,2,3,4,5 in the distinct stream, so `count` returns the value 5. 5 is then stored in the `long count` variable.

The above example is simple but show cases the difference between intermediate operations and terminal operations, and a simple example of chaining. Now, we will showcase some other nice stream operations.

<h1>Iterating and Matching</h1>

Streams can be used as a substitute for looping, including for loops, enhanced for loops, and while loops. Consider the following example:

```java
//returns true if any word in list contains an "a"
for(String str : list){
	if(str.contains("a")){
		return true;
	}
} 

//the same logic using streams
return list.stream().anyMatch(e -> e.contains("a"));
``` 

The above example is using the stream terminal operation `anyMatch()`. There are also operations `allMatch()` and `noneMatch()` which work similarly. Each of these terminal methods return a boolean, and take a `Predicate` as an argument, which is a functional interface representing a boolean-valued function taking one argument. Since `Predicate` is a functional interface, we can use a lambda expression which specifies how Predicate's abstract method `test()` works. `anyMatch()` looks at each element in the stream, represented by `e` here in the lambda expression, and checks if each element `e` contains `"a"`. If there is at least one such element, then `anyMatch()` returns `true`, otherwise it returns `false`.  

 
Here is an example of using the terminal operation `forEach()`

```java
List<Integer> list2 = new ArrayList<>(Arrays.asList(1,1,2,2,3,4,5));	
list2.forEach(System.out::println); //alternatively, could also write list2.forEach(str -> System.out.println(str));
```

The above example prints out each element in `list2`. `forEach()` takes a functional interface called `Consumer` as an argument. Again, we can pass a lambda expression that tells how Consumer's abstract method `accept()` will work. `accept()` accepts a single input argument and returns no result. Note that the `System.out.println()` method is such an operation, it takes a String as a single argument and prints it, returning void.  Instead of using a lambda expression though, we are using a <b>method reference</b> instead, which is short hand for a lambda expression. 

<h1>Filtering</h1>

The `filter()` method is an intermediate operation that allows us to create a stream of elements that satisfy a `Predicate` (mentioned above). Consider the following example:

```java
ArrayList<String> list3 = new ArrayList<>();
		list3.add("One");
		list3.add("OneAndOnly");
		list3.add("Derek");
		list3.add("Change");
		list3.add("factory");
		list3.add("justBefore");
		list3.add("Italy");
		list3.add("Italy");
		list3.add("Thursday");
		list3.add("Wednesday");
		list3.add("");
		
		System.out.println(list3.stream()
				.filter(e -> e.contains("e"))
				.peek(System.out::println)
				.count());
```

If you run this, it will filter out and keep only the words that contain "e". It is also using the `peek()` method which behaves exactly the same as the `forEach()` method, but is an intermediate operation rather than a terminating operation. This means its takes a `Consumer` as an argument, just as before. Again, we are using a method reference over a lambda expression, to print out each word in the stream collected by `filter`. Then, we are counting how many words were kept by the `filter` and printing that out as well. It is good practice for readability to put each new method call on a new line, as we did here above. As you can see, the number of stream operations we do at once can grow rather quickly. 

<h1>Mapping and Collecting</h1>

`map()` is an intermediate operation that allows us to change elements in a stream into a stream of new elements, which may have a different type from the original stream. `collect()` is a terminal operation that allows us to gather all the elements in a stream and store them into a `new Collection`. Consider the following example:

```java 
List<String> list4 = new ArrayList<>();
		list4.add("elephant");
		list4.add("bear");
		list4.add("panther");
		list4.add("rabbit");
		
		List<Integer> list5 = list4.stream()
		.map(e -> e.length())
		.collect(Collectors.toList());
		
		list5.forEach(System.out::println);
```

`map()` is being used to map the `Stream<String>` to a `Stream<Integer>`, and then we collect these String's lengths in a new List, using the `Collectors.toList()` method as an argument to the terminal operation `collect()`. You can read more about `Collectors` in the java10 API.

<h1>Reduction</h1>

This will be the last example we showcase. Suppose we had a List of Integers and we wanted to sum up all the elements using a stream, or wanted to find the product of all the elements. We could use the `reduce()` method, which is a terminal stream operation that takes two parameters, the first being a <b>starting value</b>, and the second being an <b>accumulator function</b>, represented as a lambda expression. The accumulator function is just a `BinaryOperator` interface, which takes two values and returns a single value of the same type. Here are the following two examples:

```java
List<Integer> list6 = new ArrayList<>(Arrays.asList(1,2,3,4));
System.out.println("sum:" + list6.stream().reduce(0, (a,b) -> a + b));
System.out.println("product: " + list6.stream().reduce(1, (a,b) -> a*b));
``` 

<a href="https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/">There are many more things you can do with Streams, and this website showcases some of the nice features. Please do take a look</a>. 

It also touches on <b>lazy evaluation</b>. Lazy evaluation means intermediate operations will not be executed unless a terminal operation is present. If anything, please read the section <b>Processing Order</b>, as it gives you a much better idea of how streams are working when chaining is involved. 

<h1>Time to Code</h1>

Create a class called `Streams.java`. 

Add the following List as a private static field of Streams:

```java
private static List<String> someBingoNumbers = Arrays.asList(
			"N40", "n36", "B12", "b6", "G49", "G53", "G60", "G50", "g64", "I26", "i17", "I29", "O71");
``` 

Note that the List holds some Bingo numbers. 

Implement the method `public static List<String> grabBingoNums(String letter)`

The method will return a `List` of the bingoNumber Strings that start with `letter`, in sorted order. The sort should be by natural order, which you can do by just calling `sorted()` on a stream. Also, make sure that all the bingoNumbers in the returned list start with an uppercase letter. You may NOT use any if statements or for loops in any of the methods being implemented for this lab, only steam operations and chaining.

Hints: you will need the `map()`, `filter()`, `sorted()`, and `collect()` stream operators to be able to return the desired List. You will need to figure out what arguments need to be passed to each. In this case, `map()` should take some kind of method reference from the String class, which takes a String and makes it all uppercase. 

When you are finished, you should get the following for each call:

```
grabBingoNums("B")    [B12, B6]
grabBingoNums("I")      [I17, I26, I29]
grabBingoNums("N")    [N36, N40]
grabBingoNums("G")    [G49, G50, G53, G60, G64]
grabBingoNums("O")    [O71]
```
 

Implement the method `public static List<Integer> extractNums()` which returns the List of the bingo numbers, but with the front letter removed and converted to an Integer. 

Hint: You can convert a String to an Integer using `Integer.parseInt()`. Make sure you parse for an Integer on an appropriate substring of each String in someBingoNumbers. This conversion will again be done by using the `map` method, then you just have to collect the elements from the stream.

Implement the method `public static int sumLists(List<List<Integer>> lists)`, which will add up all the values found in each list and return the result. 

Again, you may NOT use any loops, only stream operations. 

Hint: You will need to use the `flatMap()` method to flatten the stream of `List<Integer>` into a stream of the `Integers`. Once you have done that, you can use the `reduce` method to add up the values as describe above. You can read about how the `flatMap()` method works online, or ask the TA for an explanation. 

```java
//should print out 568 if you correctly implement sumLists
List<List<Integer>> lists = new ArrayList<>();
lists.add(new ArrayList<Integer>(Arrays.asList(1,2,3)));
lists.add(new ArrayList<Integer>(Arrays.asList(4,5,6)));
lists.add(new ArrayList<Integer>(Arrays.asList(7,8,9, 10)));
lists.add(extractNums());
System.out.println(sumLists(lists));
``` 

Implement the method `public static boolean isPalindrome(String str)` that returns whether `str` is the same forwards as it is spelled backwards. Note: This method will NOT use Streams, unlike the others we have done. It is mainly added to be used as a utility for another method you have yet to implement. 

Hint: StringBuilder has a built in `reverse()` method, so you can use the string to create a `StringBuilder`, reverse it, and then use the `toString()` method of StringBuilder to get the resulting String spelled backwards. From there, all you need to do is compare the reverses string to str. You should be able to implement this method in one compact line.

Next, implement the method `public static void printPalindromes(List<String> list)` that filters out the words which are palindromes, and then prints them out. 

Hint: You will need to use `filter()` where you pass in `Streams::isPaldindrome` as a method reference. Do this rather than using a lambda expression. Second, you will need `forEach()` to print each palindrome filtered out.

Implement the method `public static long countOdd(int[] arr)` which counts the number of odd elements in `arr`.

Hint: You will need to use `Arrays.stream()` to turn arr into a stream, and then you will need to use `filter()` and `count()`. Should be a short one liner.

Once you have implemented the methods above using streams, add this main method to `Streams.java` to help test your results, and feel free to add to it if you wish:

 
```java
	public static void main(String[] args){
		
		System.out.println("B bingo nums: " + grabBingoNums("B"));
		System.out.println("I bingo nums: " + grabBingoNums("I"));
		System.out.println("N bingo nums: " + grabBingoNums("N"));
		System.out.println("G bingo nums: " + grabBingoNums("G"));
		System.out.println("O bingo nums: " + grabBingoNums("O"));
		System.out.println("-------------------------------------------");
		
		System.out.println("extracted nums: " + extractNums());
		System.out.println("-------------------------------------------");
		
		List<List<Integer>> lists = new ArrayList<>();
		lists.add(extractNums());
		lists.add(new ArrayList<Integer>(Arrays.asList(1,2,3)));
		lists.add(new ArrayList<Integer>(Arrays.asList(4,5,6)));
		lists.add(new ArrayList<Integer>(Arrays.asList(7,8,9, 10)));
		System.out.println("sum: " + sumLists(lists));
		System.out.println("-------------------------------------------");
		
		System.out.println("odd count: " + countOdd(new int[]{1,2,3,4,5,6,7,8,9}));
		System.out.println("-------------------------------------------");

		List<String> words = new ArrayList<>();
		words.add("101");
		words.add("11011");
		words.add("cat");
		words.add("1000");
		words.add("12321");
		words.add("civic");
		words.add("sagas");
		words.add("dog");
		words.add("rotator");
		words.add("racecar");
		words.add("banana");
		words.add("animal");
		words.add("anna");
		
		System.out.println("palindromes: ");
		printPalindromes(words);
	}
``` 

<h1>Bonus (worth 1 additonal point)</h1>

We will start by making two simple classes, `Employee.java` and `Department.java`. Just copy them in and save them:


<h2>Employee.java</h2>

```java
package lab10;

public class Employee {
	private String name;
	private int age;
	
	public Employee(String n, int a){
		name = n;
		age = a;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString(){
		return name + "(" + age + ")";
	}
}
``` 

<h2> Department.java </h2>

```java
package lab10;

import java.util.ArrayList;
import java.util.List;

public class Department {
	private String departmentName;
	private List<Employee> employees;
	
	public Department(String n){
		departmentName = n;
		employees = new ArrayList<>();
	}
	
	public void addEmployee(Employee e){
		employees.add(e);
	}
	
	public String getDepartmentName(){
		return departmentName;
	}
	
	public List<Employee> getEmployees(){
		return employees;
	}
	
	public String toString(){
		return employees.toString();
	}
}
``` 

Add the following block of code to the top of a new file `Bonus.java`

 
```java
private static List<Department> departments = new ArrayList<>();
	
	static{
		Employee john = new Employee("John Doe", 30);
		Employee jane = new Employee("Jane Deer", 25);
		Employee jack = new Employee("Jack Hill", 40);
		Employee snow = new Employee("Snow White", 22);
		
		Employee jared = new Employee("Jared Miller", 60);
		Employee jeff = new Employee("Jeff Jackson", 27);
		Employee gerald = new Employee("Gerald House", 15);
		Employee mary = new Employee("Mary Lou", 23);
		
		Department hr = new Department("Human Resources");
		hr.addEmployee(jane);
		hr.addEmployee(jack);
		hr.addEmployee(snow);
		Department accounting = new Department("Accounting");
		accounting.addEmployee(john);
		accounting.addEmployee(jared);
		accounting.addEmployee(jeff);
		accounting.addEmployee(gerald);
		accounting.addEmployee(mary);
		
		departments.add(hr);
		departments.add(accounting);
	}
``` 

In Bonus.java, implement the method `public static void printYoungestEmployee()` which prints out the youngest Employee in departments. 

 

Hints: You will need `flatMap()` to flatten the Stream of Departments into a Stream of Employees, and you will then need to use a clever use of `reduce()` and a <b>ternary operator</b> (look it up if you are unfamilar with it) to get it to return the youngest employee. 

After you have called `reduce` on the stream, call `ifPresent()` on the `reduce` call which will allow you to use a lambda expression to print the youngest Employee you found. In this case, `reduce()` returns an `Optional` of the found Employee, which is why we are adding the `ifPresent()` check to get a hold of the value and print it. In order to match the output below, you will also need the `peek()` method to print out each department. Figure out where the peek needs to be added to the stream operation chaining. 

Calling `printYoungestEmployee()` in a main method should print out the following output:

 
```
Human Resources: [Jane Deer(25), Jack Hill(40), Snow White(22)]
Accounting: [John Doe(30), Jared Miller(60), Jeff Jackson(27), Gerald House(15), Mary Lou(23)]
youngest: Gerald House(15)
```
