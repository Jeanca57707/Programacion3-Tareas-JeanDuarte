public abstract class Empleado{

    private int codigo;
    private String nombre;
    private String apellido;
    private double salario;

    public Empleado(int codigo, String nombre, String apellido, double salario) {
       
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {

        if(salario > 0){
            this.salario = salario;
        }
    }

    public abstract void trabajar();

    @Override 
    public String toString(){

        return "Codigo: " + getCodigo() + " - " + "Nombre completo: " + getNombre() + " " + getApellido() 
        + " - " + "Salario: " + getSalario();
    }
 
}