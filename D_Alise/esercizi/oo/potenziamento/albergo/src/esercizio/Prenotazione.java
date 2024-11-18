package esercizio;

import java.time.LocalDate;

public class Prenotazione {
    private LocalDate dataArrivo;
    private LocalDate dataPartenza;
    private int numeroOspiti;

    public Prenotazione(LocalDate dataArrivo, LocalDate dataPartenza, int numeroOspiti) {
        this.dataArrivo = dataArrivo;
        this.dataPartenza = dataPartenza;
        this.numeroOspiti = numeroOspiti;
    }

    public boolean sovrappone(LocalDate otherStartDate, LocalDate otherEndDate) {
        return !(dataPartenza.isBefore(otherStartDate) || dataArrivo.isAfter(otherEndDate));
    }
}
