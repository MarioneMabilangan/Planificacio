import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Agenda implements Runnable{
    private List<Tasca> tasques;
    private boolean sortir;

    public Agenda() {
        tasques = new ArrayList<>();
        sortir = false;
    }

    public synchronized boolean afegeixTasca(Tasca tasca) {
        if (tasca.getHoraExecucio().isBefore(LocalTime.now())) {
            return false;
        }
        tasques.add(tasca);
        return true;
    }

    public synchronized Tasca getProperaTasca() {
        Tasca properaTasca = null;
        long tempsMinim = Long.MAX_VALUE;
        for (Tasca tasca : tasques) {
            long tempsFinsExecucio = LocalTime.now().until(tasca.getHoraExecucio(), java.time.temporal.ChronoUnit.MILLIS);
            if (tempsFinsExecucio < tempsMinim) {
                tempsMinim = tempsFinsExecucio;
                properaTasca = tasca;
            }
        }
        if (properaTasca != null) {
            tasques.remove(properaTasca);
        }
        return properaTasca;
    }

    public void run() {
        while (!sortir) {
            Tasca properaTasca = getProperaTasca();
            if (properaTasca != null && LocalTime.now().until(properaTasca.getHoraExecucio(), java.time.temporal.ChronoUnit.SECONDS) < 2) {
                System.out.println(properaTasca.getNom() + " executa");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void sortir() {
        sortir = true;
    }
}
