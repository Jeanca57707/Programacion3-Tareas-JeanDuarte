package controller;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Archivos;
import javafx.fxml.FXML;

public class EditarController {

    @FXML
    private TextField txtMatricula, txtNombre, txtCarrera, txtCalificacion;

    @FXML
    private Button btnGuardar, btnSalir;

    @FXML
    private Label lblMensaje;

    @FXML
    public void initialize() {

        txtMatricula.setText(ConsultarController.aEditar.getMatricula());
        txtMatricula.setEditable(false);
        txtNombre.setText(ConsultarController.aEditar.getNombre());
        txtCarrera.setText(ConsultarController.aEditar.getCarrera());
        txtCalificacion.setText(ConsultarController.aEditar.getStringCalificacion());
    }

    @FXML
    private void editar() {

        try {
            String matricula = txtMatricula.getText().trim();
            String nombre = txtNombre.getText().trim();
            String carrera = txtCarrera.getText().trim();
            float calificacion = Float.parseFloat(txtCalificacion.getText().trim());

            if (nombre.isEmpty() || carrera.isEmpty()
                    || txtCalificacion.getText().trim().isEmpty()) {

                lblMensaje.setText("No puede dejar ningún campo vacío");
                return; 
            }
            if (calificacion <= 0 || calificacion > 100) {
                lblMensaje.setText("Ingrese una calificación válida");
                return;
            }
        
            ConsultarController.aEditar.setMatricula(matricula);
            ConsultarController.aEditar.setNombre(nombre);
            ConsultarController.aEditar.setCarrera(carrera);
            ConsultarController.aEditar.setCalificacion(calificacion);

            Archivos.actualizarEstudiante(ConsultarController.aEditar);
            lblMensaje.setText("Estudiante modificado correctamente");
            ConsultarController.aEditar = null;

        } catch (NumberFormatException e) {
            lblMensaje.setText("Error de formato en la calificación");
        }
    }

    @FXML 
    private void close(){
        btnSalir.getScene().getWindow().hide();
    }

}
