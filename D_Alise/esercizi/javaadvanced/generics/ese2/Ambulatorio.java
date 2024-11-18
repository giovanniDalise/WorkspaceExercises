package esercizi.javaAdvanced.generics.ese2;
import java.util.List;
import java.util.Random;

public class Ambulatorio{
	private long timestampInizio;
	private long durata; 
	private List<Sportello> sportelli;
	private Coda coda;
	
	
	public Ambulatorio(long durata){
		this.timestampInizio = System.currentTimeMillis();
		this.durata = durata;
		this.sportelli = new ArrayList<Sportello>();//nel caso in cui volessimo specializzare i sportelli per pratica
		this.coda = new Coda();
		
		Sportello sportello1 = new Sportello(coda);
		sportelli.add(sportello1);
		Sportello sportello2 = new Sportello(coda);
		sportelli.add(sportello2);
		
	}
	
	
	public static void main(String[] input){
		Ambulatorio ambulatorio = new Ambulatorio(10000);
		
		do{
			Random rnd = new Random();
			int prenotazioneRandom = rnd.nextInt(10);//numeroprenotazioni
			for(int i = 0; i < prenotazioneRandom; i++){
				ambulatorio.accettarePrenotazioni();
			}
			
			for(int i = 0; i < ambulatorio.getSportelli().size(); i ++){
				ambulatorio.getSportelli().get(i).selezionaPratica();
			}
			
			
			List<Pratica> praticheInCoda = ambulatorio.getCoda().visualizzaCoda();
			for(int i = 0; i < praticheInCoda.size(); i++){
				System.out.println(praticheInCoda.get(i).toString());
			}
			
			
			
			
			
			
			
			
		}while (ambulatorio.isAperto() || ambulatorio.isPratiche());
			
			
		
		
		
	}
	
	private void accettarePrenotazioni(){
		if(isAperto()){
			System.out.println("Prenotazione " + coda.generaProgressivo() + " accettata");
		}else{
			System.out.println("Prenotazione non accettata");
		}
	}
	
	private boolean isAperto(){
		boolean aperto = true;
		aperto = System.currentTimeMillis() < (timestampInizio + durata);
		return aperto; 
	}
	
	private boolean isPratiche(){
		boolean presenti = true;
		if(coda.getPraticheAperte() == 0){
			presenti = false;
		}
		return presenti;
	}
	
	private List<Sportello> getSportelli(){
		return this.sportelli;
	}
	
	private Coda getCoda(){
		return this.coda;
	}	
	
}