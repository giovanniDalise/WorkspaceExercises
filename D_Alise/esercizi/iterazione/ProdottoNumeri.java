package esercizi.iterazione;
public class ProdottoNumeri{
    public static void main(String[] input){
        long prodotto=1;
        for(int i= 1; i<=15;i++){
            prodotto*=i;
        }
        System.out.println("Prodotto: " + prodotto);
    }
}      
