import java.util.Scanner;

public class Calculadora{

    public int suma(int num1, int num2){

        return  num1 + num2;
    }
    public int resta(int num1, int num2){

        return num1 - num2;
    }
    public int multiplicacion(int num1, int num2){

        return num1 * num2;
    }
    public double division(int num1, int num2){

        if(num2 == 0){

            return 0;
        }
        else{

            return (double) num1 / num2;
        }
    }

    public void menuCalculadora(){

        Scanner sc  =  new Scanner(System.in);
        int opc;

        do{

            System.out.println("\n===============================");
            System.out.println("||    CALCULADORA BASICA    ||");
            System.out.println("===============================\n");

            System.out.println("1. Sumar.");
            System.out.println("2. Restar.");
            System.out.println("3. Multiplicar.");
            System.out.println("4. Dividir.");
            System.out.println("5. Salir.\n");

            System.out.print("Elija una opcion: ");
            opc = sc.nextInt();

            switch (opc) {
                case 1:

                 int num1; 
                 int num2;

                  System.out.print("Numero 1: ");
                  num1 = sc.nextInt();

                  System.out.print("Numero 2: ");
                  num2 = sc.nextInt();

                  System.out.print("Resultado: " + suma(num1, num2));

                  break;

                case 2:

                 int num3; 
                 int num4;

                  System.out.print("Numero 1: ");
                  num3 = sc.nextInt();

                  System.out.print("Numero 2: ");
                  num4 = sc.nextInt();

                  System.out.print("Resultado: " + resta(num3, num4));

                  break;
     
                case 3:

                 int num5; 
                 int num6;

                  System.out.print("Numero 1: ");
                  num5 = sc.nextInt();

                  System.out.print("Numero 2: ");
                  num6 = sc.nextInt();

                  System.out.println("Resultado: " + multiplicacion(num5, num6));

                  break;

                case 4:

                 int num7; 
                 int num8;

                  System.out.print("Numero 1: ");
                  num7 = sc.nextInt();

                  System.out.print("Numero 2: ");
                  num8 = sc.nextInt();

                  System.out.println("Resultado: " + division(num7, num8));

                  break;

                case 5:
                    System.out.println("Saliendo de la calculadora...");
                    break;
            
                default:
                    System.out.println("Opcion invalida.");
                    break;
            }
           
        }while(opc != 5);
       
    }

}