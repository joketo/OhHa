package Kayttoliittyma;

/**
 * Tämä on ohjelman "aloitusikkuna", josta käyttäjä voi valita, haluaako
 * suorittaa kokeen vai vain harjoitella sanoja.
 *
 * @author johanna
 */
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Aloitusruutu implements Runnable {

    private JFrame frame;
    String tiedostonimi;

    public Aloitusruutu(String tiedostonimi) {
        this.tiedostonimi = tiedostonimi;
    }

    @Override
    public void run() {
        frame = new JFrame("Toistoharjoittelua");
        frame.setPreferredSize(new Dimension(400, 250));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Luo aloitusruudun komponentit ja tapahtumankuuntelijat koe- ja
     * harjoitusnapeille
     *
     * @param container
     */
    private void luoKomponentit(Container container) {
        // final JFileChooser fc = new JFileChooser(); //tänne rakennetaan tiedostonvalintasysteemiä
        // int returnVal = fc.showOpenDialog(aComponent);

        //JLabel tiedosto = new JLabel("Anna tiedosto");
         //String nimi = "testikoe";
        JLabel aloitusTeksti = new JLabel("              Tahdotko harjoitella vai suorittaa kokeen?");
        JButton harjoitella = new JButton("Harjoittele");
        JButton koe = new JButton("Suorita koe");
        container.setLayout(new GridLayout(3, 1));

        HarjoitusNappiKuuntelija harjkuuntelija = new HarjoitusNappiKuuntelija(this.tiedostonimi); //harjoittele
        KoeNappiKuuntelija koekuuntelija = new KoeNappiKuuntelija(this.tiedostonimi); // suorita koe
        koe.addActionListener(koekuuntelija);
        harjoitella.addActionListener(harjkuuntelija);


        container.add(aloitusTeksti);
        container.add(harjoitella); // erilliset käyttöliittymät kokeelle ja harjoitukselle
        container.add(koe);
    }

    public JFrame getFrame() {

        return frame;
    }

    /**
     * KoeNappiKuuntelija-luokka reagoi Aloitusruudun napin "tahdon suorittaa
     * kokeen" painallukseen ja käynnistää koekäyttöliittymän
     *
     * @author johanna
     */
    public class KoeNappiKuuntelija implements ActionListener {

        String tiedostonimi;

        /**
         * asettaa tiedostonimen saamansa tiedostonimen mukaiseksi
         *
         * @param tiedostonnimi
         */
        public KoeNappiKuuntelija(String tiedostonnimi) {
            this.tiedostonimi = tiedostonnimi;
        }

        /**
         * käynnistää graafisen käyttöliittymän kokeelle
         *
         * @param ae
         */
        @Override
        public void actionPerformed(ActionEvent ae) {
            KokeenKayttoliittyma kayttoliittyma = new KokeenKayttoliittyma(tiedostonimi);
            SwingUtilities.invokeLater(kayttoliittyma);
        }
    }

    /**
     * luokka reagoi Aloitusruudun napin "tahdon harjoitella" painallukseen ja
     * käynnistää harjoituskäyttöliittymän
     *
     * @author johanna
     */
    public class HarjoitusNappiKuuntelija implements ActionListener {

        String tiedostonnimi;

        /**
         * asettaa tiedostonnimen saamakseen nimeksi
         *
         * @param tiedostonimi
         */
        public HarjoitusNappiKuuntelija(String tiedostonimi) {
            this.tiedostonnimi = tiedostonimi;
        }

        /**
         * käynnistää graafisen käyttöliittymän harjoitukselle
         *
         * @param ae
         */
        @Override
        public void actionPerformed(ActionEvent ae) {
            HarjoitusKayttoliittyma kayttoliittyma = new HarjoitusKayttoliittyma(tiedostonnimi);
            SwingUtilities.invokeLater(kayttoliittyma);
        }
    }
}
