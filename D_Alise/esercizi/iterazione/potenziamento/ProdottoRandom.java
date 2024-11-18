package esercizi.potenziamento.iterazione;
public class ProdottoRandom{
    public static void main(String[] input){
        int prodotto=1;
        double N = Math.random()*15+1;
        N =(int)N;
        System.out.println(N);
        for(int i = 1;i<=N; i++){
            prodotto*=i;
        }
        System.out.println(prodotto);
    }
}    
