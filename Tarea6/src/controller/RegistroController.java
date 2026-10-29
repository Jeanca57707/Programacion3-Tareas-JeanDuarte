package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.*;

public class RegistroController {

    @FXML
    private TextField txtMatricula;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtCarrera;

    @FXML
    private TextField txtCalificacion;

    @FXML
    private Button btRegistrar;

    @FXML
    private Button btnConsultar;

    @FXML
    private Button btnAdministrar;

    @FXML
    private Label lblMensaje;

    @FXML
    public void initialize() {

        txtMatricula.setPromptText("Matrícula");
        txtNombre.setPromptText("Nombre completo");
        txtCalificacion.setPromptText("Calificación final");
        txtCarrera.setPromptText("Carrera");
        lblMensaje.setText("");
    }

    @FXML
    public void registrar() {
        try {
            String matricula = txtMatricula.getText().trim();
            String nombre = txtNombre.getText().trim();
            String carrera = txtCarrera.getText().trim();
            float calificacion = Float.parseFloat(txtCalificacion.getText().trim());

            if (matricula.isEmpty() || nombre.isEmpty() || carrera.isEmpty()
                    || txtCalificacion.getText().trim().isEmpty()) {

                lblMensaje.setText("No puede dejar ningún campo vacío");
            }
            if (calificacion <= 0 || calificacion > 100) {
                lblMensaje.setText("Ingrese una calificación válida");
            }

            for (Estudiante e : Datos.estudiantes()) {
                if (e.getMatricula().trim().equals(matricula)) {
                    lblMensaje.setText("Ya existe un estudiante con esta matrícula");
                }
            }  

            Estudiante estudiante = new Estudiante(matricula, nombre, carrera, calificacion);
            Archivos.guardarEstudiante(estudiante);
            lblMensaje.setText("Estudiante registrado correctamente");

        } catch (NumberFormatException e) {
            lblMensaje.setText("Error al registrar la calificación");
        }
    }

    @FXML 
    public void ventanaConsultas(){
        Ventanas.abrir("consultar", "Consultar Estudiantes", btnConsultar.getScene().getWindow());
    }

    @FXML 
    public void ventanaAdministrar(){
        Ventanas.abrir("administrar", "Administración de Calificaciones", btnAdministrar.getScene().getWindow());
    }
}
