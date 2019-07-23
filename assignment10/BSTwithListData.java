package assignment10;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

/**
 * A class to implement the Binary Search Tree data structure.
 * The structure is generic in the type of Objects it contains.
 * @param <T> the type of the contained elements this structure is to hold
 */
public class BSTwithListData<T> {
    private Comparator<T> comparator;
    private List<T> data;
    private BSTwithListData<T> left;
    private BSTwithListData<T> right;
    private int insertCount; 
    /**
     * Constructs an empty BST with a Comparator
     * @param comp the Comparator to use to impose an ordering on instances of T
     */
    public BSTwithListData(Comparator<T> comp) {
        this.comparator = comp;
    }

    /**
     * Constructs a BST with data and a Comparator
     * @param data the data this BST should hold
     * @param comp the Comparator to use to impose an ordering on instances of T
     */
    public BSTwithListData(T data, Comparator<T> comp) {
    	this.data = new ArrayList<>();
        this.data.add(data);
        this.comparator = comp;
        this.insertCount = 0;
    }
    
    public BSTwithListData(List<T> data, Comparator<T> comp) {
    	this.comparator = comp;
    	this.insertCount = 0;
    	this.data = data;
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

    	if (find(element) != null) {
    		return;
		}
		insertCount ++;

    	if(data ==null) {
    		data = new ArrayList<>();
    		data.add(element);
    	
    	}
    
    	
    	if(comparator.compare(element, data.get(0))==0) {
    		if(!data.contains(element)) {
    			data.add(element);
    		}
    		return;	
    	}
    	
    	if(comparator.compare(data.get(0), element)>0) {
    		if(left== null) {
    			left = new BSTwithListData<T>(element, comparator);
    		}else {
    			left.insert(element);
    		}
    		
    	}else {
    		if(right== null) {
    			right = new BSTwithListData<T>(element, comparator);
    		}else {
    			right.insert(element);
    		}
    		
    	}
    	if(insertCount == 10) {
			insertCount = 0;

			List<List<T>> nodes = this.getGroups();
			data = nodes.get(nodes.size() / 2);

			List<List<T>> leftNodes = new ArrayList<>();
			for (int i = 0; i < nodes.size() / 2; i++) {
				leftNodes.add(nodes.get(i));
			}

			List<List<T>> rightNodes = new ArrayList<>();
			for (int i = nodes.size() / 2 + 1; i < nodes.size(); i++) {
				rightNodes.add(nodes.get(i));
			}

			this.left = makeBalancedTree(leftNodes);
			this.right = makeBalancedTree(rightNodes);
		}
    }
    
