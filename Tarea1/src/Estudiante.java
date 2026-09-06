public class Estudiante {

    private String nombre;
    private int[] materias = new int[5];


    public Estudiante(String nombre, int[] materias) {

        this.nombre = nombre;
        this.materias = materias;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int[] getMaterias() {
        return materias;
    }

    public void setMaterias(int[] materias) {
        this.materias = materias;
    }

    public double calcularPromedio(){

        double sumaTotal = 0;

        for(double calficacion : materias){

            sumaTotal += calficacion;
        }

        return sumaTotal / materias.length;
            

    }
    public String obtenerCalificacion(){

        if(calcularPromedio() >= 60){

            return "Aprobado";
        }
        else{

            return "Reprobado";
        }
    }
    
}
