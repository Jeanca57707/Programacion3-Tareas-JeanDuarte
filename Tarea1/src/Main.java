
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
        System.out.println("6. Clase Rectangulo.");
        System.out.println("7. Clase Empleado.");
        System.out.println("8. Clase Figura.");
        System.out.println("9. Contador de vocales.");
        System.out.println("10. Calculadora de notas.");
        System.out.println("\n0. Salir.\n");

        System.out.print("Elija una opción: ");
        opcion = sc.nextInt();
        System.out.print("\n");
        

        switch (opcion) {
            case 1:

                Calculadora calculadora = new Calculadora();
                calculadora.menuCalculadora();
                break;

            case 2:

                int num;
                System.out.print("Digite un número: ");
                num = sc.nextInt();
                numPar_o_Impar(num);  
                break;

            case 3:

                int numero;
                System.out.print("Digite un número: ");
                numero = sc.nextInt();
                tabla(numero);  
                break;

            case 4:
                numsDelUnoAlCien();
                break;

            case 5:

                String nombre;
                int edad;
                String correo;

                sc.nextLine();

                System.out.print("Nombre: ");
                nombre = sc.nextLine();

                System.out.print("Edad: ");
                edad = sc.nextInt();

                sc.nextLine();

                System.out.print("Correo: ");
                correo = sc.nextLine();

                Persona p = new Persona(nombre, edad, correo);
                System.out.println("\nDatos de la persona:");
                p.mostrarInfo();
                break;

            case 6:

                double altura;
                double base; 

                System.out.print("Altura: ");
                altura = sc.nextDouble();

                System.out.print("Base: ");
                base = sc.nextDouble();

                Rectangulo r = new Rectangulo(base, altura);
                System.out.println(r.calcularArea());
                System.out.println(r.clacularPerimetro());   
                break;

            case 7:

                String nombreEmp;
                String correoEmp;
                int edadEmp;
                String puesto;
                double salario;

                sc.nextLine();

                System.out.print("Nombre del empleado: ");
                nombreEmp = sc.nextLine();

                System.out.print("Correo del empleado: ");
                correoEmp = sc.nextLine();

                System.out.print("Edad del empleado: ");
                edadEmp = sc.nextInt();
                sc.nextLine();

                System.out.print("Puesto del empleado: ");
                puesto = sc.nextLine();

                System.out.print("Salario del empleado: ");
                salario = sc.nextDouble();

                Empleado e = new  Empleado(nombreEmp, edadEmp, correoEmp, puesto, salario);
                System.out.println("\nDatos del empleado:");
                e.mostrarInfo();
                System.out.print(e.calcularBono());
                break;

            case 0:
                System.out.println("Saliendo del programa...");
                break;
        
            default:
                System.out.println("Opcion invalida");
                break;
        }
        
    }while(opcion != 0);
    sc.close();

}

public static void numPar_o_Impar(int num){

    if(num == 0){

        System.out.println("El numero simplemente es " + num);
    }
    else if(num % 2 == 0){

        if(num > 0){

            System.out.println(num + " es par y positivo.");        
        }
        else{

            System.out.println(num + " es par y negativo.");
        }
    }
    else{

        if(num > 0){

            System.out.println(num + " es impar y positivo.");        
        }
        else{

            System.out.println(num + " es impar y negativo.");
        }
    }
    
}

public static void tabla(int num){

    System.out.println("Tabla de multiplicar del " + num +"\n");

    for(int i = 1; i <= 10; i++){

        System.out.println(num + " x " + i + " = " + (num * i));
    }
}

public static void numsDelUnoAlCien(){

    for(int i = 1; i <= 100; i ++){

        if( i % 3 == 0 && i % 5 == 0){
            System.out.println("FizzBuzz");
        }
        else if(i % 3 == 0){
            System.out.println("Fizz");
        }
        else if(i % 5 == 0){
            System.out.println("Buzz");
        }
        else{
            System.out.println(i);
        }
    }
}