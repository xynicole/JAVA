package assignment09;

import java.util.List;

public class InsertionSorter implements Sorter {

    /**
     * Method that sorts the parameter array into increasing order
     * using the insertion sort algorithm and returns the time
     * taken in milliseconds.
     * This is a favored algorithm for short arrays since
     * it has linear complexity for arrays that are already sorted.
     * @param array array to be sorted
     * @return the time taken to sort the array
     */
	@Override
    public <E extends Comparable<? super E>> double timedSort(List<E> list) {
        long start = System.currentTimeMillis();
        if(list != null && list.size() > 0)
        for (int i = 1; i < list.size(); i++) {
            E next = list.get(i); // may be null
            // Move all larger elements to the right
            int j = i;
            while (j > 0 && (next == null || list.get(j - 1) != null && list.get(j - 1).compareTo(next) > 0)) {
                list.set(j,  list.get(j - 1));
                j--;
            }
            // Insert the element in its correct position
            list.set(j,  next);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

}