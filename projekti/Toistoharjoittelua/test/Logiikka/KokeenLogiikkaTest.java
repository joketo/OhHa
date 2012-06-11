/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logiikka;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author johanna
 */
public class KokeenLogiikkaTest {
    
    public KokeenLogiikkaTest() {
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
     * Test of getLopetusViesti method, of class KokeenLogiikka.
     */
    @Test
    public void testGetLopetusViesti() {
        System.out.println("getLopetusViesti");
        KokeenLogiikka instance = null;
        String expResult = "";
        String result = instance.getLopetusViesti();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of etene method, of class KokeenLogiikka.
     */
    @Test
    public void testEtene() {
        System.out.println("etene");
        boolean olikoOikein = false;
        KokeenLogiikka instance = null;
        instance.etene(olikoOikein);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
