# lab06 - due 10/10, by 11:59 pm

All packages in package lab06.

We will now switch where we develop code from Gedit and the terminal to the `Eclipse IDE` (**I**ntegrated **D**evelopment **E**nvironment). Eclipse integrates many tools as well as third-party plug-ins into one desktop application for software development. Eclipse offers package explorer, text editor, and console output windows, among others.

You may want to download Eclipse for your personal computer. It is available for Windows, Mac, and Linux <a href="https://www.eclipse.org/photon/">here</a>.

You should familiarize yourself with the `Ctrl-A Ctrl-I` shortcut which automatically reformats your source code to the proper indentation levels. Use this often - mis-indented or unindented code is challenging to write, read, and grade.

<h2>Before you run eclipse,  if you are using the lab computers open the terminal and run the command "rm -rf .cache"</h2>

<h1>Running Eclipse for the first time</h1>

Open Eclipse and make sure the splashscreen says Eclipse Oxygen (if you are using the lab computers). It usually takes a while to load the first time. You can also use Eclipse photon on your laptop if you want.

Once you run Eclipse, select a workspace directory where Eclipse will put all the files you create within it. If you have a cs140 directory, it is a good choice for this.

Create a new Java project via `File->New->Other->Java Project`. Make sure Java10 is the default JRE. Enter cs140 for the project name and click `Finish`.

