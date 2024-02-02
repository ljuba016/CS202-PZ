/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package test;

import exceptions.NevalidanBrojGodinaException;
import exceptions.NevalidanTelefonException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import klase.Klijent;
import klase.VlasnikNekretnine;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import util.DBCRUD;
import util.DatabaseConnector;
import static util.DatabaseConnector.closeConnection;

/**
 *
 * @author aleks
 */
public class DodajVlasnikaTest {
    
    public DodajVlasnikaTest() {
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
    public void dodajVlasnikaTest() throws SQLException, NevalidanTelefonException, NevalidanBrojGodinaException {
            
            DatabaseConnector.openConnection();
            VlasnikNekretnine vlasnik = new VlasnikNekretnine(6, "Bulevar Nemanjica 45",32, "Mateja Arnautovic", "+381638833301");
            VlasnikNekretnine vlasnik1 = new VlasnikNekretnine(7, "Bulevar Oslobodjenja 44",65, "Nikola Misic", "+381638833301");
            DBCRUD.dodajVlasnika(vlasnik);
            DBCRUD.dodajVlasnika(vlasnik1);
            DatabaseConnector.openConnection();
            PreparedStatement st = DatabaseConnector.con.prepareStatement("SELECT VlasnikID FROM VlasnikNekretnine WHERE VlasnikID = 6 OR VlasnikID = 7");
            ResultSet resultSet = st.executeQuery();

            assertTrue(resultSet.next());
                  
            closeConnection();
            
    }
}
