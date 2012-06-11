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
    private int oikeinMenneet = 0;
    public KokeenLogiikka(String tiedostonimi) {
        super(tiedostonimi);
    }
    public String getLopetusViesti(){
        return "Koe on ohi, pisteesi: "+oikeinMenneet+"/"+ sanojenMaaraAlussa;
    }
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
    

