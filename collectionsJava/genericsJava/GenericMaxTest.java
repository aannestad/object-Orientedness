
public class GenericMaxTest {

	public static <T extends Comparable <T>> T maximum(T x, T z, T y){
		
		T max = x;
	
		if(z.compareTo(max)>0){
		    max = z;
		}
		
		if(y.compareTo(max)>0){
			max = y;
		}
	    return max;
	}
	
	public static void main(String[] args) {
		System.out.println(maximum('1','2','3'));
	    System.out.println(maximum("A","B","C"));
	    System.out.println(maximum(3.14, 1.96, 2.31));
	}
}
