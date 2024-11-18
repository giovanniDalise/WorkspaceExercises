package esercizi.javaAdvanced.generics.ese2;

public class Sportello{
	private Pratica praticaCorrente;
	private long timestampPraticaCorrente;
	private Coda codaPratiche;
	
	public Sportello(Coda coda){
		this.codaPratiche = coda;
	}
	
	private boolean isLibero(){
		boolean libero = true;
		if (praticaCorrente != null){ //se abbiamo una pratica in atto 
			libero = System.currentTimeMillis() > (timestampPraticaCorrente + praticaCorrente.getDurata());
		}      
		return libero;
	}
	/* 
	-impostare il timestamp della pratica corrente
	-impostare la pratica corrente recuperandola dalla coda
	*/
	public void selezionaPratica(){
		if(isLibero()){
			timestampPraticaCorrente = System.currentTimeMillis();
			if(praticaCorrente != null){
				praticaCorrente.setTimestampFine(timestampPraticaCorrente);
			}
				praticaCorrente = codaPratiche.getPraticaSuccessiva();       
		}
			
	}
	
}

