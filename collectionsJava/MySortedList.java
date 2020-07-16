package inf101.collections;

class MySortedList<E extends Comparable<E>> extends MyCollection<E> implements ISortedList<E>{

	//@Override
	public void checkState(MySortedList msl){
		if(!SortedListHelper.isSorted(msl)){
		   throw new IllegalStateException("List is not sorted!");
		}
		else{
		   System.out.println("Check state ok!");
		   }
	}
	
	@Override
	public E getElementByIndex(Integer idx){
       if(idx<0){                                   // Check that input is valid
    	 throw new IllegalArgumentException("Index must be positive: " + idx);
       }
		return list.get(idx);
	}

	@Override
	public void add(E elt) {
	  if(list.size()<1){                 // Add first element
		 list.add(elt);
	  }
	  else{
	   for(E e:list){  
		if(elt.compareTo(e)<=0){         // Add element in sorted order
		  list.add(list.indexOf(e), elt);
		  checkState(this);
		  return;
		}
	   }
	   list.add(list.size(),elt);        // Add last element
	  }
	  checkState(this);
	}

	@Override
	public void removeFirst() {
		list.remove(0);
		
		checkState(this);
	}

	@Override
	public void removeLast() {
		list.remove(list.size()-1);
		
		checkState(this);
	}

}
