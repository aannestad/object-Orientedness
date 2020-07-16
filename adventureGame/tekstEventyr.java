import java.util.Scanner;
import java.util.Random;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

 /**
 *
 * @author Hans Martin Aannestad
 *
 * Eventyrspill.
 * Utforsk rom og sloss mot monstre med stein, saks papir eller bomber
 *  
 */
public class TekstEventyr {

  static int antallMonstre = 0;
  static int antallRom = 0;
  static Rom startRom = null;
  
  /**
   * Lar spilleren bruke ting fra sekken.
   * 
   * @param tastaur Tastatur for innlesing av kommandoer.
   * @param spiller Spilleren.
   * @param rom     Rommet.
   */
  private static void brukFraSekk(Scanner tastatur,Spiller spiller, Rom rom){
    // Skriv ut hva som er i sekken, og spoer om hva spilleren vil bruke.
    System.out.println("Hva vil du bruke? Om du ikke vil bruke noe, skriv lukk for aa lukke sekken igjen.");
    System.out.println("I sekken: ");
 System.out.println(spiller.hentSekk());  
      
 String spillerBrukValg = tastatur.nextLine();
   // Se etter ting i sekken, og om funnet, se om den kan brukes. 
   Ting brukTing;
   brukTing = spiller.hentSekk().hentTingFraNavn(spillerBrukValg);
  
   if (brukTing!=null){
    if (spillerBrukValg.equals("helsedrikk")) {
         // For helsedrikk, legg 1 til spillerens helse.
      spiller.settHelse(spiller.hentHelse() + 1);
      System.out.println(spiller.hentNavn() + " drakk en helsedrikk, og " + spiller.hentNavn() + " sin helse oekte med 1 og er naa " + spiller.hentHelse());
    }
    else if (spillerBrukValg.equals("bombe")) {
      // For bombe, trekk 1 fra monsterets helse dersom det er et monster i rommet.
      Monster rommonster = rom.hentMonster();
      if (rommonster!=null){
        System.out.println(spiller.hentNavn() + " kastet bomben mot monsteret, og monsteret ble skadet av eksplosjonen.");
        rommonster.settHelse(rommonster.hentHelse()-1);
      }     
     }
     brukTing.settAntall(brukTing.hentAntall()-1);
     if (brukTing.hentAntall() == 0) {
       int brukTingIndeks = spiller.hentSekk().hentTingIndeksFraNavn(brukTing.hentNavn());  
       spiller.hentSekk().fjernTing(brukTingIndeks);
   }
    
  else {
   System.out.println(brukTing + " er ikke i sekken!");
  } 
   }
  }

  /**
   * Kjoerer kamp med monster. Dersom bruker velger aa avslutte saa returnerer metoden false.
   * 
   * @param tastaur Tastatur for innlesing av kommandoer.
   * @param rand    Generator for semi-tilfeldige verdier.
   * @param spiller Spilleren.
   * @param monster Monsteret.
   * @param rom     Rommet.
   * @return        true dersom spillet fortsetter, eller false om spiller skriver "avslutt".
   */
  private static boolean slossMedMonster(Scanner tastatur,Random rand, Spiller spiller, Monster monster, Rom rom){
    // Skriv ut helse
    System.out.println(spiller.hentNavn()+" sin helse: "+spiller.hentHelse());
    System.out.println("Monsterets helse: "+monster.hentHelse());
    
    // Hent spillervalg
    int spillerValg=0;
    String[] valgMuligheter = { "stein", "saks", "papir" };
    System.out.println("Angrip med stein, saks eller papir, skriv sekk for aa bruke noe fra sekken, eller avslutt");
    // Hent spillervalg i loekke inntil gyldig valg er gitt
    // 0: stein
    // 1: saks
    // 2: papir
    boolean gyldigValg=false;
    while(!gyldigValg){
      String spillerValgStreng = tastatur.nextLine();
      if(spillerValgStreng.equals("avslutt")){
        return false;
      }else if(spillerValgStreng.equals("sekk")){   
        brukFraSekk(tastatur,spiller,rom);
        return true;
      }
      for(int v=0;v<3;v++){
        if(spillerValgStreng.equals(valgMuligheter[v])){
          gyldigValg=true;
          spillerValg=v;
          break;
        }
      }
      if(!gyldigValg){
        System.out.println("Ugyldig valg");
      }
    }
    
    // Hent datavalg og skriv ut valg
    int dataValg = rand.nextInt(3);
    System.out.println("Spillervalg: "+valgMuligheter[spillerValg]);
    System.out.println("Monstervalg: "+valgMuligheter[dataValg]);
    
    // Anvend spilleregler
    if(spillerValg==dataValg){
      System.out.println("Uavgjort");
    }else if(dataValg==(spillerValg+1)%3){
      System.out.println(spiller.hentNavn()+" vant runden");
      monster.settHelse(monster.hentHelse()-1);
    }else if((dataValg+1)%3==spillerValg){
      System.out.println("Monsteret vant runden");
      spiller.settHelse(spiller.hentHelse()-1);
    }
    
    return true;
  }

