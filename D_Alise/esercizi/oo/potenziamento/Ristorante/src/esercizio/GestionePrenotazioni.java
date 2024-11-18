package esercizio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class GestionePrenotazioni {
    private List<Tavolo> tavoli;
    private LocalTime orarioApertura;
    private LocalTime orarioChiusura;


    public GestionePrenotazioni() {
        this.orarioApertura = LocalTime.of(19, 0);
        this.orarioChiusura = LocalTime.of(23, 0);
        this.tavoli = new ArrayList<>();
    }
    public void aggiungiTavolo(int numeroTavolo,int numeroPosti){
        Tavolo nuovoTavolo = new Tavolo(numeroTavolo,numeroPosti);
        tavoli.add(nuovoTavolo);
    }
    public void prenotaTavolo(LocalDate dataPrenotazione, LocalTime oraPrenotazione, int numeroClienti, String nomePersona) {
        boolean prenotato = false;
        int numeroTavolo = 0;
        int i = 0;
        while (!prenotato && i < tavoli.size()) {
            Tavolo tavolo = tavoli.get(i);
            if (tavolo.isDisponibile(dataPrenotazione, oraPrenotazione, numeroClienti)) {
                tavolo.prenota(nomePersona, numeroClienti, dataPrenotazione, oraPrenotazione);
                prenotato = true;
                numeroTavolo = tavolo.getNumeroTavolo();
            }
            i++;
        }
        if (prenotato) {
            System.out.println("Tavolo " + numeroTavolo + " prenotato con successo.");
        } else {
            System.out.println("Nessun tavolo è disponibile per la data e l'orario specificato.");
        }
    }
    public void trovaTavoloDisponibile(LocalDate data, int numeroPersone) {
        for (Tavolo tavolo : tavoli) {
            if (tavolo.isDisponibile(data, numeroPersone)) {
                System.out.print("Tavolo " + tavolo.getNumeroTavolo() + " è disponibile");

                LocalTime orarioInizio = determinaOrarioInizio(tavolo, data);
                LocalTime orarioFine = determinaOrarioFine(tavolo, data);

                System.out.print(" dalle " + orarioInizio + " alle " + orarioFine);

                System.out.println();
            }
        }
    }
    private LocalTime determinaOrarioInizio(Tavolo tavolo, LocalDate data) {
        LocalTime orarioAperturaRistorante = orarioApertura;
        LocalTime orarioChiusuraRistorante = orarioChiusura;
        LocalTime orarioPrenotazione = tavolo.getOrarioPrenotazione(data);

        LocalTime orarioInizio = orarioAperturaRistorante;
        if (orarioPrenotazione.isAfter(orarioInizio)) {
            orarioInizio = orarioPrenotazione.plusMinutes(durataPrenotazione);
        }

        return orarioInizio;
    }




}
