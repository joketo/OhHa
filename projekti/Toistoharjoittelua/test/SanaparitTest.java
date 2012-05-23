/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashMap;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author johanna
 */
public class SanaparitTest {

    Sanaparit sanaparit;

    @Before
    public void setUp() {
        HashMap<String, String> sanasto1To2 = new HashMap<String, String>();
        HashMap<String, String> sanasto2To1 = new HashMap<String, String>();
        sanasto1To2.put("kala", "a fish");
        sanasto1To2.put("kukka", "a flower");
        sanasto1To2.put("kitara", "a guitar");
        sanasto1To2.put("leipä", "bread");
        sanasto2To1.put("a fish", "kala");
        sanasto2To1.put("a flower", "kukka");
        sanasto2To1.put("a guitar", "kitara");
        sanasto2To1.put("bread", "leipä");
        sanaparit = new Sanaparit(sanasto1To2, sanasto2To1);
    }

    /**
     * Test of onkoParitSanasto1To2 method, of class Sanaparit.
     */
    @Test
    public void testOnkoParitSanasto1To2() {
        System.out.println("onkoParitSanasto1To2");
        String eka = "kala";
        String toka = "a fish";
        Sanaparit instance = sanaparit;
        boolean expResult = true;
        boolean result = instance.onkoParitSanasto1To2(eka, toka);
        assertEquals(expResult, result);
    }

    @Test
    public void testOnkoParitSanasto1To2fail() {
        System.out.println("onkoParitSanasto1To2");
        String eka = "kala";
        String toka = "koira";
        Sanaparit instance = sanaparit;
        boolean expResult = false;
        boolean result = instance.onkoParitSanasto1To2(eka, toka);
        assertEquals(expResult, result);
    }

    /**
     * Test of onkoParitSanasto2To1 method, of class Sanaparit.
     */
    @Test
    public void testOnkoParitSanasto2To1() {
        System.out.println("onkoParitSanasto2To1");
        String eka = "a flower";
        String toka = "kukka";
        Sanaparit instance = sanaparit;
        boolean expResult = true;
        boolean result = instance.onkoParitSanasto2To1(eka, toka);
        assertEquals(expResult, result);

    }
    @Test
    public void testOnkoParitSanasto2To1fail() {
        System.out.println("onkoParitSanasto2To1");
        String eka = "a flower";
        String toka = "jaa";
        Sanaparit instance = sanaparit;
        boolean expResult = false;
        boolean result = instance.onkoParitSanasto2To1(eka, toka);
        assertEquals(expResult, result);

    }

    /**
     * Test of getPariSanasto1To2 method, of class Sanaparit.
     */
    @Test
    public void testGetPariSanasto1To2() {
        System.out.println("getPariSanasto1To2");
        String sana = "kukka";
        Sanaparit instance = sanaparit;
        String expResult = "a flower";
        String result = instance.getPariSanasto1To2(sana);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getPariSanasto2To1 method, of class Sanaparit.
     */
    @Test
    public void testGetPariSanasto2To1() {
        System.out.println("getPariSanasto2To1");
        String sana = "a flower";
        Sanaparit instance = sanaparit;
        String expResult = "kukka";
        String result = instance.getPariSanasto2To1(sana);
        assertEquals(expResult, result);
        
    }
}
