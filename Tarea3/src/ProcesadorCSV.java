public class ProcesadorCSV {

    private String datos;

    public ProcesadorCSV(String datos) {
        this.datos = datos;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    @Override 
    public String toString(){
        return datos;
    }
    public void formatoTabla(){

        String[] separador = datos.split("\n");

        System.out.printf("------------------------------------------------------------------------");
        System.out.printf("%n%-15s %-25s %-18s %-10s%n","NOMBRE" ,"CORREO" ,"DEPARTAMENTO" ,"SALARIO");
        System.out.printf("------------------------------------------------------------------------\n");
        for(String linea : separador){

            String [] campos = linea.split(",");
            System.out.printf("%-15s %-25s %-18s %-10s%n", campos[0].toUpperCase(), campos[1].toLowerCase(), campos[2], campos[3]);
        }
        System.out.println("------------------------------------------------------------------------");
    } 

    public void filtrar(){

        System.out.println("\nFILTRAR POR DEPARTAMENTO DE SISTEMAS: \n");

        String[] separador = datos.split("\n");
        for(int i = 0; i< separador.length; i++){
            if(separador[i].contains("Sistemas")){
                String sis = separador[i].replace(",", "---");
                System.out.println(sis);
            }
        }
    }
    public void filtrarCorreo(){

        System.out.println("\nFILTRAR CORREOS (@empresa.com): \n");

        String[] separador = datos.split("\n");
        for(String linea : separador){

            String[] campos = linea.split(",");
            for(int i = 0; i < campos.length; i++){
                if(campos[i].endsWith("@empresa.com")){
                    System.out.println(campos[i]);
                }
            } 
        }
    }

    public double salario(){

        String[] separador = datos.split("\n");
        double promGen = 0;
        int cantidad = 0;
        for(String linea : separador){

            String [] campos = linea.split(",");
            for(int i = 0; i< campos.length; i++){
                
                double salario = Double.parseDouble(campos[3]);
                promGen += salario;
                cantidad ++;
            }
        } 
       return promGen / cantidad;
    }

    public String menor(){

        String[] separador = datos.split("\n");
        String empleado = "";
        double menor = Double.MAX_VALUE;

        for(String linea : separador){
            String []campos = linea.split(",");

            String nombre = campos[0];
            double salario = Double.parseDouble(campos[3]);

            if(salario < menor){
                menor = salario;
                empleado = nombre;
            }
        }
        return "Empleado con menor sueldo: " + empleado + " - " + menor;
    }
    public String mayor(){

        String[] separador = datos.split("\n");
        String empleado = "";
        double mayor = 0.0;

        for(String linea : separador){
            String []campos = linea.split(",");

            String nombre = campos[0];
            double salario = Double.parseDouble(campos[3]);

            if(salario > mayor){
                mayor = salario;
                empleado = nombre;
            }
        }
        return "Empleado con mayor sueldo: " + empleado + " - " + mayor;
    }

    
}
