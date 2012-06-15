/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logiikka;

import java.io.File;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author johanna
 */
public class SanalukijaTest {

    private HashMap<String, String> sanasto1To2 = new HashMap<String, String>();
    private HashMap<String, String> sanasto2To1 = new HashMap<String, String>();
    private Sanalukija sananlukija;

    @Before
    public void setUp() {

        sanasto1To2.put("kala", "a fish");
        sanasto1To2.put("kukka", "a flower");
        sanasto1To2.put("kitara", "a guitar");
        sanasto1To2.put("leipä", "bread");
        sanasto2To1.put("a fish", "kala");
        sanasto2To1.put("a flower", "kukka");
        sanasto2To1.put("a guitar", "kitara");
        sanasto2To1.put("bread", "leipä");
        sananlukija = new Sanalukija(new File("testikoe.koe"));
    }

    /**
     * Test of luoSanaparitOlio method, of class Sanalukija.
     */
    @Test
    public void testLuoSanaparitOlio() {
        System.out.println("luoSanaparitOlio");
        Sanalukija instance = sananlukija;
        HashMap<String, String> expResult = sanasto1To2;
        HashMap<String, String> result = instance.luoSanaparitOlio().getSanasto1To2();
        assertEquals(expResult, result);

    }
    
        @Test
    public void testLuoSanaparitOlio2() {
        System.out.println("luoSanaparitOlio");
        Sanalukija instance = sananlukija;
        HashMap<String, String> expResult = sanasto1To2;
        HashMap<String, String> result = instance.luoSanaparitOlio().getSanasto2To1();
        assertEquals(expResult, result);

    }
}
