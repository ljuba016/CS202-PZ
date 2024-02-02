package scenes;

import exceptions.NevalidanTelefonException;
import klase.Klijent;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import util.AlertDisplay;
import util.DatabaseConnector;
import util.DBCRUD;

public class AddClientScene extends Application {

    private TextField klijentIdField;
    private TextField imeField;
    private TextField adresaField;
    private TextField telefonField;

    private static AlertDisplay alertDisplayer;

    @Override
    public void start(Stage primaryStage) throws NevalidanTelefonException {

        alertDisplayer = new AlertDisplay();
        klijentIdField = new TextField();
        imeField = new TextField();
        adresaField = new TextField();
        telefonField = new TextField();

        Label klijentIdLabel = new Label("Id klijenta: ");
        Label imeLabel = new Label("Ime klijenta:");
        Label adresaLabel = new Label("Adresa klijenta: ");
        Label telefonLabel = new Label("Telefon klijenta: ");

        Button dodajButton = new Button("Dodaj klijenta");
        
        Button backButton = new Button("Nazad");
        backButton.setOnAction(e -> {
            primaryStage.close();
            new scenes.ChoiceScene().start(primaryStage);
        } );

        dodajButton.setOnAction(e -> {
            try {
                // Provera da li je klijentIdField prazan
                if (klijentIdField.getText().isEmpty()) {
                    alertDisplayer.showAlertMet(Alert.AlertType.INFORMATION, "Greska!", "Polje id ne moze biti prazno");
                    return;
                }

                int klijentId = Integer.parseInt(klijentIdField.getText());
                String ime = imeField.getText();
                String adresa = adresaField.getText();
                String telefon = telefonField.getText();

                Klijent klijent = new Klijent(klijentId, ime, adresa, telefon);
                DBCRUD.dodajKlijenta(klijent);
            } catch (NumberFormatException ex) {
                // Ako nije moguće parsirati, prikaži upozorenje
                alertDisplayer.showAlertMet(Alert.AlertType.INFORMATION, "Greska!", "Nije moguce parsirati");
            } catch (NevalidanTelefonException ex) {
                // Ako postoji problem sa telefonom, prikaži upozorenje
                alertDisplayer.showAlertMet(Alert.AlertType.INFORMATION, "Greska!", "Neispravan format telefona");
            }
        });

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(
                klijentIdLabel, klijentIdField,
                imeLabel, imeField,
                adresaLabel, adresaField,
                telefonLabel, telefonField,
                dodajButton, backButton
        );

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setTitle("Dodavanje zivotinje");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
