package view;

import controller.ActionController;
import controller.FarmController;
import javafx.scene.control.Alert;
import model.Field;
import model.Seed;
import model.Animal;
import model.Farm;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FarmView extends Application {
    private Farm farm;
    private ActionController actionController;

    public FarmView() {
        farm = new Farm();
        actionController = new ActionController(new FarmController(farm));
    }

    @Override
    public void start(Stage primaryStage) {
        // Bouton pour acheter une graine
        Button buySeedButton = new Button("Acheter graine");
        buySeedButton.setOnAction(e -> {
            Field field = new Field();
            Seed seed = new Seed("Carotte", 10, 5000); // Graine de carotte avec 5 secondes de croissance
            actionController.buySeed(field, seed);
            // Afficher un message de succès
            UIUtils.showAlert("Succès", "Vous avez acheté des graines de Carottes.", Alert.AlertType.INFORMATION);
        });

        // Bouton pour acheter un animal
        Button buyAnimalButton = new Button("Acheter animal");
        buyAnimalButton.setOnAction(e -> {
            Animal animal = new Animal("Vache", 50);
            actionController.buyAnimal(animal);
            // Afficher un message de succès
            UIUtils.showAlert("Succès", "Vous avez acheté une Vache.", Alert.AlertType.INFORMATION);
        });

        // Bouton pour récolter les produits
        Button collectButton = new Button("Récolter les produits");
        collectButton.setOnAction(e -> {
            actionController.harvestProducts();
            // Afficher un message de succès
            UIUtils.showAlert("Récolte", "Les produits ont été récoltés.", Alert.AlertType.INFORMATION);
        });

        // Utiliser UIUtils pour organiser les boutons dans un VBox
        VBox layout = UIUtils.createVBox(10);
        layout.getChildren().addAll(buySeedButton, buyAnimalButton, collectButton);

        // Créer la scène
        Scene scene = UIUtils.createScene(layout, 300, 200);

        // Initialiser la fenêtre (Stage)
        primaryStage.setTitle("FarmVille Simplifié");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
