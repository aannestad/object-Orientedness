import javax.swing.JOptionPane;
import java.util.Scanner;

// @author Hans Martin Aannestad

public class Valutakalkulator {

 public static void main(String[] args) { 

   

    System.out.println();
  
     // Opprett tre valutaer med informasjonen gitt i oppgaven
       
 Valuta[] valutaPeker = new Valuta[3];
  
 valutaPeker[0] = new Valuta("NOK",(double) 1.00); 
 valutaPeker[1] = new Valuta("EUR",(double) 9.34); 
 valutaPeker[2] = new Valuta("USD",(double) 8.46); 
  
 int i = 0;
     
  Scanner tastatur = new Scanner(System.in);  
  
  String ferdig = " "; 
     
  while(ferdig.charAt(0) != '@') {                                            // Valuta loop (max 3) Valutaer
   
     String inputString = JOptionPane.showInputDialog(         // (1)
        "Velkommen til valutakalkulatoren!\n" + 
        valutaPeker[0] + "\n" + valutaPeker[1] + "\n" + valutaPeker[2] + "\n" +
        "Oppgi antall av valuta (flyttall) og valutanavn (for eksempel 10 NOK), eller @ for aa avslutte::\n" 
             ); 
                                                                     
   if (inputString.charAt(0) != '@') { 
    String[] felt = inputString.split(" "); // Deler opp strengen etter skilletegn (Del opp linje etter skilletegn i 3 deler)
   try {
    if (felt.length != 2) { 
     throw new ArithmeticException("Antall felt er ikke 2");
    } 
   } catch (ArithmeticException unntak){
    
    JOptionPane.showMessageDialog(              
               null,                                   
               "Feil: Valuta ikke stoettet: " + " " + unntak,  
               "Feil!",                               
               JOptionPane.WARNING_MESSAGE            
           );     
          
       return;
   }      
   
   String navnFra = felt[1];
   double antallFra = Double.parseDouble(felt[0]); 
          
       // Split input i navn og mengde       
    
      String navnTil = JOptionPane.showInputDialog(       
           "Oppgi valuta som skal konverteres til, eller skriv alle for aa konvertere til alle stoettede valutaer:" 
                ); 
      
   double kursTil = 0;
   double kursFra = 0;
      
    for(i=0; i<3; i++) {       
      if (valutaPeker[i].hentNavn().equals(navnFra)) {
       kursFra = valutaPeker[i].hentKurs();
      }
      if (valutaPeker[i].hentNavn().equals(navnTil)) {
       kursTil = valutaPeker[i].hentKurs();
      } 
    }
    
    if (kursFra != 0) {
     if (kursTil != 0) {
      double antallTil = (kursFra / kursTil) * antallFra;  
      
      JOptionPane.showMessageDialog(                    
                null,
                "Konvertert valuta:\n" + navnFra + " " + antallFra + " = " + antallTil + " " + navnTil,
                "Resultat",
                JOptionPane.PLAIN_MESSAGE
            );    
     } 
     if (navnTil.equals("alle")) {
        System.out.println("Konvertert valuta:");
        String printResultString = " ";
        
     for (i = 0; i<3; i++) {
      double antallTil = (kursFra / valutaPeker[i].hentKurs()) * antallFra;  
      printResultString = printResultString + "\n" + valutaPeker[i].hentNavn() + " = " + antallTil;       
     }
     
     JOptionPane.showMessageDialog(                    
                null,
                "Konvertert valuta:\n" + printResultString,
                "Resultat",
                JOptionPane.PLAIN_MESSAGE
            );              
     }                
    }               
    else {
       JOptionPane.showMessageDialog(              
               null,                                   
               "Feil: Valuta ikke stoettet: " + " " + navnFra,  
               "Feil!",                               
               JOptionPane.WARNING_MESSAGE            
           );      
           
    }                  
       }
    else{
      ferdig = "@";
   return; // Skriv ut innlest data
  }        
     }    
 }
}
