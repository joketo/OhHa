package Kayttoliittyma;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Tämä luokka huolehtii kokeen graafisesta ulkoasusta. Nappien taakse on
 * kätketty toimintaa, joka tapahtuu logiikka-pakkauksen luokissa.
 *
 * @author johanna
 */
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.GridLayout;
import Logiikka.Sanalukija;
import Logiikka.Sanaparit;
import java.io.File;

public class KokeenKayttoliittyma implements Runnable {

    private JFrame frame;
    private Sanalukija sanalukija;
    private Sanaparit sanaparit;

    public KokeenKayttoliittyma(String tiedostonnimi) {
        sanalukija = new Sanalukija(new File(tiedostonnimi)); // ei varmaan näitä tänne
       // sanaparit = sanalukija.luoSanaparitOlio();
    }

    @Override
    public void run() {
        frame = new JFrame("Koe");
        frame.setPreferredSize(new Dimension(500, 100));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(2, 2);
        container.setLayout(layout);

        JLabel teksti = new JLabel("anna pari -- ");
        container.add(teksti);

        JTextField vastausKentta = new JTextField();

        JButton menikoOikein = new JButton("Seuraava");
        // tapahtumankuuntelija


        container.add(vastausKentta);
        container.add(new JLabel(""));
        container.add(menikoOikein);
    }

    public JFrame getFrame() {


        return frame;
    }
}