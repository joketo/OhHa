
package Logiikka;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author johanna
 */
public abstract class Sanankyselija {

    private String kysymys;
    protected int nykyinen = 0;
    protected int sanojenMaaraAlussa;
    private int kysyttykpl = 0;
    private Sanalukija sanalukija;
    private Sanaparit sanaparit;
    private HashMap<String, String> sanasto;
    protected ArrayList<String> kysyttavat;
    protected boolean onkoLoppu = false;
    private String oikeaVastaus;
/**
 * konstruktori
 * @param tiedostonimi 
 */
    public Sanankyselija(String tiedostonimi) {
        this.sanalukija = new Sanalukija(new File(tiedostonimi));
        this.sanaparit = sanalukija.luoSanaparitOlio();
        this.sanasto = sanaparit.getSanasto1To2();
        this.kysyttavat = new ArrayList<String>(sanasto.keySet());
        this.sanojenMaaraAlussa = kysyttavat.size();
        // kysySana();
    }
    
    /**
     * kysyy seuraavaa sanaa
     */
    public void kysySana() {
        String kysyttava = kysyttavat.get(nykyinen);
        kysyttykpl++;
        System.out.println("Anna pari: " + kysyttava);
        oikeaVastaus = sanaparit.getPariSanasto1To2(kysyttava);
        System.out.println("(oikea pari " + sanaparit.getPariSanasto1To2(kysyttava) + ")");
        kysymys = kysyttava;
    }
    /**
     * palauttaa kysyttävän sanan stringinä
     * @return 
     */
    public String getAsetettavaTeksti() {
        return kysymys;
    }
    /**
     * antaa kysytyn sanan oikean parin
     * @return 
     */
    public String getOikeaVastaus(){
        return oikeaVastaus;
    }

    /**
     * tarkistaa onko vastaus oikein
     *
     * @param vastaus
     * @return
     */
    private boolean onkoOikein(String vastaus) {
        if (sanaparit.onkoParitSanasto1To2(kysyttavat.get(nykyinen), vastaus)) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * boolean, onko harjoitus ohi
     * @return 
     */
    public boolean onkoLoppu() {
        return onkoLoppu;
    }
   /**
    * tarkistaa vastauksen ja etenee
    * @param vastaus
    * @return 
    */
    public boolean tarkistaJaEtene(String vastaus) {
        System.out.println("nyk: " + nykyinen + " jaljella: " + (kysyttavat.size() - 1));
        boolean oikeinVaiVaarin = onkoOikein(vastaus);
        if (!kysyttavat.isEmpty()) {
            etene(oikeinVaiVaarin);
        }
        return (oikeinVaiVaarin);
    }
    /**
     * etenee. Harjoituksen etene-metodin toteutus hieman erilainen kuin kokeen.
     * @param olikoOikein 
     */
    protected abstract void etene(boolean olikoOikein);
}
