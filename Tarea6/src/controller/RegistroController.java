package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.*;

public class RegistroController {

    @FXML
    private TextField txtMatricula, txtNombre, txtCarrera, txtCalificacion;

    @FXML
    private Button btRegistrar, btnConsultar, btnEstadisticas;

    @FXML
    public Label lblMensaje;

    @FXML
    public void initialize() {
        Archivos.leerEstudiantes();
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
                return; 
            }
            if (calificacion <= 0 || calificacion > 100) {
                lblMensaje.setText("Ingrese una calificación válida");
                return;
            }
            if(matricula.length() != 8){
                lblMensaje.setText("La matricula debe ser de 8 caracteres");
                return;
            }

            for (Estudiante e : Datos.estudiantes()) {
                if (e.getMatricula().trim().equals(matricula)) {
                    lblMensaje.setText("Ya existe un estudiante con esta matrícula");
                    return; 
                }
            }  

            Estudiante estudiante = new Estudiante(matricula, nombre, carrera, calificacion);
            Archivos.guardarEstudiante(estudiante);
            lblMensaje.setText("Estudiante registrado correctamente");
            txtMatricula.clear();
            txtCalificacion.clear();
            txtCarrera.clear();
            txtNombre.clear();

        } catch (NumberFormatException e) {
            lblMensaje.setText("Error al registrar la calificación");
        }
    }

    @FXML 
    public void ventanaConsultas(){
        Ventanas.abrir("consultar", "Consultar Estudiantes", btnConsultar.getScene().getWindow());
    }

    @FXML 
    public void ventanaEstadisticas(){
        Ventanas.abrir("estadisticas", "Estadisticas Académicas", btnEstadisticas.getScene().getWindow());
    }
}