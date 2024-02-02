/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package test;

import exceptions.NevalidanTelefonException;
import java.sql.SQLException;
import java.sql.*;
import java.util.function.BooleanSupplier;
import klase.Klijent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import util.DBCRUD;
import util.DatabaseConnector;
import static util.DatabaseConnector.closeConnection;
import static util.DatabaseConnector.con;

/**
 *
 * @author aleks
 */
public class DodajKlijentaTest {
    
    

    public DodajKlijentaTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }
    
    @Test
    public void dodajKlijentaTest() throws NevalidanTelefonException, SQLException {
            
            DatabaseConnector.openConnection();
            Klijent klijent = new Klijent(6, "Bore Piksle 20", "Nikola Sarac", "+381638745588");

            DBCRUD.dodajKlijenta(klijent);
            DatabaseConnector.openConnection();
            PreparedStatement st = DatabaseConnector.con.prepareStatement("SELECT KlijentID FROM klijent WHERE KLijentID = 6");
            ResultSet resultSet = st.executeQuery();

            assertTrue(resultSet.next());
                  
            closeConnection();
            
    }
}
