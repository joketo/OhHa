/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import Logiikka.HarjoituksenLogiikka;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * tapahtumankuuntelija, joka kysyy sanoja ja tarkistaa vastauksen
 *
 * @author johanna
 */
public class HarjoitusKuuntelija implements ActionListener {

    private JTextField kayttajanVastaus;
    private JLabel kysymys;
    private String kVastaus;
    private JLabel oikeinVaarin;
    HarjoituksenLogiikka harjoituksenLogiikka;
    private JFrame frame;

    /**
     * konstruktori luo sopivan harjoituksen ja kysyy logiikan kautta
     * ensimmäisen kysymyksen
     *
     * @param tiedostonimi
     * @param kysymys
     * @param kayttajanVastaus
     */
    public HarjoitusKuuntelija(String tiedostonimi, JLabel kysymys, JTextField kayttajanVastaus, JLabel oikeinVaarin, JFrame frame) {
        this.kayttajanVastaus = kayttajanVastaus;
        this.kysymys = kysymys;
        this.oikeinVaarin = oikeinVaarin;
        harjoituksenLogiikka = new HarjoituksenLogiikka(tiedostonimi);
        this.frame = frame;

        harjoituksenLogiikka.kysySana();
        this.kysymys.setText(harjoituksenLogiikka.getAsetettavaTeksti());
    }

    /**
     * tarkistaa annetun vastauksen ja siirtyy seuraavaan kysymykseen tai
     * lopettaa
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.kVastaus = this.kayttajanVastaus.getText();

        if (harjoituksenLogiikka.tarkistaJaEtene(kVastaus)) {
            this.oikeinVaarin.setText("oikein");
        } else {
            this.oikeinVaarin.setText("väärin");
        }
        kysymys.setText(harjoituksenLogiikka.getAsetettavaTeksti());
        kayttajanVastaus.setText("");
        if (harjoituksenLogiikka.onkoLoppu()) {
            System.out.println("loppu");
            JOptionPane.showMessageDialog(frame,
                    "Harjoitus on ohi.",
                    "Kiitos",
                    JOptionPane.PLAIN_MESSAGE);
            frame.dispose();
            //lopetus mitä tänne apua ei toimi
        }
    }
}
