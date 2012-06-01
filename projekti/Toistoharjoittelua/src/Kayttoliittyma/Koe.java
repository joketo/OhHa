package Kayttoliittyma;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author johanna
 */
import Logiikka.Sanalukija;
import Logiikka.Sanaparit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.SwingUtilities;
public class Koe implements ActionListener{
    
    Sanalukija sanalukija;
    Sanaparit sanaparit;
    public Koe(String tiedostonnimi){
        sanalukija = new Sanalukija(new File (tiedostonnimi));
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        KokeenKayttoliittyma kayttoliittyma = new KokeenKayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);
    }
}
