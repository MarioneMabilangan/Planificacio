import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TascaProgramada {

    public static void main(final String... args) throws InterruptedException {
        Calendar cal = new GregorianCalendar();
        System.out.println("Inici: " + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND));

        final ScheduledExecutorService schExService = Executors.newScheduledThreadPool(2);
        final Runnable ob = new ExecutaFil();
        schExService.scheduleWithFixedDelay(ob, 2, 3, TimeUnit.SECONDS);
        schExService.awaitTermination(10, TimeUnit.SECONDS);
        schExService.shutdownNow();
        System.out.println("Completat");
    }

}
