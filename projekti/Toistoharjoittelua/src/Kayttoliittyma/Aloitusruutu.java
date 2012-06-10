package Kayttoliittyma;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 * Tämä on ohjelman "aloitusikkuna", josta käyttäjä voi valita, haluaako
 * suorittaa kokeen vai vain harjoitella sanoja. En tiedä miten tätä luokkaa
 * voisi testata. :/
 *
 * @author johanna
 */
import Logiikka.Koe;
import Logiikka.Harjoitus;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aloitusruutu implements Runnable {

    private JFrame frame;

    public Aloitusruutu() {
    }

    @Override
    public void run() {
        frame = new JFrame("Toistoharjoittelua");
        frame.setPreferredSize(new Dimension(500, 100));

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

        JButton valitseTiedosto = new JButton("valitse tiedosto");
        TiedostoKuuntelija tiedostokuuntelija = new TiedostoKuuntelija();
        valitseTiedosto.addActionListener(tiedostokuuntelija);
        String nimi = tiedostokuuntelija.getNimi();
        System.out.println(nimi);
        JLabel teksti = new JLabel("   Aloitetaanpa! Tahdotko harjoitella vai suorittaa kokeen?");
        container.add(teksti);
        JButton harjoitella = new JButton("Harjoitella");
        JButton koe = new JButton("Suorittaa kokeen");
        container.setLayout(new GridLayout(4, 1));
        Koe koekuuntelija = new Koe(nimi);
        Harjoitus harjkuuntelija = new Harjoitus(nimi, frame);
        koe.addActionListener(koekuuntelija);
        harjoitella.addActionListener(harjkuuntelija);
        container.add(valitseTiedosto);
        container.add(harjoitella); // erilliset käyttöliittymät kokeelle ja harjoitukselle
        container.add(koe);
    }

    public JFrame getFrame() {


        return frame;
    }

    private class TiedostoKuuntelija implements ActionListener {
        public String getNimi(){
            return fc.getName();
        }
        final JFileChooser fc = new JFileChooser();
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            int returnVal = fc.showSaveDialog(frame);
        }
    }
}
