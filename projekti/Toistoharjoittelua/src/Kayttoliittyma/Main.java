package Kayttoliittyma;


import Kayttoliittyma.Aloitusruutu;
import javax.swing.SwingUtilities;
/**
 * Main käynnistää ohjelman
 * @author johanna
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Aloitusruutu kayttoliittyma = new Aloitusruutu();
        SwingUtilities.invokeLater(kayttoliittyma);

    }
}
