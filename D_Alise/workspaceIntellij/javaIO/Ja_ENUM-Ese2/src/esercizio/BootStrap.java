package esercizio;
import java.util.Scanner;

public class BootStrap {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Scrivi un cifra in euro:");
        double euro = Double.parseDouble(input.nextLine());

        System.out.println("Seleziona la valuta di conversione:");
        for(Valute valuta: Valute.values()){
            System.out.println(valuta.name());
        }
        String nomeValuta = input.nextLine();

        Valute valutaSelezionata = Valute.valueOf(nomeValuta.toUpperCase());

        double valoreConvertito = euro*valutaSelezionata.getTassoDiCambio();
        System.out.println(euro + " euro corrispondono a " + valoreConvertito + " " + valutaSelezionata);
    }
}
