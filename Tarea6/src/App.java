import java.io.IOException;

import controller.Ventanas;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/registro.fxml")));
            scene.getStylesheets().add(Ventanas.class.getResource("/css/estilos.css").toExternalForm());
            stage.setTitle("Registro de estudiantes");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
}