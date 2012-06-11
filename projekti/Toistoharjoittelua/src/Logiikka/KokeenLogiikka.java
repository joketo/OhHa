
package Logiikka;

/**
 * Logiikka perii Sanankyselija-luokan. Kokeen logiikka tapahtuu täällä.
 * @author johanna
 */
public class KokeenLogiikka extends Sanankyselija{
    private int oikeinMenneet = 0;
    public KokeenLogiikka(String tiedostonimi) {
        super(tiedostonimi);
    }
    /**
     * Kokeen päätyttyä näytettävä lopetusviesti
     * @return 
     */
    public String getLopetusViesti(){
        return "Koe on ohi, pisteesi: "+oikeinMenneet+"/"+ sanojenMaaraAlussa;
    }
    /**
     * poistaa sanan kysyttävien joukosta, kun se on kerran kysytty. tarkistaa onko kaikki sanat kysytty
     * @param olikoOikein 
     */
    @Override
    public void etene(boolean olikoOikein) {
        if (olikoOikein) {
            oikeinMenneet++;
            kysyttavat.remove(nykyinen);
        } else {
            System.out.println("väärin");
            kysyttavat.remove(nykyinen);
        }

        if (kysyttavat.isEmpty()) {
            System.out.println("Koe on ohi, pisteesi: "+oikeinMenneet+"/"+ sanojenMaaraAlussa);
            onkoLoppu = true; //jotenkin lopetus

        }else{
        kysySana();
        }
    }
}
    

