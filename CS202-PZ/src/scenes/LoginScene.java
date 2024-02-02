package scenes;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import util.AlertDisplay;
import util.DatabaseConnector;

public class LoginScene extends Application {

    private static AlertDisplay alertDisplayer;
    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Login");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 20, 20, 20));

        Label usernameLabel = new Label("Korisnicko ime:");
        TextField usernameField = new TextField();

        Label passwordLabel = new Label("Lozinka:");
        PasswordField passwordField = new PasswordField();

        Button loginButton = new Button("Prijavi se");
        loginButton.setOnAction(e -> handleLogin(usernameField.getText(), passwordField.getText()));

        Button backButton = new Button("Nazad");
        backButton.setOnAction(e -> {
            primaryStage.close();
            new scenes.StartScene().start(primaryStage);
        } );

        grid.add(usernameLabel, 0, 0);
        grid.add(usernameField, 1, 0);
        grid.add(passwordLabel, 0, 1);
        grid.add(passwordField, 1, 1);
        grid.add(loginButton, 1, 2);
        grid.add(backButton, 1, 3);

        Scene scene = new Scene(grid, 350, 250);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void handleLogin(String username, String password) {

        if (alertDisplayer == null) {
            alertDisplayer = new AlertDisplay();
        }
        
        if (isValidCredentials(username, password)) {
            alertDisplayer.showAlertMet(Alert.AlertType.INFORMATION, "Dodavanje uspesno!", "Korisnik je uspesno ulogovan.");

            primaryStage.close();
            new scenes.ChoiceScene().start(primaryStage);

        } else {
            alertDisplayer.showAlertMet(Alert.AlertType.ERROR, "Dodavanje neuspesno!", "Korisnik nije uspesno ulogovan.");
        }
    }

    private boolean isValidCredentials(String username, String password) {

        try {

            DatabaseConnector.getConnection();
            PreparedStatement st = DatabaseConnector.con.prepareStatement("SELECT * FROM korisnici WHERE username = ? AND password = ?");
            st.setString(1, username);
            st.setString(2, password);
            ResultSet resultSet = st.executeQuery();
            try (resultSet) {
                return resultSet.next(); // Ako resultSet ima sledeći red, korisnik je uspešno prijavljen
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Greška prilikom registracije korisnika.");
            return false;
        }
    }
}
