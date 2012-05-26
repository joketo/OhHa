
import javax.swing.SwingUtilities;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TiedostonLuoja tiedosto = new TiedostonLuoja();
        Aloitusruutu kayttoliittyma = new Aloitusruutu();
        SwingUtilities.invokeLater(kayttoliittyma);

    }
}
