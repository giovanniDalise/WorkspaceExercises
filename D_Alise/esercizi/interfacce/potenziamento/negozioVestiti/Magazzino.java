package esercizi.interfacce.potenziamento.negozioVestiti;
import esercizi.utility.Tastiera;
import java.util.Arrays;

public class Magazzino implements GestioneMagazzino {
    private Vestito[] vestiti;

    public Magazzino() {
        this.vestiti = new Vestito[0];
    }
    public void aggiungiVestito() {
        String tipo = Tastiera.chiediStringa("Inserisci il tipo di vestito:");
        String colore = Tastiera.chiediStringa("Inserisci il colore del vestito");    
        String taglia = Tastiera.chiediStringa("Inserisci la taglia del vestito:");    
        Vestito nuovoCapo = new Vestito(tipo, colore, taglia);
        this.vestiti = Arrays.copyOf(this.vestiti, this.vestiti.length + 1);
        this.vestiti[this.vestiti.length - 1] = nuovoCapo;
    }
    public void visualizzaVestiti() {
        if (this.vestiti.length == 0) {
            System.out.println("Il magazzino è vuoto.");
        } else {
            for (int i = 0; i < this.vestiti.length; i++) {
                System.out.println(this.vestiti[i].toString());
            }
        }
    }
    public Vestito cercaVestito() {
        String tipo = Tastiera.chiediStringa("Inserisci il tipo di vestito:");
        String colore = Tastiera.chiediStringa("Inserisci il colore del vestito");    
        String taglia = Tastiera.chiediStringa("Inserisci la taglia del vestito:");    
        Vestito vestitoDaCercare = new Vestito(tipo, colore, taglia);
        Vestito vestitoTrovato = null;
        for (int i = 0; i < this.vestiti.length && vestitoTrovato == null; i++) {
            if (vestitoDaCercare.toString().equals(this.vestiti[i].toString())) {
                vestitoTrovato = this.vestiti[i];
                System.out.println(vestitoTrovato.toString());
            }else{
                System.out.println("Vestito non trovato");
            }
        }
        return vestitoTrovato;
    }
    /*Ripolo array da ridurre.In pratica, se l'elemento da eliminare si trova nella posizione i, allora viene copiato l'elemento successivo, 
    che si trova nella posizione i+1, nella posizione i. Questo procedimento viene eseguito per tutte le posizioni a partire da quella dell'elemento eliminato, 
    fino alla fine dell'array.*/       
    public void eliminaVestito() {
	    Vestito vestito = cercaVestito();
	    boolean trovato = false;
	    for (int i = 0; i < this.vestiti.length; i++) {
	        if (vestito.equals(this.vestiti[i])) { //individua elemento da eliminare
	            trovato = true;
	            if (trovato && i < this.vestiti.length - 1) {//
	                this.vestiti[i] = this.vestiti[i + 1];
	            }
	        }
        }    
	    if (trovato) {
	        this.vestiti = Arrays.copyOf(this.vestiti, this.vestiti.length - 1);//riduco array
	    } else {
	        System.out.println("Il vestito cercato non è presente nel magazzino.");
	    }
	}
}    
	
    