package esercizi.eccezioni;
import java.util.Scanner;
public class FruttiScomposto{  

    static String frutto = "";
    static String tipoMela = "";
    static int countananas=0;
    static int countbanana=0;
    static int renetta=0;
    static int golden=0;
    static int fuji=0;
    static int countmele=0;
    public static void main(String[] input){  
        inserisciFruttiSettimana();
	System.out.println("Renetta mangiate questa settimana:" + renetta);
	System.out.println("Golden mangiate questa settimana:" + golden);
	System.out.println("Fuji mangiate questa settimana:" + fuji);
	System.out.println("Ananas mangiate questa settimana:" + countananas);
	System.out.println("Banane mangiate questa settimana:" + countbanana);
	System.out.println("Mele mangiate questa settimana:" + countmele);

		
    }
    public static void contaMele(){
	boolean errore= false;
	String tipo="";
	do{
	    try{
		    errore= false;
		    tipo = Tastiera.chiediStringa("Inserisci tipo di mela:");
		if(tipo.equalsIgnoreCase("renetta")){
		    renetta++;
		}else if(tipo.equalsIgnoreCase("golden")){
		    golden++;
		}else if(tipo.equalsIgnoreCase("fuji")){
		    fuji++;
		}else{
		    errore= true;
		    throw new AppleTypeNotFound();
		}
	    }catch (AppleTypeNotFound tipoNonTrovato){
	        System.out.println("Errore puoi inserire solo il tipo renetta, golden, fuji");
			}
	}while(errore);

    }
    public static void inserisciFruttiSettimana(){
	String frutto="";
	do {
	    try{			
	        frutto=contaFrutti();
	    }catch (FruitNotFound errore){
	        System.out.println("ATTENZIONE! Hai inserito un tipo di frutto non valido");
	    }
	}while(!frutto.equalsIgnoreCase("exit"));
    }
    public static String contaFrutti()throws FruitNotFound{
	frutto = Tastiera.chiediStringa("Inserisci un frutto:");
	if(frutto.equalsIgnoreCase("mela")){
		countmele++;
	    contaMele();		
	}else if(frutto.equalsIgnoreCase("ananas")){
	    countananas++;
	}else if(frutto.equalsIgnoreCase("banana")){
	    countbanana++;
	}else if(!frutto.equalsIgnoreCase("exit")){
	    throw new FruitNotFound();
	}

	return frutto;
    }
} 