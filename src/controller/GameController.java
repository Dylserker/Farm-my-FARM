package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import model.Culture;
import model.Ferme;

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
            Label label = new Label(culture.getNom() + " - Jours restants: " + (culture.estMature() ? "Prêt à récolter" : culture.getNom()));
            cultureList.getChildren().add(label);
        }
        argentLabel.setText("Argent: " + ferme.getArgent() + " pièces");
        meteoLabel.setText("Météo: " + ferme.getMeteo().getConditionActuelle());
    }
}