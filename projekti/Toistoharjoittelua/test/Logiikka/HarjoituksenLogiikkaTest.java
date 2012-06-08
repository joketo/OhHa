/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logiikka;

import Kayttoliittyma.HarjoitusKuuntelija;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author johanna
 */
public class HarjoituksenLogiikkaTest {
    Sanaparit sanaparit;
    HarjoitusKuuntelija logiikka;
    private JLabel kysymys;
    private JTextField kayttajanVastaus;
    HashMap<String, String> sanasto1To2;
    
    @Before
    public void setUp() {
        sanasto1To2 = new HashMap<String, String>();
        HashMap<String, String> sanasto2To1 = new HashMap<String, String>();
        sanasto1To2.put("kala", "a fish");
        sanasto1To2.put("kukka", "a flower");
        sanasto1To2.put("kitara", "a guitar");
        sanasto1To2.put("leipä", "bread");
        sanasto2To1.put("a fish", "kala");
        sanasto2To1.put("a flower", "kukka");
        sanasto2To1.put("a guitar", "kitara");
        sanasto2To1.put("bread", "leipä");
        kysymys = new JLabel();
        kayttajanVastaus = new JTextField();
        kysymys.setText("testaus");
        kayttajanVastaus.setText("toinentest");
        sanaparit = new Sanaparit(sanasto1To2, sanasto2To1);
        logiikka = new HarjoitusKuuntelija("testikoe", kysymys, kayttajanVastaus);
    }
    
    

    /**
     * Test of getSanaparit method, of class HarjoitusKuuntelija.
     */
    @Test
    public void testGetSanaparit() {
        System.out.println("getSanaparit");
        HarjoitusKuuntelija instance = logiikka;
        HashMap<String, String> expResult = sanasto1To2;
        HashMap<String, String> result = instance.getSanaparit().getSanasto1To2();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getKysyttavat method, of class HarjoitusKuuntelija.
     */
    @Test
    public void testGetKysyttavat() {
        System.out.println("getKysyttavat");
        HarjoitusKuuntelija instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getKysyttavat();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNykyinen method, of class HarjoitusKuuntelija.
     */
    @Test
    public void testGetNykyinen() {
        System.out.println("getNykyinen");
        HarjoitusKuuntelija instance = logiikka;
        int expResult = 0;
        int result = instance.getNykyinen();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of kysySana method, of class HarjoitusKuuntelija.
     */
    @Test
    public void testKysySana() {
        System.out.println("kysySana");
        HarjoitusKuuntelija instance = logiikka;
        instance.kysySana();
        assertEquals(kysymys.getText(), "leipä");
    }

    /**
     * Test of tarkista method, of class HarjoitusKuuntelija.
     */
    @Test
    public void testTarkista() {
        System.out.println("tarkista");
        String vastaus = "lol";
        HarjoitusKuuntelija instance = logiikka;
        boolean expResult = false;
        boolean result = instance.tarkista(vastaus);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testTarkista2() {
        System.out.println("tarkista");
        String vastaus = "bread";
        HarjoitusKuuntelija instance = logiikka;
        boolean expResult = true;
        boolean result = instance.tarkista(vastaus);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of actionPerformed method, of class HarjoitusKuuntelija.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent ae = null;
        HarjoitusKuuntelija instance = null;
        instance.actionPerformed(ae);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
