/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;
import Kayttoliittyma.KokeenKayttoliittyma;
import Logiikka.KokeenLogiikka;
import Logiikka.Sanalukija;
import Logiikka.Sanaparit;
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
public class KokeenKuuntelija implements ActionListener{
  
    private JTextField kayttajanVastaus;
    private JLabel kysymys;
    private String kVastaus;   
       
    KokeenLogiikka kokeenLogiikka;
    /**
     * konstruktori luo sopivan harjoituksen ja kysyy ensimmäisen kysymyksen
     * @param tiedostonimi
     * @param kysymys
     * @param kayttajanVastaus 
     */
    public KokeenKuuntelija(String tiedostonimi, JLabel kysymys, JTextField kayttajanVastaus) {
        this.kayttajanVastaus = kayttajanVastaus;
        this.kysymys = kysymys;
        kokeenLogiikka = new KokeenLogiikka(tiedostonimi);
        
        kokeenLogiikka.kysySana();

    }

    /**
     * metodi tarkistaa annetun vastauksen ja siirtyy seuraavaan kysymykseen tai lopettaa
     * @param ae 
     */

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        kVastaus = this.kayttajanVastaus.getText();
        kokeenLogiikka.tarkistaJaEtene(kVastaus);
        
        kysymys.setText(kokeenLogiikka.getAsetettavaTeksti());
        
        kayttajanVastaus.setText("");
    }
}

