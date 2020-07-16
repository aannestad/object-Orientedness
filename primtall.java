import java.util.Scanner;

// * Beskrivelse: Programmet gir alle primtall opp til en maksgrense angitt av bruker.

// @author Hans Martin Aannestad



class primtall{

  public static void main(String[] args) {
 
    Scanner tastatur = new Scanner(System.in);

    System.out.print("Dette programmet regner ut alle primtall opp til en grense\n");
    System.out.print("Gi maksverdi");
    
    int b = 0;
    int maksverdi = 0;
    boolean partall = false;
    maksverdi = tastatur.nextInt();                                    
 
    for(int i=1;i<=maksverdi;i++) {   // Lokke for å behadle alle heltall opp til maksgrense gitt av bruker
      b = 2;                                                           // Begynn med divisor b>1 (for å finne primtall)
      while ((!partall) && (b<i)) {     // Lokke for å sjekke alle mulige divisorer b for a
        if ((i%b)==0)                                                     // Ingen rest av divisjon betyr IKKE primtall
          partall = true;
        b = b + 1;
      }   
      
      if (partall==false)                                                    // Hvis ingen divisjon uten rest: primtall
        System.out.print(i);
        System.out.printf("\n");
        
      partall = false;                                                        // Nullstill for å behandle neste heltall
    }

  } // end main
}
