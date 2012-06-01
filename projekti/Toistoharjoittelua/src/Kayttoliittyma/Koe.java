package Kayttoliittyma;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Koe-luokka reagoi Aloitusruudun napin "tahdon suorittaa kokeen" painallukseen
 * ja käynnistää koekäyttöliittymän
 *
 * @author johanna
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.SwingUtilities;

public class Koe implements ActionListener {

    String tiedostonimi;

    public Koe(String tiedostonnimi) {
        this.tiedostonimi = tiedostonnimi;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        KokeenKayttoliittyma kayttoliittyma = new KokeenKayttoliittyma(tiedostonimi);
        SwingUtilities.invokeLater(kayttoliittyma);
    }
}
