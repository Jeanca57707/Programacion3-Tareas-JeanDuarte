public class Administrativo extends Empleado implements Bonificable {

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

        System.out.println(getNombre() + " se encuentra en el apartamento de " + getDepartamento() + ". Su cargo es: " + getCargo());

    }
    @Override
    public double calcularBono(){

        return getSalario() * 0.25;
    }

    @Override 
    public String toString(){

        return super.toString() + " - " + "Asignatura que imparte: " 
        + getDepartamento() + " - " + "Horas que imparte la materia: " + getCargo();
    }

    
    
}
