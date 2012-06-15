package Kayttoliittyma;


import javax.swing.SwingUtilities;
import javax.swing.UIManager;
/**
 * Main käynnistää ohjelman
 * @author johanna
 */
public class Main {

    /**
     * käynnistää graafisen käyttöliittymän
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String tiedostonimi;
        final TiedostonLukija tiedostonLukija = new TiedostonLukija();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE); 
                tiedostonLukija.createAndShowGUI();
            }
        });
        tiedostonimi = tiedostonLukija.tiedostoNimi;
        System.out.println(tiedostonimi);
      //  if(tiedostonimi != null){
      //  Aloitusruutu kayttoliittyma = new Aloitusruutu();
       // SwingUtilities.invokeLater(kayttoliittyma);
      //  }
      //  else{
      //      System.out.println("pieleen meni");
     //   }
    }
}
