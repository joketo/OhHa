package Kayttoliittyma;


import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

/**
 * Tämä luokka huolehtii harjoituksen graafisesta ulkoasusta. Nappien taakse
 * kätkeytyy toimintaa, joka tapahtuu logiikka-pakkauksen luokissa.
 *
 * @author johanna
 */
public class HarjoitusKayttoliittyma implements Runnable {

    private JFrame frame;
    private String tiedostonimi;

    public HarjoitusKayttoliittyma(String tiedostonnimi) {
        this.tiedostonimi = tiedostonnimi;
    }

    @Override
    public void run() {
        frame = new JFrame("Harjoittelua");
        frame.setPreferredSize(new Dimension(250, 300));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
    /**
     * Luo ikkunan komponentit ja harjoituksenkuuntelijan, joka huolehtii ohjelman kulusta
     * @param container 
     */

    private void luoKomponentit(Container container) {

        GridLayout layout = new GridLayout(4, 1);
        container.setLayout(layout);
        JLabel kysymys = new JLabel();
        JLabel oikeinVaiVaarin = new JLabel();
        JTextField vastausKentta = new JTextField();
        JButton vastaa = new JButton("Seuraava");
        HarjoitusKuuntelija harjkuuntelija = new HarjoitusKuuntelija(tiedostonimi, kysymys, vastausKentta, oikeinVaiVaarin, frame);
        vastaa.addActionListener(harjkuuntelija);
        // tapahtumankuuntelija
        container.add(kysymys);
        container.add(vastausKentta);
        container.add(vastaa);
        container.add(oikeinVaiVaarin);
        

    }

    public JFrame getFrame() {
        return frame;
    }
}
