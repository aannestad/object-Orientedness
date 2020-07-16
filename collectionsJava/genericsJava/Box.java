
public class Box<T>{
		private T t;
		
		public void add(T t){
			this.t = t;
		}
		
		public T get(){
			return t;  // this.t;
		}
		
		public static void main(String[] args) {
			
			Box<Integer> integerBox = new Box<Integer>();
			integerBox.add(2);
			System.out.println(integerBox.get());
			
			Box<String> stringBox = new Box<String>();
			stringBox.add("DetteErTheShit!");
			System.out.println(stringBox.get());
			
		}
}
	
	

