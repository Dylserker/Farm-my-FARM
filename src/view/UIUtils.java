package view;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UIUtils {

    // Méthode pour créer un HBox avec un espacement défini
    public static HBox createHBox(double spacing) {
        HBox hbox = new HBox(spacing);
        return hbox;
    }

    // Méthode pour créer un VBox avec un espacement défini
    public static VBox createVBox(double spacing) {
        VBox vbox = new VBox(spacing);
        return vbox;
    }

    // Méthode pour afficher une alerte (par exemple, erreur ou succès)
    public static void showAlert(String title, String message, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Méthode pour initialiser une scène avec une taille donnée
    public static Scene createScene(VBox layout, double width, double height) {
        Scene scene = new Scene(layout, width, height);
        return scene;
    }

    // Méthode pour initialiser une fenêtre (Stage) avec un titre
    public static Stage createStage(String title) {
        Stage stage = new Stage();
        stage.setTitle(title);
        return stage;
    }

}
