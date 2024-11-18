package esercizio;
import java.io.Serializable;
import java.time.LocalDate;

public class Evento implements Serializable {
    private LocalDate data;
    private String coordinateGeografiche;
    private String tipo;
    private String descrizione;

    public Evento(LocalDate data, String coordinateGeografiche, String tipo, String descrizione) {
        this.data = data;
        this.coordinateGeografiche = coordinateGeografiche;
        this.tipo = tipo;
        this.descrizione = descrizione;
    }

    public LocalDate getData() {
        return data;
    }

    public String getCoordinateGeografiche() {
        return coordinateGeografiche;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "data=" + data +
                ", coordinate='" + coordinateGeografiche + '\'' +
                ", tipo='" + tipo + '\'' +
                ", descrizione='" + descrizione + '\'' +
                '}';
    }
}
