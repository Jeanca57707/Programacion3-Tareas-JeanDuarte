import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.text.Font;

public class HolaMundoFX extends Application{

    @Override
    public void start(Stage primarStage)throws Exception{
        primarStage.setTitle("Hola Mundo");
        Label lbl = new Label("¡Hola, Mundo!");
        lbl.setFont(new Font(24));
        Button btn = new Button("Pulsa aquí");
        btn.setCursor(Cursor.HAND);

        btn.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){  // Método que maneja el evento de pulsar el botón
                lbl.setText("¡Hola, Jean Carlos!");
            }
        });

        VBox cuerpo = new VBox(10);   // El 10 es el espacio de píxeles que tendrá cada nodo entre si en el VBox
        cuerpo.getChildren().addAll(lbl, btn); // Agrega el botón y el label al layout
        cuerpo.setAlignment(Pos.CENTER);  // Centra todos los nodos que están dentro del VBox
        Scene scene = new Scene(cuerpo, 300, 250);
        primarStage.setScene(scene);
        primarStage.show();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
