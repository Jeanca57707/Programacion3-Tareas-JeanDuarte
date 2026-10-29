package controller;

import javafx.beans.property.ReadOnlyFloatWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.*;

public class ConsultarController {

    @FXML
    private TableView<Estudiante> tablaEstudiantes;

    @FXML
    private TableColumn<Estudiante, String> matricula, nombre, carrera;

    @FXML
    private TableColumn<Estudiante, Float> calificacion;

    @FXML
    private FilteredList<Estudiante> estudianteBuscado;

    @FXML
    private Button btnCerrar, btnEliminar, btnEditar, btnBuscar, btnTodos;

    @FXML
    private TextField txtBuscarEstudiante;

    @FXML
    private Label lblMensaje;

    public static Estudiante aEditar;

    @FXML
    private void initialize() {

        Archivos.leerEstudiantes();
        matricula.setCellValueFactory(c -> (new ReadOnlyStringWrapper(c.getValue().getMatricula())));
        nombre.setCellValueFactory(c -> (new ReadOnlyStringWrapper(c.getValue().getNombre())));
        carrera.setCellValueFactory(c -> (new ReadOnlyStringWrapper(c.getValue().getCarrera())));
        calificacion.setCellValueFactory(c -> (new ReadOnlyFloatWrapper(c.getValue().getCalificacion())).asObject());
        estudianteBuscado = new FilteredList<>(Datos.estudiantes(), c -> true);
        tablaEstudiantes.setItems(estudianteBuscado);
        txtBuscarEstudiante.setPromptText("Buscar Estudiante");
        lblMensaje.setText("");
    }

    @FXML
    private void buscarEstudiante() {

        String busqueda = txtBuscarEstudiante.getText().trim();

        if (busqueda.isEmpty()) {
            estudianteBuscado.setPredicate(c -> true);
            lblMensaje.setText("Ingrese el nombre o matrícula del estudiante");
            return;
        }
        estudianteBuscado.setPredicate(c -> c.toString().contains(busqueda));
        txtBuscarEstudiante.clear();
        lblMensaje.setText("");
    }

    @FXML
    public void mostrarTodos() {
        estudianteBuscado.setPredicate(c -> true);
        txtBuscarEstudiante.clear();
        lblMensaje.setText("");
    }

    @FXML
    private void eliminarEstudiante() {

        Estudiante seleccionado = tablaEstudiantes.getSelectionModel().getSelectedItem();

        if (seleccionado == null) {
            lblMensaje.setText("Elija un estudiante primero");
            return;
        }
        Archivos.eliminarEstudiante(seleccionado);
    }

    @FXML
    private void close() {
        tablaEstudiantes.getScene().getWindow().hide();
    }

    @FXML 
    private void editarEstudiante(){

        aEditar = tablaEstudiantes.getSelectionModel().getSelectedItem();
        if(aEditar == null){
            lblMensaje.setText("Elija un estudiante primero");
            return;
        }
        Ventanas.abrir("editar", "Editar estudiante", btnEditar.getScene().getWindow());
    }
}