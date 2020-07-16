package inf101.collections;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCollections {

	/**
	 * Simple test to assert that the isSorted method in SortedListHelper is TRUE for sorted list
	 */
	
	@Test
	public void testSorted(){
        ICollection<String> animals = new MyCollection<String>();
	
        animals.add("Antelope");
		animals.add("Cat");
		animals.add("Dog");	
		animals.add("Horse");
		
	    assertTrue(SortedListHelper.isSorted(animals));
	}
	
	@Test
	public void testSorted2(){
        ISortedList<String> animals3 = new MySortedList<String>();
	
        animals3.add("Antelope");
		animals3.add("Cat");
		animals3.add("Dog");	
		animals3.add("Horse");
		
	    assertTrue(SortedListHelper.isSorted(animals3));
	}
	
	
	
	
	
	/**
	 * Simple test to assert that the isSorted method in SortedListHelper is FALSE for unsorted list
	 */
	
	@Test
	public void testNotSorted(){
        ICollection<String> animals = new MyCollection<String>();
	 
		animals.add("Cat");
		animals.add("Antelope");
		animals.add("Dog");	
		animals.add("Horse");
		
	    assertFalse(SortedListHelper.isSorted(animals));
	}
			
	/**
	 * A simple test of MySortedList that asserts that new elements are added correctly (sorted), 
	 * and that the methods removeFirst and removeLast are correct
	 */
	
	@Test
	public void testMySortedListSortAndRemoveFirstLast() {
		
		ISortedList<String> animals1 = new MySortedList<String>();
		
		animals1.add("Dog");
		animals1.add("Cat");
		
		ISortedList<String> animals2 = animals1; 
		
		animals1.add("Horse");    // This element is expected to be put on bottom if adding is correct (sorted)
		animals1.add("Antelope"); // This element is expected to be put on top if the adding is correct (sorted)

		animals1.removeFirst();   // This is expected remove element "Antelope"
		animals1.removeLast();    // This is expected to remove "Horse"
		
		assertTrue(animals1.equals(animals2));    // If all works the two lists should be equal
	}			
}

