
import Kirjasto.TiedostonKasittelija;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author johanna
 */
public class Koe {

    Sanalukija sanalukija;
    Scanner lukija;
    Scanner nappaimisto = new Scanner(System.in);
    Sanaparit sanaparit;

    public Koe(String tiedostonnimi) {
       // TiedostonKasittelija.luoTiedosto(tiedostonnimi);
        sanalukija = new Sanalukija(new File (tiedostonnimi));
    }

    public void run() {
        KokeenKayttoliittyma kayttoliittyma = new KokeenKayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);
        //sanaparit = sanalukija.luoSanaparitOlio();

        //while (!sanaparit.sanasto1To2.isEmpty()) {
        //  for (String i : sanaparit.sanasto1To2.keySet()) {
        //    System.out.println(i);
        //  String vastaus = this.nappaimisto.nextLine();
        //if (sanaparit.onkoParitSanasto1To2(i, vastaus)) {
        //  System.out.println("oikein!");
        // } else {
        //   System.out.println("väärin...");
        //}
        //}
        //   }

    }
}
