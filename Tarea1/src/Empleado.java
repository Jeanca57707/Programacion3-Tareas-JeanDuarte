public class Empleado extends Persona{

    private String puesto;
    private double salario;

    public Empleado(){
        
        super();
        puesto = "";
        salario = 0;
    }

    public Empleado(String nombre, int edad, String correo, String puesto, double salario) {
        
        super(nombre, edad, correo);
        this.puesto = puesto;
        this.salario = salario;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double calcularBono(){

        System.out.print("\nBono: ");

        return salario * 0.10;
    }

    @Override 
    public void mostrarInfo(){

        super.mostrarInfo();
        System.out.print("Puesto: " + getPuesto());
        System.out.print("\nSalario: " + getSalario());
    }
}
