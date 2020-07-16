import java.util.Scanner;
import java.util.Random;

// * Beskrivelse: Spillet stein-saks-papir leser inn brukerens trekk og paagaar til det skrives "avslutt", da skrives
// * antallet ganger brukeren og data har vunnet ut.

// @author Hans Martin Aannestad

public class steinSaksPapir{

  public static void main(String[] args) {
    
  int antvinn = 0;
  int anttap = 0;
  int fortsett = 1;
 
  String dataValg = new String();
     
   while (fortsett == 1) {                                                                            // Fortsett spill 
     
    System.out.println("Skriv stein, saks eller papir, eller avslutt:");
    Scanner tastatur = new Scanner(System.in);          
    String spillerValg = tastatur.nextLine();                                                 // Les inn brukerens valg
  
    if (spillerValg.equals("avslutt")) {                                                  // 1: Bruker avslutter spillet
      fortsett = 0; 
      System.out.printf("avslutt\n");  
    } else {                                                                                  //2: Eller start ny runde
     System.out.printf("Spillervalg: %s\n",spillerValg);    
     Random rand = new Random();                                                              
     int dataNumValg = rand.nextInt(3);                                        // Generer dataens trekk (tilfeldig 1-3)
     if(dataNumValg==0){                                                    
       dataValg = "stein";                                                   // Konverter numerisk data valg til: stein         
       System.out.println("Datavalg: stein");
      
       if (spillerValg.equals("stein")) {                    // Sammenlign data valg mot brukerens valg og avgjor runde
         System.out.println("Uavgjort");
       }else if (spillerValg.equals("saks")) {
         System.out.println("Data vant");
         anttap = anttap + 1;
       }else if (spillerValg.equals("papir")) {
         System.out.println("Spiller vant");
         antvinn = antvinn + 1;
       }          
     }else if(dataNumValg==1){
       dataValg = "saks";                                                     // Konverter numerisk data valg til: saks
       System.out.println("Datavalg: saks");
      
       if (spillerValg.equals("stein")) {                    // Sammenlign data valg mot brukerens valg og avgjor runde
         System.out.println("Spiller vant");
         antvinn = antvinn + 1;
       }else if (spillerValg.equals("saks")) {
         System.out.println("Uavgjort");
       }else if (spillerValg.equals("papir")) {
         System.out.println("Data vant");
         anttap = anttap + 1;
       }         
      
     }else if(dataNumValg==2){
       dataValg = "papir";                                                   // Konverter numerisk data valg til: papir
       System.out.println("Datavalg: papir");
      
       if (spillerValg.equals("stein")) {                    // Sammenlign data valg mot brukerens valg og avgjor runde
         System.out.println("Data vant"); 
         anttap = anttap + 1;
       }else if (spillerValg.equals("saks")) {
         System.out.println("Spiller vant");
         antvinn = antvinn + 1;
       }else if (spillerValg.equals("papir")) {
         System.out.println("Uavgjort");
       }      
      }           
    }  
   }
    System.out.printf("Spiller vant %d ganger\n",antvinn);                                         // Gi ut antall vinn
    System.out.printf("Data vant %d ganger\n",anttap);                                              // Gi ut antall tap
  
 }
}
  

