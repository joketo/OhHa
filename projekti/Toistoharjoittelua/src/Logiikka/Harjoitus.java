package Logiikka;

import Kayttoliittyma.HarjoitusKayttoliittyma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Harjoitus-luokka reagoi Aloitusruudun napin "tahdon harjoitella"
 * painallukseen ja käynnistää harjoituskäyttöliittymän
 * En tiedä miten tätä voisi testata.
 * @author johanna
 */
public class Harjoitus implements ActionListener {

    String tiedostonnimi;
    private JFrame frame;
    /**
     * asettaa tiedostonnimen saamakseen nimeksi
     * @param tiedostonimi 
     */
    public Harjoitus(String tiedostonimi, JFrame frame) {
        this.tiedostonnimi = tiedostonimi;
        this.frame = frame;
    }
/**
 * käynnistää graaffisen käyttöliittymän harjoitukselle
 * @param ae 
 */
    @Override
    public void actionPerformed(ActionEvent ae) {
        HarjoitusKayttoliittyma kayttoliittyma = new HarjoitusKayttoliittyma(tiedostonnimi);
        SwingUtilities.invokeLater(kayttoliittyma);
       // frame.dispose();
    }
}
