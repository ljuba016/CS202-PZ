package scenes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import util.AlertDisplay;
import util.DatabaseConnector;

public class ReserveScene extends Application {

    private static AlertDisplay alertDisplayer;

    @Override
    public void start(Stage primaryStage) {
        alertDisplayer = new AlertDisplay();
        primaryStage.setTitle("Rezervacija Nekretnine");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Unos ID-ja nekretnine
        Label idNekretnineLabela = new Label("Unesite ID nekretnine:");
        GridPane.setConstraints(idNekretnineLabela, 0, 0);

        TextField idNekretnineField = new TextField();
        idNekretnineField.setPromptText("Unesite ID nekretnine");
        GridPane.setConstraints(idNekretnineField, 1, 0);

        // Unos datuma
        Label datumLabela = new Label("Unesite datum:");
        GridPane.setConstraints(datumLabela, 0, 1);

        TextField datumField = new TextField();
        datumField.setPromptText("Unesite datum");
        GridPane.setConstraints(datumField, 1, 1);

        // Razdvajanje datuma i vremena
        GridPane.setConstraints(new Label(""), 0, 2);

        // Unos vremena
        Label vremeLabela = new Label("Unesite vreme:");
        GridPane.setConstraints(vremeLabela, 0, 3);

        TextField vremeField = new TextField();
        vremeField.setPromptText("Unesite vreme");
        GridPane.setConstraints(vremeField, 1, 3);

        // Dugme za rezervaciju
        Button rezervisiDugme = new Button("Rezerviši");
        GridPane.setConstraints(rezervisiDugme, 1, 4);

       
        rezervisiDugme.setOnAction(e -> {
            try {
                upisiRezervaciju(Integer.parseInt(idNekretnineField.getText()), datumField.getText(), vremeField.getText());
            } catch (SQLException ex) {
                Logger.getLogger(ReserveScene.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        grid.getChildren().addAll(idNekretnineLabela, idNekretnineField, datumLabela, datumField, new Label(""), vremeLabela, vremeField, rezervisiDugme);

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void upisiRezervaciju(int idNekretnine, String datum, String vreme) throws SQLException {

        try {
            if (alertDisplayer == null) {
                alertDisplayer = new AlertDisplay();
            }else {
                DatabaseConnector.getConnection();
                PreparedStatement st = DatabaseConnector.con.prepareStatement("INSERT INTO pregled (nepokretnostid, datumpregleda, vremepregleda) VALUES (?, ?, ?)");
                st.setInt(1, idNekretnine);
                st.setString(2, datum);
                st.setString(3, vreme);
                int rowsAffected = st.executeUpdate();
                if (rowsAffected > 0) {
                    alertDisplayer.showAlertMet(Alert.AlertType.INFORMATION, "Uspesno! ", "Uspesno ste rezervisali pregeld nekretnine");
                }
                DatabaseConnector.closeConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            alertDisplayer.showAlertMet(Alert.AlertType.ERROR, "Neuspesno! ", "Niste uspesno dodali nekretninu");
        }
    }

}
