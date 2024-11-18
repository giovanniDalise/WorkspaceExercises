package esercizi.primiAlgoritmi;
import java.util.Scanner;
public class Potenza{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Inserisci la base di una potenza:");
        long x = input.nextLong();
        System.out.println("Inserisci l'esponente di una potenza");
        int n = input.nextInt();
        long potenza = 1;
        for(int i =1; i<=n;i++){
            potenza*=x;
        }
        System.out.println("Potenza:\n" + potenza);
    }
}    
