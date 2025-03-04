package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import model.Animal;
import model.Culture;
import model.Ferme;

public class GameController {
    private Ferme ferme;

    @FXML
    private VBox cultureList, animalList;

    @FXML
    private Label argentLabel, nourritureLabel;

    @FXML
    private Button planterButton, acheterVacheButton, nourrirAnimauxButton, avancerJourButton, recolterButton;

    @FXML
    public void initialize() {
        ferme = new Ferme();
        updateUI();
    }

    @FXML
    public void planterCulture() {
        Culture nouvelleCulture = new Culture("Blé", 3);
        ferme.planterCulture(nouvelleCulture);
        updateUI();
    }

    @FXML
    public void acheterVache() {
        if (ferme.getArgent() >= 50) {
            ferme.ajouterAnimal(new Animal("Vache", "Lait"));
            updateUI();
        }
    }

    @FXML
    public void nourrirAnimaux() {
        ferme.nourrirAnimaux();
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

    private void updateUI() {
        cultureList.getChildren().clear();
        for (Culture culture : ferme.getCultures()) {
            Label label = new Label(culture.getNom() + " - Jours restants: " + (culture.estMature() ? "Prêt à récolter" : culture.getNom()));
            cultureList.getChildren().add(label);
        }

        animalList.getChildren().clear();
        for (Animal animal : ferme.getAnimaux()) {
            Label label = new Label(animal.getNom() + " - " + (animal.estVivant() ? "En bonne santé" : "Mort ❌"));
            animalList.getChildren().add(label);
        }

        argentLabel.setText("Argent: " + ferme.getArgent() + " pièces");
        nourritureLabel.setText("Nourriture animale: " + ferme.getNourritureAnimale());
    }
}
