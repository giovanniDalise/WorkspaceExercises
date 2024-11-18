package esercizi.potenziamento.iterazione;
import java.util.Scanner;
public class SommaMenoUno{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in); 
        int somma=0;
        int numero=0;

        while(numero!=-1){
            somma+=numero;
            System.out.println("Scrivi un numero: ");
            numero = input.nextInt();
            
        }
        System.out.println(somma);
    }
}    

