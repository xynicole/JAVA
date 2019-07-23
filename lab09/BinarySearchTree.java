package lab09;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

/**
 * A class to implement the Binary Search Tree data structure.
 * The structure is generic in the type of Objects it contains.
 * @param <T> the type of the contained elements this structure is to hold
 */
public class BinarySearchTree<T> {
    private Comparator<T> comparator;
    private T data;
    private BinarySearchTree<T> left;
    private BinarySearchTree<T> right;

    /**
     * Constructs an empty BST with a Comparator
     * @param comp the Comparator to use to impose an ordering on instances of T
     */
    public BinarySearchTree(Comparator<T> comp) {
        this.comparator = comp;
    }

    /**
     * Constructs a BST with data and a Comparator
     * @param data the data this BST should hold
     * @param comp the Comparator to use to impose an ordering on instances of T
     */
    public BinarySearchTree(T data, Comparator<T> comp) {
        this.data = data;
        this.comparator = comp;
    }

    /**
     * Inserts an element into this BST
     * if element is null, do not insert element
     * it is worth noting that the only time data could be null is if we created a BST with no initial data
     * in that case, if data is null, we just update data to equal element, and the insertion is done
     * if the element to be inserted compares equal to another value that is already in the tree, do not insert element
     * we do this for the sake of simplicity, forcing elements in the tree to be unique
     * @param element the element to insert into this BST
     */
    public void insert(T element) {
        // TODO
    	if(element==null) {
    		return;
    		
    	}
    	if(data ==null) {
    		data = element;
    		return;
    	}
    	
    	if(comparator.compare(element, data)==0) {
    		return;	
    	}
    	
    	if(comparator.compare(data, element)>0) {
    		if(left== null) {
    			left = new BinarySearchTree<T>(element, comparator);
    			
    		}else {
    			left.insert(element);
    		}
    		
    	}else {
    		if(right== null) {
    			right = new BinarySearchTree<T>(element, comparator);
    			
    		}else {
    			right.insert(element);
    		}
    		
    	}
    	
    	
    }

    /**
     * Searchs for a given element in this BST
     * if element is null, return null
     * @param element the element to search this BST for
     * @return the element in this BST matching the given element, if found,
     *         otherwise null if the given element is not in this BST
     */
    public T find(T element) {
        // TODO
    	if(element == null) {
    		return null;
    	}
    	
    	if(comparator.compare(element, data)==0) {
    		return data;	
    	}
    	else if(comparator.compare(data, element) < 0) {
			if(right == null) {
				return null;
			}
    		return right.find(element);
		}
		else if(comparator.compare(data, element) > 0) {
			if(left == null) {
				return null;
			}
			return left.find(element);
		}
		return element;
        
    }

    /**
     * Gathers all the elements of this BST in order
     * @return a List holding the elements in this BST in order
     */
    public List<T> getElements() {
        List<T> list = new ArrayList<>();
        // TODO
        if(left!=null) {
        	list = left.getElements();
        }
		if(data!=null) {
			list.add(data);
		}
		if(right!=null) {
			list.addAll(right.getElements());
		}
        return list;
    }

    /**
     * Pretty prints the contents of this BST in a horizontal tree-like fashion
     */
    public void prettyPrint() {
        prettyPrint(0);
    }

    private void prettyPrint(int indentLevel) {
        // TODO
        // print `indentLevel` amount of spaces before printing data on its own line
	//HINT: you will want to do an in order traversal here. (see the Traversal section in the explanation of Binary Trees above)
        // you may use a for loop to print `indentLevel` amount of spaces
        // each time you recurse, you add to indentLevel
    	if(left!=null) {
    		left.prettyPrint(indentLevel+1);
    	}
		if(data!=null) {
			for(int i = 0; i < indentLevel; i++) {
				System.out.print("  ");
			}
			System.out.println(data);
		}
		if(right!=null) {
			right.prettyPrint(indentLevel+1);
		}
    }
    
    
    
    public void insertDBG(T element){
		insertDBG(element, 0);
}
	
	private void insertDBG(T element, int indent) {
                if(element == null) return;
		for(int i = 0; i < indent; i++) System.out.print("\t");
		System.out.println("Inserting " + element + " from node with data: " + data);
		if(data==null){
			for(int i = 0; i < indent+1; i++) System.out.print("\t");
			System.out.println("Empty BST, setting root to hold data: " + element);
			data = element;
		}
		else if(comparator.compare(element,data)<0){
			for(int i = 0; i < indent+1; i++) System.out.print("\t");
			System.out.println("element: " + element + " < data: " + data + ", LOOK TO LEFT BST");
			if(left == null){
				for(int i = 0; i < indent+1; i++) System.out.print("\t");
				System.out.println("Left was null, so we can insert here. Setting parent node with data: " + data + 
						" to have left child with data " + element);
				left = new BinarySearchTree<T>(element, comparator);
			}
			else{
				for(int i = 0; i < indent+1; i++) System.out.print("\t");
				System.out.println("Left is non-null, holding data: " + left.data + ". Rescursively searching left BST for a place we can insert");
				for(int i = 0; i < indent+1; i++) System.out.print("\t");
				System.out.println("******************************************************************************");
				left.insertDBG(element, indent+1);
				for(int i = 0; i < indent+1; i++) System.out.print("\t");
				System.out.println("******************************************************************************");
			}
		}
		else if(comparator.compare(element,data)>0){
			for(int i = 0; i < indent+1; i++) System.out.print("\t");
			System.out.println("element: " + element + " > data: " + data + ", LOOK TO RIGHT BST");
			if(right==null){
				for(int i = 0; i < indent+1; i++) System.out.print("\t");
				System.out.println("Right was null, so we can insert here. Setting parent node with data: " + data + 
						" to have right child with data " + element);
				right = new BinarySearchTree<T>(element, comparator);
			}
			else {
				for(int i = 0; i < indent+1; i++) System.out.print("\t");
				System.out.println("Right is non-null, holding data: " + right.data + ". Rescursively searching right BST for a place we can insert");
				for(int i = 0; i < indent+1; i++) System.out.print("\t");
				System.out.println("******************************************************************************");
				right.insertDBG(element, indent+1);
				for(int i = 0; i < indent+1; i++) System.out.print("\t");
				System.out.println("******************************************************************************");
			}
		}
		for(int i = 0; i < indent; i++) System.out.print("\t");
		System.out.println("EXITING INSERT CALL MADE BY NODE WITH DATA: " + data + "\n\n");
	}

    /**
     * A main method supplied for any debugging needs
     */
    public static void main(String[] args) {
        // Up to you how you use this main method, feel free to change it
        Comparator<Integer> intComp = (i, j) -> i - j; // lambda expression
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(intComp);
        tree.insert(3);
        tree.insert(8);
        tree.insert(1);
        tree.insert(0);
        tree.insert(3);
        tree.insert(9);
        tree.insert(4);
        //tree.insertDBG(13);
        tree.prettyPrint();
        System.out.println();
        
        Comparator<String> strComp = (str1, str2) -> str2.length() - str1.length(); // lambda expression
        BinarySearchTree<String> tree2 = new BinarySearchTree<>(strComp);
        tree2.insert("stella");
        tree2.insert("oxymoron");
        tree2.insert("test");
        tree2.insert("blackjack");
        tree2.insert("oranges");
       // tree2.insert("stella");
        tree2.insert("penta");
        tree2.insert("hi");
        tree2.insert("cat");  
        tree2.insert("a");
        
        tree2.prettyPrint();
        tree.insertDBG(13);
    }
}
