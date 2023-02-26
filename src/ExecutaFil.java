import java.util.Calendar;
import java.util.GregorianCalendar;

public class ExecutaFil implements Runnable{
    @Override
    public void run() {
        Calendar calendario = new GregorianCalendar();
        System.out.println("Hora execució tasca: "
        + calendario.get(Calendar.HOUR_OF_DAY) + ":"
        + calendario.get(Calendar.MINUTE)
        + ":" + calendario.get(Calendar.SECOND));
        System.out.println("Tasca en execució");
        System.out.println("Execució acabada");
    }
}
