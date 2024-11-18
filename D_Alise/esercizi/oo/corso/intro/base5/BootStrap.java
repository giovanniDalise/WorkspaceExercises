package esercizi.oo.corso.intro.base5;
import esercizi.utility.Tastiera;

public class BootStrap {
    public static void main(String[] args) {

        int altezzaInserita = Tastiera.chiediInteroPositivo("Inserisci l'altezza:");
        int lunghezzaInserita = Tastiera.chiediInteroPositivo("Inserisci la lunghezza:");
        Rettangolo rettangolo1 = new Rettangolo(altezzaInserita,lunghezzaInserita);
        Rettangolo rettangolo2 = new Rettangolo(altezzaInserita,lunghezzaInserita);       
        Rettangolo rettangolo3 = new Rettangolo(altezzaInserita+1,lunghezzaInserita+1);   

        if (rettangolo1.equals(rettangolo2)) { //il metodo equals tra due oggetti appartenente alla classe Object è stato sovrascritto nella classe  Rettangolo per il confronto tra due istanze di Rettangolo 
            System.out.println("rettangolo1 e rettangolo2 sono uguali");
        } else {
            System.out.println("rettangolo1 e rettangolo2 sono diversi");
        }

        if (rettangolo1.equals(rettangolo3)) {
            System.out.println("rettangolo1 e rettangolo3 sono uguali");
        } else {
            System.out.println("rettangolo1 e rettangolo3 sono diversi");
        }
    }
    }