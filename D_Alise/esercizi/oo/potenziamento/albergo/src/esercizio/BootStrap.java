package esercizio;

import java.time.LocalDate;
import java.util.Scanner;

public class BootStrap {

    public static void main(String[] args) {

    SistemaPrenotazione hotel = new SistemaPrenotazione();
    Scanner input = new Scanner (System.in);

    // Aggiungi camere all'hotel
        hotel.aggiungiCamera(101,20,5);
        hotel.aggiungiCamera(102,20,5);
        hotel.aggiungiCamera(103,25,2);
        hotel.aggiungiCamera(104,25,2);
        hotel.aggiungiCamera(105,25,2);

        int scelta =0;
        do{
            System.out.println("Scegliere tra queste operazioni:");
            System.out.println("1.Prenota camera."); //all'interno richiamiamo il metodo per il calcolo del costo
            System.out.println("2.Cerca camera disponibile.");
            System.out.println("3.Esci.");
            LocalDate dataArrivo = null;
            LocalDate dataPartenza = null;
            int numeroOspiti = 0;
            scelta = input.nextInt();
            input.nextLine();
            switch (scelta){
                case 1:
                    System.out.println("Indicare la data di arrivo(YYYY-MM-DD)");
                    dataArrivo = LocalDate.parse(input.nextLine());
                    System.out.println("Indicare la data di partenza(YYY-MM-DD)");
                    dataPartenza = LocalDate.parse(input.nextLine());
                    System.out.println("Inserire il numero di ospiti:");
                    numeroOspiti = input.nextInt();
                    input.nextLine();
                    System.out.println("Le camere 101 e 102 sono da 2 posti e vengono 20 euro a notte a persona.");
                    System.out.println("Le camere 103,104 e 105 sono da 3 posti e vengono 25 euro a notte a persona.");
                    System.out.println("Inserire la camera da prenotare:");
                    int numeroCamera = input.nextInt();
                    input.nextLine();
                    hotel.prenotaCamera(numeroCamera,dataArrivo,dataPartenza,numeroOspiti);
                    break;
                case 2:
                    System.out.println("Indicare la data di arrivo(YYYY-MM-DD)");
                    dataArrivo = LocalDate.parse(input.nextLine());
                    System.out.println("Indicare la data di partenza(YYY-MM-DD)");
                    dataPartenza = LocalDate.parse(input.nextLine());
                    System.out.println("Inserire il numero di ospiti:");
                    numeroOspiti = input.nextInt();
                    input.nextLine();
                    hotel.trovaCamereDisponibili(dataArrivo,dataPartenza,numeroOspiti);
                    break;
                case 0:
                    System.out.println("Arrivederci!");
                    break;
                default:
                    System.out.println("Scelta errata. Riprovare!");
                    break;
            }
        }while(scelta !=0);
    }
}