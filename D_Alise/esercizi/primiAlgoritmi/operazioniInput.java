package esercizi.primiAlgoritmi;
/*ho trasformato la variabile int N1 in float in modo da ottenere un numero decimale se 
avessi diviso i due N int mi avrebbe troncato i decimali.
il metodo Math.round(divisione*100.0)/100.0 in questo caso usava il *100 e il /100 che sono degli operatori letterali ossia non sono definiti come tipi(int, float...) e questi hanno come proprietà il fatto che potremo tranquillamente operare in questo caso la divisione tra due interi ci darebbe un float o double(basta eseguire l'operazione matematicamente,prova) ma non utilizzando questa formula casto N1 in float perchè è importante che uno dei due N sia decimale in modo da non perdere la parte decimale(se avessi fatto int diviso int avrei perso invece il decimale) */
import java.util.Scanner;

public class operazioniInput{
    public static void main(String[] input){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci il primo numero: ");
        int N1 = scanner.nextInt();
        System.out.println("");
    
        System.out.println("Inserisci il secondo numero: ");
        int N2 = scanner.nextInt();
        System.out.println("");

        int somma = N1 + N2;
        int differenza = N1 - N2;
        int modulo = N1%N2;
        int moltiplicazione = N1*N2;
        double divisione = ((float) N1/N2);

        System.out.println(somma);
        System.out.println("");
        System.out.println(differenza);
        System.out.println("");
        System.out.println(modulo);
        System.out.println("");
        System.out.println(moltiplicazione);
        System.out.println("");
        System.out.println(divisione);
        System.out.println("");
    }
}



     