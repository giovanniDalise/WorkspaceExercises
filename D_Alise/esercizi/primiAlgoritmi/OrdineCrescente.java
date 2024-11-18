package esercizi.primiAlgoritmi;

import java.util.Scanner; 

public class OrdineCrescente{
    public static void main(String[] input){

        Scanner scanner = new Scanner(System.in);

        System.out.println(""); 

        System.out.println("Inserisci il primo numero: ");
        int N1 = scanner.nextInt();
        System.out.println("");

        System.out.println("Inserisci il secondo numero: ");
        int N2 = scanner.nextInt();
        System.out.println("");

        if(N1==N2){
            System.out.println("N1 e N2 sono uguali"); 
        }else if(N1>N2) {
            System.out.println(N2 + "\n" + N1); 
        }else {
            System.out.println(N1 + "\n" + N2); 
        }  
        System.out.println(""); 
    }
}