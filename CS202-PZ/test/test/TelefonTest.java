/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package test;

import exceptions.NevalidanBrojGodinaException;
import exceptions.NevalidanTelefonException;
import klase.Klijent;
import static klase.Klijent.jeValidanTelefonKlijenta;

import klase.VlasnikNekretnine;
import static klase.VlasnikNekretnine.jeValidanTelefonVlasnika;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aleks
 */
public class TelefonTest {
    
    public TelefonTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    @Test
    public void telefonKlijentaTest() throws NevalidanTelefonException{
        Klijent klijent = new Klijent(6, "Bore Piksle 20", "Nikola Sarac", "+381638745588");
        assertTrue(jeValidanTelefonKlijenta(klijent));
    }
    
    @Test
    public void telefonVlasnikaTest() throws NevalidanTelefonException, NevalidanBrojGodinaException{
        VlasnikNekretnine vlasnik = new VlasnikNekretnine(6, "Bulevar Nemanjica 45",32, "Mateja Arnautovic", "+381638833301");
        assertTrue(jeValidanTelefonVlasnika(vlasnik));
    }
}
