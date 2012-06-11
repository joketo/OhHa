/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logiikka;

import static org.junit.Assert.*;
import org.junit.*;

/**
 *
 * @author johanna
 */
public class HarjoituksenLogiikkaTest {

    public HarjoituksenLogiikkaTest() {
    }
    HarjoituksenLogiikka harjoituksenLogiikka;

    @Before
    public void setUp() {
        harjoituksenLogiikka = new HarjoituksenLogiikka("testikoe");
    }

    /**
     * Test of etene method, of class HarjoituksenLogiikka.
     */
    @Test
    public void testPoistuukoSanaListastaJosVastausOnOikein() {
        System.out.println("etene");
        boolean olikoOikein = true;
        HarjoituksenLogiikka instance = harjoituksenLogiikka;
        instance.etene(olikoOikein);
        int expResult = 3;
        int result = instance.kysyttavat.size();
        assertEquals(expResult, result);
    }

    @Test
    public void testKasvaakoNykyinenJosVastausOnVaarin() {
        System.out.println("etene");
        boolean olikoOikein = false;
        HarjoituksenLogiikka instance = harjoituksenLogiikka;
        instance.etene(olikoOikein);
        int expResult = 1;
        int result = instance.nykyinen;
        assertEquals(expResult, result);
    }

    @Test
    public void testNollautuukoNykyinenJosListaMeneeYmpari() {
        System.out.println("etene");
        boolean olikoOikein = false;
        HarjoituksenLogiikka instance = harjoituksenLogiikka;
        instance.etene(olikoOikein);
        instance.etene(olikoOikein);
        instance.etene(olikoOikein);
        instance.etene(olikoOikein);
        int expResult = 0;
        int result = instance.nykyinen;
        assertEquals(expResult, result);
    }
}
