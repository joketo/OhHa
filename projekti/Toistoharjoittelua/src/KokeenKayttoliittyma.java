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

public class KokeenKayttoliittyma implements Runnable {

    private JFrame frame;

    public KokeenKayttoliittyma() {
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
        JLabel teksti = new JLabel("Saat nyt suoritettavaksesi setin sanapareja.");
        container.add(teksti);
    }

    public JFrame getFrame() {


        return frame;
    }
}