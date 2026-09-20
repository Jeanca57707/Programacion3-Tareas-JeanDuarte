import java.util.*;

public class Main{

    public static void main(String[] args) {

        String[] productos = {"Laptop", "Mouse", "Teclado", "Monitor", "Audifonos"};
        double[] precios = {45000.0, 850.0, 1200.0, 12000.0, 2500.0};
        int[] cantidades = {10, 50, 30, 8, 25};

        String[] nombres = {"Ana","Luis","Maria","Carlos"};
        double[][]parciales = {{8.5,9.0,7.5},
                               {6.0,5.5,7.0},
                               {9.0,8.5,9.5},
                               {4.5,6.0,7.0}};
        Estudiante e = new Estudiante(nombres, parciales);

        Inventario i = new Inventario(productos, precios, cantidades);

        i.mostrarInventario();
        e.mostarParciales();
        

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