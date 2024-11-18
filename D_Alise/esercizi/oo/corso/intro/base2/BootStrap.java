package esercizi.oo.corso.intro.base2;
import esercizi.utility.Tastiera;

public class BootStrap {
    public static void main(String[] args) {

        int altezzaInserita = Tastiera.chiediInteroPositivo("Inserisci l'altezza:");
        int lunghezzaInserita = Tastiera.chiediInteroPositivo("Inserisci la lunghezza:");
        Tavolo tavolo = new Tavolo(altezzaInserita,lunghezzaInserita);
        tavolo.stampaMessaggio();
    }
}