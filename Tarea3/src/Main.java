import java.util.*;

public class Main{

    public static void main(String[] args) {
        
        menu();
    }

    public static void menu(){

        Scanner sc = new Scanner(System.in);
        int opc = 0;

        String[] productos = {"Laptop", "Mouse", "Teclado", "Monitor", "Audifonos"};
        double[] precios = {45000.0, 850.0, 1200.0, 12000.0, 2500.0};
        int[] cantidades = {10, 50, 30, 8, 25};

        Inventario i = new Inventario(productos, precios, cantidades);

        String[] nombres = {"Ana","Luis","Maria","Carlos"};
        double[][]parciales = {{8.5,9.0,7.5},
                               {6.0,5.5,7.0},
                               {9.0,8.5,9.5},
                               {4.5,6.0,7.0}};
        Estudiante e = new Estudiante(nombres, parciales);


        String datos =  "Juan Perez,juanp@empresa.com,Sistemas,35000\n" +                
        "Ana Lopez,anal@empresa.com,Contabilidad,28000\n" +                
        "Carlos Ruiz,carlosr@gmail.com,Sistemas,42000\n" +                
        "Maria Diaz,mariad@empresa.com,RRHH,31000\n" +                
        "Luis Marte,luism@gmail.com,Sistemas,38000";

        do{

            System.out.println("\n=====================================");
            System.out.println("||   MENU PRINCIPAL DE EJERCICIOS   ||");
            System.out.println("=====================================\n");

            System.out.println("1. Inventario.");
            System.out.println("2. Estudiantes.");
            System.out.println("3. Busqueda de producto.");
            System.out.println("4. Inventario.");
            System.out.println("5. Inventario.");
            System.out.println("6. Inventario.");
            System.out.println("0. Salir.");

            System.out.printf("\nElija una opcion: ");
            opc = sc.nextInt();

            switch (opc) {
                case 1: 
                    i.mostrarInventario();
                    
                    break;
                case 2: 
                    e.mostarParciales();

                    break;
                
                case 3:
                    int indice = i.busquedaProducto(productos, "laptop");
                    int indice2 = i.busquedaProducto(productos, "mousE");
                    int indice3 = i.busquedaProducto(productos, "moNitor");

                    int [] indices = {indice, indice2, indice3};

                    for(int a = 0; a < indices.length; a++){

                        if(indices[a] != -1){

                           System.out.println(productos[a]  + " - " + precios[a] + " - " + cantidades[a]);
                        }
                        else{
                           System.out.println("Objeto no encontrado.");
                        }
                    } 
                    break;
                
                case 4:

                    break;
                
                case 0:
                    System.out.println("\nSaliendo del programa...");
                    break;
            
                default:
                    System.out.println("\nOpcion invalida.");
                    break;
            }

        }while(opc != 0);

        sc.close();
    }
}