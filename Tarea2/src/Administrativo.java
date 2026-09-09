public class Administrativo extends Empleado {

    private String departamento;
    private String cargo;
    
    public Administrativo(int codigo, String nombre, String apellido, double salario, String departamento,
            String cargo) {
        
        super(codigo, nombre, apellido, salario);
        this.departamento = departamento;
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override 
    public void trabajar(){


    }

    @Override 
    public String toString(){

        return super.toString() + " - " + "Asignatura que imparte: " 
        + getDepartamento() + " - " + "Horas que imparte la materia: " + getCargo();
    }

    
    
}
