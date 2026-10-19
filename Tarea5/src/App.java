import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.geometry.Pos;

public class App extends Application {

    private double presupuestoFijo;
    private double totalGastado = 0;
    private double presupuestoActual;
    private Label lblPresupuesto = new Label();
    private VBox gastosVBox = new VBox(5);
    private Label mensaje = new Label();

    public double getPresupuestoFijo() {
        return presupuestoFijo;
    }

    public void setPresupuestoFijo(double presupuestoFijo) {
        this.presupuestoFijo = presupuestoFijo;
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        TextField presupuestoTxt = new TextField();
        presupuestoTxt.setPromptText("Ingrese el presupuesto");

        Label lblPresupuestoFijo = new Label();
        lblPresupuestoFijo.setStyle("-fx-font-weight: bold");

        mensaje.setStyle("-fx-font-weight: bold");
        HBox mensajeHB = new HBox(mensaje);
        mensaje.setAlignment(Pos.BOTTOM_LEFT);
        

        Label lblTítulo = new Label("Gestor de gastos mensuales");
        lblTítulo.setStyle("-fx-font-size: 22px; -fx-font-weight: bold");
        VBox VBTitulo = new VBox(lblTítulo);
        VBTitulo.setAlignment(Pos.TOP_CENTER);

        Label lblGastos = new Label("Agregar nuevo gasto");
        lblGastos.setStyle("-fx-font-size: 15px; -fx-font-weight: bold");
        HBox gasBox = new HBox(lblGastos);
        gasBox.setAlignment(Pos.CENTER_LEFT);

        TextField descripcionTxt = new TextField();
        descripcionTxt.setPromptText("Descripción");

        TextField montoTxt = new TextField();
        montoTxt.setPromptText("Monto");

        Button btnFijar = new Button("Fijar");
        btnFijar.setStyle("-fx-background-color: #121212;" + "-fx-text-fill: #FFFFFF;" + "-fx-font-weight: bold;");
        btnFijar.setCursor(Cursor.HAND);

        Button btnAgregar = new Button("Agregar gasto");
        btnAgregar.setStyle("-fx-background-color: #121212;" + "-fx-text-fill: #FFFFFF;" + "-fx-font-weight: bold;");
        btnAgregar.setCursor(Cursor.HAND);

        gastosVBox.setAlignment(Pos.CENTER_LEFT);

        btnAgregar.setOnAction(e -> {

            if (descripcionTxt.getText().isEmpty() || montoTxt.getText().isEmpty()) {
                mensaje.setText("Error. Dejó un campo vacio.");
            } else {

                try {
                    double monto = Double.parseDouble(montoTxt.getText().trim());

                    if (presupuestoActual <= 0 || monto > presupuestoActual) {
                        mensaje.setText("No tiene presupuesto para agregar gastos");

                    } else {
                        HBox gastoHB = crearGasto(descripcionTxt.getText().trim(), monto);
                        gastosVBox.getChildren().add(gastoHB);
                        mensaje.setText("");
                    }
                } catch (NumberFormatException err) {
                    mensaje.setText("Debe ingresar un monto válido");
                }
            }

        });

        btnFijar.setOnAction(e -> {
            try {
                presupuestoFijo = Double.parseDouble(presupuestoTxt.getText().trim());
                presupuestoActual = Double.parseDouble(presupuestoTxt.getText().trim());

                if (presupuestoFijo <= 0) {
                    mensaje.setText("El presupuesto no puede ser menor o igual a 0");
                    presupuestoTxt.setPromptText("Ingrese el presupuesto mensual");
                } else {
                    setPresupuestoFijo(presupuestoFijo);
                    lblPresupuestoFijo.setText("Presupuesto fijo: RD$" + String.valueOf(getPresupuestoFijo()));
                    presupuestoTxt.setPromptText("Ingrese el presupuesto mensual");
                    mensaje.setText("");
                    gastosVBox.getChildren().removeAll();
                    actualizarTotal();
                }
            } catch (NumberFormatException err) {
                mensaje.setText("Debe ingresar un número válido");
            }

        });

        HBox presupuesto = new HBox(25);
        presupuesto.getChildren().addAll(presupuestoTxt, btnFijar, lblPresupuestoFijo);
        VBox rama = new VBox(15);
        rama.getChildren().addAll(VBTitulo, presupuesto, gasBox, descripcionTxt, montoTxt, btnAgregar, gastosVBox, lblPresupuesto,
                mensajeHB);
        rama.setAlignment(Pos.CENTER);
        rama.setStyle("-fx-padding: 20px; -fx-background-color: #F5F0E6");
        Scene scene = new Scene(rama, 500, 600);
        stage.setTitle("Gastos Mensuales");
        stage.setScene(scene);
        stage.show();

    }

    public HBox crearGasto(String descripcion, double monto) {

        HBox gastoHb = new HBox(10);
        gastoHb.setStyle("-fx-background-color: #121212;" + "-fx-border-color: #000000;" +
            "-fx-background-radius: 10px;" + "-fx-padding: 5px;" + "-fx-border-radius: 5px;"
        );

        Label lblDescripcion = new Label("-"+descripcion.trim());
        lblDescripcion.setStyle("-fx-text-fill: #FFFFFF;" + "-fx-font-weight: bold;" 
            +"-fx-font-size: 15px;"
        );

        Label lblGasto = new Label("RD$"+ String.format("%.2f", monto));
        lblGasto.setStyle("-fx-text-fill: #FFFFFF;" + "-fx-font-weight: bold;"
            + "-fx-font-size: 15px;"
            
        );
        
        Button btnElminar = new Button("X");
        btnElminar.setCursor(Cursor.HAND);
        btnElminar.setStyle("-fx-background-color: #E53935;" + "-fx-text-fill: #FFFFFF;" + "-fx-font-weight: bold;"
        );
        HBox.setHgrow(lblDescripcion, Priority.ALWAYS);
        lblDescripcion.setMaxWidth(Double.MAX_VALUE);

        btnElminar.setOnAction(e -> {
            gastosVBox.getChildren().remove(gastoHb);
            presupuestoActual += monto;
            totalGastado -= monto;
            mensaje.setText("");
            actualizarTotal();
        });
        gastoHb.getChildren().addAll(lblDescripcion, lblGasto, btnElminar);
        presupuestoActual -= monto;
        totalGastado += monto;
        actualizarTotal();
        return gastoHb;
    }

    public void actualizarTotal() {

        lblPresupuesto.setText("Presupuesto actual: RD$" + presupuestoActual +
            "   |   Total Gastado: RD$" + totalGastado 
        );

        if ((presupuestoActual / getPresupuestoFijo()) * 100 < 70) {
            lblPresupuesto.setStyle("-fx-background-color: #FFFF00; -fx-font-weight: bold");
        } else if ((presupuestoActual / getPresupuestoFijo()) * 100 <= 100) {
            lblPresupuesto.setStyle("-fx-background-color: #00FF73; -fx-font-weight: bold");
        } else {
            lblPresupuesto.setStyle("-fx-background-color: #FF0000; -fx-font-weight: bold");
        }
    }
}
