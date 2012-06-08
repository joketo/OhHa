package Logiikka;

import Kayttoliittyma.HarjoitusKayttoliittyma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    /**
     * asettaa tiedostonnimen saamakseen nimeksi
     * @param tiedostonimi 
     */
    public Harjoitus(String tiedostonimi) {
        this.tiedostonnimi = tiedostonimi;
    }
/**
 * käynnistää graaffisen käyttöliittymän harjoitukselle
 * @param ae 
 */
    @Override
    public void actionPerformed(ActionEvent ae) {
        HarjoitusKayttoliittyma kayttoliittyma = new HarjoitusKayttoliittyma(tiedostonnimi);
        SwingUtilities.invokeLater(kayttoliittyma);

    }
}
