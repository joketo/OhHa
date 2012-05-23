/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author johanna
 */
public class SanaparitTest {
    
    public SanaparitTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of onkoParitSanasto1To2 method, of class Sanaparit.
     */
    @Test
    public void testOnkoParitSanasto1To2() {
        System.out.println("onkoParitSanasto1To2");
        String eka = "";
        String toka = "";
        Sanaparit instance = null;
        boolean expResult = false;
        boolean result = instance.onkoParitSanasto1To2(eka, toka);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onkoParitSanasto2To1 method, of class Sanaparit.
     */
    @Test
    public void testOnkoParitSanasto2To1() {
        System.out.println("onkoParitSanasto2To1");
        String eka = "";
        String toka = "";
        Sanaparit instance = null;
        boolean expResult = false;
        boolean result = instance.onkoParitSanasto2To1(eka, toka);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPariSanasto1To2 method, of class Sanaparit.
     */
    @Test
    public void testGetPariSanasto1To2() {
        System.out.println("getPariSanasto1To2");
        String sana = "";
        Sanaparit instance = null;
        String expResult = "";
        String result = instance.getPariSanasto1To2(sana);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPariSanasto2To1 method, of class Sanaparit.
     */
    @Test
    public void testGetPariSanasto2To1() {
        System.out.println("getPariSanasto2To1");
        String sana = "";
        Sanaparit instance = null;
        String expResult = "";
        String result = instance.getPariSanasto2To1(sana);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
