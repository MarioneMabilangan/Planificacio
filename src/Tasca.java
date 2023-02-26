import java.time.LocalTime;

public class Tasca {
    private LocalTime horaExecucio;
    private String nom;

    public Tasca(LocalTime horaExecucio, String nom) {
        this.horaExecucio = horaExecucio;
        this.nom = nom;
    }

    public LocalTime getHoraExecucio() {
        return horaExecucio;
    }

    public void setHoraExecucio(LocalTime horaExecucio) {
        this.horaExecucio = horaExecucio;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}