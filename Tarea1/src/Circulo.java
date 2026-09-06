public class Circulo extends Figura {

    private final double PI = 3.141592;
    private double radio;


    public Circulo(double radio) {
        this.radio = radio;
    }
    
    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override 
    public double calcularArea(){

        System.out.print("\nEl Area es: ");

        return (radio * radio) * PI;
    }
    
}
