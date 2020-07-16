public class mainApp{
	
	public static void main(String[] args){
		
	   Box2<String> stringBox = new Box2<String>();
	   stringBox.add2("HM");
	   stringBox.doSomething();
	   System.out.println(stringBox.get());
	}
	
}