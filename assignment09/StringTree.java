package assignment09;

import java.util.ArrayList;
import java.util.List;
/**
 * A simple tree structure for storing Strings. Notes in the tree can 
 * have any number of children
 * IMPORTANT: we will ensure that each String is stored ONLY ONCE in the tree
 */
public class StringTree {
	private String data;
	List<StringTree> children;
	
	/** 
	 * Constructor sets the data field to be the given String and
	 * instantiates the List of children to an empty list
	 * @param str the String that will be the data at the root of the tree
	 */
	public StringTree(String str) {
		data = str;
		children = new ArrayList<>();
	}
	
	/**
	 * The new subtree is added as one of the children of this StringTree but only 
	 * after removing all the Strings in subtree that are already stored in 
	 * this StringTree.
	 * @param subtree the tree to be added to the children of this StringTree
	 */
	public void addSubTree(StringTree subtree) {
		// first get the list of current Strings in the StringTree "this"
		// using listContent(). For each String str in the list change
		// subtree to subtree.treeDelete(str)
		// after that add subtree to children
		this.listContent();
		for(String str:this.listContent() ) {
			subtree = subtree.treeDelete(str);
		}
		children.add(subtree);
	}
	
	/** 
	 * Getter method for the data field
	 * @return the value data
	 */
	public String getData() {
		return data;
	}

	/** 
	 * Getter method for the children field
	 * @return the value children
	 */
	public List<StringTree> getChildren() {
		return children;
	}
	
	/**
	 * Return a list of the Strings stored in this StringTree
	 * @return a list of the Strings stored in this StringTree
	 */
	public List<String> listContent() {
		// make a new ArrayList
		// add the String data
		// for every String t in children, recursively
		// add all the Strings from t using addAll(t.listContent())
		// return the ArrayList
		List<String> str = new ArrayList<String>();
		str.add(data);
		for (StringTree t : children) {
			str.addAll(t.listContent());
		}
		return str;	
	}
	
	/**
	 * Remove the give String from this StringTree. ASSUME the String
	 * only appears once in the StringTree
	 * @param str the String to be removed from the tree
	 * @return a modified version of this StringTree with the String removed
	 */
	public StringTree treeDelete(String str) {
		// return "this" if !data.equals(str) and children is empty
		// if data.equals(str) there are two subcases
			// if children is empty return null
			// make a new StringTree called newRoot set to be children.get(0)
			// and add all the other children to newRoot.children
			// return newRoot;
		// when neither of the above returns happened set the i-th element of 
		// children to children.get(i).treeDelete(str) for every i
		// return this
		if(!data.equals(str) && children.isEmpty() ) {
			return this;
		}
			
		if(data.equals(str)) {
			if(children.isEmpty()) {
				return null;
			}
			StringTree newRoot = new StringTree("");
			newRoot= children.remove(0);
			newRoot.children.addAll(children);
			return newRoot;
		}
		for(int i = 0; i<children.size(); i++) {
			children.set(i,children.get(i).treeDelete(str) );
		}
		return this;
	}
	
	/**
	 * Tests whether the given String is stored in the StringTree
	 * @param str returns true if str is stored in this StringTree otherwise
	 * returns false.
	 * @return
	 */
	public boolean contains(String str) {
		if(listContent().contains(str)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Simple test program for the Tree on Page 768
	 * @param args command line parameters are not used here
	 */
	
	public static void main(String[] args) {
		var s1 = new StringTree("section_4");
		var s2 = new StringTree("section_1");
		var s3 = new StringTree("section_2");
		var s4 = new StringTree("worked_example_1");
		var s5 = new StringTree("how_to_1");
		var s6 = new StringTree("ch01");
		var s7 = new StringTree("ch02");
		var s8 = new StringTree("Sample_Code");
		s7.addSubTree(s2);
		s7.addSubTree(s3);
		s7.addSubTree(s4);
		s7.addSubTree(s5);
		s6.addSubTree(s1);
		s8.addSubTree(s6);
		s8.addSubTree(s7);
		System.out.println(s8.listContent());
		s8 = s8.treeDelete("ch02");
		System.out.println(s8.listContent());
		s8 = s8.treeDelete("Sample_Code");
		System.out.println(s8.listContent());
	}
}
