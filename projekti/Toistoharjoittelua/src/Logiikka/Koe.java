package Logiikka;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Koe-luokka reagoi Aloitusruudun napin "tahdon suorittaa kokeen" painallukseen
 * ja käynnistää koekäyttöliittymän
 * En tiedä miten tätä voisi testata.
 * @author johanna
 */
import Kayttoliittyma.KokeenKayttoliittyma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

public class Koe implements ActionListener {

    String tiedostonimi;
/**
 * asettaa tiedostonimensä saamansa tiedostonimen mukaiseksi
 * @param tiedostonnimi 
 */
    public Koe(String tiedostonnimi) {
        this.tiedostonimi = tiedostonnimi;
    }
/**
 * käynnistää graafisen käyttöliittymän kokeelle
 * @param ae 
 */
    @Override
    public void actionPerformed(ActionEvent ae) {
        KokeenKayttoliittyma kayttoliittyma = new KokeenKayttoliittyma(tiedostonimi);
        SwingUtilities.invokeLater(kayttoliittyma);
    }
}
