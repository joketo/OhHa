
import java.io.File;
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author johanna
 */
public class TiedostonLuoja { //muut ehkä perii tämän luokan?
    File kahva = new File("kemialliset merkit");
    public TiedostonLuoja(){
        try {
            kahva.createNewFile();   //tiedosto luodaan tässä, oma metodi sille?
        } catch (IOException ex) {
            System.out.println("Ei löydy");
            
        }
    }
    public File getFile(){
        return kahva;  //mutta muualla tiedoston käsittely ei onnistu
    }
    
  
}
