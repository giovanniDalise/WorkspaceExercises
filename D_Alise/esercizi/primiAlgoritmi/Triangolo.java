package esercizi.primiAlgoritmi;
import java.util.Scanner;

public class Triangolo{  
    public static void main(String[] input){          
	
        Scanner tastiera = new Scanner(System.in);   
      
	System.out.println("Inserisci la base:");
	int base = tastiera.nextInt();

	while (base<=0){
	    System.out.println("Inserisci un numero positivo:");
	    base = tastiera.nextInt();
	}

	System.out.println("Inserisci l'altezza:");
	int altezza = tastiera.nextInt();

	while (altezza<=0){
	    System.out.println("Inserisci un numero positivo:");
	    altezza = tastiera.nextInt();
	}

	double perimetro = base + altezza + Math.sqrt(base*base+altezza*altezza);
	double area = base * altezza/2.0;

	System.out.println("Perimetro = "+ perimetro);
	System.out.println("Area = "+area);

	String riga1="";
	int i=0;
	for(i=0;i<base;i++){
	    riga1=riga1+"*";
	}
				
	String riga2="*";
	double pendenza=(double) base/altezza;
	System.out.println(riga2);
	for(i=1;i<altezza-1;i++){
	    int coeff=(int) Math.round(i*pendenza);
	    for(int j=1;j<coeff;j++){
	        riga2=riga2+" ";
	    }
	    riga2=riga2+"*";
	    System.out.println(riga2);
	    riga2="*";
	}
	System.out.println(riga1);
    } 
} 