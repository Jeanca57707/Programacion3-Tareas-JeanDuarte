package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.*;

public class EstadisticaController {


    @FXML private Button btnCopiaSeguridad, btnRecuperarCopia;

    @FXML private Label lblMensaje, lblEstudiantesRegistrados, lblEstudiantesAprobados,
    lblEstudiantesReprobados, lblPromedioGeneral;

    @FXML 
    private void initialize(){
        Archivos.leerEstudiantes();
        lblEstudiantesAprobados.setText("Estudiantes aprobados: " + calcularAprobados());
        lblEstudiantesReprobados.setText("Estudiantes reprobados: " + calcularReprobados());
        lblEstudiantesRegistrados.setText("Estudiantes registrados: " + Datos.estudiantes().size());
        lblPromedioGeneral.setText("Promedio General: " + String.format("%.2f", promedioGeneral()));
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
}