![Java Project](https://github.com/Binghamton-CS140-A0-Fall-2018/screenshots/blob/master/lab06/java_project.PNG)

<h1>Using Github to grab lab06</h1>

Now that you have made your java project, we will show you how to clone this repository into eclipse using a built in git feature.

Hit `Window->Perspective->Open Perspective->Other` and select `Git` to be opened. Here is what you should see:

![Git View](https://github.com/Binghamton-CS140-A0-Fall-2018/screenshots/blob/master/lab06/git%20view.PNG)

Hit the clone button, which has been circled. You should see a box with some information to be collected. Grab the URL from the repository on github that you usually do a git clone command for, and paste that into the URL field. It should auto fill in the host and repository path for you. Down below, you should also provide authentication, your git username and password. It should look like this:

![Git Import](https://github.com/Binghamton-CS140-A0-Fall-2018/screenshots/blob/master/lab06/git_import.PNG)

Hit `Next` and make sure `master` is selected as your branch. Then hit `next` again. 

Now, you will be asked to select a local destination. 

<h2>Here you NEED to edit the Directory, make sure it ends in the package name of the assignment, not the name of the repository. Also, make sure you select the src directory of the java project you have made above. You will need to go into the eclipse-workspace you set up initially, into the java project, and into the src folder. So for instance, based off where my workspace is on my personal computer, I would use C:\Users\Shawn\eclipse-workspace\cs140_Fall2018\src\lab06. Note it does not end in lab06-sbailey6, just lab06.</h2>

You will run into issues if you do not set up the local destination properly. It must match the package name of the assignment you are cloning, it is not named after the name of the repository itself. <b>You need to be mindful of changing the local destination for every assignment and lab from here on out, so be sure to ask for help if something doesn't make sense.</b>

![Local Destination](https://github.com/Binghamton-CS140-A0-Fall-2018/screenshots/blob/master/lab06/local_destination.PNG)

Once you update the local destination correctly, hit `Finish`.

You should now see that the lab06[master] was added to your GitRepositories tab. If not, try to right click and hit refresh. If it is still not there, ask a TA for help. Now, go back to Package Explorer, and right click the java project you made, then hit `refresh`. You should see that `lab06` now appears in the `src` folder. You can switch between `git` and `package explorer` by clicking the two icons circles in the top right of the screenshot shown below. 

![Switching](https://github.com/Binghamton-CS140-A0-Fall-2018/screenshots/blob/master/lab06/switching.PNG)

<h2>You will also need to add a Library for Junit5 to work. To do this, right click the java project, then hit `Build Path->Add Libraries`. Select Junit, and then make sure you add Junit5. If you added a module-info.java file, please delete it from your java project</h2>

Congratulations, you just cloned your first git repository on Eclipse!

In addition to getting comfortable with Eclipse and some ways it can make life easier, we will be working with <b>subclasses</b> and <b>JUnit</b> testing today.

<h1>Some notes on the toString method</h1>
  
The `Object` class is the root class of all classes. If you don't declare a class to `extend` another class, it implicitly `extends` the `Object` class. Since the `Object` class implements the `toString` method, all classes have a `toString` method. By default though, it just returns the object's memory address so we typically override it to something meaningful. For instance, the way the `ArrayList` class implements its `toString` is to build a comma-separated list of each of its elements' `toString` methods.

Since all Objects have the `toString` method, we can always call it on any instance of any `Object`. Given this fact and that programmers often want to convert complex objects into digestable Strings, Java will call `toString` implicitly.

So instead of writing `System.out.println(myArrayList.toString());` you should write `System.out.println(myArrayList);` which will automatically invoke `toString` for non-nulls.

This is not just less to type, it is less error-prone. If `myArrayList` or whatever `Object` you're printing happened to be `null`, you would get a `NullPointerException` from explicitly calling `toString` on a `null` `Object`. By just referring to the variable, Java will automatically first check if its value is `null` and only if it is not `null` will it then call `toString` on it.

<h1>Classes and subclasses</h1>

Create a class `BankAccount` with the following private fields:

>double balance  
int idNum  
static int numAccounts, initialized to 0  

You can create a new class by right clicking the lab06 package, going to New, and selecting class. 

![New Class](https://github.com/Binghamton-CS140-A0-Fall-2018/screenshots/blob/master/lab06/new_class.PNG)
  
Create a constructor that accepts a `double balance` and assigns that `balance` to the `balance` field. If the given `balance` is negative, throw an `IllegalArgumentException`, with a meaningful error message. Additionally in the constructor, assign `numAccounts` to `idNum` and then increment `numAccounts`. Since `numAccounts` is a static field, it is shared across all instances of the `BankAccount` class. This is different than `balance` because we want `balance` to be unique to each `BankAccount`. This static field and constructor pattern is an easy way to assign each instance of a class a unique identifying number. An id number gives us a way to distinguish two bank accounts that may happen to have the same balance.

Create a getter for `balance` and `idNum`. You can have eclipse automatically do this for you. Hit `Source`, and select `Generate Getters and Setters...`. Note in the screenshot below we only want getters generated, not setters for the fields in this case.

![Generate Getters](https://github.com/Binghamton-CS140-A0-Fall-2018/screenshots/blob/master/lab06/generate_getters.PNG)

Create a method `static void reset()` which sets `numAccounts` equal to zero. This method does not need to have public in its method header, it is package private. This will be used to ensure that your `idNums` are not off when the `@BeforeEach` method in your JUnit tester is being rerun multiple times.

Provide a `toString`, paying attention to add the annotation:

```java
@Override // good habit to include
public String toString() {
    // should return the string "Acct. #3 has $50.0" for an account with idNum = 3 and balance = 50
}
```

The `@Override` annotation asks the compiler to make sure we are overriding (redefining) an inherited method (from the Object superclass) instead of making a different one. So if we misspelled toString or gave the wrong return type, the compiler would give an error.

Provide a method `public void deposit(double amount)` that adds `amount` additional dollars into the account's `balance`. If `amount` is negative, throw an `IllegalArgumentException`, explaining deposits must be done with positive values.

Provide a method `public double withdraw(double amount)`. This method attempts to withdraw `amount` of money from `balance`. This method withdraws as much as possible (at most `amount`) from the account and returns the amount being withdrawn. The reason the return value might not be equal to the `amount` argument is if the account does not have enough money to cover the full withdraw. This logic should prevent an account from having a negative balance. If `amount` is negative, throw an `IllegalArgumentException`, explaining withdrawals must be done with positive values.


<h1>Now for the interesting part: subclassing.</h1>

Create a class `SavingsAccount` that `extends` the `BankAccount` class. We say that `SavingsAccount` subclasses (is a subclass of) `BankAccount` and that `BankAccount` is the superclass/parent class of `SavingsAccount`. When class A subclasses class B, this leads some people to say "A is a B". For example, if Dog subclasses Animal, Dog is an Animal.

In subclassing `BankAccount`, `SavingsAccount` inherits all the non-private methods and fields. This means it gets `deposit`, `withdraw`, etc, but not the `balance` nor `idNum` fields. But this is okay since it inherits the public getter methods to those fields. A `SavingsAccount` is like a `BankAccount` but gets interest on each deposit.

Give `SavingsAccount` a private `double` field named `rate`.

Make a constructor that accepts an `double balance` and a `double rate`. When a class subclasses another, its constructor has the option to call the superclass's constructor as the first line of its constructor. We do this with the keyword `super`.

Example:

``` java 
class Parent {
    private int i;
    public Foo(int i) {
        this.i = i;
    }
}

class Child extends Parent { // subclassing/inheritance
    private boolean b;
    public Foo(int i, boolean b) {
        super(i); // must be first line of constructor
        this.b = b;
    }
}
```
  
Using the above example as a guide, call `BankAccount`'s constructor, passing in the `balance` parameter from the `SavingsAccount` constructor. Then use the `rate` parameter to assign to the `rate` field. If `rate` is negative, throw an `IllegalArgumentException` explaining the `rate` cannot be negative.

Next, we want to override the `deposit` method. Instead of inheriting the same method, we want to change its behavior from that of `BankAccount`.

We override by copying the method signature exactly and following the good habit of adding the `@Override` annotation.

`SavingsAccount`'s `deposit` should not only deposit the given `balance`, but also an additional `rate` percent of it. So if I construct a `SavingsAccount` with a 0.1 `rate` and `deposit` $10, $11 should actually be added (10 + 0.1*10). The issue is `balance` is private within `BankAccount` so `SavingsAccount` cannot get at it nor is there a setter method. Instead we can use the `BankAccount` `deposit` method and send in the proper amount. You can call the parent's version of the method, say `methodName()`, within its subclass by doing `super.methodName()`;

Now knowing how to call a super class method, implement `SavingsAccount`'s `deposit` method by calling the superclass's (`BankAccount`) `deposit` method with the proper inflated amount.

Provide a getter for `rate`.

Override the `toString` method to return the superclass's `toString`, concatenated with `" @ N%"` where `N` represents the `rate` of the savings account as a percent. For example, an account with id number 5 and balance 100 at rate 0.05, would give a string of "Acct. #5 has $100 @ 5.0%". No credit will be given for duplicating the code to print out the first portion, you must call the superclass's `toString`.

Create a class `CheckingAccount`, also a subclass of `BankAccount`. A `CheckingAccount` is like a `BankAccount`, but has a limit on how many withdraws are allowed (i.e. how many checks you can write).

A `CheckingAccount` should have two private integer fields, one named `withdrawLimit` and another named `withdrawCount`, initialized to 0.

Provide the class a constructor that accepts a `double balance` and an `int limit`. Pass the `balance` to superclass constructor and assign the `limit` parameter into the `withdrawLimit` field. If `limit` is less than 1, throw an `IllegalArgumentException` explaining the Withdrawl limit must be positive.

Provide a getter for `withdrawLimit` and `withdrawCount`. Recall you can have eclipse generate them for you. 

Override `toString` to return the superclass's toString, concatenated with `" (C/L)"` where `C` is the `withdrawCount` and `L` is the `withdrawLimit`. The "/" is the literal backslash character, do not divide `C` by `L`.

Override the `withdraw` method. If the `withdrawCount` is less than the `withdrawLimit`, call the superclass's `withdraw` method and return the value it returns. Also increment the `withdrawCount` as we have just written a check. If the `withdrawCount` is at or above the `withdrawLimit`, return 0 to signify nothing was withdrawn.

<h1>JUnit Tester</h1>

With these classes written, we now want to test them. We could do it the way we're familiar with: create a Tester class with a `main` method that prints out what is expected and what is received but this is error prone. This leaves the user to visually inspect both results and assert they're equal. It also means that if one test of a method throws an exception or goes into an unexpected state, any further tests may not be run or may run incorrectly.
That's why we will now be shifting our testing to be with `JUnit`, the Java unit-testing framework.

Take a look at `BankTester` which has been provided for you already. <a href="https://junit.org/junit5/docs/5.0.0/user-guide/">You can read about some of the things you can do with JUnit testing here</a>.

Every test case that we want to test will correspond to one test method in the Junit class. Notice that the test method has a @Test annotation. Every method you want JUnit to test must have one of these or that method won't be called. The name of the test does not matter but it should describe what you're testing. You can also add `@DisplayName` to give more information about what the test is doing.

The `assertEquals` is the key difference from the old way to this way. Instead of printing expected and received, we call the already written method `assertEquals(Object expected, Object actual)` that checks its two arguments for equality and remembers the result.

When checking two doubles for equality, we must handle the fact that doubles can be imprecise. To rectify this, `JUnit` provides a method `assertEquals(double expected, double actual, double tolerance)` that says that expected == actual if |expected - actual| <= tolerance. For simple applications, `1e-6` will do, and should be used in this lab.

There is also `assertTrue`, `assertArrayEquals`, `assertNull`, etc. Once `JUnit` runs all your tests, Eclipse will pop-up a dialog on the left that shows how many tests passed. If any tests failed, you can click on them and it will explain why.

Make `JUnit` tests for the remaining classes and methods you have written.

<h1> Minimal Testing Required </h1>

Add some additional test cases to test each method you have written for `BankAccount`, `CheckingAcount`, and `SavingAccount`. See `testBankAccDeposit()` and `testCheckingAccWithdraw()` for some concrete examples. 

Inside the the `initialize()` method of your junit tester:

Instantiate `accounts` to an empty `ArrayList`. Then add some objects, so that accounts is holding <b>2 BankAccounts, 2 SavingsAccounts, and 2 CheckingsAccounts</b> with varied values to the accounts list in a mixed-up order so that no two adjacent elements in the list are the same class.

The cool part of inheritance (subclassing) is that anywhere an instance of the parent class is expected, an instance of the child class can be given. This means our list of BankAccounts can hold BankAccounts or any of its current or future child classes.

Next, in the test method called `dynamicDispatchPrinting()`, print out the accounts by sending it to the `System.out.println` method. Remember, Java will call toString on it, which will in turn call toString on each `BankAccount` object. Don't forget the `@Test` above the method you are writing here.

From the output, we observe that each class's toString is called, and not just the `BankAccount` toString on each. This is `dynamic dispatching` in action - what makes inheritance powerful. Even though the static (written) type of each element in `accounts` is `BankAccount`, the dynamic (at-runtime) type of each object varies based on the order you added objects. When the `toString` is invoked, Java examines the dynamic type of object and calls the `toString` of that (sub)class. Add this block of code to dynamicDispatchPrinting() make things even more explicit, after the printout of accounts:

 
``` java
		for(BankAccount b : accounts){
			if(b instanceof SavingsAccount){
				System.out.println("SavingsAccount: ");
			}
			else if(b instanceof CheckingAccount){
				System.out.println("CheckingAccount: ");
			}
			//note that we do this as an else block
			//since SavingsAccount and CheckingAccounts are also
			//considered to be instances of BankAccount
			//since they are subclasses of BankAccount.
			else{
				System.out.println("BankAccount: ");
			}
			System.out.println(b);
			
		}

```

Create another test method, and in an enhanced for-loop, deposit an amount of your choosing into each account in `accounts`. Use `assertEquals` on the toString of each object to verify the output is correct, instead of just printing them out with System.out.println(). You will need to do this without using a loop, explicitly on each Account in `accounts`. In general it is not usually a good idea to have multiple assertEquals in a single testing method, but you can do so in this case, just for the sake of time. (If you are feeling really ambitious, try to use `assertAll` so that if an assertion fails, the test will report all the assertions that fail. This is new to Junit Jupiter, and you can see it in the JUnit 5 User Guide, the link provided above.)

Now, we'd like to test the `withdraw` behavior of each class. To properly test the `CheckingAccount` logic, we'll need to `withdraw` a bunch of times to make sure it caps off at its limit. Create a for loop that goes `N` times, where `N` should be big enough for at least one of your CheckingAccounts to exceed its `withdrawLimit`. In that for loop, `withdraw` an amount of your choice from each account, using an inner for loop. After the inner for loop, but still inside the outer for each loop, print all the accounts. Verify the output is correct. Writing a bunch of `assertEquals()` here is timely and we will print the results out instead for the sake of time. 

We can take the generalization a bit further by making an `ArrayList` of `Objects` called, `objects`, which is at the top of the junit tester. Since all classes and types have the `Object` class as their root type, anything can go in this array: `Objects`, `ints`, `arrays`, any of the `BankAccounts`, `booleans`, other `arraylists`, `BankTesters`, etc. Add 8 elements to the `objects` array, of various types, inside the `initialize()` method. The more creative the better. Print the objects array in the test method `dynamicDispatchPrinting()` and observe how each class implements its `toString` method.

This generalization is a bit too far for normal use cases. The whole purpose of types is to restrict the values that data can take on to make them more reasonable to operate on. We often want to be as general as we can, but no further. Walking this line comes with practice. If we want a list of bank accounts, we generalize to the base `BankAccount` class, which allows the two subclasses as well, but nothing else. We would not want the list to hold `Object`s, which would mean things like `String`s and `arrays` could be thrown in and unnecessarily complicate things.

<h1>Submitting to Github and myCourses</h1>

To submit to github, you need to go back to the git perspective. Left click lab06[master], Right click the WorkingTree folder, and hit `Add to index`. You should see that the files are added to the `Staged Changes`. Enter a message in `commit message` and then finally hit `Commit and push`. Be sure to provide your credentials. Refresh the github repository to make sure your code has been pushed.

![Git Push](https://github.com/Binghamton-CS140-A0-Fall-2018/screenshots/blob/master/lab06/git_push.PNG)
