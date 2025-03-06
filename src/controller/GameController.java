package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import model.Culture;
import model.Ferme;
import model.Vache;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.*;

public class GameController {
    private Ferme ferme;

    @FXML
    private VBox cultureList;

    @FXML
    private Label argentLabel;

    @FXML
    private Label meteoLabel;

    @FXML
    private Button planterButton;

    @FXML
    private Button avancerJourButton;

    @FXML
    private Button recolterButton;

    @FXML
    private VBox animalList;

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
    public void recolter() {
        ferme.recolter();
        updateUI();
    }

    @FXML
    public void vendreCulture() {
        if (!ferme.getCultures().isEmpty()) {
            Culture culture = ferme.getCultures().get(0);
            ferme.vendreCulture(culture);
            updateUI();
        }
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

    private void updateUI() {
        cultureList.getChildren().clear();
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
                cultureList.getChildren().add(imageView);
            } else {
                System.err.println("Image not found for culture: " + culture.getNom());
            }
        }

        animalList.getChildren().clear();
        for (Vache vache : ferme.getVaches()) {
            InputStream animalImageStream = getClass().getResourceAsStream("/Assets/Images/miltank.png");
            if (animalImageStream != null) {
                ImageView imageView = new ImageView(new Image(animalImageStream));
                animalList.getChildren().add(imageView);
            } else {
                System.err.println("Image not found for vache.");
            }
        }

        argentLabel.setText("Argent: " + ferme.getArgent() + " pièces");
        meteoLabel.setText("Météo: " + ferme.getMeteo().getConditionActuelle());
    }
}