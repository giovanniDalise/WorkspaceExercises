package esercizio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BootStrap {
    public static Agenda nuovaAgenda = new Agenda();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int scelta = 0;
        do{
            System.out.println("Scegli tra queste operazioni:");
            System.out.println("1.Aggiungi contatto all'agenda.");
            System.out.println("2.Ricerca contatto.");
            System.out.println("3.Cancella contatto.");
            System.out.println("4.Visualizza contatti.");
            System.out.println("0.Esci");
            scelta = input.nextInt();
            input.nextLine();
            switch (scelta) {
                case 1:
                    System.out.println("Inserisi il nome del contatto:");
                    String nome = input.nextLine();
                    System.out.println("Inserisci il numero del contatto:");
                    long numero = input.nextLong();
                    input.nextLine();
                    System.out.println("Inserisci l'email del contatto:");
                    String email = input.nextLine();
                    nuovaAgenda.setContatto(nome, numero, email);
                    break;
                case 2:
                    System.out.println("1.Ricerca per nome.");
                    System.out.println("2.Ricerca per numero di telefono.");
                    int sceltaRicerca = input.nextInt();
                    input.nextLine();
                    if (sceltaRicerca == 1) {
                        List<Contatto> contattiTrovati = new ArrayList<Contatto>();
                        System.out.println("Inserire il nome del contatto:");
                        contattiTrovati = nuovaAgenda.ricercaContattiPerNome(input.nextLine());
                        for(Contatto contatto:contattiTrovati){
                            System.out.println(contatto.toString());
                        }
                    } else if (sceltaRicerca == 2) {
                        System.out.println("Inserire il numero del contatto:");
                        Contatto contattoTrovato = nuovaAgenda.ricercaContattiPerNumero(input.nextLong());
                        input.nextLine();
                        System.out.println(contattoTrovato.toString());
                    } else {
                        System.out.println("Scelta non valida.");
                    }
                    break;
                case 3:
                    System.out.println("Inserisci il numero del contatto da eliminare:");
                    nuovaAgenda.eliminaContatto(input.nextLong());
                    break;
                case 4:
                    nuovaAgenda.visualizzaContatti();
                    break;
                case 0:
                    System.out.println("Arrivederci");
                    break;
                default:
                    System.out.println("Scelta non valida. Reinserire un numero:");
                    break;
            }
        }while (scelta!=0);
    }
}