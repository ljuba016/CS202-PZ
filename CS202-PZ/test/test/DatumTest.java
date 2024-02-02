/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package test;

import exceptions.NevalidanDatumException;
import exceptions.NevalidanIznosException;
import klase.Ugovor;
import static klase.Ugovor.jeValidanDatumIsteka;
import static klase.Ugovor.jeValidanDatumNastanka;
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
public class DatumTest {
    
    public DatumTest() {
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
    public void datumNastankaTest() throws NevalidanDatumException, NevalidanIznosException{
        
        Ugovor ugovor = new Ugovor(6, "2023-12-22", "2024-2-3", 300000.00, 10000.00, 6, 4, 5);
        
        assertTrue(jeValidanDatumNastanka(ugovor));
        
    }
    
    @Test
    public void datumIstekaTest() throws NevalidanDatumException, NevalidanIznosException{
        
        Ugovor ugovor1 = new Ugovor(6, "2023-12-22", "2024-01-01", 250000.00, 5000.00, 7, 5, 3);
        
        assertTrue(jeValidanDatumIsteka(ugovor1));
        
    }
}
