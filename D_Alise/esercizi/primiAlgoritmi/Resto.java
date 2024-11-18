package esercizi.primiAlgoritmi;

public class Resto{
    public static void main(String[] input){

       int A = Tastiera.chiediInteroPositivo("Inserisci il dividendo:");
       int B = Tastiera.chiediInteroPositivo("Inserisci il divisore:");
       while(B>=A){
           System.out.println("Il divisore deve essere più piccolo del dividendo se vogliamo calcolare il resto");
           B = Tastiera.chiediInteroPositivo("Inserisci nuovamente il divisore:"); 
       }
       int resto = A;
       while(resto>=B){
           resto-=B;
       }
       System.out.println("Resto della divisione:\n" + resto);
    }
}



