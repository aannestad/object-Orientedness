import java.util.ArrayList;

public class app1 {
	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		numbers.add(10);
		numbers.add(100);
		numbers.add(50);
		
		// Retrieve
		
		System.out.println(numbers.get(0));
		
		// loop
		for(int i=0; i < numbers.size(); i++){
			System.out.println(numbers.get(i));
		}
		System.out.println("\nIterable list");

		numbers.remove(numbers.size()-1);
		
		for(Integer value: numbers){
			System.out.println(value);
		}				
		
		numbers.remove(0);
	}
	
}
