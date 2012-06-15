package Kayttoliittyma;


import Logiikka.Sanalukija;
import Logiikka.Sanaparit;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import javax.swing.*;
/**
 * Tämä luokka huolehtii kokeen graafisesta ulkoasusta. Nappien taakse kätkeytyy
 * toimintaa, joka tapahtuu logiikka-pakkauksen luokissa.
 * @author johanna
 */
public class KokeenKayttoliittyma implements Runnable {

    private JFrame frame;
    private Sanalukija sanalukija;
    private Sanaparit sanaparit;
    private String tiedostonimi;

    public KokeenKayttoliittyma(String tiedostonnimi) {
        sanalukija = new Sanalukija(new File(tiedostonnimi)); // ei varmaan näitä tänne
       sanaparit = sanalukija.luoSanaparitOlio();
       this.tiedostonimi = tiedostonnimi;
    }

    @Override
    public void run() {
        frame = new JFrame("Koe");
        frame.setPreferredSize(new Dimension(250, 300));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
/**
 * Luo ikkunan komponentit ja tapahtumankuuntelijan(/t)
 * @param container 
 */
    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(3, 1);
        container.setLayout(layout);

        JLabel kysymys = new JLabel();
        container.add(kysymys);

        JTextField vastausKentta = new JTextField();

        JButton vastaa = new JButton("Seuraava");
        KokeenKuuntelija koekuuntelija = new KokeenKuuntelija(tiedostonimi, kysymys, vastausKentta, frame);
        vastaa.addActionListener(koekuuntelija);


        container.add(vastausKentta);
        container.add(vastaa);
    }

    public JFrame getFrame() {


        return frame;
    }
}