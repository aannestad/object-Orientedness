package inf101.collections;

import java.util.Iterator;

public interface ISortedList<E extends Comparable<E>> extends ICollection<E> {
	
	/**
	 * Get element from index
	 * 
	 * 
	 * @param elt
	 *            The element
	 */
	E getElementByIndex(Integer idx);  // 
	
	/**
	 * Remove first element from the collection
	 * 
	 * 
	 * @param elt
	 *            The element
	 */
	void removeFirst();

    /**
     * Remove last element from the collection
     * 
     * 
     * @param elt
     *            The element
     */
	void removeLast();

}