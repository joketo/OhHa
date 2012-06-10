package Kayttoliittyma;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Tämä luokka huolehtii kokeen graafisesta ulkoasusta. Nappien taakse on
 * kätketty toimintaa, joka tapahtuu logiikka-pakkauksen luokissa.
 * En tiedä miten tätä voisi testata.
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
    private String tiedostonimi;

    public KokeenKayttoliittyma(String tiedostonnimi) {
        sanalukija = new Sanalukija(new File(tiedostonnimi)); // ei varmaan näitä tänne
       sanaparit = sanalukija.luoSanaparitOlio();
       this.tiedostonimi = tiedostonnimi;
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
/**
 * Luo ikkunan komponentit ja tapahtumankuuntelijan(/t)
 * @param container 
 */
    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(2, 2);
        container.setLayout(layout);

        JLabel kysymys = new JLabel("anna pari -- ");
        container.add(kysymys);

        JTextField vastausKentta = new JTextField();

        JButton vastaa = new JButton("Seuraava");
        KokeenKuuntelija koekuuntelija = new KokeenKuuntelija(tiedostonimi, kysymys, vastausKentta);
        vastaa.addActionListener(koekuuntelija);


        container.add(vastausKentta);
        container.add(new JLabel(""));
        container.add(vastaa);
    }

    public JFrame getFrame() {


        return frame;
    }
}