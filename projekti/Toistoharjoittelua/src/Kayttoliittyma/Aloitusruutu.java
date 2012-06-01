package Kayttoliittyma;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Tämä on ohjelman "aloitusikkuna", josta käyttäjä voi valita, haluaako suorittaa 
 * kokeen vai vain harjoitella sanoja.
 * @author johanna
 */

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.GridLayout;
   

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

    private void luoKomponentit(Container container) {
        JLabel tiedosto = new JLabel("Anna tiedosto");
        String nimi = "kemialliset merkit";
        JLabel teksti = new JLabel("   Aloitetaanpa! Tahdotko harjoitella vai suorittaa kokeen?");
        container.add(teksti);
        JButton harjoitella = new JButton("Harjoitella");
        JButton koe = new JButton("Suorittaa kokeen");
        container.setLayout(new GridLayout(3,1));
        Koe koekuuntelija = new Koe(nimi);
        Harjoitus harjkuuntelija = new Harjoitus(nimi);
        koe.addActionListener(koekuuntelija);
        harjoitella.addActionListener(harjkuuntelija);
        container.add(harjoitella); // erilliset käyttöliittymät kokeelle ja harjoitukselle?
        container.add(koe);
    }

    public JFrame getFrame() {
        
        
        return frame;
    }
}

