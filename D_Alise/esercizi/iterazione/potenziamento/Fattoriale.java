package esercizi.potenziamento.iterazione;
public class Fattoriale{
    public static void main(String[] args){
        long fattoriale=1;

        for(int i=1;i<=20;i++){
            fattoriale*=i;           
        }
        System.out.println("Fattoriale:\n"+ fattoriale);
    }
}    

