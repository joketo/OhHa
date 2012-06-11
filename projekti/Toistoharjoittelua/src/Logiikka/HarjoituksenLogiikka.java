
package Logiikka;

/**
 * perii sanankyselija-luokan. toteuttaa etene-metodin
 * @author johanna
 */
public class HarjoituksenLogiikka extends Sanankyselija {

    public HarjoituksenLogiikka(String tiedostonimi) {
        super(tiedostonimi);
    }
    /**
     * tarkistaa, oliko vastaus oikein ja toimii sen mukaan. katsoo meneekö lista ympäri
     * ja onko kaikki sanat jo kysytty ja niihin vastattu oikein
     * @param olikoOikein 
     */
    
    @Override
    public void etene(boolean olikoOikein) {
        if (olikoOikein) {
            System.out.println("oikein"); //testausta
            kysyttavat.remove(nykyinen);
        } else {
            System.out.println("väärin"); //testausta
            nykyinen++;
        }

        if (kysyttavat.size() <= nykyinen) { 
            nykyinen = 0;
        }

        if (kysyttavat.isEmpty()) {
            onkoLoppu = true; //lopetus

        } else {
            kysySana();
        }
    }
}
