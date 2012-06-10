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
public abstract class Sanankyselija {

    private String kysymys;
    protected int nykyinen = 0;
    private int kysyttykpl = 0;
    private Sanalukija sanalukija;
    private Sanaparit sanaparit;
    private HashMap<String, String> sanasto;
    protected ArrayList<String> kysyttavat;
    protected boolean onkoLoppu = false;

    public Sanankyselija(String tiedostonimi) {
        this.sanalukija = new Sanalukija(new File(tiedostonimi));
        this.sanaparit = sanalukija.luoSanaparitOlio();
        this.sanasto = sanaparit.getSanasto1To2();
        this.kysyttavat = new ArrayList<String>(sanasto.keySet());

        // kysySana();
    }

    public void kysySana() {
        String kysyttava = kysyttavat.get(nykyinen);
        kysyttykpl++;
        System.out.println("Anna pari: " + kysyttava);
        System.out.println("(oikea pari " + sanaparit.getPariSanasto1To2(kysyttava) + ")");
        kysymys = kysyttava; //kysymys.setText(kysyttava);
    }

    public String getAsetettavaTeksti() {
        return kysymys;
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

    public boolean onkoLoppu() {
        return onkoLoppu;
    }

    public boolean tarkistaJaEtene(String vastaus) {
        System.out.println("nyk: " + nykyinen + " jaljella: " + (kysyttavat.size() - 1));
        boolean oikeinVaiVaarin = onkoOikein(vastaus);
        etene(oikeinVaiVaarin);
        return (oikeinVaiVaarin);
    }

    protected abstract void etene(boolean olikoOikein);
    
}
