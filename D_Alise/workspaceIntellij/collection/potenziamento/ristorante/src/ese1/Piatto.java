package ese1;
import java.util.List;
import java.util.ArrayList;

public class Piatto implements Comparable<Piatto> {
    private String nome;
    private String tipo;
    private List<Ingrediente> ingredienti;
    private double prezzo;
    private String procedimento;

    public Piatto(String nome, String tipo, List<Ingrediente> ingredienti, double prezzo, String procedimento){

        this.nome = nome;
        this.tipo = tipo;
        this.ingredienti = ingredienti;
        this.prezzo = prezzo;
        this.procedimento = procedimento;
    }
    public String getNome() {
        return nome;
    }
    public String getTipo() {
        return tipo;
    }

    public List<Ingrediente> getIngredienti() {
        return ingredienti;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public String getProcedimento() {
        return procedimento;
    }

    public boolean isVegano(){
        boolean result = true;
        for(int i =0;i<this.ingredienti.size() && result;i++){
            if(!this.ingredienti.get(i).isVegano()){
                result = false;
            }
        }
        return result;
    }
    public boolean isVegetariano(){
        boolean result = true;
        for(int i =0;i<this.ingredienti.size() && result;i++){
            if(!this.ingredienti.get(i).isVegetariano()){
                result = false;
            }
        }
        return result;
    }
    public boolean isCeliaco(){
        boolean result = true;
        for(int i =0;i<this.ingredienti.size() && result;i++){
            if(!this.ingredienti.get(i).isCeliaco()){
                result = false;
            }
        }
        return result;
    }
    public int calcolaCalorie(int grammiIngrediente){
        int sommaCalorie=0;
        for(int i =0;i<this.ingredienti.size();i++){
                sommaCalorie+=this.ingredienti.get(i).getCalorie()*grammiIngrediente;
        }
        return sommaCalorie;
    }

    @Override
    public String toString() {
        return "Piatto{" +
                "nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", ingredienti=" + ingredienti +
                ", prezzo=" + prezzo +
                ", procedimento='" + procedimento + '\'' +
                '}';
    }
    @Override
    public int compareTo(Piatto piatto) {
        double result=this.prezzo-piatto.prezzo;
        return (int)result;
    }
}
