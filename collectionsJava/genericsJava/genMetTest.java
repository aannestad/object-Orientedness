
public class genMetTest {
	
	  // Implementer en generisk klasse Box, som kan legge til (add) og hente (get) av en generisk type T
	  public class Box<T>{
		private T t;
		  
		public void add(T t){
			  this.t = t;
		  }
		
		public T get(){
			return t;
		}	  
	  
	  
	  public static void main(String args[]){
		  Box<String> stringBox = new Box<String>();
		  
	}
	 	  
	  
	// Generate a function that takes the largest of some variables
	
      public static <T extends Comparable<T>> T maximum(T a, T b, T c){
    	  T maxV = a;
    	  if(b.compareTo(maxV)>0){
    		   maxV = b;
    	  }
    	  if(c.compareTo(maxV)>0){
    		  maxV = c;
    	  }
    	  
    	  return maxV;
    	  
      }

}
