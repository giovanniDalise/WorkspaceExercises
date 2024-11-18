package esercizi.ereditarieta.corso.objectoriented.ereditarieta;

public class Animale {
    private String verso;

    public Animale(String verso) {
        this.verso = verso;
    }

    protected String faiVerso() {
        return verso;
    }
}