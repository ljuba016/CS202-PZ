package scenes;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import util.AlertDisplay;
import util.DatabaseConnector;

public class RegistrationScene extends Application {

    private static Stage primaryStage;
    private static AlertDisplay alertDisplayer;

    @Override
    public void start(Stage primaryStage) {
        alertDisplayer = new AlertDisplay();
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Registracija");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 20, 20, 20));

        Label usernameLabel = new Label("Korisničko ime:");
        TextField usernameField = new TextField();

        Label passwordLabel = new Label("Lozinka:");
        PasswordField passwordField = new PasswordField();

        Button registerButton = new Button("Registruj se");
        registerButton.setOnAction(e -> {
            try {
                registerUser(usernameField.getText(), passwordField.getText());
            } catch (SQLException ex) {
                Logger.getLogger(RegistrationScene.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Button backButton = new Button("Nazad");
        backButton.setOnAction(e -> {
            primaryStage.close();
            new scenes.StartScene().start(primaryStage);
        } );

        grid.add(usernameLabel, 0, 0);
        grid.add(usernameField, 1, 0);
        grid.add(passwordLabel, 0, 1);
        grid.add(passwordField, 1, 1);
        grid.add(registerButton, 1, 2);
        grid.add(backButton, 1, 3);

        Scene scene = new Scene(grid, 350, 250);
        primaryStage.setScene(scene);

        primaryStage.show();

    }

    public static void registerUser(String username, String password) throws SQLException {

        try {
            if (alertDisplayer == null) {
                alertDisplayer = new AlertDisplay();
            }
            if (username.isEmpty() || password.length() < 5) {
                alertDisplayer.showAlertMet(Alert.AlertType.ERROR, "Dodavanje neuspesno!", "Korisnik nije uspesno registrovan.");
            } else {
                DatabaseConnector.getConnection();
                PreparedStatement st = DatabaseConnector.con.prepareStatement("INSERT INTO korisnici (username, password) VALUES (?, ?)");
                st.setString(1, username);
                st.setString(2, password);
                int rowsAffected = st.executeUpdate();
                if (rowsAffected > 0) {
                    alertDisplayer.showAlertMet(Alert.AlertType.INFORMATION, "Dodavanje uspesno!", "Korisnik je uspesno registrovan.");
                }
                DatabaseConnector.closeConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            alertDisplayer.showAlertMet(Alert.AlertType.ERROR, "Dodavanje neuspesno!", "Korisnik nije uspesno registrovan.");
        }
    }
}