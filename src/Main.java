import javafx.application.Application;
import javafx.stage.Stage;
import view.FarmView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Créer une instance de FarmView (la vue principale du jeu)
        FarmView farmView = new FarmView();

        // Démarrer la vue avec la fenêtre principale
        farmView.start(primaryStage);
    }

    public static void main(String[] args) {
        // Lancer l'application JavaFX
        launch(args);
    }
}
