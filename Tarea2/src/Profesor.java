public class Profesor extends Empleado implements Bonificable{

    private String asignatura;
    private int horas;
    
    public Profesor(int codigo, String nombre, String apellido, double salario, String asignatura, int horas) {
        
        super(codigo, nombre, apellido, salario);
        this.asignatura = asignatura;
        this.horas = horas;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {

        if(horas > 0){
            this.horas = horas;
        }
        
    }

    @Override 
    public void trabajar(){

        System.out.println(getNombre() + " esta impartiendo clases de " + getAsignatura() + " en estos momentos");
    }

    @Override 
    public double calcularBono(){

        return getSalario() * 0.15;

    }

    @Override
    public String toString(){

        return super.toString() + " - " + "Asignatura que imparte: " 
        + getAsignatura() + " - " + "Horas que imparte la materia: " + getHoras();
    }   
    
}
