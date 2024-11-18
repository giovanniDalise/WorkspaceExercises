package esercizi.utility;

import java.util.Scanner;
public class Tastiera{
    public static Scanner sc=new Scanner(System.in);
	
    public static int chiediInteroPositivo(String messaggio){
        System.out.println(messaggio);
        int numeroInteroPositivo=sc.nextInt();
        sc.nextLine();
        while(numeroInteroPositivo<=0){
            System.out.println("Inserisci un numero positivo:");
	        numeroInteroPositivo=sc.nextInt();
            sc.nextLine();
	    }
	    return numeroInteroPositivo;
    }

    public static double chiediDouble(String messaggio){
	    System.out.println(messaggio);
	    return sc.nextDouble();
    }

    public static float chiediFloat(String messaggio){
        System.out.println(messaggio);
        return sc.nextFloat();
    }    

    public static int chiediNumeroInt(int numMin, int numMax){
            int scelta;
	    do{
            System.out.println("Inserisci un numero compreso tra " + numMin + " e " + numMax + " per favore: ");
	        scelta = sc.nextInt();
            System.out.println("");
	    }while(scelta < numMin || scelta > numMax);
	    return scelta;
        }
	
    public static int chiediIntero(String messaggio){
	    System.out.println(messaggio);     
	    return sc.nextInt();
    }
        
    public static String chiediStringa(String messaggio){
        System.out.println(messaggio);
        return sc.nextLine();
    }

    public static int numeroMassimo(int numero1,int numero2){
        int max = 0;
        if(numero1>numero2){
            max=numero1;
        }else{
            max=numero2;
        }
        return max;
    }
    public static void smaltisciRestoInput() {
        sc.nextLine(); // Consuma il resto dell'input
    }   
}