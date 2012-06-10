/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logiikka;

/**
 *
 * @author johanna
 */
public class HarjoituksenLogiikka extends Sanankyselija {

    public HarjoituksenLogiikka(String tiedostonimi) {
        super(tiedostonimi);
    }

    public void etene(boolean olikoOikein) {
        if (olikoOikein) {
            System.out.println("oikein");
            kysyttavat.remove(nykyinen);
        } else {
            System.out.println("väärin");
            nykyinen++;
        }

        if (kysyttavat.size() <= nykyinen) {
            nykyinen = 0;
        }

        if (kysyttavat.isEmpty()) {
            onkoLoppu = true; //jotenkin lopetus

        } else {
            kysySana();
        }
    }
}
