public class Estudiante implements Buscable{

    private String nombre;
    private String correo;
    private String matricula;
    private String [] nombres;
    private double[][] parciales;
	
    public Estudiante(String nombre, String correo, String matricula) {
		this.nombre = nombre;
		this.correo = correo;
		this.matricula = matricula;
	}

	public Estudiante(String[] nombres, double[][] parciales) {
		this.nombres = nombres;
		this.parciales = parciales;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String[] getNombres() {
		return nombres;
	}

	public void setNombres(String[] nombres) {
		this.nombres = nombres;
	}

	public double[][] getParciales() {
		return parciales;
	}

	public void setParciales(double[][] parciales) {
		this.parciales = parciales;
	}

    public void mostarParciales(){

        double [] promedio = promedio();
        String [] estados = estado(promedio);
        double [] promPorParcial = promedioParciales();
        String mejorEst = mayor(promedio);
        String peorEst = menor(promedio);

        System.out.println("\n------------------------------------------------------------------------------------------");
        System.out.println("ESTUDIANTE\tPARCIAL 1\tPARCIAL 2\tPARCIAL 3\tPROMEDIO\tESTADO");
        System.out.println("------------------------------------------------------------------------------------------");

        for(int i = 0; i <nombres.length; i ++){
           
            System.out.println(String.format("%s\t\t%.2f\t\t%.2f\t\t%.2f\t\t%.2f\t\t%s", nombres[i], parciales[i][0],
            parciales[i][1], parciales[i][2], promedio[i], estados[i]));  
        }
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.printf("PROMEDIO\t");
        for(int i = 0; i< promPorParcial.length; i ++){
            System.out.printf("%.2f\t\t", promPorParcial[i]);
        }
        System.out.println("\n------------------------------------------------------------------------------------------");
        System.out.println("\nMEJOR ESTUDIANTE: " + mejorEst);
        System.out.println("\nPEOR ESTUDIANTE: " + peorEst);
        cantApr_Rep(estados);
      
    }

    public double[] promedio(){

        double[] promedioEst = new double[nombres.length];
        for(int i = 0; i < nombres.length; i ++){

            double promedio = (parciales[i][0] +  parciales[i][1] +  parciales[i][2])/ 3.0;
            promedioEst[i] = promedio;
        }
        return promedioEst;
    }

    public String [] estado(double[]promedio){

        String[] estadosEst = new String[promedio.length]; 

        for(int i = 0; i< promedio.length; i++){
            if(promedio[i] >= 6.0){
                estadosEst[i] = "Aprobado";
            }
            else{
                estadosEst[i] = "Reprobado";
            }
        }
        return estadosEst;
    }
    public double [] promedioParciales(){

        double [] promedioParciales = new double[3];

        for(int i = 0; i < nombres.length-1 ; i ++){

            double prom = (parciales[0][i] + parciales[1][i]+ parciales[2][i]+ parciales[3][i]) / 4.0;
            promedioParciales[i] = prom;
        }
        return promedioParciales;
    }

    @Override 
    public String mayor(double[] promedios){

        double mejor = promedios[0];
        int indice = 0;
        for(int i = 0; i < promedios.length; i++){
            if(promedios[i] > mejor){
                mejor = promedios[i];
                indice = i;
            }     
        }
        return nombres[indice];
    }
    @Override 
    public String menor(double[] promedios){

        double peor = promedios[0];
        int indice = 0;
        for(int i = 0; i < promedios.length; i++){
            if(promedios[i] < peor){
                peor = promedios[i];
                indice = i;
            }
        }
        return nombres[indice];
    }
    public void cantApr_Rep(String[] estados){

        int apr = 0;
        int rep = 0;
        for(int i = 0; i< estados.length; i ++){

            if(estados[i].equals("Aprobado")){
                apr ++;
            }
            else{
                rep ++;
            }
        }
        System.out.println("\nAPROBADOS: " + apr);
        System.out.println("\nREPROBADOS: " + rep);
    }

}
