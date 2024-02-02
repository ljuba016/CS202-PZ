package scenes;

import exceptions.NevalidanBrojGodinaException;
import exceptions.NevalidanTelefonException;
import klase.Klijent;
import klase.VlasnikNekretnine;
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

public class AddOwnerScene extends Application {

    private TextField vlasnikIdField;
    private TextField imeField;
    private TextField adresaField;
    private TextField telefonField;
    private TextField godineField;

    private static AlertDisplay alertDisplayer;

    @Override
    public void start(Stage primaryStage) throws NevalidanTelefonException {

        alertDisplayer = new AlertDisplay();
        vlasnikIdField = new TextField();
        imeField = new TextField();
        adresaField = new TextField();
        telefonField = new TextField();
        godineField = new TextField();

        Label vlasnikIdLabel = new Label("Id vlasnika: ");
        Label imeLabel = new Label("Ime vlasnika:");
        Label adresaLabel = new Label("Adresa vlasnika: ");
        Label telefonLabel = new Label("Telefon vlasnika: ");
        Label godineLabel = new Label("Godine vlasnika: ");

        Button dodajButton = new Button("Dodaj vlasnika");
        
        Button backButton = new Button("Nazad");
        backButton.setOnAction(e -> {
            primaryStage.close();
            new scenes.ChoiceScene().start(primaryStage);
        } );

        dodajButton.setOnAction(e -> {
            try {
                // Provera da li je vlasnikIdField prazan
                if (vlasnikIdField.getText().isEmpty()) {
                    alertDisplayer.showAlertMet(Alert.AlertType.INFORMATION, "Greska!", "Polje id ne moze biti prazno");
                    return;
                }

                int vlasnikId = Integer.parseInt(vlasnikIdField.getText());
                String ime = imeField.getText();
                String adresa = adresaField.getText();
                String telefon = telefonField.getText();
                int godine = Integer.parseInt(vlasnikIdField.getText());

                VlasnikNekretnine vlasnik = new VlasnikNekretnine(vlasnikId, adresa, godine, ime, telefon);
                DBCRUD.dodajVlasnika(vlasnik);
            } catch (NumberFormatException ex) {
                // Ako nije moguće parsirati, prikaži upozorenje
                alertDisplayer.showAlertMet(Alert.AlertType.INFORMATION, "Greska!", "Nije moguce parsirati");
            } catch (NevalidanTelefonException ex) {
                // Ako postoji problem sa telefonom, prikaži upozorenje
                alertDisplayer.showAlertMet(Alert.AlertType.INFORMATION, "Greska!", "Neispravan format telefona");
            }
            catch (NevalidanBrojGodinaException ex) {
                // Ako postoji problem sa telefonom, prikaži upozorenje
                alertDisplayer.showAlertMet(Alert.AlertType.INFORMATION, "Greska!", "Broj godina mora biti veci od 18");
            }
        });

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(
                vlasnikIdLabel, vlasnikIdField,
                imeLabel, imeField,
                adresaLabel, adresaField,
                telefonLabel, telefonField,
                godineLabel, godineField,
                dodajButton, backButton
        );

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setTitle("Dodavanje zivotinje");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
