import java.util.Scanner;

// * Beskrivelse: Programmet skriver ut et rektangel med dimensjoner angitt av bruker

// @author Hans Martin Aannestad

class tegnRektangel{

  public static void main(String[] args) {

    Scanner tastatur = new Scanner(System.in);

    int dimx=0;
    int dimy=0;
    
    boolean positivDimx = false;
    boolean positivDimy = false;

    while (!positivDimx) {
      System.out.print("Bredde: ");                                                       
      dimx = tastatur.nextInt();                                                          // Les inn bredde (x-retning)                                 
      tastatur.nextLine();

      if (dimx > 0)                                                                           // Forsikre positiv verdi
        positivDimx = true;      
      else
        System.out.println("Ugyldig bredde.");
    }
    
    while (!positivDimy) {                                                       
      System.out.print("Høyde: ");
      dimy = tastatur.nextInt();                                                           // Les inn høyde (y-retning)                                  
      tastatur.nextLine();

      if (dimy > 0)                                                                           // Forsikre positiv verdi
        positivDimy = true;
      else
        System.out.println("Ugyldig hoyde");
    }    
         
    for(int linjeNr=0; linjeNr<dimy; linjeNr++) { // Loekke for høyde
     
     if ((linjeNr == 0) || (linjeNr == dimy-1))                                             // Fromater topp eller bunn
       for(int i=0;i<dimx;i++) {    // Loekke for x-retning
         if ((i == 0) || (i == dimx-1))
           System.out.printf("*");
         else
           System.out.printf("-");
      }
     
     else                                                                                        // Formater sidevegger
       for(int i=0;i<dimx;i++) {    // 
          if ((i == 0) || (i == dimx-1))
             System.out.printf("|");
           else
             System.out.printf(" ");
      }

      System.out.printf("\n");

    } // end linjeNr

  } // end main
}
