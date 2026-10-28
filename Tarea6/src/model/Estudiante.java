package model;

import java.io.Serializable;

public class Estudiante implements Serializable {

    private String matricula;
    private String nombre;
    private String carrera;
    private float calificacion;

    public Estudiante(String matricula, String nombre, String carrera, float calificacion) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.carrera = carrera;
        this.calificacion = calificacion;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    @Override 
    public String toString(){
        return matricula + " " + nombre + " " + carrera + " " + calificacion;
    }   
}