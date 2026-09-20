import java.util.*;

public class Main{

    public static void main(String[] args) {

        String[] productos = {"Laptop", "Mouse", "Teclado", "Monitor", "Audifonos"};
        double[] precios = {45000.0, 850.0, 1200.0, 12000.0, 2500.0};
        int[] cantidades = {10, 50, 30, 8, 25};

        Inventario i = new Inventario(productos, precios, cantidades);

        i.mostrarInventario();
        

    }

    public static void menu(){

        Scanner sc = new Scanner(System.in);
        int opc = 0;

        do{

            System.out.println("\n=====================================");
            System.out.println("||    MENU PRINCIPAL DE EJERCICIOS    ||");
            System.out.println("=====================================\n");

            System.out.println("1. Inventario.");
            System.out.println("1. Inventario.");
            System.out.println("1. Inventario.");
            System.out.println("1. Inventario.");
            System.out.println("1. Inventario.");
            System.out.println("1. Inventario.");
            System.out.println("0. Salir.");

            System.out.printf("\nElija una opcion: ");
            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    
                    break;
            
                default:
                    break;
            }



        }while(opc != 0);

        sc.close();
    }
}