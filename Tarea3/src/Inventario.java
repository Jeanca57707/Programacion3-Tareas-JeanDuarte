public class Inventario implements Buscable{

    private String[] productos;
    private double[] precios;
    private int[] cantidades;

    public Inventario(String[]productos, double[]precios, int[] cantidades){

        this.productos = productos;
        this.precios = precios;
        this.cantidades = cantidades;
    }

	public String[] getProductos() {
		return productos;
	}

	public void setProductos(String[] productos) {
		this.productos = productos;
	}

	public double[] getPrecios() {
		return precios;
	}

	public void setPrecios(double[] precios) {
		this.precios = precios;
	}

	public int[] getCantidades() {
		return cantidades;
	}

	public void setCantidades(int[] cantidades) {
		this.cantidades = cantidades;
	}


    public void mostrarInventario(){

        ordenacionBurbuja();

        double totalGeneral = totalGeneral();
        double [] valorTotal = valorTotal();
        String [] enStock = productosEnStock();

        System.out.println("\n------------------------------------------------------------");
        System.out.println("PRODUCTO\tPRECIO\t\tCANTIDAD\tVALOR TOTAL");
        System.out.println("------------------------------------------------------------");
        for(int i = 0; i< productos.length; i++){

            System.out.println(String.format("%-15s\t%-15.2f\t%-10d\t%-15.2f", productos[i], precios[i], cantidades[i], valorTotal[i]));
        }
        System.out.println("------------------------------------------------------------");

        System.out.printf("\nTOTAL GENERAL: %.2f%n", totalGeneral);
        System.out.println("\nEL PRODUCTO DE MAYOR VALOR ES: " + mayor(precios));
        System.out.println("\nEL PRODUCTO DE MENOR VALOR ES: " + menor(precios));
        System.out.println("\nPRODUCTOS QUE ESTAN EN STOCK:");

        for(int i = 0; i< enStock.length; i++){
            System.out.println(enStock[i]);
        }
    }

    //Método que calcula el valor total de cada producto
    public double[] valorTotal(){

        double[] valorTotal = new double[productos.length];

        for(int i = 0; i < productos.length; i++){

            int cantidad = cantidades[i];
            double precio = precios[i];
            double valor = cantidad * precio;

            valorTotal[i] = valor;
        }

        return valorTotal;
    }

    //Método que calcula el valor total general que tiene el inventario
    public double totalGeneral(){

        double valorGeneral = 0;

        for(int i = 0; i< productos.length; i ++){

            valorGeneral += cantidades[i] * precios[i];
        }
        return valorGeneral;
    }

    @Override
    public String mayor(double [] precios){

        double mayor = precios[0];
        int indice = 0;

        for(int i = 0; i < precios.length; i++){

            if(precios[i] > mayor){
                mayor = precios[i];
                indice = i;
            }
        }
        return productos[indice];
    }
    @Override
    public String menor(double[] precios){

        double menor = precios[0];
        int indice = 0;

        for(int i = 0; i < precios.length; i++){

            if(precios[i] < menor){
                menor = precios[i];
                indice = i;
            }
        }
        return productos[indice]; 
    }

    //Metodo que revisa cuales productos están es Stock (MENOS DE 15 PRODUCTOS)
    public String[] productosEnStock(){

        int enStock = 0;

        for(int i = 0; i < cantidades.length; i ++){
            if(cantidades[i] < 15){
                enStock ++;
            }
        }
        if(enStock > 0){

            String[] stock = new String[enStock];

            for(int i = 0; i < cantidades.length; i ++){
                if(cantidades[i] < 15){
                    stock[i] = productos[i];
                }
            }
            return  stock;
        }
        else{
           String [] mensaje = {"NO hay productos en Stock"};
           return mensaje;
        }    
    }

    //Algoritmo de ordenacion de burbuja para ordenar todos los arreglos según el precio de los productos
    public void ordenacionBurbuja(){

        boolean ordenado;

        for(int i = 0; i < precios.length - 1; i++){

            ordenado = false;

            for(int j = 0; j < precios.length - 1; j++){

                if(precios[j] < precios[j+1]){
                    
                    double aux = precios[j];
                    precios[j] = precios[j+1];
                    precios[j+1] = aux;

                    String aux2 = productos[j];
                    productos[j] = productos[j+1];
                    productos[j+1] = aux2;

                    int aux3 = cantidades[j];
                    cantidades[j] = cantidades[j+1];
                    cantidades[j+1] = aux3;

                    ordenado = true;
                }
            }
            if(!ordenado){
                break;
            }
        }
    }

    //Método para buscar un producto<
    public int busquedaProducto(String[] productos, String busqueda){

        for(int i = 0; i < productos.length; i++){
            if(productos[i].toLowerCase().contains(busqueda.toLowerCase())){

                return i;
            }
        }
        return -1;
    }
   
     
}