import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.geometry.Pos;

public class App extends Application{

    private double presupuesto;
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override 
    public void start(Stage stage) throws Exception{

        TextField presupuestoTxt = new TextField();
        presupuestoTxt.setPromptText("Ingrese el presupuesto mensual");

        Label lblPresupuesto = new Label();
        Label mensaje = new Label();

        TextField descripcionTxt = new TextField();
        descripcionTxt.setPromptText("Descripción");

        TextField montoTxt = new TextField();
        montoTxt.setPromptText("Monto");

        Button btnAgregar = new Button("Agregar gasto");

        VBox gastosVB = new VBox(25);
        gastosVB.setAlignment(Pos.CENTER_LEFT);

        try {
            btnAgregar.setOnAction(e->{
            double monto = Double.parseDouble(montoTxt.getText().trim());

            if(presupuesto <= 0 || monto > presupuesto){
                mensaje.setText("No tiene presupuesto para agregar gastos");

            }else{
                HBox gastoHB = crearGasto(descripcionTxt.getText().trim(), monto);
                gastosVB.getChildren().add(gastoHB);
                lblPresupuesto.setText("Presupuesto: " + presupuesto);
            }

           });   
        } catch (NumberFormatException e) {
            mensaje.setText("Debe ingresar un monto válido");
        }

        Button btnFijar = new Button("Fijar");
        btnFijar.setOnAction(e->{

            try {
            presupuesto = Double.parseDouble(presupuestoTxt.getText().trim());

            if(presupuesto <= 0){
                mensaje.setText("El presupuesto no puede ser menor o igual a 0");
                presupuestoTxt.setPromptText("Ingrese el presupuesto mensual");
            }
            else{
                lblPresupuesto.setText("Presupuesto: " +String.valueOf(presupuesto));
                presupuestoTxt.setPromptText("Ingrese el presupuesto mensual");
            }
            
        } catch (NumberFormatException err) {
            mensaje.setText("Debe ingresar un número válido");  
        }

        });

        HBox presupuesto = new HBox(25);
        presupuesto.getChildren().addAll(presupuestoTxt, btnFijar);
        VBox rama = new VBox(15);
        rama.getChildren().addAll(presupuesto,descripcionTxt, montoTxt, btnAgregar, gastosVB, lblPresupuesto, mensaje);
        rama.setAlignment(Pos.CENTER);
        rama.setStyle("-fx-padding: 20px");
        Scene scene = new Scene(rama, 400, 300);
        stage.setTitle("Gastos Mensuales");
        stage.setScene(scene);
        stage.show();

    }
    public HBox crearGasto(String descripcion, double gasto){
        
        HBox gastoHb = new HBox(10);
        Label lblDescripcion = new Label(descripcion.trim());
        Label lblGasto = new Label(String.valueOf(gasto));
        Button btnElminar = new Button("X");
        gastoHb.getChildren().addAll(lblDescripcion, lblGasto, btnElminar);

        presupuesto -= gasto;
    
        return gastoHb;
    }
}
