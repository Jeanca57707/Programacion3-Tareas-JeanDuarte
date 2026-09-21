import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class CalculadoraFecha {
    private Calendar ahora;

    public CalculadoraFecha(Calendar ahora) {
        this.ahora = Calendar.getInstance();
    }

    public void mostrarFechaActual(){

        Date fechaActual = ahora.getTime();

        SimpleDateFormat formato1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        SimpleDateFormat formato2 = new SimpleDateFormat("EEEE/ d 'de' MMMM 'de' yyyy");
        SimpleDateFormat formato3 = new SimpleDateFormat("yyyy-MMMM-dd (hh:mm a)");

        System.out.println("\nHORA ACTUAL EN DIFERNTES FORMATOS\n");
        System.out.println("Formato 1: " + formato1.format(fechaActual));
        System.out.println("Formato 2: " + formato2.format(fechaActual));
        System.out.println("Formato 2: " + formato3.format(fechaActual));
        System.out.println();

    }
    public Date calcularFechaEnDias(int dias){
        Calendar fechaFutura = (Calendar) ahora.clone();
        fechaFutura.add(Calendar.DAY_OF_YEAR, dias);
        return  fechaFutura.getTime();
    }

    public Date calcularFechaEnMeses(int meses){
        Calendar fechaPasada = (Calendar) ahora.clone();
        fechaPasada.add(Calendar.MONTH, meses);
        return fechaPasada.getTime();
    }

    public int calcularEdad(int anio){
        int anioActual = ahora.get(Calendar.YEAR);
        return anioActual - anio;
    }

    public double calcularDiasParaFinalDeAnio(){

        Calendar finDeAnio = Calendar.getInstance();
        finDeAnio.set(Calendar.MONTH, Calendar.DECEMBER);
        finDeAnio.set(Calendar.DAY_OF_MONTH, 31);

        double msActual = ahora.getTimeInMillis();
        double msFinDeAnio = finDeAnio.getTimeInMillis();

        double diferenciaDeMes = msFinDeAnio - msActual;
        return  diferenciaDeMes / (1000.0 * 60 * 60 * 24);
    }

    
}
