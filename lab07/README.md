# lab07 - Due Friday, October 19th, at 11:59 PM. 

Today's lab will focus on using <b>interfaces</b> and show you an example of <b>abstract classes</b>. We will make our own interfaces as well as use a pre-existing interface, called `Comparator`. We will also showcase <b>functional interfaces</b> and how <b>lambda expressions</b> can be used to implement them concisely. 

<h1>An Introduction to Interfaces</h1>

First of all, what is an interface? You can think of an interface as a combination of a blueprint (ie template) and a contract. There are a few rules about interfaces.

1. An interface can have default methods and static methods, which have to have a function body. (Note: This is only true for java 1.8 and beyond). 
2. In contrast, abstract methods do not have a function body, and are implicitly public and abstract. Note this means that if you do not specify with modifiers, a method is considered public.
3. A method must be exclusively abstract, exclusively default, or exclusively static.
4. The only modifiers that are allowed to be explicitly used when declaring methods in an interface are public, abstract, default, and static. You cannot use the private keyword in an interface.
5. All the fields declared in an interface are implicitly public, static, and final constants. 
   
Here is a simple example of an interface, with a default method, a static method, an abstract method, and a public static final field:
  
 ![Interface Example](https://github.com/Binghamton-CS140-A0-Fall-2018/screenshots/blob/master/lab07/interface_example.png)
  
Note that for abstract methods, the idea is that Example doesn't know how a class will implement that abstract method, but if the class wants to be an Example, then it needs to implement all of the abstract methods that Example specifies. This is a mutual agreement, or contract, between the interface and the class which implements the interface. 
  
So now, for the interface above called `Example`, let's create a class which `implements` this interface called `Implementer`. If you just try to make Implementer and say that it implements Example, you will get the following error message: "The type Implementer must implement the inherited abstract method Example.printClassDescription()".

![Implements Error](https://github.com/Binghamton-CS140-A0-Fall-2018/screenshots/blob/master/lab07/implements_error.png)

Why is this error showing up? Well, its because we have agreed to implement `Example`, but have not defined how the abstract method `printClassDescription()` is going to work for this class we are making. Analogously, we have not fulfilled the terms and conditions associated with using this contract. To fix this issue, let's go ahead and override the abstract method, and give it a function body. I am also going to override the `returnZero()` method we have written in the interface to show a distinction:
  
 ![Implement Example](https://github.com/Binghamton-CS140-A0-Fall-2018/screenshots/blob/master/lab07/implement_example.png)
  
Please note that there is a purple triangle for `printClassDescription()` and a green triangle for `returnZero()`. In eclipse, a purple triangle is used to indicate that we are <b>implementing</b> an abstract method. In other words, we are telling the compiler how this abstract method will work for this class, by giving it a method body which explicitly describes how the method behaves when called on an instance of this class. In contrast, `returnZero()` has a green triangle, indicating that we have <b>overriden</b> the default behavior of the `returnZero` method. If we did not override the `returnZero` method, when we called the method on an instance of `Implementer`, it would have simply returned zero, since that is the default behavior we have provided in the interface `Example`. However, now we have overriden the method to also zero out the array passed in as a parameter before returning zero. 
  
Please also note that in order to implement interfaces in a <b>concrete class</b> (a class which is not abstract), the class needs to implement all of the abstract methods of the interface, otherwise you will get error messages. In this simple example, we only had one abstract method, so we only needed to implement `printClassDescription()` for the code to compile. Again, the override of `returnZero` was just to show that you can also override default methods, similar to what we have been doing with subclassing.

You can also have an interface <b>extend</b> another interface. The extended interface is called a <b>super interface</b>. If you are using an interface that is used by many java developers, you probably do not want to alter the base interface, as that will break other developer's code, since they will also have to implement the abstract methods you add to the base interface. Thus, instead, you can make a new interface that extends the original interface, and add your additions there. In this way, you can expand how the interface works, but not ruin the code of other java developers. 

<h1>Brief Explanation of an Abstract Class</h1>
  
An <b>abstract class</b> is a class which only implements some of the abstract methods, or has some unimplemented abstract methods of its own. An abstract class does not need to implement an interface, and can also have constructors, fields, and methods like a non-abstract class. The abstract class must then be extended by a non-abstract class (also called a <b>concrete class</b>), which is responsible for implementing all the abstract methods not already implemented by the abstract class it is extending. Because of this, <b>abstract classes cannot be instantiated</b>, since they do not implement all of the abstract methods it contains and/or the abstract methods associated with the interface they may be partially implementing. *This may sound odd, abstract classes can have constructors, but those constructors cannot be used to create instances of the abstract class.* Here is a quick example of an abstract class which also implements Example:

![Abstract Class](https://github.com/Binghamton-CS140-A0-Fall-2018/screenshots/blob/master/lab07/abstract_class.png)

Notice that the abstract class `Abstract` can implement `Example` without any error messages. Since it is an abstract class, it is not obligated to implement the abstract methods of `Example`. Furthermore, `Abstract` also can introduce its own abstract methods as well. Now, it is up to the concrete subclass which extends `Abstract` to implement both abstract methods from `Abstract` and `Example`. 

<h1>One major Difference Between Subclasses and Interfaces</h1>

Just like with subclassing, you can have multiple classes that implement an interface, each of which implement the interface in a slightly different way.  The benefit to interfaces over subclasses is that a class can implement multiple interfaces, but can only extend one super class. You can implement multiple interfaces by saying something like `public class C implements F, G, H`. Here, class C would implement three interfaces, F, G, and H. We comma separate each interface that the class is implementing. You can also have an interface extend multiple interfaces, eg `public interface T extends P, Q`. 

It is also worth noting that the class which implements an interface is considered a subtype of that interface. This means we can create an ArrayList of interfaces, which holds a bunch of different objects that have implemented a common interface. This is very similar to when we made an ArrayList of BankAccount objects, which was able to hold BankAccount objects and any classes that were subclasses of BankAccount. In fact, you have done this already in assignment03 when we made a `List<Occupation>`. Occupation was an interface.

<h1>Differences between Interfaces and Abstract Classes</h1>

The following distinctions were found on stack overflow between interfaces and abstract classes: 
1. Interfaces cannot have changeable fields. all fields of a interface are implicitly constant
2. Methods in an abstract class can have any visibility, whereas interfaces all have public methods, even if not explicitly declared with the public modifier
3. Abstract classes and interfaces are both not responsible for implementing the abstract methods they inherit or declare. On the other hand, concrete classes must implement all inherited abstract methods.
4. A child class can only extend a single class (abstract or concrete) while a interface or class can extend multiple interfaces.
5. A child class can define abstract methods with the same or less restrictive visibility, whereas a class implementing an interface must define the methods with the exact same visibility (public)
 
<h1>Let's Get Coding</h1>

Now that you have read an explanation of interfaces and abstract classes, let's put them to some practical use. We are going to create a hierarchy of Animals. Animals all have certain actions, including speaking, eating, and moving. We will try to create an interface to embody these actions all animals perform, and have some subclasses of the abstract animal class. 

Start by making an interface called `Classifications`. It will have three abstract methods. Note that these are not package private, they are public and abstract by default.
>String kingdom()  
String genus()  
String species()  
  
Make another interface called `Actions`. It will have four abstract methods:
>void speak()  
void eat()  
void move()  
void sleep()  
   
Next, make an `abstract` class called `Animal`, which implements both `Actions` and `Classifications`. Again, if class X implements interfaces P, R, and Q, then we write `class X implements P, R, Q{ //...  }`. Override the `toString` method and return the String "This is the higher level abstract animal class. It's subclasses will implement the interfaces.\n". Add an abstract method in Animal, `abstract String getAnimalName()`. This method will be needed later for the Comparator we are adding toward the end of this lab.

We will now make two more `abstract` classes which extend the abstract class `Animal`, `Carnivore` and `Herbivore`.  

`Carnivore` has a private String `prey`, a private int `predatoryLevel`, and an abstract method `prowl()` which returns void. Add a value constructor, which takes in a String and int as parameters, used to initialize the fields `prey` and `predatoryLevel`. Override the `toString()` method, and return a string saying: "A carnivore only eats meat. It can additionally perform the action prowl, and has prey it eats". Finally, add getter methods for `prey` and `predatoryLevel`. 

Similarly, in `Herbivore` we do the following:
1. add a private String called `foliage`
2. add a private int called `agressionLevel`
3. add an abstract method called `graze()` which returns void
4. add a value constructor that takes in a String and int as parameters and initializes `foliage` and `agressionLevel`.
5. Override the `toString` method so that it returns the String: "A herbivore only eats plants. It can additionally perform the action graze, and has a foliage it eats."
6. Add getter methods for `foliage` and `agressionLevel`.
 

Next, we will finally make some concrete classes, two which will <b>extend</b> the `Carnivore` class and one which will <b>extend</b> the `Herbivore` class. 

Create a concrete class called `Tiger` which extends `Carnivore`. (if you get stuck on writing Tiger, take a look at Hyena and Deer which have bene provided to get a similar flavor). 

1. `Tiger` has a private String called `name`
2. Write  a getter method `getName()` for the field `name`.
3. `Tiger` has a value constructor which takes in parameters to initialize `prey` and `predatoryLevel` using the `super` constructor, and a third parameter to initialize `name`. 
4. Override the `toString` method so that it returns some description of a `Tiger`, for instance: "Tigers are a predator of Asia, known for their stripes". 
5. Override the `getAnimalName()` method inherited from `Animal` so that it simply returns the String "Tiger"
6. Implement the `speak()` method so that when it is called "Growl!" is printed to the screen using `System.out.println`
7. Implement the `eat()` method so that when it is called it prints out "Tony the Tiger eats Hyenas". Here, Tony is what the `name` field has been set to and Hyenas is what the `prey` field has been set to. Do not hard code Tony and Hyenas, but rather find a way to generally print out the `name` and `prey`. Hint: You will need to use the getter method for `prey` that you wrote in `Carnivore`. 
8. Implement the `move()` method so that it prints out: "Tigers move gracefully due to their powerful leg and shoulder muscles."
9. Implement the `sleep()` method so that it prints out "Tigers like to sleep in rocky places, grassy areas, or inside caves."
10. Implement the `kingdom()` method so that it returns "Animalia"
11. Implement the `genus()` method so that it returns "Panthera"
12. Implement the `species()` method so that it returns "P.tigris (tiger)"
13. Finally, implement the `prowl()` method so that it prints out "The tiger pounces on an unsuspecting (Prey field goes here)"
 
<h1>More about using the Comparator Interface</h1>
  
`Comparator` is a generic interface for comparing instances of the same type (call it type T) with one method:
  
``` java
/**
 * Compares two instances of type T
 * @param a the first instance to compare
 * @param b the second instance to compare
 * @return a negative number if a is less than b
 *         0 if a is equal to b
 *         a positive number if a is greater than b
 */
public int compare(T a, T b);
```
  
We are going to compare animals by considering the food chain. If Animal A is prey of Animal B, then we will say A is less than B. If on the other hand Animal A is a predator of Animal B, then we will say that A is greater than B. If one is a `Herbivore` and the other is a `Carnivore`, then we will say that the `Herbivore` is less than the `Carnivore`, since Herbivores are lower on the food chain than Carnivores. If the animals do not have a prey and predatory relationship and are both Herbivores, then we compare them based off their agressionLevels, returning `a.getAgressionLevel() - b.getAgressionLevel()`. If two Carnivores do not have a predatory-prey relationship, then they will be compared by their `predatoryLevel`. The Carnivore with the higher predatoryLevel is considered greater than the other. If they have the same predatoryLevel, then the two Carnivores are considered equal. Let's get working on implementing this method. 

1. Make a concrete class `AnimalComparator` that implements `Comparator<Animal>`. You will need to add the import `java.util.Comparator`.
2. Inside `AnimalComparator`, override the method `compare()`, which will have the following method heading. This is because the Comparator's Java generic was specified as Animal, so our type T is comparing Animal objects to one another: 
``` java
@Override
public int compare(Animal a, Animal b){
	
}
```

3. Start by making two Strings inside compare, `aPrey` and `bPrey`, each initialized to the empty String.
4. Now, we want to see if each `Animal` is a `Carnivore`, if it is, then we want to extract the `prey` and store it inside `aPrey` or `bPrey` respectively. This will require subtype checking and downcasting. The logic will look like this:
  
``` java
if(a instanceof Carnivore) aPrey = ((Carnivore)a).getPrey();
if(b instanceof Carnivore) bPrey = ((Carnivore)b).getPrey();
```
  
5. Please note that `instanceof` check is necessary, otherwise we could get Casting Exceptions at runtime. If we try to cast the animal down to the subtype Carnivore but it is actually a Herbivore, that is a Down Casting Error. The downcast is also necessary, because the `getPrey()` method can only be called on Carnivores, not Animal objects. 
6. Next, if the length of `aPrey` and `bPrey` are both still zero, then this means that a and b were actually both Herbivores, so we return ((Herbivore)a).getAgressionLevel() - ((Herbivore)b).getAgressionLevel().
7. Next, we will check if A is the prey of animal B. To do so, we will do something like this, utilizing the `getAnimalName()` method, `equals()` method to compare Strings, and `bPrey`:
```java
//if Animal A is B's prey then A is considered less than B
if(a.getAnimalName().equals(bPrey)) return -1;
```
8. Do a similar check after this if block to see if b is actually the prey of animal a. if it is, a is considered greater than b, so return a positive integer, say 1.
9. If we have not returned yet, it could be that a and b are both carnivores. we can check if `aPrey` and `bPrey` are both non-empty strings. If this is the case, this implies they both have prey and are carnivores, but are not related by a predator-prey relationship. so we return ((Carnivore)a).getPredatoryLevel() - ((Carnivore)b).getPredatoryLevel() in this case.
10. Finally, if we have not returned yet, then one of our animals is a herbivore and the other is a carnivore. we can simply return `aPrey.length() - bPrey.length()`. if a is the herbivore, then it has length zero, and no matter what b's prey is, the method will return negative, indicating that the herbivore a is less than the carnivore b. Otherwise, if a is the carnivore, then bPrey is empty, so the function will return a positive value, indicating the carnivore a is greater than the herbivore b. This covers all the cases for comparing two Animals to one another.
   
Let's do one last thing. Inside `AnimalComparator`, make a method `public void sortAnimals(ArrayList<Animal> list)`. This method will sort a provided list of animals, putting the Herbivores toward the beginning of the list, and the Carnivores towards the end of the list. This time, instead of using a bubble sort we will be using an <b>insertion Sort</b>. Below is the code for doing an insertion sort on an array of integers. Please note that `temp` should be changed to type `Animal`, since we are sorting Animals. Also, you will need to use equivalent statements using `get()` and `set()` methods, since we are working with ArrayLists and not arrays. Finally, to check if the jth animal is less than the j-1th animal in the if statement, you will need to use the `compare` method, since the < operator is not defined for Animals. That is why it was necessary to implement the `compare` method from the `Comparator` interface in the first place. <a href= "https://upload.wikimedia.org/wikipedia/commons/9/9c/Insertion-sort-example.gif">Here is a gif showing you what the insertionSort is doing with a concrete example: insertionSort</a>.
  
```java
public void doInsertionSort(int[] input){
         
        int temp;
        for (int i = 1; i < input.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(input[j] < input[j-1]){
                    temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
            }
        }
    }
 ```
  
Add the following `staticCompare()` method and `staticSortAnimals()` method to AnimalComparator which will make testing easier: 

```java 
	public static int staticCompare(Animal a, Animal b){
		return new AnimalComparator().compare(a, b);
	}
	
	public static void staticSortAnimals(ArrayList<Animal> list){
		new AnimalComparator().sortAnimals(list);
	}
``` 

Make sure that the code you have written for `compare` is working by passing test01 through test12 in the provided junit tester. test13 is meant to see if your `sortAnimals()` method has been implemented correctly.
  
You do not need to write tests for the other methods written, they were added mainly to show you two things. First, how implementing abstract methods from an interface work, and also to highlight that classes can implement multiple interfaces. It is worth noting that that even though Carnivores and Herbivores cannot be instantiated, they can still have constructors to set the additional fields associated with these abstract classes.  The constructors are called by the subclass which extend these abstract parent classes.

<h1>Functional Interfaces and Lambda expressions</h1>
  
<a href="https://www.geeksforgeeks.org/functional-interfaces-java/">Please browse through this link for an introduction to functional intefaces and lambda expressions and seeing how they are related to one another.</a> 

A <b>functional interface</b> is an interface that <b>contains only one abstract method</b>. Note that above, when we used `Comparator`, there was only one abstract method we had to implement, `compare()`. By definition, `Comparator` is a functional interface. This means we can implement the `Comparator`'s `compare()` method using a <b>lambda expression</b>, rather than having the class implement `Comparator` itself. Let me show you a simple example. 

First, below is how we have been implementing the `Comparator` interface. Notice that is a bit undesirable to have to make an object to be able to call `sort` in the main's static context. Additionally, writing a `sort` method is annoying and error prone. (Notice that I do no checking for Integer's in the list being null, which could cause null pointer exceptions). 

```java
package lab07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ImplementInterface implements Comparator<Integer>{
	@Override
	public int compare(Integer a, Integer b){
		return a- b;
	}
		
	public void sort(List<Integer> list){
		//make a deepcopy of list so we can remove from it
		List<Integer> deepCopy = new ArrayList<>();
		for(Integer i : list) deepCopy.add(new Integer(i));
		//empty the list
		list.clear();
		//while there are elements in deepCopy, find the minimum element
		//add that element to retVal and remove it from deepCopy
		while(deepCopy.size() > 0){
			Integer min = deepCopy.get(0);
			for(Integer i : deepCopy){
				if(compare(min, i) > 0) min = i; 
			}
			list.add(min);
			deepCopy.remove(min);
		}
	}
	
	public static void main(String[] args){
		List<Integer> list = new ArrayList<>(Arrays.asList(3,6,1,2,4,0));
		System.out.println("Before sorting: " + list);
		new ImplementInterface().sort(list);
		System.out.println("After sorting: " + list);
	}
}
``` 

Here is a how we could do the same thing using lambda expressions:

```java
package lab07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda {
	private static Comparator<Integer> intComp = (a, b) -> { return a - b; };
	
	public static void main(String[] args){
		List<Integer> list = new ArrayList<>(Arrays.asList(3,6,1,2,4,0));
		System.out.println("Before sorting: " + list);
		list.sort(intComp);
		System.out.println("After sorting: " + list);
	}
}
```

OR even more concisely, we could do it like this:

```java
package lab07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda {
	public static void main(String[] args){
		List<Integer> list = new ArrayList<>(Arrays.asList(3,6,1,2,4,0));
		System.out.println("Before sorting: " + list);
		list.sort((a, b) -> { return a - b; });
		System.out.println("After sorting: " + list);
	}
}
``` 

So what is going on with the lambda expressions? If you think about it, since Comparator only has one abstract method to implement, the only thing we really need to do is implement that `compare()` method to make it useable. 
```java
private static Comparator<Integer> intComp = (a, b) -> { return a - b; };
```
Here we are creating an instance of the Comparator interface which compares Integers. We assign it equal to a lambda expression, which is an <b>anonymous function definition</b>, which is describing how the `compare()` method is implemented. <b>It is treating the function definition as if it is an object that can be assigned</b>. This means the lambda expression not only describes the functionality of the abstract method inside the functional interface, but can be thought of as representing the entire functional interface itself. This is a concept that comes from <b>functional programming</b>. As you can see, it is much more concise, although arguably a little harder to read and comprehend. `(a, b)` are two dummy parameters representing the two Integer objects that get passed to compare(). Since we declared `intComp` as a `Comparator<Integer>`, the compiler can deduce that a and b are in fact Integer objects without us telling it, just by looking at `compare()`'s method header. The `-> { }` is where we place the method body of the `compare()` method, which uses the dummy `a` and `b` values as needed to describe how the `compare()` method will work. All together, we have an anonymous definition for the `compare()` method of the `Comparator<Integer>` interface.

list has a `sort` method built in already! Why do we need to reinvent the wheel and write our own `sort()` method? The only catch is list's `sort()` method needs to take a `Comparator` as an argument. Luckily, we have just made one, `intComp`. We can thus pass it in to `list.sort()`, as we did in the first example. 
  
However, why do we need to make `intComp` in the first place? Why not just pass in the lambda expression itself? As we said, to compare two Integers, we should only need to describe how to compare them. We really don't need a notion of the `Comparator` class itself. `Comparator` can be thought of as a mere wrapper for the `compare()` method. That is why the second example with Lambda expressions was made possible in java 1.8 and beyond.

Using this example, we should be able to make comparing Animals much more concise as well. 

1. Go back to Animal and create a private static Comparator<Animal> called animalComp, set equal to a lambda expression. The lambda expression, should take two dummy parameters, a and b, and the method body should be exactly what you wrote for your compare() method in AnimalComparator.
 
2. Add a getter method for animalComp called public static Comparator<Animal> getComp().
 

Back in `ComparatorTester`:

1. at the top add the line `Comparator<Animal> animalComp = Animal.getComp();` before the `init()` method.
2. Change the tests so you are using `animalComp` to compare for tests 1 through 12.
3. In test13, right before the print out of "Animal list after insertion sort", change the sort so we are using `list.sort(animalComp)` You should get the following output for test 13:
 
 ```java
***********Animal list before insertion sort************
Tony the Tiger which eats Hyena
Troy the Tiger which eats Antelope
Bambi the Deer which eats grass
Ed the Hyena which eats Deer
Pippin the Deer which eats apple
***********Animal list after insertion sort************
Bambi the Deer which eats grass
Pippin the Deer which eats apple
Ed the Hyena which eats Deer
Troy the Tiger which eats Antelope
Tony the Tiger which eats Hyena
```
