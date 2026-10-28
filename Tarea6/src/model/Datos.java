package model;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

public class Datos {

    private static final ObservableList<Estudiante> ESTUDIANTES = FXCollections.observableArrayList();

    public static ObservableList<Estudiante> estudiantes(){
        return ESTUDIANTES;
    }
}
