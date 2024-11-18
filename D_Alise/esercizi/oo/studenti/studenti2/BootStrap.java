package esercizi.oo.studenti.studenti2;
import esercizi.utility.Tastiera;
import java.util.Scanner;

public class BootStrap{
	public static void main(String[] args){
		Scanner tastiera = new Scanner(System.in);
		Classe classe = new Classe();
		int numero;
		do{
			System.out.println("Inserire il numero:");
			System.out.println("1. Aggiungi studente");
			System.out.println("2. Visualizza studenti");
			System.out.println("3. Ricerca studenti");
			System.out.println("4. Aggiungi voti");
			System.out.println("5. Ordina Studenti");
			System.out.println("0. Esci");
			numero = tastiera.nextInt();
			switch (numero){
				case 1:
					Studente studente = creaStudente();
					classe.aggiungiStudente(studente);
					break;
				case 2:
					Studente[] studenti = classe.getStudenti();
					stampaStudenti(studenti);
					break;
				case 3:
					studenti = cercaStudenti(classe);
					stampaStudenti(studenti);
					break;
				case 4:
					studente = cercaStudente(classe);
					if (studente != null){
						System.out.println("Inserisci voto:");
						int voto = tastiera.nextInt();
						studente.aggiungiVoto(voto);
					}
					break;
				case 5:
					classe.ordina();
					studenti = classe.getStudenti();
					stampaStudenti(studenti);
					break;
				case 0:
					break;
				default:
					System.out.println("Inserire uno dei numeri elencati:");
					break;
			}
		} while (numero != 0);
	}
	public static Studente creaStudente(){
		String nome = Tastiera.chiediStringa("Inserisci il nome dello studente:");
		String cognome = Tastiera.chiediStringa("Inserisci il cognome dello studente:");
		String email = Tastiera.chiediStringa("Inserisci l'email dello studente:");
		int eta = Tastiera.chiediInteroPositivo("Inserisci l'età dello studente:");	
		Studente studente = new Studente (nome,cognome,email,eta);
		return studente;	
	}
	public static void stampaStudenti(Studente[] studenti){
		for (int i = 0; i < studenti.length; i++) {
            System.out.println(studenti[i] + " ");
        }
	}
	public static Studente[] cercaStudenti(Classe classe){//gli do l'oggetto classe per chiamare i metodi immagino
	    int numero = Tastiera.chiediInteroPositivo("Come vuoi cercare:\n1.Testo\n2.Email");
	    Studente[] risultato=new Studente[0]; //nuovo array vuoto che sarà poi valorizzato nel metodo ByText e assegnato alla variabile result
	    if (numero ==1){
	        String testo = Tastiera.chiediStringa("Inserisci il testo:");
	        risultato = classe.cercaStudentiByText(testo); //il metodo poi restituirà un array nuovo di studenti(vedi nel metodo)
	    }else if(numero==2){
	        String email = Tastiera.chiediStringa("Inserisci l'email:");   
	        Studente studente = classe.cercaStudenteByMail(email);
	        if(studente!=null){
	            risultato = new Studente[1];//in questo caso alla variabile result invece sarà assegnato un altro array di lunghezza 1 dato che abbiamo solo un elemento in questa ricerca
	            risultato[0] = studente;
	        }    		    	             
	    } 
	    return risultato; //in entrambi casi in result sono restituiti array nel primo di n elementi e nel secondo di 1 elemento
	} 
	public static Studente cercaStudente(Classe classe){        
    	String email = Tastiera.chiediStringa("Inserisci l'email:");   
    	Studente studente = classe.cercaStudenteByMail(email);		
	    if(studente!=null){
	        return studente;
        }    
        return null;		    	             
    }  	

}