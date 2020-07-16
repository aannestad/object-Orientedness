import java.util.Scanner;
import java.util.Random;

// @author Hans Martin Aannestad

/**
 * Produkt.
 * 
 * Inneholder informasjon om produkt.
 */
public class Produkt implements Comparable<Produkt>{
  
  String navn;
  String identifikasjonsKode;
  double pris;
  
  /**
   * Konstruktoer.
   * 
   * @param n Navn.
   * @param idk Identifikasjonskode.
   * @param p Pris.
   */
  Produkt(String n,String idk,double p){
    navn = n;
    identifikasjonsKode = idk;
    pris = p;
  }
  
  /*
   * Henter navn.
   * 
   * @return navn.
   */
  String hentNavn(){
    return navn;
  }
  
  /*
   * Setter navn.
   * 
   * @param n navn.
   */
  void settNavn(String n){
    navn = n;
  }
  
  /*
   * Henter identifikasjonskode.
   * 
   * @return identifikasjonskode.
   */
  String hentIdentifikasjonsKode(){
    return identifikasjonsKode;
  }
  
  /*
   * Setter identifikasjonskode.
   * 
   * @param idk identifikasjonskode.
   */
  void settIdentifikasjonsKode(String idk){
    identifikasjonsKode = idk;
  }
  
  /*
   * Henter pris.
   * 
   * @return pris.
   */
  double hentPris(){
    return pris;
  }
  
  /*
   * Setter pris.
   * 
   * @param p pris.
   */
  void settPris(double p){
    pris = p;
  }
  
  /**
   * Sammenlikner to produkter.
   * 
   * @param annen Annet produkt.
   */
  public int compareTo(Produkt annet){
    return this.hentNavn().compareTo(annet.hentNavn());
  }
  
  /**
   * Skriver ut produkt.
   * 
   * @return Streng som skal skrives ut.
   */
  public String toString(){
    return identifikasjonsKode + ": " + navn + ", kr " + pris;
  }
  
}

