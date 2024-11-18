package esercizi.potenziamento.iterazione;
public class FattorialeRandom{
    public static void main(String[] args){
        double N = Math.random()*15+1;
        N=(int)N;
        System.out.println("Il numero generato è:\n" + N);
        long fattoriale = 1;

        for(int i=1;i<=N;i++){
            fattoriale*=i;           
        }
        System.out.println("Fattoriale:\n"+ fattoriale);
    }
}    