    public BSTwithListData<T> makeBalancedTree(List<List<T>> nodes){
    	if(nodes == null || nodes.size() == 0){
    		return null;
    	}
    	BSTwithListData<T> retVal = new BSTwithListData<T>(nodes.get(nodes.size()/2), comparator);
    		List<List<T>> leftNodes = new ArrayList<>();
    		for(int i = 0 ; i < nodes.size()/2 ; i++){
    			leftNodes.add(nodes.get(i));
    		}

    		List<List<T>> rightNodes = new ArrayList<>();
    		for(int i = nodes.size()/2+1 ; i < nodes.size() ; i++){
    			rightNodes.add(nodes.get(i));
    		}
    		retVal.left = makeBalancedTree(leftNodes);
    		retVal.right = makeBalancedTree(rightNodes);
    		return retVal;
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

    	if (data == null) {
    		return null;
		}
    	
    	if(comparator.compare(element, data.get(0)) == 0) {
    		if(data.contains(element)){
    			return element;
    		}
    		return null;	
    	}
    	else if(comparator.compare(data.get(0), element) < 0) {
			if(right == null) {
				return null;
			}
    		return right.find(element);
		}
		else if(comparator.compare(data.get(0), element) > 0) {
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
			list.addAll(data);
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
    
    public List<T> nonLeaves(){
    	List<T> retVal = new ArrayList<T>();	
    	if(data == null){
    		return null;
    	}

    	if (left == null && right == null) {
    		return retVal;
		}

		if (right != null) {
			retVal.addAll(right.nonLeaves());
		}
		retVal.addAll(data);
		if (left != null) {
			retVal.addAll(left.nonLeaves());
		}
    	return retVal;
    	
    }
    public int height() {
    	if (left == null && right == null) return 0;
    	if(left == null){
    		return right.height()+1;
    	 }
    	 if(right == null) {
			 return left.height() + 1;
		 }
    	 return Math.max(left.height(), right.height()) + 1;
    	 
    	
    }
    
    public List<List<T>> getGroups(){
    	List<List<T>> list = new ArrayList<>();
        if(left!=null) {
        	list = left.getGroups();
        }
		if(data!=null) {
			list.add(data);
		}
		if(right!=null) {
			list.addAll(right.getGroups());
		}
        return list;
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
			data.add(element);
		}
		else if(comparator.compare(element,data.get(0))<0){
			for(int i = 0; i < indent+1; i++) System.out.print("\t");
			System.out.println("element: " + element + " < data: " + data + ", LOOK TO LEFT BST");
			if(left == null){
				for(int i = 0; i < indent+1; i++) System.out.print("\t");
				System.out.println("Left was null, so we can insert here. Setting parent node with data: " + data + 
						" to have left child with data " + element);
				left = new BSTwithListData<T>(element, comparator);
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
		else if(comparator.compare(element,data.get(0))>0){
			for(int i = 0; i < indent+1; i++) System.out.print("\t");
			System.out.println("element: " + element + " > data: " + data + ", LOOK TO RIGHT BST");
			if(right==null){
				for(int i = 0; i < indent+1; i++) System.out.print("\t");
				System.out.println("Right was null, so we can insert here. Setting parent node with data: " + data + 
						" to have right child with data " + element);
				right = new BSTwithListData<T>(element, comparator);
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
        BSTwithListData<Integer> tree = new BSTwithListData<>(intComp);
        tree.insert(3);
        tree.insert(8);
        tree.insert(1);
        tree.insert(0);
        tree.insert(3);
        tree.insert(9);
        tree.insert(4);
        tree.prettyPrint();
        System.out.println();
        
        Comparator<String> strComp = (str1, str2) -> str2.length() - str1.length(); // lambda expression
        BSTwithListData<String> tree2 = new BSTwithListData<>(strComp);
        tree2.insert("stella");
        tree2.insert("oxymoron");
        tree2.insert("test");
        tree2.insert("blackjack");
        tree2.insert("oranges");
        tree2.insert("penta");
        tree2.insert("hi");
        tree2.insert("cat");  
        tree2.insert("a");
        
        tree2.prettyPrint();
        tree.insertDBG(13);
        
        
        
        BSTwithListData<String> sTree1 = new BSTwithListData<>(Comparator.comparingInt(String::length));
        sTree1.insert("John");
        sTree1.insert("Jane");
        sTree1.insert("July");
        sTree1.insert("June");
        sTree1.insert("Jeff");
        sTree1.insert("Jedd");
        sTree1.insert("Johl");
        sTree1.insert("Jude");
        sTree1.insert("Julie");
        sTree1.insert("Molly");
        sTree1.prettyPrint();
        System.out.println(sTree1.height());
        System.out.println(sTree1.getElements());
        System.out.println(sTree1.nonLeaves());
        
        
        BSTwithListData<String> sTree = new BSTwithListData<>(strComp);
        sTree.insert("a");
        sTree.insert("hi");
        sTree.insert("cat");
        sTree.insert("test");
        sTree.insert("penta");
        sTree.insert("stella");
        sTree.insert("oranges");
        sTree.insert("oxymoron");
        sTree.insert("blackjack");


		System.out.println(sTree.getElements());

        sTree.insert("a1");

        sTree.insert("h1");
        sTree.insert("ca1");
        sTree.insert("tes1");
        sTree.insert("pent1");
        sTree.insert("stell1");
        sTree.insert("orange1");
        sTree.insert("oxymoro1");
        sTree.insert("blackjac1");
        sTree.insert("a2");
        sTree.insert("h2");
        sTree.insert("ca2");
        sTree.insert("tes2");
        sTree.insert("pent2");
        sTree.insert("stell2");
        sTree.insert("orange2");
        sTree.insert("oxymoro2");
        sTree.insert("blackjac2");
        sTree.prettyPrint();
        System.out.println("Balance Height: " +sTree.height());
    }
}
