package ese8.dto;

import java.sql.Timestamp;

public class Timbratura {
    private int idDipendente;
    private Timestamp timbraturaTempo;
    private String tipo;

    public Timbratura(int idDipendente,Timestamp timbraturaTempo, String tipo) {
        this.idDipendente = idDipendente;
        this.timbraturaTempo = timbraturaTempo;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Timbratura{" +
                "idDipendente=" + idDipendente +
                ", timbraturaTempo=" + timbraturaTempo +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    public int getIdDipendente() {
        return idDipendente;
    }

    public Timestamp getTimbraturaTempo() {
        return timbraturaTempo;
    }

    public String getTipo() {
        return tipo;
    }
}


