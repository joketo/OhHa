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
public class SanalukijaTest {
    
    public SanalukijaTest() {
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
     * Test of luoSanaparitOlio method, of class Sanalukija.
     */
    @Test
    public void testLuoSanaparitOlio() {
        System.out.println("luoSanaparitOlio");
        Sanalukija instance = null;
        Sanaparit expResult = null;
        Sanaparit result = instance.luoSanaparitOlio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
