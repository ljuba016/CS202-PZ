package util;

import java.sql.*;
import java.sql.SQLException;

public class DatabaseConnector {

    public static Connection con = null;
    private static String url = "jdbc:mysql://localhost:3306/agencija_za_nekretnine";
    private static String username = "root";
    private static String password = "";

    public static void getConnection() {
        try {
            con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void openConnection() throws SQLException {
        con = DriverManager.getConnection(url, username, password);
    }

    public static void closeConnection() throws SQLException {
        con.close();
    }
}
