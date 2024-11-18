package esercizi.eccezioni;

import java.util.Random;

public class Centodivisioni{
    public static void main(String[] args) {
    
        Random generator = new Random();

        int rndNumber1 = 0;

        int rndNumber2 = 0;
  
        int divisione = 0;

        for(int i=1;i<=100;i++){
            try{
                rndNumber1 = generator.nextInt(6);
                rndNumber2 = generator.nextInt(6);
                divisione = rndNumber1/rndNumber2; 
            }catch(ArithmeticException eccezione){
                System.out.println("Errore Aritmetico!" + eccezione.getMessage());
                eccezione.printStackTrace(); 
            }finally{
                System.out.println("Grazie per aver utilizzato il nostro programma");
            }
                System.out.println(String.format("Risultato divisione: \n %d",divisione));
        }    
        
    }
    
}



   