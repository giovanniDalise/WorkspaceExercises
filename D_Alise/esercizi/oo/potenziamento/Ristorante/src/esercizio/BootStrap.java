package esercizio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class BootStrap {
    public static void main(String[] args) {
        GestionePrenotazioni ristoranteDaLucio = new GestionePrenotazioni();
        Scanner input = new Scanner(System.in);

        ristoranteDaLucio.aggiungiTavolo(1,2);
        ristoranteDaLucio.aggiungiTavolo(2,2);
        ristoranteDaLucio.aggiungiTavolo(3,4);
        ristoranteDaLucio.aggiungiTavolo(4,4);
        ristoranteDaLucio.aggiungiTavolo(5,6);
        ristoranteDaLucio.aggiungiTavolo(6,6);

        int scelta = 0;
        do{
            System.out.println("Inserisci un numero per le seguenti oeprazioni:");
            System.out.println("1.Prenota un tavolo.");
            System.out.println("2.Cerca disponibilità tavoli.");
            System.out.println("3.Cancella Prenotazione.");
            System.out.println("4.Esci");
            LocalDate dataPrenotazione = null;
            LocalTime oraPrenotazione = null;
            int numeroClienti = 0;
            scelta = input.nextInt();
            input.nextLine();
            switch (scelta){
                case 1:
                    System.out.println("Inserire la data di prenotazione");
                    dataPrenotazione = LocalDate.parse(input.nextLine());
                    System.out.println("Inserire l'orario di prenotazione(HH:mm:ss)");
                    oraPrenotazione = LocalTime.parse(input.nextLine());
                    System.out.println("Inserire il numero di persone");
                    numeroClienti = input.nextInt();
                    input.nextLine();
                    System.out.println("Inserisci un nome per la prenotazione");
                    String nomePrenotazione = input.nextLine();
                    ristoranteDaLucio.prenotaTavolo(dataPrenotazione,oraPrenotazione,numeroClienti,nomePrenotazione);
                    break;
                case 2:
                    System.out.println("Inserire la data di interesse");
                    LocalDate data = LocalDate.parse(input.nextLine());
                    System.out.println("Inserire il numero di persone");
                    numeroClienti = input.nextInt();
                    input.nextLine();
                    ristoranteDaLucio.trovaTavoloDisponibile(data,numeroClienti);


            }
        }
    }
}