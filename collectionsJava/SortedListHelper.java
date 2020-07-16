package inf101.collections;

public class SortedListHelper {

	/**
	 * Check if the elements in a collection appears in sorted order
	 * 
	 * @param coll A collection
	 * @return True if the elements are in sorted order
	 */
	
	public static <E extends Comparable<E>> boolean isSorted(ICollection<E> coll)  {
		E last = null;
		for(E e: coll){
		   if(last != null){
              if(last.compareTo(e) > 0){
            	  return false;
              }    
		   }  
		   last = e;
	    }
	    return true;	
	}
}