import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

public class App {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Timer timer = new Timer();

        System.out.println("Inici: " + LocalTime.now());

        for (int i = 0; i < 10; i++) {
            Tasca tasca = new Tasca(LocalTime.now().plusSeconds(10 + i * 5), "Tasca (" + i + ")");
            System.out.println("Tasca (" + i + ")");
            agenda.afegeixTasca(tasca);
        }


        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Thread(agenda).start();
            }
        }, 2000, 2000);

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        agenda.sortir();
        timer.cancel();

        System.out.println("Completat");
    }
}