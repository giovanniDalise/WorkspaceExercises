package esercizi;

import java.util.Scanner; 

public class conversione{
    public static void main(String[] input){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci un numero: ");
        double D = scanner.nextDouble();
     
        System.out.println("");

        int I =(int) D;
 
        long L =(long) D;

        float F =(float) D;

        System.out.println(I);
        System.out.println("");
        System.out.println(L);
        System.out.println("");
        System.out.println(F);
        System.out.println("");
    }
}




        