  /**
   * Lar spilleren ta ting fra rommet.
   * 
   * @param tastaur Tastatur for innlesing av kommandoer.
   * @param spiller Spilleren.
   * @param rom     Rommet.
   * @param taTekst Navnet paa tingen som skal taes fra rommet.
   */
  private static void taFraRom(Scanner tastatur,Spiller spiller, Rom rom,String taTekst){
   
    // Finn tingen ut fra navn
 Ting taTing;
 taTing = rom.hentTingSamling().hentTingFraNavn(taTekst);
 
 if (taTing!=null){
 
    // Ta tingen bort fra rommet. 
    //taTing.settAntall(taTing.hentAntall()-1);
    //if (taTing.hentAntall() == 0) {
  int taTingIndeks = rom.hentTingSamling().hentTingIndeksFraNavn(taTing.hentNavn());  
  rom.hentTingSamling().fjernTing(taTingIndeks);
 }
 else {
  System.out.println(taTekst + " er ikke en ting i rommet!");
 } 
  
    // Legg tingen i spillerens sekk.
    spiller.hentSekk().leggTilTing(taTing);
 System.out.println(spiller.hentNavn() + " puttet " + taTing.hentNavn() + " (x" + taTing.hentAntall() + ") i sekken sin.");
 System.out.println(spiller.hentNavn() + " har naa " + spiller.hentSekk().hentTingFraNavn(taTekst).hentAntall() + " " + spiller.hentSekk().hentTingFraNavn(taTekst).hentNavn()+".");
  }

  /**
   * Lar spilleren navigere rom. Dersom bruker velger aa avslutte saa returnerer metoden false.
   * 
   * @param tastaur Tastatur for innlesing av kommandoer.
   * @param spiller Spilleren.
   * @param rom     Rommet.
   * @return        true dersom spillet fortsetter, eller false om spiller skriver "avslutt".
   */
  private static boolean navigerRom(Scanner tastatur,Spiller spiller, Rom rom){
    rom.seIRommet();
    System.out.println("Skriv hvor du vil gaa (oest, vest, nord, soer), ta og navn paa ting for aa ta noe i rommet, sekk for aa bruke noe fra sekken, eller avslutt:");
    String valgTekst = tastatur.nextLine();
    String[] deler = valgTekst.split(" ");
    if(valgTekst.equals("oest")){
      spiller.gaaMotOest();
    }else if(valgTekst.equals("vest")){
      spiller.gaaMotVest();
    }else if(valgTekst.equals("nord")){
      spiller.gaaMotNord();
    }else if(valgTekst.equals("soer")){
      spiller.gaaMotSoer();
    }else if(deler[0].equals("ta")){
      if(deler.length == 2)
        taFraRom(tastatur,spiller,rom,deler[1]);
      else
        System.out.println("For aa ta noe, skriv ta fulgt av navn paa tingen. Tingens navn kan ikke ha mellomrom.");
    }else if(valgTekst.equals("sekk")){
      brukFraSekk(tastatur,spiller,rom);
    }else if(valgTekst.equals("avslutt")){
      return false;
    }else{
      System.out.println("Ukjent kommando.");
    }
    return true;
  }
  
