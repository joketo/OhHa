package Kayttoliittyma;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
import Logiikka.HarjoituksenLogiikka;
import Logiikka.Sanalukija;
import Logiikka.Sanaparit;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.GridLayout;
import java.io.File;

/**
 * Tämä luokka huolehtii harjoituksen graafisesta ulkoasusta. Nappien taakse on
 * kätketty toimintaa, joka tapahtuu logiikka-pakkauksen luokissa. En tiedä
 * miten tätä voisi testata.
 *
 * @author johanna
 */
public class HarjoitusKayttoliittyma implements Runnable {

    private JFrame frame;
    private Sanalukija sanalukija;
    private Sanaparit sanaparit;
    private String tiedostonimi;

    public HarjoitusKayttoliittyma(String tiedostonnimi) {
        sanalukija = new Sanalukija(new File(tiedostonnimi)); //näitä ei välttämättä tarvita täällä ollenkaan
        sanaparit = sanalukija.luoSanaparitOlio(); //vaan vasta logiikassa
        this.tiedostonimi = tiedostonnimi;
    }

    @Override
    public void run() {
        frame = new JFrame("Harjoittelua");
        frame.setPreferredSize(new Dimension(500, 100));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {

        GridLayout layout = new GridLayout(2, 2);
        container.setLayout(layout);

        JLabel teksti = new JLabel("anna pari -- "); //erillinen kuuntelija, joka seuraa harjoituksenlogiikkaa ja antaa tähän aina sanan?
        container.add(teksti);

        JTextField vastausKentta = new JTextField();
        container.add(vastausKentta);
        JButton menikoOikein = new JButton("Seuraava");
        HarjoituksenLogiikka harjkuuntelija = new HarjoituksenLogiikka(tiedostonimi, vastausKentta);
        menikoOikein.addActionListener(harjkuuntelija);
        // tapahtumankuuntelija



        container.add(new JLabel(""));
        container.add(menikoOikein);

    }

    public JFrame getFrame() {


        return frame;
    }
}
