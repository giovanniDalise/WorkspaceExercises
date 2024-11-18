package esercizio;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

public class Prodotto implements Serializable {
    private String nome;
    private String codice;
    private String tipo;
    private List<Evento> tracciabilita;

    public Prodotto(String nome, String codice, String tipo, List<Evento> tracciabilita) {
        this.nome = nome;
        this.codice = codice;
        this.tipo = tipo;
        this.tracciabilita = tracciabilita;
    }

    public String getNome() {
        return nome;
    }

    public String getCodice() {
        return codice;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        String result = "Prodotto{" +
                "nome='" + nome + '\'' +
                ", codice='" + codice + '\'' +
                ", tipo='" + tipo + '\'';

        if (tracciabilita.isEmpty()) {
            result += ", tracciabilita=Nessun evento di tracciabilità";
        } else {
            result += ", tracciabilita=" + tracciabilita;
        }

        result += '}';

        return result;
    }
}