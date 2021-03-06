package Logiikka;


/**
 * Sanalukija purkaa saamansa tiedoston kahdenlaiseen HashMappiin. Ohjelmalle kelpaavat tiedostot,
 * joissa joka toisella rivillä on esim. sana suomeksi ja joka toisella sama käännettynä halutulle kielelle.
 * @author johanna
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Sanalukija {

    Sanaparit sanastot;
    private File tiedosto;
/**
 * asettaa this.tiedostonsa parametrina saaduksi tiedostoksi
 * @param tiedosto 
 */
    public Sanalukija(File tiedosto) {
        this.tiedosto = tiedosto;
    }
/**
 * luo HashMapin tiedoston sanoista. joka toisen rivin sana on avain, joka toinen arvo
 * @param tiedosto
 * @return 
 */
    private HashMap<String, String> luoSanasto1To2HashMap(File tiedosto) {
        HashMap<String, String> sanasto1To2 = new HashMap<String, String>();
        try {
            Scanner lukija = new Scanner(tiedosto);
            while (lukija.hasNextLine()) {
                String eka = lukija.nextLine();
                String toka = lukija.nextLine();
                sanasto1To2.put(eka, toka);
            }
            return sanasto1To2;
        } catch (FileNotFoundException ex) {
            return sanasto1To2;   //muista käsitellä mahdollisuus, että tiedosto onkin tyhjä
        }
    }
/**
 * luo HashMapin tiedoston sanoista. nyt arvoina onkin äskeisen avaimet ja toistepäin
 * @param tiedosto
 * @return 
 */
    private HashMap<String, String> luoSanasto2To1HashMap(File tiedosto) {
        HashMap<String, String> sanasto2To1 = new HashMap<String, String>();
        try {
            Scanner lukija = new Scanner(tiedosto);
            while (lukija.hasNextLine()) {
                String eka = lukija.nextLine();
                String toka = lukija.nextLine();
                sanasto2To1.put(eka, toka);
            }
            return sanasto2To1;
        } catch (FileNotFoundException ex) {
            return sanasto2To1;   //muista käsitellä mahdollisuus, että tiedosto onkin tyhjä
        }
    }
    /**
     * Sanalukija luo Sanaparit-olion antaen tälle luomansa HashMapit.
     * @return 
     */
    public Sanaparit luoSanaparitOlio(){
        this.sanastot = new Sanaparit(luoSanasto1To2HashMap(tiedosto), luoSanasto2To1HashMap(tiedosto));
        return this.sanastot;
    }
}
