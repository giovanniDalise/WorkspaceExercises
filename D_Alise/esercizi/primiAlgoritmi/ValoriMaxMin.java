package esercizi.primiAlgoritmi;

import java.util.Scanner; 

public class ValoriMaxMin{
    public static void main(String[] input){

        Scanner scanner = new Scanner(System.in);

        System.out.println(""); 


        System.out.println("Inserisci il primo numero: ");
        int N1 = scanner.nextInt();
        System.out.println("");

        System.out.println("Inserisci il secondo numero: ");
        int N2 = scanner.nextInt();
        System.out.println("");

        System.out.println("Inserisci il terzo numero: ");
        int N3 = scanner.nextInt();
        System.out.println("");

        if(N1>N2 && N1>N3){
            System.out.println("Il primo numero è il maggiore.");
            
        }else if(N2>N3 && N2>N1) {
            System.out.println("Il secondo numero è il maggiore.");
        }else { 
            System.out.println("Il terzo numero è il maggiore.");

        System.out.println(""); 

        }
        if(N1<N2 && N1<N3){
            System.out.println("Il primo numero è il  minore.");
        }else if(N2<N3 && N2<N1) {
            System.out.println("Il secondo numero è il minore.");
        }else { 
            System.out.println("Il terzo numero è il minore.");
        }
        System.out.println(""); 
    }
}

            

            


