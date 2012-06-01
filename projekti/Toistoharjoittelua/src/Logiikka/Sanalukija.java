package Logiikka;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Sanalukija purkaa saamansa tiedoston kahdenlaiseen HashMappiin. Ohjelmalle kelpaavat tiedostot,
 * joissa joka toisella rivillä on esim. sana suomeksi ja joka toisella sama käännettynä halutulle kielelle.
 * @author johanna
 */
import Logiikka.Sanaparit;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sanalukija {

    Sanaparit sanastot;
    private File tiedosto;

    public Sanalukija(File tiedosto) {
        this.tiedosto = tiedosto;    //jossain kohtaa tiedoston luonti ei onnistu
    }

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
            return sanasto1To2;   //johanna huom! muista käsitellä tämä mahdollisuus, että mappi onkin tyhjä
        }
    }

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
            return sanasto2To1;   //johanna huom! muista käsitellä tämä mahdollisuus, että mappi onkin tyhjä
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
