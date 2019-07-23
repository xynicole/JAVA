package assignment09;
import java.util.ArrayList;
import java.util.List;

public class NaiveQuickSort implements Sorter {

	/**
	 * Return a list of all the elements that are less than list.get(0)
	 * according to the compareTo of E, i.e. all elements e in list such
	 * that e.compareTo(get(0)) < 0.
	 * @param list the input list from which the elements that are less than are taken
	 * @return a list of all the elements that are less than list.get(0)
	 * according to the compareTo of E 
	 */
	 static <E extends Comparable<? super E>> List<E> less(List<E> list) {
		List<E> retVal = new ArrayList<E>();
		for (int i =1 ; i<list.size(); i++) {
			if(list.get(i).compareTo(list.get(0)) < 0) {
				retVal.add(list.get(i));
			}
		}
		return retVal;
	}

	/**
	 * Return a list of all the elements that are greater than or equal to list.get(0)
	 * according to the compareTo of E, i.e. all elements e in list such
	 * that e.compareTo(get(0)) >= 0. DO NOT INCLUDE list.get(0) in the return list.
	 * @param list the input list from which the elements that are not less than are taken
	 * @return a list of all the elements that are greater than or equal to list.get(0)
	 * according to the compareTo of E 
	 */
	 static <E extends Comparable<? super E>> List<E> gteq(List<E> list) {
		List<E> retVal = new ArrayList<E>();
		// todo your code here--do not include list.get(0)
		// you must include any other list.get(i) if they happen to equal list.get(0)
		for (int i =1 ; i<list.size(); i++) {
			if(list.get(i).compareTo(list.get(0)) >= 0) {
				retVal.add(list.get(i));
			}
		}
		return retVal;
	}

	/**
	 * Returns true or false according as the list is already sorted according to the
	 * compareTo of E.
	 * @param list a list to be checked for sorted order
	 * @return true if the list is already sorted, otherwise false
	 */
	 static <E extends Comparable<? super E>> boolean inOrder(List<E> list) {
		// compare element by element and return false as soon as one
		// element is out of order. Return true at the end.
		boolean retVal = true;
		for (int i =0 ; i<list.size(); i++) {
			for(int j=i+1;j<list.size();j++) {
				if(list.get(j).compareTo(list.get(i)) < 0) {
					return false;
				}
			}	
		}
		return retVal;
	}

	/**
	 * Return a sorted copy of the input list, using the compareTo of E
	 * to determine the order of the elements
	 * @param list the input list
	 * @return the same list elements in sorted order
	 */
	public static <E extends Comparable<? super E>> List<E> sort(List<E> list) {
		// How to: create a new ArrayList retVal of E. Set retVal equal to list
		// if list is null, empty or already in order.
		// Otherwise set retVal equal to sort(less(list)), then add list.get(0)
		// to retVal and finally use addAll to add all of sort(gtreq(list))
		// return retVal
		
		List<E> retVal = new ArrayList<E>();
		if(list ==null || list.size() ==0|| inOrder(list) ) {
			retVal = list;
		
		}else {
			retVal = sort(less(list));
			retVal.add(list.get(0));
			retVal.addAll(sort(gteq(list)));
		}
		return retVal;
	}

	@Override
	public <E extends Comparable<? super E>> double timedSort(List<E> list) {
		long start = System.currentTimeMillis();
		list = sort(list);
		long end = System.currentTimeMillis();
		return end - start;
	}
}
