package test.ide.scritto.vecio;

import java.util.ArrayList;
import java.util.List;

public class Piatto {
    private List<Ingrediente> ingredienti;
    private double prezzo;
    private String nome;

    @Override
    public String toString() {
        return "Piatto{" +
                "prezzo=" + prezzo +
                ", nome='" + nome + '\'' +
                '}';
    }

    public Piatto(double prezzo, String nome) {
        this.prezzo = prezzo;
        this.nome = nome;
        this.ingredienti = new ArrayList<Ingrediente>();
    }
    public void aggiungiIngrediente(Ingrediente ingrediente){
        this.ingredienti.add(ingrediente);
    }

    public List<Ingrediente> getIngredienti() {
        return ingredienti;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public String getNome() {
        return nome;
    }
}
