/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logiikka;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author johanna
 */


public class Sanankyselija {
    
    private String kayttajanVastaus;
    private String kysymys;
    private int oikeinMenneet;
    private int nykyinen = 0;
    private int kysyttykpl = 0;
    private Sanalukija sanalukija;
    private Sanaparit sanaparit;
    private HashMap<String, String> sanasto;
    private ArrayList<String> kysyttavat;
    
    public Sanankyselija(String kayttajanVastaus, String tiedostonimi){
        this.kayttajanVastaus = kayttajanVastaus;
        this.sanalukija = new Sanalukija(new File(tiedostonimi));
        this.sanaparit = sanalukija.luoSanaparitOlio();
        this.sanasto = sanaparit.getSanasto1To2();
        this.kysyttavat = new ArrayList<String>(sanasto.keySet());
        
        kysySana();
    }
    public void kysySana() {
        String kysyttava = kysyttavat.get(nykyinen);
        kysyttykpl++;
        System.out.println("Anna pari: " + kysyttava);
        kysymys = kysyttava; //kysymys.setText(kysyttava);
    }
    public String getAsetettavaTeksti(){
        return kysymys;
    }
    /**
     * tarkistaa onko vastaus oikein
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
    private boolean onkoLoppu = false;
    public boolean onkoLoppu(){
        return onkoLoppu;
    }
     public boolean tarkistaJaEtene() {
        System.out.println("nyk: " + nykyinen + " jaljella: " + kysyttavat.size());
        boolean oikeinVaiVaarin = onkoOikein(kayttajanVastaus);
        if (oikeinVaiVaarin) {
            System.out.println("oikein");
            kysyttavat.remove(nykyinen);
        } else {
            System.out.println("väärin");
            nykyinen++;
        }
        
        if (kysyttavat.size() <= nykyinen) {
            nykyinen = 0;
        }

        if (kysyttavat.isEmpty()) {
            onkoLoppu = true; //jotenkin lopetus
        }
        kysySana();
        return (oikeinVaiVaarin);
    }
}
