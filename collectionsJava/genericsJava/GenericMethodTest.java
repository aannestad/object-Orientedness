
public class GenericMethodTest {

	// A generic method printArray
	
	public static <E> void printArray(E[] inputArray){
		for(E element: inputArray){
			System.out.printf("%s ", element);
		}
		System.out.println();
	}

	public static void main(String[] args) {
    // Create some arrays of different types and pass all to inputArray
		
		System.out.println("Integers:");
		
		Integer[] intarray = {3,2,3};
		printArray(intarray);
		
		System.out.println("Characters:");
		 
		Character[] chararray = {'H','I','J'};
		printArray(chararray);
		
		Double[] doubles = { 3.14, 1.96, (double) (2/3)};
		printArray(doubles);
		
	}
	
}
