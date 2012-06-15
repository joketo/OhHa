/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

/**
 * pyytää käyttäjältä tiedoston graafisen käyttöliittymän kautta
 * @author johanna
 */
public class TiedostonKasittelija extends JPanel
        implements ActionListener {

    static private final String newline = "\n";
    static JFrame frame;
    String tiedostoNimi;
    JButton avaaTiedosto;
    JTextArea log;
    JFileChooser fc;

    public TiedostonKasittelija() {
        super(new BorderLayout());
        log = new JTextArea(5, 20);
        log.setMargin(new Insets(5, 5, 5, 5));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);

        //luodaan tiedostonvalitsin
        fc = new JFileChooser();

        avaaTiedosto = new JButton("Avaa tiedosto...");
        avaaTiedosto.addActionListener(this);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(avaaTiedosto);
        add(buttonPanel, BorderLayout.PAGE_START);
        add(logScrollPane, BorderLayout.CENTER);
    }
/**
 * käsittelee napin painamisesta tapahtuvat asiat. Ottaa tiedostonimen talteen ja 
 * käynnistää Aloitusruudun
 * @param e 
 */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == avaaTiedosto) {
            int palautusArvo = fc.showOpenDialog(TiedostonKasittelija.this);

            if (palautusArvo == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                log.append("Avataan: " + file.getName() + "." + newline);
                this.tiedostoNimi = file.getName();
                System.out.println(file.getName());
                Aloitusruutu kayttoliittyma = new Aloitusruutu(this.tiedostoNimi);
                SwingUtilities.invokeLater(kayttoliittyma);
                frame.dispose();
            } else {
                log.append("Tiedoston avaus peruutettu." + newline);
            }
            log.setCaretPosition(log.getDocument().getLength());
            
            
        }
    }
    /**
     * luo ikkunan, lisää siihen jutut ja asettaa ikkunan näkyväksi
     */
    public static void createAndShowGUI() {

        frame = new JFrame("Anna tiedosto");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new TiedostonKasittelija());

        frame.pack();
        frame.setVisible(true);
    }
}
