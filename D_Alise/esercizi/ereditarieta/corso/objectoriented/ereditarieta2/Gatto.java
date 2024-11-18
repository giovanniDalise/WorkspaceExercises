package esercizi.ereditarieta.corso.objectoriented.ereditarieta2;

import java.util.Random;

public class Gatto extends Animale {

    private Random random = new Random();

    public Gatto() {
        super("miao");
    }

    @Override
    public void mangia(Cibo cibo) throws VomitoException {
        if (random.nextBoolean()) {
            setStato(Stati.ARRABBIATO);
            throw new VomitoException("Il gatto ha vomitato!");
        } else {
            super.mangia(cibo);
            setStato(Stati.FELICE);
        }
    }
}