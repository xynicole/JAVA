package assignment09;

import java.util.List;

public interface Sorter {
	public <E extends Comparable<? super E>> double timedSort(List<E> list);
}

