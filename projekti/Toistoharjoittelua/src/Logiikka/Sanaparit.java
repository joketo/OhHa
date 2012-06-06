package Logiikka;

/**
 * Sanaparit on ohjelman logiikan kannalta ehkä tärkein luokka. Se käsittelee sanapareja kahdessa
 * eri HashMapissa ja esim. tutkii ovatko tietyt sanat pareja keskenään, tai mikä on tietyn sanan pari.
 * Näiden tietojen saaminen on ohjelman kannalta tärkeää.
 */
import java.util.HashMap;

public class Sanaparit {

    HashMap<String, String> sanasto1To2; //avaimina esim. sanat englanniksi, arvoina käännökset suomeksi
    HashMap<String, String> sanasto2To1; //sama toistepäin (avaimina suomeksi, arvoina enkuksi)
/**
 * saa parametreina sanastot ja ottaa ne käyttöön
 * @param sanasto1To2
 * @param sanasto2To1 
 */
    public Sanaparit(HashMap<String, String> sanasto1To2, HashMap<String, String> sanasto2To1) {
        this.sanasto1To2 = sanasto1To2;
        this.sanasto2To1 = sanasto2To1;
    }
    
/**
 * tarkistaa onko toinen sana ensimmäisen sanan pari
 * @param eka
 * @param toka
 * @return 
 */
    public boolean onkoParitSanasto1To2(String eka, String toka) {
        if (sanasto1To2.get(eka).equalsIgnoreCase(toka)) {
            return true;
        } else {
            return false;
        }
    }
/**
 * edellinen toistepäin
 * @param eka
 * @param toka
 * @return 
 */
    public boolean onkoParitSanasto2To1(String eka, String toka) {
        if (sanasto2To1.get(eka).equalsIgnoreCase(toka)) {
            return true;
        } else {
            return false;
        }
    }
/**
 * palauttaa halutun sanan parin
 * @param sana
 * @return 
 */
    public String getPariSanasto1To2(String sana) {
        return sanasto1To2.get(sana);
    }
/**
 * palauttaa halutun sanan parin
 * @param sana
 * @return 
 */
    public String getPariSanasto2To1(String sana) {
        return sanasto2To1.get(sana);
    }
    /**
     * palauttaa sanaston niin päin kun se tiedostossa on
     * @return 
     */
    public HashMap<String, String> getSanasto1To2(){
        return sanasto1To2;
    }
    /**
     * palauttaa sanaston käännettynä
     * @return 
     */
    public HashMap<String, String> getSanasto2To1(){
        return sanasto2To1;
    }
}
