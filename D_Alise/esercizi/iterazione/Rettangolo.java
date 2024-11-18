/* Per il contorno vediamo che viene inizializzata la riga 1 con nessun valore ("") per riuscire a ciclarla dopo e si fa lo stesso con il contatore i; dopodiche si dice che finchè la i sarà più piccola della base la nostra riga sarà uguale alla riga senza nulla più un asterisco ed infine aumentiamo la i di 1(i++). Quindi facendo cosi per ogni ciclo noi avremo la prima riga(che successivamente potremo stampare come la base di sopra o la base di sotto)(nota che abbiamo messo il contatore a 0 facendo cosi possiamo tranquilamente mettere i<base restituindoci il numero di asterischi corrispondenti alla base se avessimo fatto i=1 allora avremo dovuto mettere i<=base). 

Per la riga2 invece vediamo che questa viene inizializzata con 1 asterisco e che questa volta diamo ad i il valore 1 e diciamo che finche la i sarà minore della base meno 1 noi avremo che la nostra riga due sarà uguale al suo valore iniziale(1 asterisco) + uno spazio vuoto ed in seguito fare i++. Quindi facciamo un esempio abbiamo la nostra base a 4 e la nostra riga2 con un asterisco solo noi aggiungeremo gli spazi vuoti (parliamo delle parti vuote centrali del rettangolo) per un unumero minore della base -1 ossia 2 perchè base -1 fa 3 ed il numero subito minore di 3 è 2.

Successivamente mettiamo una condizione dove diciamo che se la base è maggiore di 1 allora 
avremo che la riga due sarà uguale ad il suo valore più un asterisco. Questa cosa viene fatta per chiudere questa riga di spazi vuoti sul lato opposto dato che abbiamo incominciato con un asterisoc e poi inserito tutti spazi vuoti l'ultimo dovrà di nuovo essere un asterisco. Facciamo questa operazione tramite la condizione base>1(se la base fosse uguale a 1 non avremo bisogno di un altro asterisco per questa riga ne basterebbe 1.

Dopo stampiamo la riga1 che abbiamo definito all'inizio, dopo di che diciamo che finchè l'altezza sarà maggiore di 1 noi stampiamo la riga2 per un numero del contatore i minore dell'altezza. Quindi stamperemo le righe2(quelle vuote al centro) in altezza e per fare cio ovviamente avremo la i=0 e la condizione < e non <= facendo si che il numero di print sarà uguale al numero dell'altezza -2.

Infine stampiamo la nostra base sottostante con un print riga1.*/

package esercizi.iterazione;
import java.util.Scanner;
public class Rettangolo{ 
    public static void main(String[] input){   
       
       	Scanner tastiera = new Scanner(System.in);         
	System.out.println("Inserisci la base:");
	int base = tastiera.nextInt();
	while (base<=0){
	    System.out.println("Inserisci un numero positivo:");
	    base = tastiera.nextInt();
	}
	System.out.println("Inserisci l'altezza:");
	int altezza = tastiera.nextInt();

	while (altezza<=0){
	    System.out.println("Inserisci un numero positivo:");
	    altezza = tastiera.nextInt();
	}

	System.out.println("Perimetro = "+(2*(base+altezza)));
	System.out.println("Area = "+(base*altezza));

	String riga1="";
	int i=0;
	for (i=0;i<base;i++){
	    riga1=riga1+"*";
	}
					
	String riga2="*";
	for (i=1;i<base-1;i++){
	    riga2=riga2+" ";
	}
				
	if (base>1){
	    riga2=riga2+"*";
	}
				
	System.out.println(riga1);
	if(altezza>1){
	   for (i=1;i<altezza-1;i++){
	       System.out.println(riga2);
	}
					
	System.out.println(riga1);
	}
			
    } 
} 