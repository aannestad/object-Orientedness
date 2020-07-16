import java.util.*;

public class collectiontest {
	public static void main(String[] args) {
		
		List<String> minListe = new ArrayList<String>();
		minListe.add("Mikkel");
		minListe.add("Hans Martin");
		minListe.add("Ole Petter");
		
		Collections.sort(minListe);
		
		Iterator<String> iter = minListe.iterator();
				
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		
		//System.out.println(minListe);
		
		HashMap<String, Double> minHash = new HashMap<String, Double>();
		minHash.put("Mikkel", (double) 107);
		minHash.put("Hans", (double) 78);
		minHash.put("Ole", (double) 76);
		
		double sumVekt;
		sumVekt =  minHash.get("Mikkel").doubleValue() + minHash.get("Hans").doubleValue();
		
		System.out.println("Totalvekt er:" + sumVekt);
		
	}
	
	

}
