import java.util.Scanner;

// * Beskrivelse: Programmet gir ut verdien til et polynom med parametre angitt av bruker, ved utskrift på
//                tabellform med x-verdier og y-verdier, hvor startpunkt, intervall og antall er angitt av bruker.

// @author Hans Martin Aannestad

class polynomEvaluator{

  public static void main(String[] args) {

    Scanner tastatur = new Scanner(System.in);

    System.out.print("f(x) = a*x*x + b*x + c\n");                                             // Vis polynom til bruker
   
    double a=0;
    double b=0;
    double c=0;
    double x = 0;
    double y = 0;
    double firstx = 0;
    double incx = 0;
    int numinc = 0;
                                  // Les inn parametre
    System.out.print("a:");
    a = tastatur.nextDouble();                                    
    tastatur.nextLine();
    System.out.print("b:");
    b = tastatur.nextDouble();                                    
    tastatur.nextLine();
    System.out.print("c:");
    c = tastatur.nextDouble();                                    
    tastatur.nextLine();
    System.out.print("Forste verdi av x:");
    firstx = tastatur.nextDouble();  
    tastatur.nextLine();
    System.out.print("Tillegg til x");
    incx = tastatur.nextDouble(); 
    tastatur.nextLine();
    System.out.print("Antall verdier som skal skrives ut");
    numinc = tastatur.nextInt(); 
    tastatur.nextLine();
    
    System.out.printf("x f(x)");
    System.out.printf("\n");
    
    x = firstx;                                                                       // Første x-verdi angitt av bruker
    
    for(int i=0;i<numinc;i++) {    // Loekke for polynom-kalkulasjoner
   
      y = a*x*x + b*x + c;                                                                   // Kalkuler funksjonsverdi

      System.out.printf("%.4f %.4f",x,y);
      System.out.printf("\n");
      x = x + incx;  
      }

  } // end main
}
