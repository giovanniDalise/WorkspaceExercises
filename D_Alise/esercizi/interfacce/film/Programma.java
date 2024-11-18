package esercizi.interfacce.film;
import java.util.Arrays;
import java.util.Scanner;

public class Programma{
	private static Film[] film = new Film[4];
	private static Scanner tastiera = new Scanner(System.in);

	public static void main(String[] args){
		int numero;
		film[0] = new Film ("Harry Potter e la Pietra Filosofale", 2001,"fantasy");
		film[1] = new Film ("Harry Potter e la camera dei segreti", 2002,"fantasy");
		film[2] = new Film ("Harry Potter e il prigioniero di Azkaban", 2004,"fantasy");
		film[3] = new Film ("L'uomo bicentenario", 1999,"drammatico");		
		do{
			System.out.println("Inserire il numero:");
			System.out.println("1. Inserisci film");
			System.out.println("2. Visualizza film");		
			System.out.println("3. Elimina film");
			System.out.println("4. Ordina film");			
			System.out.println("0. Esci");		
			numero = tastiera.nextInt();
			switch (numero){
				case 1:
					inserisciFilm();
					break;
				case 2:
					visualizzaFilm();
					break;
				case 3:
					eliminaFilm();
					visualizzaFilm();				
					break;					
				case 4:
					ordinaFilm();
					visualizzaFilm();				
					break;
				case 0:
					break;
				default:
					System.out.println("Inserire uno dei numeri elencati:");
					break;
		    }
		} while (numero != 0);
	}
	public static void inserisciFilm(){	
		System.out.println("Inserisci il titolo del film:");	
		String titolo = tastiera.next();
		System.out.println("Inserisci l'anno di uscita del film:");	
		int annoUscita = tastiera.nextInt();
		System.out.println("Inserisci il genere del film:");	
		String genere = tastiera.next();	
		try {
		    Film nuovo = new Film(titolo, annoUscita, genere);
		    film=Arrays.copyOf(film,film.length+1);
		    film[film.length-1]=nuovo;                    
		} catch (Exception e) {
		    System.out.println("Errore durante l'inserimento del film: " + e.getMessage());
		}	
	}	
	public static void visualizzaFilm(){
		for(int i =0;i<film.length;i++){
			System.out.println(film[i].toString());
		}
	}
	public static void eliminaFilm(){
		System.out.println("Inserisci il titolo del film:");	
		String titolo = tastiera.next();
		System.out.println("Inserisci l'anno di uscita del film:");	
		int annoUscita = tastiera.nextInt();
		System.out.println("Inserisci il genere del film:");	
		String genere = tastiera.next();		
		Film temp= new Film(titolo, annoUscita, genere);
		Film[] f = new Film[film.length - 1];
		boolean trovato = false;
		try{
			for(int i=0; i< film.length;i++){
				if(temp.toString().equals(film[i].toString())){
					trovato = true;
				}else{
					if(trovato){//sarebbe if trovato = true o trovato=false a seconda dell'ultimo valore assunto
						f[i-1]=film[i];
					}else{
						f[i]= film[i];
					}
				}
			}
			film = f;
		} catch (Exception e){
			System.out.println("Errore durante il cancellamento del film: " + e.getMessage());
		}	
	}	

	public static void ordinaFilm(){
		System.out.println("Inserire il numero:");
		System.out.println("1. Ordina per titolo");
		System.out.println("2. Ordina per Anno di Uscita");
		System.out.println("3. Ordina per genere");				
		System.out.println("0. Esci");		
		int numero = tastiera.nextInt();
		switch (numero){
			case 1:
				ComparatorT ct = new ComparatorT();
				Arrays.sort(film, ct);
				break;
			case 2:
				ComparatorA ca = new ComparatorA();
				Arrays.sort(film, ca);
				break;
			case 3:
				ComparatorG cg = new ComparatorG();
				Arrays.sort(film, cg);				
				break;	
			case 0:
				break;
			default:
				System.out.println("Inserire uno dei numeri elencati:");
				break;
	    }
	}
}