  /**
   * Lager test-brett.
   */
  private static void lagTestBrett(){
    // Lag rom
    startRom = new Rom();
    Rom v1Rom = new Rom();
    Rom vn1Rom = new Rom();
    Rom vnn1Rom = new Rom();
    Rom vs1Rom = new Rom();
    Rom.kobleVestOest(v1Rom,startRom);
    Rom.kobleNordSoer(vn1Rom,v1Rom);
    Rom.kobleNordSoer(vnn1Rom,vn1Rom);
    Rom.kobleNordSoer(v1Rom,vs1Rom);
    Rom o1Rom = new Rom();
    Rom on1Rom = new Rom();
    Rom os1Rom = new Rom();
    Rom.kobleVestOest(startRom,o1Rom);
    Rom.kobleNordSoer(on1Rom,o1Rom);
    Rom.kobleNordSoer(o1Rom,os1Rom);
    antallRom = 8;
    
    // Legg inn ting
    v1Rom.hentTingSamling().leggTilTing(new Ting("gull",3));
    o1Rom.hentTingSamling().leggTilTing(new Ting("gull",2));
    vs1Rom.hentTingSamling().leggTilTing(new Ting("helsedrikk",1));
    o1Rom.hentTingSamling().leggTilTing(new Ting("bombe",1));
    
    // Lag monstre
    vnn1Rom.settMonster(new Monster(1,1));
    vs1Rom.settMonster(new Monster(1,2));
    on1Rom.settMonster(new Monster(1,1));
    os1Rom.settMonster(new Monster(1,2));
    antallMonstre = 4;
  }
  
