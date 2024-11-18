package esercizi.ereditarieta.corso.objectoriented.ereditarieta2;

public class Stati {
    public static final Stati AFFAMATO = new Stati("Affamato");
    public static final Stati ARRABBIATO = new Stati("Arrabbiato");
    public static final Stati FELICE = new Stati("Felice");
    public static final Stati TRISTE = new Stati("Triste");
    
    private String nome;
    
    private Stati(String nome) {
        this.nome = nome;
    }
    
    public String toString() {
        return nome;
    }
}