import java.util.Scanner;
import java.util.Arrays;

// @author Hans Martin Aannestad

//**
// * Butikk.
// * 
// * Programmets hovedklasse. Haandterer en butikk sine varer.
// */

public class Butikk {
  
  public static void main ( String [] args ){
    Scanner tastatur = new Scanner(System.in);

    final int maksProdukter = 10;
    ProduktDatabase produkter = new ProduktDatabase(maksProdukter);
    
    System.out.println("Velkommen til butikken!");

    boolean ferdig = false;
    
    while(!ferdig){
      System.out.println("Meny:");
      System.out.println("1: Skriv ut produkter");
      System.out.println("2: Nytt produkt");
      System.out.println("3: Slette produkt");
      System.out.println("4: Les produkter fra fil");
      System.out.println("5: Lagre produkter til fil");
      System.out.println("6: Avslutt");
      
      int menyvalg = tastatur.nextInt();
      tastatur.nextLine();
      
      switch(menyvalg){
        case 1: // Skriv ut produkter
          System.out.println(produkter);
          break;
        case 2: // Nytt produkt
        {
          // Les inn produktinformasjon
          System.out.println("Oppgi nytt produktnavn (minst ett tegn):");
          String prodNavn = tastatur.nextLine();
          if(prodNavn.length()<1){
            System.out.println("For kort produktnavn");
            continue;
          }
          System.out.println("Oppgi identifikasjonskode (unik, 4 tegn):");
          String prodID = tastatur.nextLine();
          if(prodID.length()!=4){
            System.out.println("Identifikasjonskoden maa bestaa av 4 tegn");
            continue;
          }
          System.out.println("Oppgi pris (flyttall, minst 1.0):");
          double prodPris = tastatur.nextDouble();
          if(prodPris<1.0){
            System.out.println("Pris kan ikke vaere lavere enn 1.0");
            continue;
          }
          tastatur.nextLine();
          // Legg til produktet
          Produkt prod = new Produkt(prodNavn,prodID,prodPris);
          produkter.nyttProdukt(prod);
          break;
        }
        case 3: // Slette produkt
        {
          // Hent identifikasjonskode for produktet som skal fjernes
          System.out.println("Oppgi identifikasjonskode (4 tegn) til produktet som skal fjernes:");
          String prodID = tastatur.nextLine();
          if(prodID.length()!=4){
            System.out.println("Identifikasjonskoden maa bestaa av 4 tegn");
            continue;
          }
          produkter.slettProdukt(prodID);
          break;
        }
        case 4: // Les produkter fra fil
        {
          System.out.println("Oppgi filnavn produktdatabasen skal leses fra");
          String filnavn = tastatur.nextLine();
          produkter.lesFraFil(filnavn);
          break;
        }
        case 5: // Lagre produkter til fil
        {
          System.out.println("Oppgi filnavn produktdatabasen skal lagres til");
          String filnavn = tastatur.nextLine();
          produkter.lagreTilFil(filnavn);
          break;
        }
        case 6: // Avslutt
          ferdig = true;
          break;
        default:
          System.out.println("Ugyldig valg");
      }
    }
    
  }
  
}

