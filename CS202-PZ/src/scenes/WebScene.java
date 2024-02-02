package scenes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebScene extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Web Scraping Example");

        Label resultLabel = new Label("Naslovi sa stranice:");
        resultLabel.setWrapText(true);  // Postavljanje omotača teksta na true

        
        try {
            Document doc = Jsoup.connect("https://www.zidart.rs/o-nama").get();
            Elements titles = doc.select("div.section-text p");  

            StringBuilder resultText = new StringBuilder();
            for (Element title : titles) {
                resultText.append(title.text()).append("\n");
            }

            resultLabel.setText(resultText.toString());
        } catch (IOException e) {
            e.printStackTrace();
            resultLabel.setText("Greška prilikom povlačenja podataka sa stranice.");
        }

        VBox root = new VBox(resultLabel);
        Scene scene = new Scene(root, 600, 500);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    
}
