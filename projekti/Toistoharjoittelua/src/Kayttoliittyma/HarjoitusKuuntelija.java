/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import Logiikka.Sanankyselija;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * "logiikka" on oikeastaan tapahtumankuuntelija, joka kysyy sanoja ja tarkistaa vastauksen
 * @author johanna
 */

public class HarjoitusKuuntelija implements ActionListener {

    private JTextField kayttajanVastaus;
    private JLabel kysymys;
    private String kVastaus;   
    private JLabel oikeinVaarin;    
    Sanankyselija sanankyselija;
    /**
     * konstruktori luo sopivan harjoituksen ja kysyy ensimmäisen kysymyksen
     * @param tiedostonimi
     * @param kysymys
     * @param kayttajanVastaus 
     */
    public HarjoitusKuuntelija(String tiedostonimi, JLabel kysymys, JTextField kayttajanVastaus, JLabel oikeinVaarin) {
        this.kayttajanVastaus = kayttajanVastaus;
        this.kysymys = kysymys;
        this.oikeinVaarin = oikeinVaarin;
        sanankyselija = new Sanankyselija(this.kayttajanVastaus.getText(), tiedostonimi);
        
        sanankyselija.kysySana();
        this.kysymys.setText(sanankyselija.getAsetettavaTeksti());
    }
    /**
     * metodi tarkistaa annetun vastauksen ja siirtyy seuraavaan kysymykseen tai lopettaa
     * @param ae 
     */

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.kVastaus = this.kayttajanVastaus.getText();
        if(sanankyselija.tarkistaJaEtene(kVastaus)){
            this.oikeinVaarin.setText("oikein");
        }else{
            this.oikeinVaarin.setText("väärin");
        }
        kysymys.setText(sanankyselija.getAsetettavaTeksti());
        kayttajanVastaus.setText("");
    }
}
