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
        PieChart.Data aprobados = new PieChart.Data("Aprobados", calcularAprobados());
        PieChart.Data reprobados = new PieChart.Data("Reprobados", calcularReprobados());
        grafico.getData().addAll(aprobados, reprobados);
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
    private void close(){
        btnCerrar.getScene().getWindow().hide();
    }
}
