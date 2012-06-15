
package Logiikka;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Scanner;

/**
 * Jatkosoveltamista vaativa luokka, joka hoitaa kokeen tulosten historiaa.
 * @author johanna
 */


public class TulosHistoria {
    File tuloshistoriaKahva;
    Scanner historia;
    /**
     * tuloshistoria luetaan tiedostosta, jossa tietyt tiedot ovat tietyillä paikoilla.
     * tiedoston muoto:
     * eka rivi: paras tulos
     * toka rivi: keskiarvo
     * kolmas rivi: tulosten kplMaara
     * neljäs - n riviä: tulokset, yksi per rivi
     */
    public TulosHistoria(){
        tuloshistoriaKahva = new File("tuloshistoria");
        try{
            tuloshistoriaKahva.createNewFile();
            historia = new Scanner(tuloshistoriaKahva);
        }catch(IOException ex){
            System.out.println("Tapahtui virhe");
        }
    }
    /**
     * kun koe on loppu, tätä metodia kutsutaan. metodi ylikirjoittaa tiedoston 
     * "tulosten lukumäärän", keskiarvon, sekä "parhaan tuloksen" jos se muuttuu.
     * myös itse tulos lisätään tiedostoon
     * @param tulos 
     */
    public void lisaaTulos(Integer tulos){
        //lisätään filen "kpl" kohtaan yksi
        //ja itse tulos tiedoston loppuun uudelle riville
        if(tulos > this.getParasTulos()){
            //korvataan parhaan tuloksen kohta filessä
            korvaaVanhaParasTulos(tulos);
        }
        korvaaVanhaKeskiarvo(tulos);
    }
    /**
     * korvataan tiedoston vanha keskiarvo uudella
     * @param uusinTulos 
     */
    private void korvaaVanhaKeskiarvo(Integer uusinTulos){
        //lasketaan uusi keskiarvo
        //kirjotetaan tiedoston keskiarvo-kohdan päälle uusi kA
    }
    /**
     * palauttaa tiedostoon tallennetun keskiarvon
     * @return 
     */
    public int getKeskiArvo(){
        int keskiArvo = 0;
        if(historia.hasNext()){
            //otetaan tiedostosta toinen rivi eli keskiarvo
        }
        return keskiArvo;
    }
    /**
     * palauttaa tiedostoon tallennetun tulosten lukumäärän
     * @return 
     */
    public int getTulostenKplMaara(){
        int kpl = 0;
        if(historia.hasNext()){
            //otetaan tiedoston kolmas rivi
        }
        return kpl;
    }
    /**
     * palauttaa tiedostoon tallennetun parhaan tuloksen
     * @return 
     */
    public int getParasTulos(){
        int paras = 0;
        if(historia.hasNext()){
            //otetaan tiedoston ensimmäinen rivi
        }
           return paras;
    }
    /**
     * kirjoitetaan tiedoston Parhaan tuloksen päälle uusi paras tulos
     * @param tulos
     */
    private void korvaaVanhaParasTulos(int tulos){
        //kirjoitetaan tiedoston ensimmäinen rivi uusiksi parametrina saadulla tuloksella
    }
    
}
