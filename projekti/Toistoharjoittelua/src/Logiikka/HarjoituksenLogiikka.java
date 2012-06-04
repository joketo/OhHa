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

/**
 *
 * @author johanna
 */
public class HarjoituksenLogiikka implements ActionListener {

    private ArrayList<String> kysytytSanat;
    private String vastaus;
    private int oikeinMenneet;
    private Sanalukija sanalukija;
    private Sanaparit sanaparit;
    public HarjoituksenLogiikka(String tiedostonimi) {
        this.kysytytSanat = new ArrayList<String>();
        this.sanalukija = new Sanalukija(new File(tiedostonimi));
        this.sanaparit = sanalukija.luoSanaparitOlio();
    }

    public void kysyUusiSana() {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (kysytytSanat.isEmpty()){
            kysyUusiSana();
        }else{
            if (vastaus.equals("")){ // tänne: jos OIKEIN
                oikeinMenneet++;
            }
        }
        kysyUusiSana();
    }
}
