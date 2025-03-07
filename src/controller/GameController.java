package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import model.Culture;
import model.Ferme;
import model.Vache;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

import java.io.*;

public class GameController {
    private Ferme ferme;

    @FXML
    private GridPane cultureList;

    @FXML
    private Label argentLabel;

    @FXML
    private Label meteoLabel;

    @FXML
    private Button planterButton;

    @FXML
    private Button avancerJourButton;

    @FXML
    private GridPane animalList;

    @FXML
    public void initialize() {
        ferme = new Ferme();
        updateUI();
    }

    @FXML
    public void acheterVache() {
        ferme.acheterVache();
        updateUI();
    }

    @FXML
    public void nourrirAnimaux() {
        ferme.nourrirAnimaux();
        updateUI();
    }

    @FXML
    public void planterCulture() {
        Culture nouvelleCulture = new Culture("Blé", 3);
        ferme.planterCulture(nouvelleCulture);
        updateUI();
    }

    @FXML
    public void avancerJour() {
        ferme.passerUnJour();
        updateUI();
    }

    @FXML
    public void vendreLait() {
        ferme.vendreLait();
        updateUI();
    }

    @FXML
    public void vendreCulture() {
        for (Culture culture : ferme.getCultures()) {
            if (culture.estMature()) {
                ferme.vendreCulture(culture);
                updateUI();
                return;
            }
        }
        System.out.println("Aucune culture mature à vendre.");
    }

    @FXML
    public void vendreVache() {
        if (!ferme.getVaches().isEmpty()) {
            Vache vache = ferme.getVaches().get(0);
            ferme.vendreVache(vache);
            updateUI();
        }
    }

    @FXML
    public void sauvegarderFerme() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ferme.sav"))) {
            oos.writeObject(ferme);
            System.out.println("Sauvegarde réussie.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void chargerFerme() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ferme.sav"))) {
            ferme = (Ferme) ois.readObject();
            updateUI();
            System.out.println("Chargement réussi.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void afficherGestion() {
        Stage gestionStage = new Stage();
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10));

        Label titreLabel = new Label("Finances et Gestion");
        titreLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        Label revenusLabel = new Label("Revenus totaux: " + ferme.getArgent() + " pièces");
        Label nbVachesLabel = new Label("Nombre de vaches: " + ferme.getVaches().size());
        Label nbCulturesLabel = new Label("Nombre de cultures: " + ferme.getCultures().size());

        layout.getChildren().addAll(titreLabel, revenusLabel, nbVachesLabel, nbCulturesLabel);

        Scene scene = new Scene(layout, 300, 200);
        gestionStage.setTitle("Finances et Gestion");
        gestionStage.setScene(scene);
        gestionStage.show();
    }

    private void updateUI() {
        cultureList.getChildren().clear();
        int cultureColumn = 0;
        for (Culture culture : ferme.getCultures()) {
            ImageView imageView;
            InputStream imageStream = null;
            if (culture.estMature()) {
                imageStream = getClass().getResourceAsStream("/Assets/Images/Baie_Oran4.jpg");
            } else if (culture.getJoursRestants() == 2) {
                imageStream = getClass().getResourceAsStream("/Assets/Images/Baie_Oran2.jpg");
            } else if (culture.getJoursRestants() == 1) {
                imageStream = getClass().getResourceAsStream("/Assets/Images/Baie_Oran3.jpg");
            } else {
                imageStream = getClass().getResourceAsStream("/Assets/Images/Baie_Oran1.jpg");
            }
            if (imageStream != null) {
                imageView = new ImageView(new Image(imageStream));
                cultureList.add(imageView, cultureColumn++, 0);
            } else {
                System.err.println("Image not found for culture: " + culture.getNom());
            }
        }

        animalList.getChildren().clear();
        int animalColumn = 0;
        for (Vache vache : ferme.getVaches()) {
            InputStream animalImageStream = getClass().getResourceAsStream("/Assets/Images/miltank.png");
            if (animalImageStream != null) {
                ImageView imageView = new ImageView(new Image(animalImageStream));
                animalList.add(imageView, animalColumn++, 0);
            } else {
                System.err.println("Image not found for vache.");
            }
        }

        argentLabel.setText("Argent: " + ferme.getArgent() + " pièces");
        meteoLabel.setText("Météo: " + ferme.getMeteo().getConditionActuelle());
    }
}