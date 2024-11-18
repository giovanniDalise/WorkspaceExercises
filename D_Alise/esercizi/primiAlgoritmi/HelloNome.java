package esercizi.primiAlgoritmi;

import java.util.Scanner; //import classe Scanner

public class HelloNome{
    public static void main(String[] input){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci il tuo nome:");
        String nome = scanner.nextLine();
        System.out.println("");

        System.out.println("Ciao " + nome);
        System.out.println("");
    }
}