package esercizi.oo.studenti;

public class Classe {
    private Studente[] elencoStudenti;
    private int numStudenti;

    public Classe(int maxStudenti) {
        elencoStudenti = new Studente[maxStudenti];
        numStudenti = 0;
    }

    public boolean aggiungiStudente(Studente s) {
        if (numStudenti >= elencoStudenti.length) {
            return false;
        }
        elencoStudenti[numStudenti] = s;
        numStudenti++;
        return true;
    }

	public Studente cercaStudente(String nomeOEmail) {
	    for (int i = 0; i < numStudenti; i++) {
	        if (elencoStudenti[i].getNome().equalsIgnoreCase(nomeOEmail) || elencoStudenti[i].getEmail().equalsIgnoreCase(nomeOEmail)) {
	            return elencoStudenti[i];
	        }
	    }
	    return null;
	}

    public float calcolaMediaVoti() {
        if (numStudenti == 0) {
            return 0;
        }
        float sommaVoti = 0;
        for (int i = 0; i < numStudenti; i++) {
            sommaVoti += elencoStudenti[i].getVotoMedio();
        }
        return sommaVoti / numStudenti;
    }
}
