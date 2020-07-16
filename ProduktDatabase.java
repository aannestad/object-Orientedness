import java.util.Scanner;

import java.util.Arrays;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;

// @author Hans Martin Aannestad

/**
 * Produktdatabase.
 * 
 * Inneholder database av produkter.
 */
public class ProduktDatabase {
  
  int maksProdukter;
  Produkt[] produkter;
  int indeksNyttProdukt;
  
  /**
   * Konstruktoer.
   * 
   * @param maks Maksimalt antall produkter.
   */
  ProduktDatabase(int maks){
    maksProdukter = maks;
    produkter = new Produkt[maksProdukter];
    indeksNyttProdukt = 0;
  }
  
  /**
   * Finner indeks til et produkt ut fra identifikasjonskode.
   * 
   * @param idk Identifikasjonskode.
   * @return Indeks til produkt med identifikasjonskoden, eller -1 om ikke funnet.
   */
  int finnProduktIndeksFraIdentifikasjonsKode(String idk){
   int funnetLik = 0;
   for(int i=0;i<indeksNyttProdukt;i++) {
      if (produkter[i].hentIdentifikasjonsKode().equals(idk)) {
         funnetLik = 1;
      return i;    
      }
      }
   if (funnetLik == 1); {
   return -1;
   } 
  }
  
  /**
   * Legger inn et nytt produkt i databasen.
   * 
   * @param nytt Nytt produkt
   * @return false ved feil, og ellers true
   */
  boolean nyttProdukt(Produkt nytt){
    int indeks = finnProduktIndeksFraIdentifikasjonsKode(nytt.hentIdentifikasjonsKode());
    if(indeks!=-1){
       System.out.println("Kan ikke registrere flere produkter med samme identifikasjonskode");
       return false;
       }
    else {
       if (indeksNyttProdukt < maksProdukter) {
       produkter[indeksNyttProdukt] = nytt;
       indeksNyttProdukt = indeksNyttProdukt + 1;
       return true;
       }
       else {
       System.out.println("Kan ikke registrere flere produkter");
       return false;
          }
       }

  }
  
  /**
   * Sletter et produkt fra databasen.
   * 
   * @param indeks Indeks for produkt som skal slettes
   * @return false ved feil, og ellers true
   */
  boolean slettProdukt(String idk){
  int funnetLik = 0;
  for(int i = 0; i<indeksNyttProdukt;i++) {
     if (produkter[i].hentIdentifikasjonsKode().equals(idk)) {                         // Finn produkt til sletting
         indeksNyttProdukt = indeksNyttProdukt - 1;                                    // Sett antall produkter én tilbake
         produkter[i] = produkter[indeksNyttProdukt];                                  // Erstatt produktet som skal fjernes med siste

         funnetLik = 1;
         return true;
     }     
  }
 if (funnetLik == 1); {
  System.out.println("Fant ikke produkt som skulle slettes");
     return false;
 } 
  }
  
  /**
   * Leser produktdatabase fra fil.
   * 
   * @param filnavn Navn paa filen databasen skal leses fra.
   */
  boolean lesFraFil(String filnavn) {
 try{
 FileReader tekstFilleser = new FileReader(filnavn);                         //  Aapne fil for lesing
 BufferedReader tekstLeser = new BufferedReader(tekstFilleser); 
    
 boolean ferdig = false;
      while (!ferdig) {
       String linje = tekstLeser.readLine();   // Les linje for linje
       
       if (linje != null) { // Får null når filen er slutt  
        String[] felt = linje.split("Â§"); // Deler opp strengen etter skilletegn (Del opp linje etter skilletegn i 3 deler)
        try {
         if (felt.length != 3) { 
          throw new ArithmeticException("Antall felt er ikke 3");
         } 
        } catch (ArithmeticException unntak){
         System.out.println("Unntak ved lesing av fil: " + unntak);
            return false;
        }      
        
        String prodNavn = felt[1];
        String prodID = felt[0];
        double prodPris = Double.parseDouble(felt[2]);
        Produkt prod = new Produkt(prodNavn,prodID,prodPris);
             
        this.nyttProdukt(prod);                          // Registrerer produkter
        
         //produkter[indeksNyttProdukt] = prod;          // Registrer produkter
         //indeksNyttProdukt = indeksNyttProdukt + 1;  
                
       }
          else {
           ferdig = true;
          }
          
     }
    tekstLeser.close();         
 }
 catch(IOException unntak){
  System.out.println("Unntak ved lesing av fil: " + unntak);
  return false;
 }
 return true;
  }
  
  /**
   * Lagrer produktdatabase til fil.
   * 
   * @param filnavn Navn paa filen databasen skal lagres til.
   */
  boolean lagreTilFil(String filnavn){
    try{
      FileWriter filSkriver = new FileWriter(filnavn);
      PrintWriter utskriver = new PrintWriter(filSkriver);
      for(int l=0;l<indeksNyttProdukt;l++){
        Produkt prod = produkter[l];
        utskriver.println(prod.hentIdentifikasjonsKode()+"Â§"+prod.hentNavn()+"Â§"+prod.hentPris());
      }
      utskriver.close();
      filSkriver.close();
    }
    catch(IOException unntak){
      System.out.println("Unntak ved lesing av database: "+unntak);
      return false;
    }
    return true;
  }
  
  /**
   * Skriver ut produkt.
   * 
   * @return Streng som skal skrives ut.
   */
  public String toString(){
    String s = "Produkter:";
    for(int l=0;l<indeksNyttProdukt;l++){
      s += "\n   " + produkter[l].toString();
    }
    return s;
  }
  
}


