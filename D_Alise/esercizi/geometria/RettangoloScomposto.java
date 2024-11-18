package esercizi.geometria;
import esercizi.Tastiera;

public class RettangoloScomposto{  
    public static void main(String[] input){   
       
	int base = Tastiera.chiediInteroPositivo("Inserisci la base");
        int altezza = Tastiera.chiediInteroPositivo("Inserisci l'altezza");

	System.out.println("Perimetro = " + (2*(base+altezza)));
	System.out.println("Area = " + (base*altezza));

	String riga1= riempi("*",base);

	String riga2="*"+ riempi(" ",base-2);

	if (base>1){
	    riga2=riga2+"*";
	}

	System.out.println(riga1);

	if(altezza>1){
	    for (int i=1;i<altezza-1;i++){
	        System.out.println(riga2);
	    }
	System.out.println(riga1);
	}	

    }
    public static String riempi(String carattere, int lunghezza){
	String result = "";
	for (int i=0;i<lunghezza;i++){
	    result=result+"*";
	}
	return result;
    }
	
} 