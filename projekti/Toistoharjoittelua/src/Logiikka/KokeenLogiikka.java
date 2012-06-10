/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logiikka;

/**
 *
 * @author johanna
 */
public class KokeenLogiikka extends Sanankyselija{
    public KokeenLogiikka(String tiedostonimi) {
        super(tiedostonimi);
    }

    public void etene(boolean olikoOikein) {
        if (olikoOikein) {
            System.out.println("oikein");
            kysyttavat.remove(nykyinen);
        } else {
            System.out.println("väärin");
            kysyttavat.remove(nykyinen);
        }

       // if (kysyttavat.size() <= nykyinen) {
       //     nykyinen = 0;
       // }

        if (kysyttavat.isEmpty()) {
            onkoLoppu = true; //jotenkin lopetus

        }
        kysySana();
    }
}
    

