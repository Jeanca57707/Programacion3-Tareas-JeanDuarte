import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

public class HolaMundoFX extends Application{

    @Override
    public void start(Stage primarStage)throws Exception{
        primarStage.setTitle("Hola Mundo");
        Label lbl = new Label();
        lbl.setText("¡Hola Mundo!");
        Button btn = new Button();
        btn.setText("Pulsa aquí");

        btn.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event){
                lbl.setText("¡Hola, Jean Carlos!");
            }
        });
        VBox cuerpo = new VBox();
        cuerpo.getChildren().addAll(lbl, btn);
        Scene scene = new Scene(cuerpo, 300, 250);
        primarStage.setScene(scene);
        primarStage.show();
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }
}
