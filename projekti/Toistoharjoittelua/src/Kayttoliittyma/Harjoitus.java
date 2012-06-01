package Kayttoliittyma;

import Logiikka.Sanalukija;
import Logiikka.Sanaparit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.SwingUtilities;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Harjoitus-luokka reagoi Aloitusruudun napin "tahdon harjoitella"
 * painallukseen ja käynnistää harjoituskäyttöliittymän
 *
 * @author johanna
 */
public class Harjoitus implements ActionListener {

    String tiedostonnimi;

    public Harjoitus(String tiedostonimi) {

        this.tiedostonnimi = tiedostonimi;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        HarjoitusKayttoliittyma kayttoliittyma = new HarjoitusKayttoliittyma(tiedostonnimi);
        SwingUtilities.invokeLater(kayttoliittyma);

    }
}