  /**
   * Laster brett fra fil.
   * 
   * @param filBane Filbane for brettet som skal lastes.
   * @return true om vellykket, eller false om feil oppstod.
   */
  private static boolean lesBrettFraFil(String filBane){
    // Aapne fil for lesing.
   try{
     FileReader tekstFilleser = new FileReader(filBane);                         //  Aapne fil for lesing
     BufferedReader tekstLeser = new BufferedReader(tekstFilleser); 
   
     String linje0 = tekstLeser.readLine();
     String[] felt0 = linje0.split(" "); // Deler opp strengen etter skilletegn (Del opp linje etter skilletegn i 3 deler)
     int lesAntallRom = Integer.parseInt(felt0[0]);
     int lesStartRom = Integer.parseInt(felt0[1]);
    
     // Sett antallRom til antall rom i brettet.
     antallRom = lesAntallRom;
    
     // Lag rom. 
     Rom[] romPeker = new Rom[antallRom];
    
     for (int i=0;i<antallRom; i++) {
       romPeker[i] = new Rom(); 
     }
     
     // Sett startRom til rommet som spilleren starter i.
     startRom = romPeker[lesStartRom];
     
     // Les inn koblinger mellom rom.   
     boolean ferdig = false;
     while (!ferdig) {
       String linje = tekstLeser.readLine();   // Les linje for linje
       if (linje != null) { // Faar null naar filen er slutt  
         String[] felt = linje.split(" "); // Deler opp strengen etter skilletegn (Del opp linje etter skilletegn i 3 deler)
       
         // Les inn foerste linje: antall rom; indeks for start-rom.    
         if (felt[0].equals("koble")) {           
           if (felt[1].equals("vest-oest")) {
              Rom.kobleVestOest(romPeker[Integer.parseInt(felt[2])],romPeker[Integer.parseInt(felt[3])]);
           }
           else if (felt[1].equals("nord-soer")) {   
             Rom.kobleNordSoer(romPeker[Integer.parseInt(felt[2])],romPeker[Integer.parseInt(felt[3])]);
           }
         }     
         else if (felt[0].equals("ting")) {   
           // Les inn ting i rom.         
           romPeker[Integer.parseInt(felt[1])].hentTingSamling().leggTilTing(new Ting(felt[2],Integer.parseInt(felt[3])));     
         }       
         else if (felt[0].equals("monster")) {              
         // Les inn monstre i rom (hvis det ikke allerede er monster i rommet)
           if (romPeker[Integer.parseInt(felt[1])].hentMonster() == null) {            
             romPeker[Integer.parseInt(felt[1])].settMonster(new Monster(Integer.parseInt(felt[2]),Integer.parseInt(felt[3])));
             // Sett antallMonstre til antall monstre i brettet.
             antallMonstre = antallMonstre + 1;  
           }
         }        
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
   * Programmet starter her.
   */
  public static void main ( String [] args ){
    Scanner tastatur = new Scanner(System.in);
    Random rand = new Random();
    
    System.out.println("Velkommen til teksteventyret!");
    
    antallMonstre = 0;
    
    // Hent spillernavn og lag spiller
    System.out.println("Hva heter du?");
    String navn = tastatur.nextLine();
    // Spoer om spilleren vil laste brett fra en fil eller bruke testbrett
    System.out.println("Hvilket brett vil du spille? Skriv navn paa fil, eller @ for aa bruke innebygget test-brett:");
    String brettNavn = tastatur.nextLine();
    if(brettNavn.equals("@")){
      lagTestBrett();
    }else{
      // Last brett fra fil
      if(!lesBrettFraFil(brettNavn)){
        return;
      }
    }
    
    Spiller spiller = new Spiller(navn,startRom,3);
    System.out.println(spiller.hentNavn()+ " finner seg selv i en verden med "+antallRom+" rom og "+antallMonstre+" monstre, med kun stein/saks/papir til forsvar. "
                         +spiller.hentNavn()+" har "+spiller.hentHelse()+" helsepoeng. Forsoek aa samle saa mye som mulig i sekken, og aa bekjempe alle monstrene. Lykke til!");
    
    // Kjoer spill-loekke
    boolean ferdig = false;
    while(!ferdig){
      Rom iRom = spiller.hentRom();
      Monster romMonster = iRom.hentMonster();
      if(romMonster!=null){
        // Dersom det er et monster i rommet saa maa det bekjempes.
        System.out.println("Det er et monster i rommet!");
        if(!slossMedMonster(tastatur,rand,spiller,romMonster,iRom)){
          ferdig = true;
        }
        // Om monsteret slo spilleren saa er spillet slutt.
        if(spiller.hentHelse()==0){
          System.out.println(spiller.hentNavn()+" har tapt spillet.");
          System.out.println("I sekk: "+spiller.hentSekk());
          System.out.println("Poeng: "+spiller.beregnPoeng());
          ferdig=true;
        // Om spilleren slo monsteret saa ta bort monsteret fra rommet.
        }else if(romMonster.hentHelse()==0){
          System.out.println(spiller.hentNavn()+" bekjempet monsteret!");
          // La monsteret legge igjen gull i rommet.
          int monsterGull = romMonster.hentGull();
          iRom.hentTingSamling().leggTilTing(new Ting("gull",monsterGull));
          System.out.println("Monsteret la fra seg "+monsterGull+" gull.");
          // Ta bort det bekjempede monsteret.
          iRom.settMonster(null);
          antallMonstre--;
          if(antallMonstre==0){
            System.out.println(spiller.hentNavn()+" har bekjempet alle monstrene.");
            System.out.println(spiller.hentNavn()+" har vunnet spillet!");
            spiller.hentSekk().leggTilTing(new Ting("gull",monsterGull));
            System.out.println(spiller.hentNavn()+" tok gullet fra det siste monsteret.");
            System.out.println("I sekk: "+spiller.hentSekk());
            System.out.println("Poeng: "+spiller.beregnPoeng());
            ferdig=true;
          }else{
            System.out.println("Det er "+antallMonstre+" monstre igjen i brettet.");
          }
        }
      }else{
        // Om det ikke er en kamp med monster saa kan vi utforske.
        if(!navigerRom(tastatur,spiller,iRom)){
          ferdig = true;
        }
      }
    }
    
  }
  
}

