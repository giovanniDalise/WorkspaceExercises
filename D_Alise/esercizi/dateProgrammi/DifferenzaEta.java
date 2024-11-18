//calcola la differenza di età tra due persone in base alla data di nascita inserita dall'utente con le classi java.time



package esercizi.dateProgrammi;
import java.time.*;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;

public class DifferenzaEta{
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println("Inserisci la data di nascità della prima persona (in formato yyyy-mm-dd):");
        LocalDate data1 = LocalDate.parse(input.nextLine());
        System.out.println("Inserisci la data di nascità della seconda persona (in formato yyyy-mm-dd):");
        LocalDate data2 = LocalDate.parse(input.nextLine());

        long differenza = 0;

        if(data1.isAfter(data2)){
        	differenza = ChronoUnit.YEARS.between(data1,data2);
        }else{
        	differenza = ChronoUnit.YEARS.between(data2,data1);
        }
        System.out.println("La differenza di età è di " + Math.abs(differenza) + " anni.");
    }
}
