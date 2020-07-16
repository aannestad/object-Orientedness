import java.util.Scanner;

// * Beskrivelse: Programmet soker i en lang streng etter forekomster av en kort streng (begge gitt av bruker).
// * Posisjon og tekst fra posisjon skrives ut, sammen med antall forekomster funnet.

// @author Hans Martin Aannestad

public class strengSok{

  public static void main(String[] args) {

    Scanner tastatur = new Scanner(System.in);

    System.out.println("Skriv inn tekst");                                                     // Input 1 (lang streng)          
    String longString = tastatur.nextLine();
  
    System.out.println("Skriv inn ord som skal sokes etter");                                  // Input 2 (kort streng)
    String shortString = tastatur.nextLine();  
    
    int nlongString = longString.length();
    int nshortString = shortString.length();
    int strmatch = 1;
    int antmatch = 0;
      
    for(int i=0; i < (nlongString-nshortString+1); i++) {     // Lokke for lang streng
      int j = 0;
      while ((j<nshortString) && strmatch == 1) {                       // Lokke for kort streng 
        if (longString.charAt(i+j) != shortString.charAt(j))                                         // Hvis ulike tegn
           strmatch = 0;                                                                           
           j = j + 1;
      }
      
      if (strmatch == 1) {
        int r = 0;
        System.out.printf("\n%d: ",i+1);                                      // Skriv ut startposisjon for kort streng
        for (r = i; r<nlongString; r++) {     // Lokke for aa skrive ut streng
           System.out.printf("%c",longString.charAt(r));                            
        }        
        antmatch = antmatch + 1;                                                              // Tell opp antall funnet
      }
      
      strmatch = 1;
    }
      System.out.printf("\n Fant %d forekomster\n",antmatch);                         // Gi ut antall totale forekomster
  }
}

