/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kirjasto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author johanna
 */
public class TiedostonKasittelija {

  

    public static File luoTiedosto(String nimi) {
        File kahva = new File(nimi);
        try {
            kahva.createNewFile();
        } catch (IOException ex) {
            System.out.println("virhe");
           
        }
      
            return kahva;
    
    }
}
