package esercizi.interfacce.potenziamento.veicolo;
import esercizi.utility.Tastiera;

public class Veicolo implements MovimentiVeicolo{
	private Posizione posizione;

	public Veicolo(Posizione posizione){
		this.posizione=posizione;
	}

	public void vaiAvanti(int incremento) {
	    int nuovaPosizione = this.posizione.getY() + incremento;
	    if (nuovaPosizione > 100) {
	        System.out.println("Non possiamo andare oltre il valore 100!");
	    } else {
	        this.posizione.setY(nuovaPosizione);
	    }
	}

	public void vaiIndietro(int incremento) {
	    int nuovaPosizione = this.posizione.getY() - incremento;
	    if (nuovaPosizione < 0) {
	        System.out.println("Non possiamo andare oltre il valore 0!");
	    } else {
	        this.posizione.setY(nuovaPosizione);
	    }
	}

	public void svoltaASinistra(int incremento) {
	    int nuovaPosizione = this.posizione.getX() - incremento;
	    if (nuovaPosizione < 0) {
	        System.out.println("Non possiamo andare oltre il valore 0!");
	    } else {
	        this.posizione.setX(nuovaPosizione);
	    }
	}

	public void svoltaADestra(int incremento) {
	    int nuovaPosizione = this.posizione.getX() + incremento;
	    if (nuovaPosizione > 100) {
	        System.out.println("Non possiamo andare oltre il valore 100!");
	    } else {
	        this.posizione.setX(nuovaPosizione);
	    }
	}

    public String toString(){
        return "X:" + posizione.getX() + " Y:" + posizione.getY();
    }   
}