public class Rectangulo {

    private double base;
    private double altura;

    public Rectangulo(double base, double altura) {

        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double calcularArea(){

        System.out.println("\nArea del rectangulo:");

        return base * altura;
    }
    public double clacularPerimetro(){

        System.out.println("\nPerimetro del rectangulo:");

        return  2 * (base + altura);
    }
   
}
