package esercizi.javaadvanced.ripasso.ese1;
import esercizi.utility.Tastiera;
import java.time.LocalDate;

/*
1. (ese1) Creazione istanze di classe ed utilizzo di metodi e attributi degli oggetti:
Creare un programma con le seguenti classi:
    - BootStrap: che rappresenta il punto di partenza del programma con il metodo main
    - Persona: che rappresenta una persona generica ed ha i seguenti attributi 
        - nome: String
        - cognome: String
        - dataNascita: LocalDate

        ed i seguenti metodi:
        - presentati: il metodo restituisce una stringa con una presentazione della persona. (esempio: ciao io mi chiamo Mario Rossi ed ho 25 anni.). 
        - get*: tutti i getter 
        - getEta: restituisce il numero di anni trascorsi tra la data di nascita ed oggi. 
        Per capire quanti anni sono trascorsi dalla data di nascita, determinare la data odierna e calcolare la differenza tramite ChronoUnit.YEARS

Il programma dovrà eseguire i seguenti passi:
    - creare una persona chiedendo i dati all'utente
    - richiamare il metodo presentati della persona creata e stampare in output il risultato
    - creare una seconda persona chiedendo i dati all'utente
    - richiamare il metodo presentati della seconda persona e stampare in output il risultato
    - verificare se il nome della prima persona è uguale al nome della seconda persona e stampare il risultato
    - stampare quale delle due persone è più grande (utilizzare il metodo compareTo della data di nascita che è già implementato nella classe LocalDate)
    - verificare se le due persone sono uguali (ovvero hanno lo stesso nome, cognome e data di nascita)
    */
public class BootStrap{
    public static void main(String[] args){
       Persona persona1 = creaPersona();
       Persona persona2 = creaPersona();
       persona1.presentati();
       persona2.presentati();
       confrontaNome(persona1,persona2);
       confrontaPersone(persona1,persona2);
       confrontaEta(persona1,persona2);

    }
    public static Persona creaPersona(){
        String nome = Tastiera.chiediStringa("Inserisci un nome:");
        String cognome = Tastiera.chiediStringa("Inserisci un cognome:");
        String data = Tastiera.chiediStringa("Inserisci la data di nascita:(yyyy-mm-dd)");
        LocalDate dataDiNascita = LocalDate.parse(data);
        Persona pippo = new Persona(nome,cognome,dataDiNascita);
        return pippo;
    }
    public static void confrontaNome(Persona persona1,Persona persona2){
	   	if(persona1.getNome().equals(persona2.getNome())){
	   		System.out.println("I nomi sono uguali.");
	   	}else{
	   		System.out.println("I nomi sono diversi.");
	   	}
    }
    public static void confrontaPersone(Persona persona1,Persona persona2){
    	if(persona1.equals(persona2)){
    		System.out.println("Le due persone sono uguali");
    	}else{
    		System.out.println("Le due persone sono diverse");
    	}
    }
    public static void confrontaEta(Persona persona1,Persona persona2){
    	int result=persona1.getDataDiNascita().compareTo(persona2.getDataDiNascita());
    	    if (result ==0){
    	    	System.out.println(persona1.getNome() + " e " + persona2.getNome() + " " + " hanno la stessa età");
    	    }else if (result <0){
    	    	System.out.println(persona1.getNome() + " è piu grande di  " + persona2.getNome());
    	    }else{
    	    	System.out.println(persona1.getNome() + " è piu piccolo di  " + persona2.getNome());
    	    }
    }
}
