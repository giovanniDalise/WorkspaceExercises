/*1. fino € 15.000 	        23% = 15000-0*0.23 = 3450 primo numero 
  2. da € 15.001 a € 28.000 	25% = 28000-15000 * 0.25 = 3250
  3. da € 28.001 a € 50.000 	35% = 50000-28000 * 035 = 7700
  4. da € 50.001         	43%

Come prima cosa si fa la differenza del reddito massimo dello scaglione attuale meno il reddito massimo dello scaglione precedente per la percentuale dell'attuale. Questo valore che noi abbiamo già calcolato e inserito nelle variabili primoNum,secondoNume e terzoNum poi andrà sommato alla differenza tra il massimo dello scaglione precedente meno il reddito selezionato per la percentuale dello scaglione attuale(dove rientra il reddito selezionato). 
Attenzione che se entriamo nel secondo scaglione per reddito selezionato allora sommeremo  sia il valore costante primoNum che secondoNum e ugualmente accadrà per il terzo dove si aggiungerà anche terzoNum.
In pratica l'operazione è uguale e si ripete due volte sia tra i massimi degli scaglioni attuale e precedente sia tra il reddito selezionato e il massimo scaglione precendete.  
Nel primo caso non avendo uno scaglione precedente ovviamente non faremo la differenza ma solo il calcolo della percentuale.
Utilizziamo il float per i valori decimale e il metodo Math.round per arrotondare di due decimale grazie alla moltiplicazione *100/100
*/
package esercizi.primiAlgoritmi;
import java.util.Scanner;

public class Irpef{
    public static void main(String[] args){

        System.out.println("");

	System.out.println("Inserire il reddito lordo: ");
	Scanner tastiera = new Scanner(System.in);
	int redditoLordo = tastiera.nextInt();
        System.out.println("");

	double tassazione = 0;

	int primoNum = 3450;
	int secondoNum = 3250;
	int terzoNum = 7700;
	int differenza = 0;

	if(redditoLordo <= 15000){
	    tassazione=(float) redditoLordo*0.23;
	}else if(redditoLordo <=28000) {
	    differenza=redditoLordo-15000;
	    tassazione=((float) differenza*0.25)+primoNum;
        }else if(redditoLordo<=50000){
            differenza=redditoLordo-28000;
            tassazione=((float) differenza*0.35)+primoNum+secondoNum;
	}else{
            differenza=redditoLordo-50000;
	    tassazione=((float) differenza *0.43)+ primoNum+secondoNum+terzoNum;
	}
        System.out.println("risultato:"+((float) Math.round(tassazione*100))/100);
        System.out.println("");
    }
}