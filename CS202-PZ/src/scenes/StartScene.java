package scenes;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class StartScene extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login ili Registracija");

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 20, 20, 20));

        Button login = new Button("Prijavi se");
        

        Button register = new Button("Registruj se");
        

        vbox.getChildren().addAll(login, register);

        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);

        primaryStage.show();
        
        login.setOnAction(e -> {
            primaryStage.close();
            new scenes.LoginScene().start(primaryStage);
        });
        register.setOnAction(e -> {
            primaryStage.close();
            new scenes.RegistrationScene().start(primaryStage);
        });
        
        
    }

    

    public static void main(String[] args) {
        launch(args);
    }
}
