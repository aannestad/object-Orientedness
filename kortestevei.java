import java.util.Scanner;

// * Beskrivelse: Programmet leser inn navnet til tre personer og deres x og y koordinater. Avstandene mellom personene
// * skrives ut, og det beregnes hvilken sti som er kortest for å formidle en beskjed fra første person til de to andre.

// @author Hans Martin Aannestad


public class kortestevei{

  public static void main(String[] args) {

    Person[] personer = new Person[3];
    String[] navnListe = new String[3];
    Scanner tastatur = new Scanner(System.in);
    double p1p2p3;
    double p1p3p2;

// Foer initialisering
    System.out.println(personer[0]);

// Oppretter forste person (ved bruk av klasse)
    Person p1 = new Person();                                                           
    
    System.out.println("Skriv inn navn:");                                                              // Bruker input
    p1.settNavn(tastatur.nextLine());
    System.out.println("Skriv inn X-posisjon:");
    p1.settxPosisjon(tastatur.nextDouble());
    System.out.println("Skriv inn Y-posisjon:");
    p1.settyPosisjon(tastatur.nextDouble());
    tastatur.nextLine();

    personer[0] = p1;
    navnListe[0] = p1.navn;

// Oppretter andre person (ved bruk av klasse)
    
    Person p2 = new Person();

    System.out.println("Skriv inn navn:");
    
    p2.settNavn(tastatur.nextLine());                                                                   // Bruker input
    System.out.println("Skriv inn X-posisjon:");
    p2.settxPosisjon(tastatur.nextDouble());
    System.out.println("Skriv inn Y-posisjon:");
    p2.settyPosisjon(tastatur.nextDouble());
    tastatur.nextLine();
    
    personer[1] = p2;
    navnListe[1] = p2.navn;
    
// Oppretter tredje person (ved bruk av klasse)
    
    Person p3 = new Person();
    
    System.out.println("Skriv inn navn:");                                                              // Bruker input
    p3.settNavn(tastatur.nextLine());
    System.out.println("Skriv inn X-posisjon:");
    p3.settxPosisjon(tastatur.nextDouble());
    System.out.println("Skriv inn Y-posisjon:");
    p3.settyPosisjon(tastatur.nextDouble());
    tastatur.nextLine();
    
    personer[2] = p3;
    navnListe[2] = p3.navn;
                               
    for(Person p : personer) {                                         // Skriver ut informasjon om navn og koordinater
      System.out.println(p);
    }
    
    double avstander[][] = {                                                                   // Matrise med avstander
                           {0,p1.avstand(p2.xPosisjon,p2.yPosisjon),p1.avstand(p3.xPosisjon,p3.yPosisjon)},
                           {p2.avstand(p1.xPosisjon,p1.yPosisjon),0,p2.avstand(p3.xPosisjon,p3.yPosisjon)},
                           {p3.avstand(p1.xPosisjon,p1.yPosisjon),p3.avstand(p2.xPosisjon,p2.yPosisjon),0}
                           };
    
    System.out.println("Avstander:\n");
    System.out.println("    " + p1.navn + " " + p2.navn + " " + " " + p3.navn);                           // Overskrift
    int i, j; 
    for(i=0; i<3; i++) {                                                                    // Skriv ut avstandsmatrise
      System.out.print(navnListe[i] + " "); 
      for(j=0; j<3; j++) { 
        System.out.printf(String.format( "%.2f", avstander[i][j])+ "m "); 
      }
      System.out.println();  
    } 
     
    p1p2p3 = p1.avstand(p2.xPosisjon,p2.yPosisjon) + p2.avstand(p3.xPosisjon,p3.yPosisjon);    // Kalkuler sti-lengde 1 
    System.out.printf("Avstand fra " + p1.navn + " til " + p3.navn + " via " + p2.navn + ": ");                                                              
    System.out.printf(String.format( "%.2f", p1p2p3) + "m \n");                                                            
                                                                
    p1p3p2 = p1.avstand(p3.xPosisjon,p3.yPosisjon) + p3.avstand(p2.xPosisjon,p2.yPosisjon);    // Kalkuler sti-lengde 2
    System.out.printf("Avstand fra " + p1.navn + " til " + p2.navn + " via " + p3.navn + ": ");                                                              
    System.out.printf(String.format( "%.2f", p1p3p2) + "m \n");   
       
    System.out.println(p1.navn + " har en viktig beskjed til " + p2.navn + " og " + p3.navn + ".");
    
    if (p1p2p3 <= p1p3p2)                                                           // Avgjør hvilke sti som er raskest
       System.out.println("Det er raskest dersom " + p1.navn + " forteller beskjeden til " + p2.navn +
                          ", som saa forteller den til " + p3.navn);            
     else
      System.out.println("Det er raskest dersom " + p1.navn + " forteller beskjeden til " + p3.navn +
                          ", som saa forteller den til " + p2.navn);                   
    
  }
}
