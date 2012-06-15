package Logiikka;

/**
 * Logiikka perii Sanankyselija-luokan. Kokeen logiikka tapahtuu täällä.
 *
 * @author johanna
 */
public class KokeenLogiikka extends Sanankyselija {

    public Integer oikeinMenneet = 0;
    TulosHistoria historia = new TulosHistoria();

    public KokeenLogiikka(String tiedostonimi) {
        super(tiedostonimi);
    }

    /**
     * Kokeen päätyttyä näytettävä lopetusviesti
     *
     * @return
     */
    public String getLopetusViesti() {
        return "Koe on ohi, pisteesi: " + oikeinMenneet + "/" + sanojenMaaraAlussa;
    }

    /**
     * poistaa sanan kysyttävien joukosta, kun se on kerran kysytty. tarkistaa
     * onko kaikki sanat kysytty
     *
     * @param olikoOikein
     */
    @Override
    public void etene(boolean olikoOikein) {
        if (olikoOikein) {
            oikeinMenneet++;
        }
        kysyttavat.remove(nykyinen);

        if (kysyttavat.isEmpty()) {
            System.out.println("Koe on ohi, pisteesi: " + oikeinMenneet + "/" + sanojenMaaraAlussa);
            historia.lisaaTulos(oikeinMenneet);
            onkoLoppu = true; //lopetus

        } else {
            kysySana();
        }
    }
}
