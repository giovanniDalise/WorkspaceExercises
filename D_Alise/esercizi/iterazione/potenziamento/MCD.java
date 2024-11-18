package esercizi.potenziamento.iterazione;
import java.util.Scanner;
import esercizi.utility.Tastiera;

public class MCD{
    public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    int mcd =0;
    int a = Tastiera.chiediInteroPositivo("Inserisci un numero:");
    int b = Tastiera.chiediInteroPositivo("Inserisci un numero:");
    if (b==0){
      mcd = a;
    }else{
      mcd = metodoMassimoComuneDivisore(a,b);
    }
    System.out.println("Il massimo comune divisore è:\n" + mcd);
    }

    public static int metodoMassimoComuneDivisore( int a, int b) {
        int r;
        while (b != 0) {
          r = a % b;
          a = b;
          b = r;
        }
        return Math.abs(a);
    }
}

