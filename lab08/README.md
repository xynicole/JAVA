# lab08 - Due at midnight tonight

All packages in lab08

Today we will be implementing recursive methods and testing them with the JUnit unit testing framework, which has an Eclipse plug-in. No credit will be given for recursive methods written non-recursively.

Outside of a computer science context, a recursive problem is one that is defined in terms of a smaller instance of that same problem. For example, the factorial of a number is defined in terms of the factorial of that number minus 1.

In a computer science context, the above still holds and usually manifests by a method calling itself, directly or indirectly, with a smaller input. Every recursive problem must have a base case - an input that cannot be made any smaller and can be solved non-recursively. Otherwise, the input would never stop shrinking and the recursion would never end. In Java, this results in a StackOverflowError exception.

<h1>Methods</h1>

Create a class `Recursion` which will hold a bunch of static recursive methods to practice recursion.

Add a `private static final double DELTA `field to this class and initialize it to `1e-6`.

Create a method `public static int factorial(int n)` which we will implement recursively. Recall the factorial of a number is the product of that number and the factorial of the difference of that number and 1. The factorial of 0 is 1 and the factorial of 1 is 1. If either of the base cases apply, return the corresponding int, otherwise we must recurse by calling the factorial method with n-1 and then returning the product of n and this return value.

Sometimes when working with recursion, we need to know where we are in the recursive call chain and as such need more than one parameter. When the overall function only requires one parameter but our implementation requries two, it is useful to create a helper function with two parameters that our function with one parameter can call. Typically, we  make the helper private, since we don't want the user to have access to the helper, it is created to make our implementation easier from our end, but the user doesn't need to know the details of how the helper is working.

Create a method `public static double squareRoot(double n)` and a helper method `private static double squareRootHelper(double n, double approx)`.

One way to compute the square root of a number is to make a guess of the square root and continuously refine that guess until it is "close enough". The implementation of `squareRoot` is simple, it just calls its helper method and returns the value the helper returns, passing in its parameter and some initial guess of your choosing. The real logic goes in `squareRootHelper`. 

In `squareRootHelper`, one base case is that we're computing the square root of 0, which is 0. The other base case is that our current guess for the square root is close enough to the original number. This is the case if the absolute difference between `approx` squared and `n` is less than `1e-6`. (The idea being that if `approx ` is close to being the square root of `n`, then its square should be extremely close to equaling `n`). Recall that we can get the absolute value of something with the function `Math.abs()`, no imports necessary. Otherwise, we must recurse with the same number but with a better approximation. This better approximation is computed as `(approx + n/approx) / 2`. 

Why this average? Well, consider that `n / approx` should work out to equal `approx` if `approx` is truely close to being the square root of `n`. So if it slightly off, note that taking the average will either raise our new approximation or lower our approximation as needed.If `n / approx` is slightly too big, that means our approximation for `approx` is too small (dividng by a smaller number makes the fraction bigger overall), and taking the average will increase `approx`. If on the other hand `n / approx` is slightly too small, that means our approximation for `approx` is too big (dividng by a bigger number makes the fraction smaller overall), and taking the average will decrease `approx`.

So far we've seen recursion for recursive mathematical sequences but recursion is also a natural choice for recursive data structures. A recursive data structure is one that is defined in terms of smaller instances of itself. Lists and arrays can be defined recursively.

A list of ints can be defined as either the empty list or an int followed by a list. The list is defined in terms of another, smaller list, which in turn is defined in terms of another, smaller list, ..., which in turn is defined by the empty list. We could write the list [1, 2, 3, 4] as [1 : [2 : [3 : [4 : []]]]] where ':' takes an int and an int list and returns an int list with the int as the first element, followed by the elements of the original int list. Similarly for arrays.

Create a method `public static int sum(List<Integer> nums)` and a helper method `private static int sumHelper(List<Integer> nums, int index)` which will recursively sum the elements of `nums`. Again `sum` will simply call `sumHelper` with some initial value (think about what it should be) and `sumHelper` will do the heavy lifting. The `index` in `sumHelper` is needed to track the position in the list this method should examine. `sum` should return the result of calling `sumHelper` with the same list of `nums` and an initial index of `0` (corrseponding to the first element). Note that the base case for `sumHelper` happens when we are at the end of the list. Another base case to cover is where `nums` is empty. If we are not at the end of the list, then we must recurse by returning the sum of the int at index `index` and the result of calling `sumHelper` on the same list but with the `index` plus 1.

