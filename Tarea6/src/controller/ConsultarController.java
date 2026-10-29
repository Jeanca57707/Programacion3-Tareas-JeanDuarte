package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    private Button btnCerrar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnTodos;

    @FXML
    private TextField txtBuscarEstudiante;

    @FXML
    private Label lblMensaje;

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

        Datos.estudiantes().clear();

        try (BufferedReader br = new BufferedReader(new FileReader(Archivos.fileEstudiantes));
                BufferedWriter bw = new BufferedWriter(new FileWriter(Archivos.NOMBRE_ARCHIVO))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.contains(seleccionado.toString())) {

                    String[] partes = linea.split("; ");

                    String matricula = partes[0];
                    String nombre = partes[1];
                    String carrera = partes[2];
                    float calificacion = Float.parseFloat(partes[3]);

                    Estudiante estudiante = new Estudiante(matricula, nombre, carrera, calificacion);
                    bw.write(estudiante.toString());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            lblMensaje.setText("Error al eliminar el estudiante del archivo");

        } catch (NumberFormatException e) {
            lblMensaje.setText("Se encontró un formato de calificación erróneo");
        }
    }

    @FXML
    private void close() {
        tablaEstudiantes.getScene().getWindow().hide();
    }
}