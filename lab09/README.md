# lab09 - Due November 2nd at 11:59 pm
Binary Search Trees


Today we will learn about a specific kind of Binary Tree and implement that data structure.

A <b>Recursive Binary Tree</b> is a data structure which is built in a way to resemble a tree, having a root, branches, and leaves.

* You can think of it as being made up of Nodes.
* Each Node will hold three things:
  * some piece of data. (below the data are ints, but they could be any type of data, including Strings, or even objects made from some       class we define)
  * a left Node
  * a right Node
* The first Node in the tree is often referred to as the <b>root</b> of the tree.
* The left and right of a Node are said to be that Node's <b>children</b>. 
* A Node is considered a <b>parent</b> to its left and right children.
* Two children that share the same parent are called <b>siblings</b>.
* We say a Node is a <b>leaf</b> if both its children are null 
* A <b>branch</b> is a path that you can follow from the root to a leaf via edges in the Binary Tree.
* The <b>depth</b> of a node is the number of edges from the root to the node.
* We say that the <b>height</b> of a Binary tree is the maximum number of edges between the root and any leaves in the Tree.
* A Recursive Binary Tree can be traversed using recursion. 
* Below is an example of what a Recursive Binary Tree can look like:

![Java Project](https://github.com/Binghamton-CS140-A0-Fall-2018/screenshots/blob/master/lab09/binaryTree.PNG)

* Here, the root has a data value of 1. 
* The root node has a left child, which holds a data value of 2, and a right child, which holds a value of 3.
* Note that the node with a data value of 2 has two non-null children, while the node with a data value of 3 only has one non-null child, namely its right.
* We do not explicitly show when a child node is null in our picture. The absence of a child from a parent node implies that child is null.
* The leafs are the nodes containing a data value of 4, 5, and 6 here. 
* Note that the nodes with values 4 and 5 are considered siblings, and their parent node is the node which holds the value 2.
* The height of this tree is 2.
* The root is at depth 0, its children are at depth 1, and the leaves are at depth 2.
* One example of a branch would be the path from the root to the leaf with data value 4, which would be 1 -> 2 -> 4.
* Note there are three branches in this example.
  * 1-> 2-> 4
  * 1 -> 2 -> 5
  * 1 -> 3 -> 6
 

Now, we'd like to briefly highlight different ways you can traverse a binary tree. Below, when we say <b>visit</b>, this means we are going to actually interact with the data inside the node we are <b>visiting</b>. 

* We can visit a node to <b>change</b> the value of the data inside a node
* We can visit a node to <b>extract</b> its value and print the value of the data inside a node
* We can visit a node in an attempt to <b>find</b> a particular value within the Binary Tree
* We can visit a node to <b>remove</b> it from the Binary Tree if it holds a particular value
* We can visit a node in an attempt to find a sensible place to <b>insert</b> a new Node in Binary Tree, which may depend on the value stored in a Node already in the Tree.
* There are various other reasons we may want to visit each Node

![Java Project](https://github.com/Binghamton-CS140-A0-Fall-2018/screenshots/blob/master/lab09/traversals.PNG)

A <b>B</b>inary <b>S</b>earch <b>T</b>ree (BST) is a binary tree which further satisfies an additional <b>search property</b>. The property is that
  * the left child (if it exists) has a value <b>strictly less</b> than its parent's value
  * the right child (if it exists) has a value <b>strictly greater</b> than its parent's value
 
Any operation on the BST, such as insertion and removal, must maintain this search property at all times. Thus, binary search trees can have no duplicates. This property needs to be maintained at all times, but greatly simplifies searching for elements (why?) and allows for other nice things. These optimizations from regular binary trees is what make search trees common in code.

Binary search trees are simply a container. Like arrays or arraylists, they should be able to store any kind of Object. Since BSTs need to know if one value is greater than another, BSTs either use the natural ordering of their elements (like '>' for integers) or can accept a custom function that tells the BST how to order its elements. This lab will use the latter.

Instead of having an inner Node class, we will think of a BST as being made up of smaller sub BSTs. Instead of every node having a left and right Node, we view it as each node having a left and right BST. For instance, If you look at the example above, you can view the tree in the following way:

![Java Project](https://github.com/Binghamton-CS140-A0-Fall-2018/screenshots/blob/master/lab09/subTrees.PNG)

The node with data value 8 is the root of the entire BST, which has a left sub tree of 3,1,6,4,7 and a right sub tree of 10,14,13. Similarly, we can also view 3 as the root of the left BST, and 10 as the root of the right BST. Notice we are breaking the bigger data structure down into smaller and smaller pieces ... which means we are already thinking recursively. In this view, the smallest BST (our base case) would be a leaf, which is a BST containing a root which has no children. If we get any smaller than a leaf, then we have a trivial empty BST which doesn't even have a root. (You may decide you want to account for the empty BST as a base case as well, although it probably won't be too interesting of a case to consider.) 

<a href="https://www.cs.usfca.edu/~galles/visualization/BST.html"><b>Here is an additional link that will let you play around with BSTs, inserting nodes, finding nodes, and even removing nodes.</b></a>

<h1>Lets get Coding</h1>

In <b>BinarySearchTree.java</b>, the methods that you have to implement are marked with a <b>TODO</b> comment. Use the method javadocs and the above explanation of BSTs to implement the methods. Two constructors and a short main method have been implemented for you. Change the main method how you want (as long as it still compiles) - it is for you to debug with.

<b>Important:</b>
  * You are not allowed to use (Array)Lists or arrays (except in the `getElements` method) in your implementation of the methods
  * You are not allowed to use for/while/do-while loops, except where noted.
  * Significant points will be deducted for failure to follow this.

To know if your code is correct, we have provided a series of JUnit tests you can test your code with. Note that since each method requires a BST to test, and a BST can only be constructed through the `insert` method, all tests will require you to at least implement `insert` before they can work. Also the `prettyPrint` method is not tested here so you will likely want to test that on your own in the main method of the `BinarySearchTree` class. Note it will print the node with the least value (ie the left most node) in the tree first and the node with the greatest value (ie the right most node) in the tree last. This implies we are visiting left, the parent, then the right, which is again an inOrder Traversal. The given implementation of the main method should print

 ![Java Project](https://github.com/Binghamton-CS140-A0-Fall-2018/screenshots/blob/master/lab09/prettyPrint.PNG)

    
<h1>Complete Tree with Strings</h1>

Look how the provided main method makes a `Comparator` for integers using a <b>lambda expression</b>. Some quick google-ing should clue you in to the syntax of lambda expressions and how they can act as anonymous interface implementations. Given that and how `Comparator`'s `compare` methods works, it should be clear how `intComp` tells the BST to order numbers in ascending order.

In the main of BinarySearchTree, create another BST that holds Strings. Create a `Comparator` for Strings that will order Strings by their length, in <b>descending</b> order. This Comparator <b>must</b> be initialized in one-line of code via a lambda expression. Add the following strings: 
>a  
hi  
cat  
test  
penta  
stella  
oranges  
oxymoron  
blackjack  
      
and prettyPrint the tree to show your `Comparator` works. Make sure at least 9 Strings are printed out, and that the tree is <b>complete</b>. <a href="http://web.cecs.pdx.edu/~sheard/course/Cs163/Doc/FullvsComplete.html"> By complete, we mean the definition that appears here. Not the full definition, the second one that appears toward the bottom of the page</a>. 

Hint: Here is a complete tree involving the first 9 integers, in descending order.

 ![Java Project](https://github.com/Binghamton-CS140-A0-Fall-2018/screenshots/blob/master/lab09/complete.PNG)


<h1>Bonus</h1>

(Same details as lab08)

If attempting, show case that it works properly in the main of a new file called `Bonus.java`.

You must implement one of the following 2 methods, back in `BinarySearchTree`:

<h2>Option 1</h2>

Create a method `public int height()` that returns the height of the BST. The method must be recursive, no for loops are allowed.

Hint: Let the root of the current BST contribute 1 to the total height if it is not a leaf, and in general, let leaves contribute zero to the total height. This will make the implementation easier. There are 4 cases to consider:

>the left and right subtrees are both non-null (Math.max() may prove useful here).  
the left subtree is non-null while the right subtree is null  
the right subtree is non-null while the left subtree is null  
you are at a leaf (this also would account for the root if both its subtrees are null)  

<h2>Option 2</h2>

Create a method `public List<T> nonLeaves()` that returns a list containing all data T contained in the non-leaves of the BST, in <b>descending</b> order. (Assume the comparator of the tree sorts in ascending order, such as the BinarySearchTree of Integers in BinaryTreeTester). The method must be recursive, no for loops are allowed.

Hint: You will need to do an in order traversal here, but doing the right first instead of the left. Additionally, you only add an element if it is not a leaf (think about what this entails). You will have to use the addAll method in this method's implementation to avoid for loops.