Create a method `public static int sum(int[] nums)` and a helper method `private static int sumHelper(int[] nums, int index)` which do the same thing but with arrays, not arraylists. As a reminder, note that it is possible to have more than one method/constructor with the same name as long as they can be distinguised. `sum(int[])` can be distinguished from `sum(ArrayList<Integer>)` because their first parameters have different types. Similary for both sumHelpers. This is called <b>operator overloading</b>.

Another mathematical recursive sequence we can implement is the binomial coefficient. Create a method `public static int binomialCoefficient(int n, int k)` which will represent <b>n choose k</b> or <b>(n C k)</b>. The base case is (n C 0) is 1. (Note we assume that n and k will never be negative and also assume that k <= n.) Also, recall the identity that (n C k) == (n C n-k). To exploit this, we have another base case when k is more than half of n. In this case, we return `(n C n-k)`. Otherwise, (n C k) is defined recursively as (n-1 C k) + (n-1 C k-1) for n greater than 1.

<h1>JUnit Tester</h1>

Make JUnit tests for

1. factorial
  test both base cases and a non-base case (will need 3 test methods)
2. squareRoot
  test either 0 or 1 and a perfect square (will need 2 test methods)
3. sum(ArrayList)
  test one arraylist of 3 non-null ints
4. sum(int[])
  test one array of 3 ints
5. binomialCoefficient
  test one where k < n/2 and one where k > n/2, where n > 2 in both. (2 methods)


<h1>BONUS</h1>

For 1 point extra on the lab (choose one of the two given options)

No partial credit

You will receive little help from TAs

If attempting option 1, please make a new class Bonus with a main method. If attempting option 2, please attach a text file with your answer. You may only pick one, not both. If you do both, we will look over both and give you feedback, but only award you one point.

<h2>(Option 1: worth 1 point)</h2>

Add the method `public static void printPascalsTriangle(int limit)` that prints rows from Pascal's Triangle up to and including limit. All this method will do is call printPascalsHelper(limit, 0, 0). The real magic happens in the helper method, `private static void printPascalsHelper(int limit, int n, int k)`. You should use binomialCoefficient to aid in the implementation. This helper method must be recursive, or no credit. No for loops allowed.

In the main method, call the method `printPascalsTriangle` with a limit of 5.

You should see (trailing whitespace is OK)

>1  
1 1  
1 2 1  
1 3 3 1  
1 4 6 4 1  
1 5 10 10 5 1  

<h3>Hints:</h3> 

Note that each row of Pascals Triangle corresponds to a bunch of (n C k) values.
The first line is just (0 C 0), the second is (1 C 0) and (1 C 1), 3rd line is comprised of (2 C 0) (2 C 1) and (2 C 2), and so forth. 

Additionally, the different cases you need to account for is if n == k and if n < k. If n == k, you need to print the n choose k and also a new line character, then recurse to print the first entry of the next row of Pascal's triangle. However, you will only recurse to the next row of Pascal's Triangle if the limit has not been reached. On the other hand, if n < k, then you need to print n choose k with a space, and no new line character, then recurse to print out the next binomial coefficient contained in the current row of Pascal's triangle. 

<h2>(Option 2: worth 1 point)</h2>

In a text file, explain the recursive calls that are made when computing 
binomialCoefficient(4, 2); as specified above. Make sure you list out the recursive calls made in the correct order, and explain who control if given back to after each call returns a value. For instance, when (4 C 2) is called, it will recursively call (3 C 2) and (3 C 1) (think about which of these two gets called first). Eventually, (3 C 2) will return some value. When it does, it givens control back to (4 C 2) since (4 C 2) is the one who called (3 C 2). Also explicitly say how many calls to the `binomialCoefficient` method have been made in all for the computation of (4 C 2).

<h3>Hint:</h3>

It may be helpful to add a helper method for BinomialCoefficient that takes in an extra paramter, called level. the original method will call this helper method starting at level 0 initially, and the helper method will print out level amount of tabs, and then the string (n C k) to show case what level each function call is being made on. After that, the helper will perform the same logic that the original BinomialCoefficient method used to perform, except calling itself when necessary. Each time the helper method calls itself recursively, it should pass level + 1 to the call, so that the level is being passed along via the extra parameter.
