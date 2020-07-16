
public class Box2<T> extends Box<T> {
    T t;  
    
	void add2(T t){
		this.t = t;
		super.add(t);
		System.out.println("Box 2 menthod called");
	}

	@Override
	void add(T t) {
		
		super.add(t);
	}

	@Override
	T get() {
		
		return super.get();
	}
	
}
