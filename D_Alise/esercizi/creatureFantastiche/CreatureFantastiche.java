package esercizi.creatureFanstastiche;

public class CreatureFanstastiche{
	public static void main(String[] args){
		creaCarte(colore1,colore2);
		Giocatore giocatore = new Giocatore(creaMazzo(giocatore));
		Giocatore computer = new Giocatore(creaMazzo(computer));

		while(giocatore.getPuntiVita>0&&computer.getPuntiVita() > 0 && giocatore.puoPescare() && computer.puoPescare()){
			giocatore.giocaTurno();
			computer.giocaTurno();
		}
	}	    
}