package esercizio;

public class BootStrap {
    public static void main(String[] args) {
        Mela mela = new Mela("laMiaMela",1.20,"golden",2 );
        double prezzo = mela.calcolaPrezzoAlKilo();
        System.out.println(prezzo);
    }
}