package esercizi.ereditarieta.corso.objectoriented.ereditarieta2;

public class Animale {
    protected String verso;
    private Stati stato;
    private boolean affamato;


    public Animale(String verso) {
        this.verso = verso;
    }
    public Stati getStato(){
        return this.stato;
    }
    public void setStato(Stati stato){
        this.stato=stato;
    }
    public String faiVerso() {
        return this.verso;
    }
    public void mangia(Cibo cibo) throws VomitoException {
    }

}