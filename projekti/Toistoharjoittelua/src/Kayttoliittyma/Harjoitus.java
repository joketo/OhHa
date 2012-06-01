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
 *
 * @author johanna
 */
public class Harjoitus implements ActionListener {

    Sanalukija sanalukija;
    Sanaparit sanaparit;

    public Harjoitus (String tiedostonimi) {
        sanalukija = new Sanalukija(new File (tiedostonimi));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        HarjoitusKayttoliittyma kayttoliittyma = new HarjoitusKayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);
        
    }
}
