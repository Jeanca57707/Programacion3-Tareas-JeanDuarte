import java.util.ArrayList;

public static void main(String[] args){

    Profesor p1 = new Profesor(001, "Carlos", "Perez", 25000, "Matematicas", 5);
    Administrativo adm1 = new Administrativo(101, "Ana", "Castro", 39000, "Finanzas", "Contador");
    Mantenimiento m1 = new Mantenimiento(201, "Pedro", "Rivas", 14000, "Edificio C");
    Profesor p2 = new Profesor(002, "Maria", "Torres", 28000, "Historia", 7);
    Administrativo adm2 = new Administrativo(102, "Jorge", "Ramos", 41000, "Compras", "Director");
    Mantenimiento m2 = new Mantenimiento(202, "Raul", "Mendoza", 18000, "Edificio A");
    Profesor p3 = new Profesor(003, "Luis", "Valdes", 26000, "Quimica", 3);
    Administrativo adm3 = new Administrativo(103, "Sofia", "Vargas", 38000, "Personal", "Asistente");
  
    Empleado [] empleados = {p1, adm1, m1, p2, adm2, m2, p3, adm3}; 

    int salarioTotal = 0;
    int prof = 0;
    int adm = 0;
    int mant = 0;
    Empleado empleadoDelMes = empleados[0];
    
    for(int i = 0; i< empleados.length; i++){

        salarioTotal += empleados[i].getSalario();
        empleados[i].trabajar();
        System.out.println(empleados[i].getNombre() + " pertenece a: " + empleados[i].getClass());
        if(empleados[i] instanceof Profesor){
            prof ++;
            System.out.println(empleados[i].getNombre() + " tiene un bono de: " + ((Profesor)empleados[i]).calcularBono());

        }
        else if(empleados[i] instanceof Administrativo){
            adm ++;
            System.out.println(empleados[i].getNombre() + " tiene un bono de:  " + ((Administrativo)empleados[i]).calcularBono());
        }
        else{
            mant ++;
        }
        if(empleadoDelMes.getSalario() < empleados[i].getSalario()){
            empleadoDelMes = empleados[i];
        }
    }
    System.out.println("\nEl empleado con el sueldo más alto es " + empleadoDelMes.getNombre() + " con un sueldo de: " + empleadoDelMes.getSalario());
    
    System.out.println("\nEstan registrados: \n" + prof + " Profesores \n" +
        adm + " Administrativos \n" + mant + " de Mantenimiento"
    );
}