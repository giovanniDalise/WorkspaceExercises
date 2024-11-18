package esercizio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Tavolo {
    private int numeroTavolo;
    private List<Prenotazione> prenotazioni;
    private int numeroPosti;


    public Tavolo(int numeroTavolo,int numeroPosti) {
        this.numeroTavolo = numeroTavolo;
        this.numeroPosti = numeroPosti;
        this.prenotazioni = new ArrayList<Prenotazione>();
    }

    public int getNumeroTavolo() {
        return numeroTavolo;
    }

    public int getNumeroPosti() {
        return numeroPosti;
    }
    public boolean isDisponibile(LocalDate data,LocalTime ora, int numeriClienti){
        for(Prenotazione prenotazione:prenotazioni){
            if(!prenotazione.getData().equals(data) && !prenotazione.getOra().equals(ora) && ora.isAfter(prenotazione.getOra().plus(prenotazione.getDurataMax()))&&this.numeroPosti>=numeriClienti){
                return true;
            }
        }
        return false;
    }
    public void prenota(String nomePersona,int numeroClienti,LocalDate data, LocalTime ora) {
        Prenotazione nuovaPrenotazione = new Prenotazione(nomePersona, numeroClienti, data,ora);
        prenotazioni.add(nuovaPrenotazione);
    }

}
