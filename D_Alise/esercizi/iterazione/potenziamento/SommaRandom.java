package esercizi.potenziamento.iterazione;
public class SommaRandom{
    public static void main(String[] input){
        int somma=0;
        double N = Math.random()*100;
        N =(int)N;
        System.out.println(N);
        for(int i = 1;i<=N; i++){
            somma+=i;
        }
        System.out.println(somma);
    }
}    

