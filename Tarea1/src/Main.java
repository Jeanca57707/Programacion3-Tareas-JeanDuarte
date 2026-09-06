import java.util.*;

public static void main(String[] args){

   menu();

}

public static void menu(){

    Scanner sc = new Scanner(System.in);
    int opcion;

    do{
        System.out.println("\n================================");
        System.out.println("||     MENU DE EJERCICIOS     ||");
        System.out.println("================================\n");

        System.out.println("1. Calculadora básica.");
        System.out.println("2. Par o impar.");
        System.out.println("3. Tabla de Multiplicar.");
        System.out.println("4. Numeros del 1 al 100.");
        System.out.println("5. Clase Persona.");
        System.out.println("6. Clase Rectangula..");
        System.out.println("7. Clase Empleado.");
        System.out.println("8. Clase Figura.");
        System.out.println("9. Contador de vocales.");
        System.out.println("10. Calculadora de notas.");
        System.out.println("\n0. Salir.\n");

        System.out.print("Elija una opción: ");
        opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                Calculadora calculadora = new Calculadora();
                calculadora.menuCalculadora();
                break;
        
            default:
                break;
        }
    
    }while(opcion != 0);

}