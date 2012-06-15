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
    KokeenLogiikka kokeenLogiikka;
    @Before
    public void setUp() {
        kokeenLogiikka = new KokeenLogiikka("testikoe.koe");
    }
    
 
    /**
     * Test of getLopetusViesti method, of class KokeenLogiikka.
     */
    @Test
    public void testGetLopetusViesti() {
        System.out.println("getLopetusViesti");
        KokeenLogiikka instance = kokeenLogiikka;
        String expResult = "Koe on ohi, pisteesi: "+kokeenLogiikka.oikeinMenneet+"/"+ kokeenLogiikka.sanojenMaaraAlussa;
        String result = instance.getLopetusViesti();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of etene method, of class KokeenLogiikka.
     */
    @Test
    public void testKasvaakoOikeinMenneetJosOikein() {
        System.out.println("etene");
        boolean olikoOikein = true;
        KokeenLogiikka instance = kokeenLogiikka;
        instance.etene(olikoOikein);
        int expResult = 1;
        int result = instance.oikeinMenneet;
        assertEquals(expResult, result);
    }
    
    /**
     * testataan etene-metodia
     */
    @Test
    public void testPoistuukoSanaListastaKunKysytty(){
        System.out.println("etene");
        boolean olikoOikein = false;
        KokeenLogiikka instance = kokeenLogiikka;
        instance.etene(olikoOikein);
        int expResult = 3;
        int result = kokeenLogiikka.kysyttavat.size();
        assertEquals(expResult, result);
    }
    
    /**
     * testataan etene-metodia
     */
    @Test
    public void testMuuttuukoOnkoLoppuArvoJosLoppu(){
        System.out.println("etene");
        boolean olikoOikein = false;
        KokeenLogiikka instance = kokeenLogiikka;
       // while(kokeenLogiikka.kysyttavat.size() >= -1){
       //     instance.etene(olikoOikein);
       // }
        instance.etene(olikoOikein);
        instance.etene(olikoOikein);
        instance.etene(olikoOikein);
        instance.etene(olikoOikein);
        boolean expResult = true;
        boolean result = instance.onkoLoppu();
        assertEquals(expResult, result);
    }
    
    /**
     * testataan abstraktia Sanankyselija-luokkaa sen toteuttavan KokeenLogiikka-luokan kautta
     */
    @Test
    public void testKasvaakoKysyttyjenMaaraKunKysytaan(){
        System.out.println("kysySana");
        KokeenLogiikka instance = kokeenLogiikka;
        instance.kysySana();
        int expResult = 1;
        int result = instance.kysyttykpl;
        assertEquals(expResult, result);
    }
    @Test
    public void testGetAsetettavaTeksti(){
        System.out.println("kysySana");
        System.out.println("getAsetettavaTeksti");
        KokeenLogiikka instance = kokeenLogiikka;
        instance.kysySana();
        String expResult = instance.kysyttavat.get(instance.nykyinen);
        String result = instance.getAsetettavaTeksti();
        assertEquals(expResult, result);
    }
    @Test
    public void testGetOikeaVastaus(){
        System.out.println("kysySana");
        System.out.println("getOikeaVastaus");
        KokeenLogiikka instance = kokeenLogiikka;
        instance.kysySana();
        String kysyttava =instance.kysyttavat.get(kokeenLogiikka.nykyinen);
        String expResult = instance.sanaparit.getPariSanasto1To2(kysyttava);
        String result = instance.getOikeaVastaus();
        assertEquals(expResult, result);
    }
    @Test
    public void testTarkistaJaEtene(){
        System.out.println("tarkistaJaEtene");
        System.out.println("onkoOikein");
        KokeenLogiikka instance = kokeenLogiikka;
        instance.tarkistaJaEtene("asf");
        boolean expResult = false;
        boolean result = instance.tarkistaJaEtene("nkh");
        assertEquals(expResult, result);
    }
}
