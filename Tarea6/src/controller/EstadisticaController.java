package controller;

import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.*;

public class EstadisticaController {

    @FXML private PieChart grafico;

    @FXML private Button btnCopiaSeguridad, btnRecuperarCopia, btnCerrar;

    @FXML private Label lblMensaje, lblEstudiantesRegistrados,
    lblPromedioGeneral;

    @FXML 
    private void initialize(){
        Archivos.leerEstudiantes();
        PieChart.Data aprobados = new PieChart.Data(String.format("Aprobados (%d)", calcularAprobados()), calcularAprobados());
        PieChart.Data reprobados = new PieChart.Data(String.format("Reprobados (%d)", calcularReprobados()), calcularReprobados());
        grafico.getData().addAll(aprobados, reprobados);
        grafico.setLegendVisible(false);
        lblEstudiantesRegistrados.setText("Estudiantes registrados: " + Datos.estudiantes().size());
        lblPromedioGeneral.setText("Promedio General: " + String.format("%.2f", promedioGeneral()));
        lblMensaje.setText("");
    }

    private int calcularAprobados(){
        int aprobados = 0;

        for(Estudiante e : Datos.estudiantes()){
            if(e.getCalificacion() >= 70){
                aprobados ++;
            }
        }
        return aprobados;
    }

    private int calcularReprobados(){
        int reprobados = 0;
    
        for(Estudiante e : Datos.estudiantes()){
            if(e.getCalificacion() < 70){
                reprobados ++;
            }
        }
        return reprobados;
    }
    private double promedioGeneral(){
        double promedioGeneral = 0;

        for(Estudiante e : Datos.estudiantes()){
            promedioGeneral += (double) e.getCalificacion();
        }
        return promedioGeneral / Datos.estudiantes().size();
    }

    @FXML 
    private void crearCopiaSeguridad(){
        try {
            Archivos.copiaSeguridad();
        } catch (Exception e) {
            lblMensaje.setText("Error al crear la copia");
            return;
        }
        lblMensaje.setText("¡Copia creada correctamente!");
    }

    @FXML 
    private void restaurarCopiaSeguridad(){
        try {
            Archivos.recuperarCopia();
        } catch (Exception e) {
           lblMensaje.setText("Error al restuarar los datos");
           return;
        }
        lblMensaje.setText("¡Datos restuarados correctamente!");
    }
    
    @FXML 
    private void close(){
        btnCerrar.getScene().getWindow().hide();
    }
}
