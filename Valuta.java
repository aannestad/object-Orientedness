public class Valuta {

   // @author Hans Martin Aannestad
    
   private String navn;
   private Double kurs;
  
   Valuta(String navn, Double kurs) {                           // Oppretter et Valutaobjekt med div

       this.navn = navn;
       this.kurs = kurs;      
     }

   public void SettKurs(Double ValutaKurs) {                                         // Legger til ny interesse
        kurs = ValutaKurs;
   }

   public void settNavn(String ValutaNavn) {         // Setter navnet til Valutaen, @param ValutaNavn navnet til Valutaen
     navn = ValutaNavn;
   }
    
   public String hentNavn() {                                 // Henter navnet til Valutaen, @return Navnet til Valutaen
     return navn; 
   }
   
   public Double hentKurs() {
    return kurs;
   }
  
   public String toString() {                                                      // Skriver ut informasjon om Valutaen
     String streng = "Valuta: " + navn + " " + kurs + "\n";
     return streng;
   }
}
 
 
 

