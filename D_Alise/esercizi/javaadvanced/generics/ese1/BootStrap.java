package esercizi.javaadvanced.generics.ese1;
import java.util.Scanner;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
public class BootStrap{
	static Scanner tastiera = new Scanner(System.in);
	
	GestioneImpl<Libro> gestioneLibri = new GestioneImpl<Libro>();
	GestioneImpl<Carta> gestioneCarte = new GestioneImpl<Carta>();
	GestioneImpl<Persona> gestionePersone = new GestioneImpl<Persona>();
		
	public static void main(String[] args) throws DateTimeParseException{
		
		BootStrap b = new BootStrap();
		
		int scelta;
		
		do{
			System.out.println("Scegliere quello che si vuole fare: ");
			System.out.println("1: Inserire Oggetto");
			System.out.println("2: Cancella oggetto");
			System.out.println("3: Ordina lista oggetti");
			System.out.println("4: Ricerca oggetti ");
			System.out.println("5: Visualizza lista ");
			System.out.println("0: Esci dal programma ");
			scelta = tastiera.nextInt();
			tastiera.nextLine();
			switch(scelta){
				case 1:
					System.out.println("Cosa vuoi aggiungere?");
					System.out.println("1: Libro");
					System.out.println("2: Carta");
					System.out.println("3: Persona");
					int risultato = tastiera.nextInt();
					tastiera.nextLine();
					switch(risultato){
						case 1:
							b.gestioneLibri.inserimento(b.creaLibro());
							break;
						case 2:
							b.gestioneCarte.inserimento(b.creaCarta());
							break;
						case 3:
							b.gestionePersone.inserimento(b.creaPersona());
							break;
						default:
							System.out.println("Comando non corretto");
							break;
					}
					break;
				case 2:
					b.cancellaElemento("Su quale lista vuoi cancellare l'elemento?");
					break;
				case 3:
					b.gestioneLibri.ordinamento();
					b.gestioneCarte.ordinamento();
					b.gestionePersone.ordinamento();
					break;
				case 4:
					System.out.println("Inserisci stringa");
					String stringa= tastiera.nextLine();
					List<Libro> risultatiRicerca = b.gestioneLibri.ricerca(stringa);
					for( int i=0 ; i< risultatiRicerca.size(); i++){
						System.out.println(risultatiRicerca.get(i));
					}
					/*b.gestioneCarte.ricerca();
					b.gestionePersone.ricerca();*/
					
					break;
				case 5:
					b.visualizzaLista("Quale lista vuoi vedere?");
					
			}
		}while(scelta != 0);
		
	}
	private Libro creaLibro(){
		System.out.println("Inserire Titolo del libro");
		String titolo = tastiera.nextLine();
		System.out.println("Inserire Autore del libro");
		String autore = tastiera.nextLine();
		System.out.println("Inserire Editore del libro");
		String editore = tastiera.nextLine();
		Libro nuovoLibro = new Libro(titolo, autore, editore);
		return nuovoLibro;
	}
	
	private Carta creaCarta(){
		System.out.println("Inserire Valore della carta");
		int valore = tastiera.nextInt();
		tastiera.nextLine();
		System.out.println("Inserire Seme della carta");
		String seme = tastiera.nextLine();
		Carta nuovaCarta = new Carta(valore, seme);
		return nuovaCarta;
		
	}
	
	private Persona creaPersona() throws DateTimeParseException{
		System.out.println("Inserire Nome della persona");
		String nome = tastiera.nextLine();
		System.out.println("Inserire Cognome della persona");
		String cognome = tastiera.nextLine();
		System.out.println("Inserire Data di nascita della persona in questo formato: yyyy-mm-DD");
		LocalDate dataDiNascita = LocalDate.parse(tastiera.nextLine());
		Persona nuovaPersona = new Persona(nome, cognome, dataDiNascita);
		return nuovaPersona;
	}
	
	private int visualizzaLista(String messaggio){
		System.out.println(messaggio);
		System.out.println("1: Libri");
		System.out.println("2: Carte");
		System.out.println("3: Persone");
		int scelta = tastiera.nextInt();
		tastiera.nextLine();
		switch(scelta){
			case 1:
				System.out.println("Lista dei libri: ");
				for(int i = 0; i < gestioneLibri.getItems().size(); i++){
					System.out.println(i+ " - " + gestioneLibri.getItems().get(i));
				}
				break;
			case 2:
				System.out.println("Lista delle Carte: ");
				for(int i = 0; i < gestioneCarte.getItems().size(); i++){
					System.out.println(i+ " - " + gestioneCarte.getItems().get(i));
				}
				break;
			case 3:
				System.out.println("Lista delle persone: ");
				for(int i = 0; i < gestionePersone.getItems().size(); i++){
					System.out.println(i+ " - " + gestionePersone.getItems().get(i));
				}
				break;
			default:
				System.out.println("Scelta non valida");
				break;
		}
		return scelta;
	}
	
	private void cancellaElemento(String messaggio){
		int scelta = visualizzaLista(messaggio);
		int itemNumber;
		switch(scelta){
			case 1:
				System.out.println("Inserisci numero da cancellare");
				itemNumber = tastiera.nextInt();
				tastiera.nextLine();
				gestioneLibri.cancellazione(gestioneLibri.getItems().get(itemNumber));
				break;
			case 2:
				System.out.println("Inserisci numero da cancellare");
				itemNumber = tastiera.nextInt();
				tastiera.nextLine();
				gestioneCarte.cancellazione(gestioneCarte.getItems().get(itemNumber));
				break;
			case 3:
				System.out.println("Inserisci numero da cancellare");
				itemNumber = tastiera.nextInt();
				tastiera.nextLine();
				gestionePersone.cancellazione(gestionePersone.getItems().get(itemNumber));
				break;
			default: 
				System.out.println("Scelta errata");
				break;
		}
		
	}
	
}