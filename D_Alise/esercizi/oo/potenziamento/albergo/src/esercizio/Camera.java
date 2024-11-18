package esercizio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Camera {
    private int numeroCamera;
    private List<Prenotazione> prenotazioni;
    private double prezzoPersona;
    private int postiLetto;

    public Camera(int numeroCamera, double prezzoPersona, int postiLetto) {
        this.numeroCamera = numeroCamera;
        this.prezzoPersona = prezzoPersona;
        this.postiLetto = postiLetto;
        prenotazioni = new ArrayList<>();
    }

    public int getNumeroCamera() {
        return numeroCamera;
    }
    public int getPostiLetto() {
        return postiLetto;
    }

    public double getPrezzoPersona() {
        return prezzoPersona;
    }

    public boolean isDisponibile(LocalDate dataArrivo, LocalDate dataPartenza, int numeroOspiti) {
        for (Prenotazione prenotazione : prenotazioni) {
            if (prenotazione.sovrappone(dataArrivo, dataPartenza) && numeroOspiti>=postiLetto) {
                return false;
            }
        }
        return true;
    }

    public void prenota(LocalDate dataArrivo, LocalDate dataPartenza, int numeroOspiti) {
        Prenotazione prenotazione = new Prenotazione(dataArrivo, dataPartenza, numeroOspiti);
        prenotazioni.add(prenotazione);
    }
}

