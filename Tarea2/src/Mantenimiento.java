public class Mantenimiento extends Empleado{

    private String areaAsig;

    public Mantenimiento(int codigo, String nombre, String apellido, double salario, String areaAsig) {
        
        super(codigo, nombre, apellido, salario);
        this.areaAsig = areaAsig;
    }

    public String getAreaAsig() {
        return areaAsig;
    }

    public void setAreaAsig(String areaAsig) {
        this.areaAsig = areaAsig;
    }

    @Override 
    public void trabajar(){

    }

    @Override 
    public String toString(){

        return super.toString() + " - " + "Area asignada: " + getAreaAsig();
    }

    
    
}
