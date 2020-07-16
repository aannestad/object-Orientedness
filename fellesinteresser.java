import java.util.Scanner;
    
// * Beskrivelse: Programmet leser inn navnet til (opptil) tre personer og deres (opptil) 4 tilhorende interesser.
// * Det kan avsluttes underveis ved aa taste inn '@'. Til slutt skrives det ut felles interesser.

// @author Hans Martin Aannestad

 class fellesinteresser{
         
  public static void main(String[] args) {
               
    Scanner tastatur = new Scanner(System.in);
    Person[] personPeker = new Person[3];
    int i = 0;
    int j = 0;
    
    String navn = " ";
    String nyinteresse = " ";
    
    while(i <= 2 && navn.charAt(0) != '@') {                                            // Person loop (max 3) personer
        
      // Oppretter en student
      System.out.println("Oppgi navn paa person (opptil 3 personer), eller @ for avslutt:");                                                              
      
      navn = tastatur.nextLine();                                                        // Skriv inn navn fra tastatur
      
      if (navn.charAt(0) != '@') {   
        System.out.println("Oppgi interesse for " + navn + "(opptil 4 interesser), eller @ for avbryt:");                                                              
        String[] interesse = {tastatur.nextLine()};                                       // Skriv inn forste interesse 
        personPeker[i] = new Person(navn,interesse);                     // Opprett person med navn og forste interesse
    
      while(j <= 2 && nyinteresse.charAt(0) != '@') {                           // Loop for innleggelse av ny interesse 
         
        System.out.println("Oppgi interesse for " + navn + "(opptil 4 interesser), eller @ for avbryt:");                                                          
       
        nyinteresse = tastatur.nextLine();  
        
        if (nyinteresse.charAt(0) != '@') {
          personPeker[i].leggTilInteresser(nyinteresse);                                    // Legg inn en ny interesse
        }
        j = j + 1;
      }
     }
     j = 0;        
     navn = " ";                                                           // Nullstill stopp-variabler for neste runde
     nyinteresse = " ";
     i = i + 1;
    } 
                                                                                               // Skriv ut innlest data
    System.out.println(personPeker[0]);
    System.out.println(personPeker[1]);
    System.out.println(personPeker[2]);
                                                                                    // Hent antall interesser til lokke
    int antinteresser0 = personPeker[0].hentAntInteresser();
    int antinteresser1 = personPeker[1].hentAntInteresser();
    int antinteresser2 = personPeker[2].hentAntInteresser();
    
    String[] fellesInt = new String[4];
    
    int antfelles = 0;
    
    for(i=0; i<antinteresser0; i++){                                                                   // Forste person:
      for(j=0; j<antinteresser1; j++){                                                // Forste person mot andre person
        
        if (finnlik(personPeker[0].interesseTabell[i],personPeker[1].interesseTabell[j])==1){   // Finn like interesser
          fellesInt[antfelles] = personPeker[0].interesseTabell[i];
          antfelles = antfelles + 1;       
        }
      }
    }
    
    if (antfelles > 0) {
       printfelles(fellesInt,antfelles,personPeker[0].hentNavn(),personPeker[1].hentNavn());       // Skriv ut felles int.
    }

    antfelles = 0;
    
    for(i=0; i<antinteresser0; i++){       
      for(j=0; j<antinteresser2; j++){                                               // Forste person mot tredje person       
        if(finnlik(personPeker[0].interesseTabell[i],personPeker[2].interesseTabell[j])==1){    // Finn like interesser
          fellesInt[antfelles] = personPeker[0].interesseTabell[i];
          antfelles = antfelles + 1; 
        }
      }  
    }
    
    if (antfelles > 0) {
       printfelles(fellesInt,antfelles,personPeker[0].hentNavn(),personPeker[2].hentNavn());     // Skriv ut felles int
    }
    
    antfelles = 0;
    
    for(i=0; i<antinteresser1; i++){                                                                // Andre person mot:
      for(j=0; j<antinteresser2; j++){                                                // Andre person mot tredje person
        if(finnlik(personPeker[1].interesseTabell[i],personPeker[2].interesseTabell[j]) == 1) { 
          fellesInt[antfelles] = personPeker[1].interesseTabell[i];
          antfelles = antfelles + 1; 
        }
      }
    }
    if (antfelles > 0) {
       printfelles(fellesInt,antfelles,personPeker[1].hentNavn(),personPeker[2].hentNavn());      // Skriv ut felles int
    }      
  }
  
  static int finnlik(String strengEn, String strengTo) {                       // Metode for sammenligning av interesser  
    int r = 0;
    int strmatch = 1;
    if (strengEn.length() == strengTo.length()) {
      while (r<strengEn.length() && strmatch == 1) {                                     // Lokke sammenligning av tegn
         if (strengEn.charAt(r) != strengTo.charAt(r)){                                              // Hvis ulike tegn
           strmatch = 0; }                                                                     
         r = r + 1;
      }
    }
    else {
         strmatch = 0;}  
    return strmatch;
    }
  
  static void printfelles(String[] innListe,int nfelles, String navn1, String navn2) {        // Metode for a skrive ut
    System.out.println("Personer " + navn1 + " og " + navn2 + "\n");
    System.out.print("- til felles: ");                                          
    int k;
    for(k=0; k<nfelles; k++) {                                                  
      System.out.print(innListe[k] + ", "); 
    }
    if (nfelles == 1) {
      System.out.print("(1 fellesinteresse)\n");
    }
    else
      System.out.print("(" +nfelles + " fellesinteresser)\n");
    System.out.println();
   }
}
