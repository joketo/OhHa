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
 *
 * @author johanna
 */
public class TiedostonLukija extends JPanel
        implements ActionListener {

    static private final String newline = "\n";
    static JFrame frame;
    String tiedostoNimi;
    JButton avaaTiedosto;
    JTextArea log;
    JFileChooser fc;

    public TiedostonLukija() {
        super(new BorderLayout());

        //Create the log first, because the action listeners
        //need to refer to it.
        log = new JTextArea(5, 20);
        log.setMargin(new Insets(5, 5, 5, 5));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);

        //Create a file chooser
        fc = new JFileChooser();

        avaaTiedosto = new JButton("Avaa tiedosto...");
        avaaTiedosto.addActionListener(this);
        JPanel buttonPanel = new JPanel(); //use FlowLayout
        buttonPanel.add(avaaTiedosto);
        //Add the buttons and the log to this panel.
        add(buttonPanel, BorderLayout.PAGE_START);
        add(logScrollPane, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {

        //Handle open button action.
        if (e.getSource() == avaaTiedosto) {
            int returnVal = fc.showOpenDialog(TiedostonLukija.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //This is where a real application would open the file.
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
    public String annaTiedostoNimi(){
        return this.tiedostoNimi;
    }
    public static void createAndShowGUI() {
        //Create and set up the window.
        frame = new JFrame("Anna tiedosto");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new TiedostonLukija());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
