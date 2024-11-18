package esercizio;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class Prenotazione {
    private String nomePersona;
    private int numeroClienti;
    private LocalDate data;
    private LocalTime ora;
    private static final Duration DURATA_MAX = Duration.ofHours(2);

    public Prenotazione(String nomePersona, int numeroClienti, LocalDate data, LocalTime ora) {
        this.nomePersona = nomePersona;
        this.numeroClienti = numeroClienti;
        this.data = data;
        this.ora = ora;
    }

    public String getNomePersona() {
        return nomePersona;
    }

    public int getNumeroClienti() {
        return numeroClienti;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getOra() {
        return ora;
    }
    public static Duration getDurataMax() {
        return DURATA_MAX;
    }
}
