package Kayttoliittyma;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Tämä luokka huolehtii harjoituksen graafisesta ulkoasusta 
 * @author johanna
 */
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.GridLayout;

public class HarjoitusKayttoliittyma implements Runnable {

    private JFrame frame;

    public HarjoitusKayttoliittyma() {
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
        JLabel teksti = new JLabel("testaus");
        container.add(teksti);
    }

    public JFrame getFrame() {


        return frame;
    }
}
