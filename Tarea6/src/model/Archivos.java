package model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;

public class Archivos {

    public static final String NOMBRE_ARCHIVO = "estudiante.txt";
    public static File fileEstudiantes = new File(NOMBRE_ARCHIVO);

    public static void guardarEstudiante(Estudiante estudiante) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true))) {

            bw.write(estudiante.toString());
            bw.newLine();

        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    public static void leerEstudiantes() {

        if (fileEstudiantes.length() == 0) {
            System.out.println("El archivo está vacio");

        } else {
            Datos.estudiantes().clear();

            try (BufferedReader br = new BufferedReader(new FileReader(fileEstudiantes))) {

                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] partes = linea.split("; ");

                    String matricula = partes[0];
                    String nombre = partes[1];
                    String carrera = partes[2];
                    float calificacion = Float.parseFloat(partes[3]);

                    Estudiante estudiante = new Estudiante(matricula, nombre, carrera, calificacion);
                    Datos.estudiantes().add(estudiante);
                }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error de formato de numero en el archivo: " + e.getMessage());
            }
        }
    }

    public static void actualizarEstudiante(Estudiante estudianteEditado) {

        try (BufferedReader br = new BufferedReader(new FileReader(fileEstudiantes));
                BufferedWriter bw = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO))) {

            String linea;
            while ((linea = br.readLine()) != null) {

                String[] partes = linea.split("; ");
                String matricula = partes[0];
                String nombre = partes[1];
                String carrera = partes[2];
                float calificacion = Float.parseFloat(partes[3]);

                Estudiante estudiante = new Estudiante(matricula, nombre, carrera, calificacion);

                if (estudiante.getMatricula().equals(estudianteEditado.getMatricula())) {
                    bw.write(estudianteEditado.toString());
                    bw.newLine();
                } else {
                    bw.write(estudiante.toString());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error de archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error de formato de numero: " + e.getMessage());
        }
    }

    public static void eliminarEstudiante(Estudiante estudianteSeleccionado) {

        try (BufferedReader br = new BufferedReader(new FileReader(Archivos.fileEstudiantes));
                BufferedWriter bw = new BufferedWriter(new FileWriter(Archivos.NOMBRE_ARCHIVO))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.contains(estudianteSeleccionado.toString())) {

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
            System.out.println("Error al eliminar el estudiante del archivo");

        } catch (NumberFormatException e) {
            System.out.println("Se encontró un formato de calificación erróneo");
        }
    }
}