package esercizi.oo.corso.intro.base2;

public class Tavolo{
    private int altezza;
    private int lunghezza;

    public Tavolo(int altezza,int lunghezza){
        this.altezza = altezza;
        this.lunghezza = lunghezza;
    }
        public void stampaMessaggio() {
        System.out.println("Altezza: " + altezza + ", Lunghezza: " + lunghezza);
    }
}

