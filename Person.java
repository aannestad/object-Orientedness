  // Beskrivelse: Klassen Person brukes for aa haandere informasjon om personnavn og interesser
  // @author Hans Martin Aannestad

public class Person {
   
  private static final int maxInteresser = 4;                           // Maksimalt antall interesser en person kan ha

  private static int antallPersoner;

  private String navn;

  public String[] interesseTabell = new String[maxInteresser];

  private int antallInteresser = 0; 
  
  public static void skrivStatistikk() {
    System.out.printf("Har opprettet %d Person-objekt\n",antallPersoner);
  }

   public Person() {                                                                  // Oppretter et tomt personobjekt
     antallPersoner++; 
   }
                                                    
  public Person(String navn, String[] interesseListe) {                           // Oppretter et personobjekt med div
    if (interesseListe.length > maxInteresser) {
      System.out.println("Kan ikke opprette, for mange interesser\n");
    }
    else {
      antallPersoner++;
      this.navn = navn;
      this.antallInteresser = interesseListe.length;
      for(int i=0;i<interesseListe.length;i++) 
        this.interesseTabell[i] = interesseListe[i];
    }
  }

  public void leggTilInteresser(String interesser) {                                         // Legger til ny interesse
    if (antallInteresser < maxInteresser) {
      interesseTabell[antallInteresser] = interesser;
      antallInteresser++;
    }
    else {
     System.out.println("For mange interesser:");
     System.out.println(this);
    }
  }

  public void settNavn(String personNavn) {         // Setter navnet til personen, @param personNavn navnet til personen
    navn = personNavn;
  }
   
  public String hentNavn() {                                 // Henter navnet til personen, @return Navnet til personen
    return navn; 
  }

  public int hentAntInteresser() {
    return antallInteresser; 
  }
  
  public String toString() {                                                      // Skriver ut informasjon om personen
    String streng = "Person: " + navn + "\n";
    //streng += "Interesse: ";
    for(int i=0;i<antallInteresser;i++)
      streng += "Interesse: " + interesseTabell[i] + "\n";

    return streng;
  }
}

