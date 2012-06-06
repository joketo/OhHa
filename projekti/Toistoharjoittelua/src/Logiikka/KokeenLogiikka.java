/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logiikka;
import Kayttoliittyma.KokeenKayttoliittyma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *Tekee paljolti samaa kuin harjoituksenLogiikka. Erona se, ettei väärinmenneitä sanoja kysytä uudestaan.
 * @author johanna
 */
public class KokeenLogiikka implements ActionListener{
  
    private JTextField kayttajanVastaus;
    private JLabel kysymys;
    private String kVastaus;
    private int oikeinMenneet;
    private int nykyinen = 0;
    private int kysyttykpl = 0;
    private Sanalukija sanalukija;
    private Sanaparit sanaparit;
    private HashMap<String, String> sanasto;
    private ArrayList<String> kysyttavat;
    private int listanKokoAlussa;
    /**
     * konstruktori luo sopivan harjoituksen ja kysyy ensimmäisen kysymyksen
     * @param tiedostonimi
     * @param kysymys
     * @param kayttajanVastaus 
     */
    public KokeenLogiikka(String tiedostonimi, JLabel kysymys, JTextField kayttajanVastaus) {
        this.kayttajanVastaus = kayttajanVastaus;
        this.sanalukija = new Sanalukija(new File(tiedostonimi));
        this.sanaparit = sanalukija.luoSanaparitOlio();
        this.kysymys = kysymys;
        this.sanasto = sanaparit.getSanasto1To2();
        kysyttavat = new ArrayList<String>(sanasto.keySet());
        this.listanKokoAlussa = kysyttavat.size();
        kysySana();

    }
    /**
     * palauttaa sanaparit-olion
     * @return 
     */
    public Sanaparit getSanaparit() {
        return sanaparit;
    }
/**
 * palauttaa listan kaikista kysyttävistä sanoista
 * 
 * @return 
 */
    public ArrayList<String> getKysyttavat() {
        return kysyttavat;
    }
/**
 * palauttaa tämänhetkisen sanan
 * @return 
 */
    public int getNykyinen() {
        return nykyinen;
    }
    /**
     * metodi kysyy sanan paria
     */

    public void kysySana() {
        String kysyttava = kysyttavat.get(nykyinen);
        kysyttykpl++;
        System.out.println("Anna pari: " + kysyttava);
        kysymys.setText("Anna pari: " + kysyttava);
    }
    /**
     * tarkistaa onko vastaus oikein
     * @param vastaus
     * @return 
     */
    public boolean tarkista(String vastaus) {
        if (sanaparit.onkoParitSanasto1To2(kysyttavat.get(nykyinen), vastaus)) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * metodi tarkistaa annetun vastauksen ja siirtyy seuraavaan kysymykseen tai lopettaa
     * @param ae 
     */

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("nyk: " + nykyinen + " jaljella: " + (kysyttavat.size()-1));
        kVastaus = this.kayttajanVastaus.getText();

        if (tarkista(kVastaus)) {
            System.out.println("oikein");
            oikeinMenneet++;
            kysyttavat.remove(nykyinen);
        } else {
            kysyttavat.remove(nykyinen);
            System.out.println("väärin");
            
        }
        

        if (kysyttavat.isEmpty()) {
            System.out.println("Koe on ohi, pisteesi: " + this.oikeinMenneet +"/"+kysyttavat.size()); //pisteet, lopetus
            return;
        }
        kysySana();
        kayttajanVastaus.setText("");
    }
}

