
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    TiedostonLuoja tiedostonLuoja = new TiedostonLuoja(); 
    File kahva = tiedostonLuoja.getFile();
    Scanner lukija;
    Scanner nappaimisto = new Scanner(System.in);
    Sanaparit sanaparit;

    public Koe() {
        try {
            lukija = new Scanner(kahva);//tiedostonluoja voisi käsitellä File-olion omassa luokassaan?
            sanalukija = new Sanalukija(kahva);
        } catch (FileNotFoundException ex) {
            System.out.println("Tiedostoa ei löydy");
        }
    }

    public void run() {
        System.out.println("Saat nyt tehtäväksesi satunnaisen setin kysymyksiä.");
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
