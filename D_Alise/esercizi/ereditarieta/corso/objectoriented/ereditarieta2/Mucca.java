package esercizi.ereditarieta.corso.objectoriented.ereditarieta2;

public class Mucca extends Animale {

    public Mucca() {
        super("muu");
    }

    @Override
    public void mangia(Cibo cibo) throws VomitoException {
        if (cibo.getTipo() == Cibo.CARNE) {
            setStato(Stati.ARRABBIATO);
            throw new VomitoException("Non posso mangiare carne! Vomito!");
        } else if (cibo.getTipo() == Cibo.VERDURA) {
            setStato(Stati.FELICE);
            System.out.println("Mangio volentieri " + cibo);
        }
    }
}
