package scenes;

import exceptions.NevalidanTelefonException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import scenes.StartScene;
import static util.DBCRUD.ispisDodatno;
import static util.DBCRUD.ispisLokacije;
import static util.DBCRUD.ispisNepokretnost;
import util.DatabaseConnector;
import static util.DatabaseConnector.con;

public class ChoiceScene extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Lista i Postojeće Scene");

        
        ObservableList<String> items = FXCollections.observableArrayList(
                "Dodaj klijenta", "Dodaj vlasnika", "Ispis lokacije", "Ispis dodatno", "Ispis nekretnine", "Ispis sa sajta");

        
        ListView<String> listView = new ListView<>(items);

        
        listView.setOnMouseClicked(event -> {
            String selectedItem = listView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                try {
                    // Pozovite metodu za prikazivanje postojeće scene sa odabranom stavkom
                    prikaziPostojecuScenu(selectedItem);
                } catch (NevalidanTelefonException ex) {
                    Logger.getLogger(ChoiceScene.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(listView);

        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    // Metoda za prikaz postojeće scene na osnovu odabrane stavke
    private void prikaziPostojecuScenu(String selectedItem) throws NevalidanTelefonException {
        
        if (selectedItem.equals("Dodaj klijenta")) {
            prikaziScenuStavke1();
        } else if (selectedItem.equals("Dodaj vlasnika")) {
            prikaziScenuStavke2();
        } else if (selectedItem.equals("Ispis lokacije")) {
            prikaziScenuStavke3();
        } else if (selectedItem.equals("Ispis dodatno")) {
            prikaziScenuStavke4();
        }else if (selectedItem.equals("Ispis nekretnine")) {
            prikaziScenuStavke5();
        }else if (selectedItem.equals("Ispis sa sajta")) {
            prikaziScenuStavke6();
        }
    }

    // Metoda za prikaz postojeće scene za Stavku 1
    private void prikaziScenuStavke1() throws NevalidanTelefonException {
        primaryStage.close();
        new AddClientScene().start(primaryStage);
    }

    // Metoda za prikaz postojeće scene za Stavku 2
    private void prikaziScenuStavke2() throws NevalidanTelefonException {
        primaryStage.close();
        new AddOwnerScene().start(primaryStage);
    }

    private void prikaziScenuStavke3() throws NevalidanTelefonException {
        Label podaciLabela = new Label();
        try {
            DatabaseConnector.getConnection();

            String podaci = ispisLokacije();

            podaciLabela.setText(podaci);

            con.close(); 
        } catch (Exception e) {
            e.printStackTrace(); 
        }

        VBox novoRoot = new VBox(10);
        novoRoot.setPadding(new Insets(10));
        novoRoot.getChildren().add(podaciLabela);

        Scene novaScene = new Scene(novoRoot, 600, 400);
        Stage noviProzor = new Stage();
        noviProzor.setTitle("Prikaz lokacije");

        noviProzor.setScene(novaScene);

        noviProzor.show();
    }

    private void prikaziScenuStavke4() throws NevalidanTelefonException {
        Label podaciLabela = new Label();
        try {
            DatabaseConnector.getConnection();

            String podaci = ispisDodatno();

            podaciLabela.setText(podaci);

            con.close();
        } catch (Exception e) {
            e.printStackTrace(); 
        }

        VBox novoRoot = new VBox(10);
        novoRoot.setPadding(new Insets(10));
        novoRoot.getChildren().add(podaciLabela);

        Scene novaScene = new Scene(novoRoot, 600, 400);
        Stage noviProzor = new Stage();
        noviProzor.setTitle("Prikaz Dodatno");

        noviProzor.setScene(novaScene);

        noviProzor.show();
    }

    private void prikaziScenuStavke5() throws NevalidanTelefonException {
        Label podaciLabela = new Label();
        try {
            DatabaseConnector.getConnection();

            String podaci = ispisNepokretnost();

            podaciLabela.setText(podaci);

            con.close(); 
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        Button rezervisi = new Button("Rezervisi pregled");
        rezervisi.setOnAction(e -> {
            primaryStage.close();
            new scenes.ReserveScene().start(primaryStage);
        } );
        
        Button backButton = new Button("Nazad");
        
        VBox novoRoot = new VBox(10);
        novoRoot.setPadding(new Insets(10));
        novoRoot.getChildren().addAll(podaciLabela, rezervisi, backButton);

        Scene novaScene = new Scene(novoRoot, 600, 450);
        Stage noviProzor = new Stage();
        noviProzor.setTitle("Prikaz Nepokretnost");

        noviProzor.setScene(novaScene);

        noviProzor.show();
        
        backButton.setOnAction(e -> {
            noviProzor.close();
            new scenes.ChoiceScene().start(primaryStage);
        } );
        
    }
    private void prikaziScenuStavke6() throws NevalidanTelefonException {
        new scenes.WebScene().start(primaryStage);
    }

    
}
