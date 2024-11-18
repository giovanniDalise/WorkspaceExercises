package esercizi.array;
import esercizi.utility.Tastiera;

public class FibonacciRicorsivo{
    public static void main(String[] input){
        int numeroScelto = Tastiera.chiediIntero("Scrivi un numero della sequenza di fibonacci:");
        int indice = trovaIndice(0,1,1,numeroScelto);
        System.out.println("Indice:"+ indice);
    }
    public static int trovaIndice(int numeroPrecedente,int numeroAttuale,int cnt,int numeroScelto){
        int result = 0;
        if(numeroScelto<=1){
            result=numeroScelto;
        }else if(numeroAttuale==numeroScelto){
            result=cnt;
        }else if(numeroAttuale<numeroScelto){
            result=trovaIndice(numeroAttuale,numeroAttuale+numeroPrecedente,++cnt,numeroScelto);
        }else{
            result=-1;
        }
        return result;
    }
}   