/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logiikka;

import Kayttoliittyma.HarjoitusKayttoliittyma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JTextField;

/**
 *
 * @author johanna
 */
public class HarjoituksenLogiikka implements ActionListener {

    private JTextField kayttajanVastaus;
    private ArrayList<String> kysytytSanat;
    private String kVastaus;
    private int oikeinMenneet;
    private Sanalukija sanalukija;
    private Sanaparit sanaparit;
    private HashMap<String, String> sanasto;
    private ArrayList<String> kysyttavat;

    public HarjoituksenLogiikka(String tiedostonimi, JTextField kayttajanVastaus) {
        this.kayttajanVastaus = kayttajanVastaus;
        this.kysytytSanat = new ArrayList<String>();
        this.sanalukija = new Sanalukija(new File(tiedostonimi));
        this.sanaparit = sanalukija.luoSanaparitOlio();
        this.sanasto = sanaparit.getSanasto1To2();
    }

    public ArrayList<String> getKysyttavat() {
        kysyttavat = new ArrayList<String>(sanasto.keySet());
        return kysyttavat;
    }

    public void kysyUusiSana() {
        if (oikeinMenneet >= sanasto.size()) {
            return;
        } else {
            System.out.println("Anna pari: "
                    + getKysyttavat().get(kysytytSanat.size()));
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        kVastaus = this.kayttajanVastaus.getText();
        System.out.println(kVastaus);

       // if (oikeinMenneet >= sanasto.size()) {
         //   System.out.println("Harjoitus on ohi");
       // } else {
          //  if (kysytytSanat.isEmpty()) {
          //      System.out.println("testi");
          //      kysyUusiSana();
          //  } else {
          //      if (kVastaus.equals("")) { // tänne: jos OIKEIN
         //           oikeinMenneet++;
         //           kysyUusiSana();
         //       }
        //    }
        //}
    }
}
