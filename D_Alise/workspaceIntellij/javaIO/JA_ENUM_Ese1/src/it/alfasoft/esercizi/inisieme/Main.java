package it.alfasoft.esercizi.inisieme;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
// ESEMPIO
//        int[] arrayInteri={8,2,14,43,51};
//        for(int elementoDellArray : arrayInteri){
//
//        }
        for (Stagioni stagione:Stagioni.values()) {
            System.out.println(stagione.name());
        }
        System.out.println("Inserisci il nome della stagione che vuoi vedere: ");
        Scanner sc = new Scanner(System.in);
        String nomeStagione = sc.nextLine();
        Stagioni stagioneSelezionata = Stagioni.valueOf(nomeStagione.toUpperCase());
        System.out.println("----------------");
        System.out.println(stagioneSelezionata.name());
        System.out.println("Data Inizio             : " + stagioneSelezionata.getInizio());
        System.out.println("Data Fine               : " + stagioneSelezionata.getFine());
        System.out.println("Temperatura Media       : " + stagioneSelezionata.getTemperatura());
        System.out.println("Durata Media del giorno : " + stagioneSelezionata.getDurataGiorno());
    }
}
