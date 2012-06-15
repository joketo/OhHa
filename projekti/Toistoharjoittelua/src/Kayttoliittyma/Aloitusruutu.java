package Kayttoliittyma;

/**
 * Tämä on ohjelman "aloitusikkuna", josta käyttäjä voi valita, haluaako
 * suorittaa kokeen vai vain harjoitella sanoja.
 *
 * @author johanna
 */
import Logiikka.TulosHistoria;
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
        frame.setPreferredSize(new Dimension(600, 250));

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
        JLabel aloitusTeksti = new JLabel("Tahdotko harjoitella vai suorittaa kokeen? Voit myös tarkastella tuloshistoriaa");
        JButton harjoitella = new JButton("Harjoittele");
        JButton koe = new JButton("Suorita koe");
        JButton tarkastele = new JButton("Tarkastele tuloksia");
        container.setLayout(new GridLayout(4, 1));

        HarjoitusNappiKuuntelija harjkuuntelija = new HarjoitusNappiKuuntelija(this.tiedostonimi); //harjoittele
        KoeNappiKuuntelija koekuuntelija = new KoeNappiKuuntelija(this.tiedostonimi); // suorita koe
        HistoriaNapinkuuntelija histkuuntelija = new HistoriaNapinkuuntelija();
        koe.addActionListener(koekuuntelija);
        harjoitella.addActionListener(harjkuuntelija);
        tarkastele.addActionListener(histkuuntelija);


        container.add(aloitusTeksti);
        container.add(harjoitella); // erilliset käyttöliittymät kokeelle ja harjoitukselle
        container.add(koe);
        container.add(tarkastele);
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
    /**
     * Luokka reagoi tulokset-napit painamiseen ja näyttää erilaisia koetuloksia
     */
    public class HistoriaNapinkuuntelija implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            TulosHistoria historia = new TulosHistoria();
            JOptionPane.showMessageDialog(frame,
                    "Keskiarvo: " + historia.getKeskiArvo() + "\nParas tulos: " + historia.getParasTulos()
                    + "\nKokeita suoritettu: " + historia.getTulostenKplMaara(),
                    "Koetulokset:",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }
}
