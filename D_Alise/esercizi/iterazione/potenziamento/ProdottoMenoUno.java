package esercizi.potenziamento.iterazione;
import java.util.Scanner;
public class ProdottoMenoUno{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in); 
        int prodotto=1;
        int numero=1;

        while(numero!=-1){
            prodotto*=numero;
            System.out.println("Scrivi un numero: ");
            numero = input.nextInt();
            
        }
        System.out.println("Prodotto:\n"+ prodotto);
    }
}    

