/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
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
   

public class Kayttoliittyma implements Runnable {

    private JFrame frame;

    public Kayttoliittyma() {
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
        JLabel teksti = new JLabel("   Aloitetaanpa! Tahdotko harjoitella vai suorittaa kokeen?");
        container.add(teksti);
        JButton harjoitella = new JButton("Harjoitella");
        JButton koe = new JButton("Suorittaa kokeen");
        container.setLayout(new GridLayout(3,1));
        Tapahtumankuuntelija kuuntelija = new Tapahtumankuuntelija();
        koe.addActionListener(kuuntelija);
        container.add(harjoitella);
        container.add(koe);
    }

    public JFrame getFrame() {
        return frame;
    }
}

