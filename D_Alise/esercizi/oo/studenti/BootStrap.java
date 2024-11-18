/*Scrivi un programma che gestisce una classe di studenti, con variabili di istanza come il nome dello studente, 
l'età, il voto medio e l'indirizzo email. Implementa metodi per aggiungere uno studente alla classe, 
per cercare uno studente per nome o per email e per calcolare la media dei voti degli studenti nel database.*/

package esercizi.oo.studenti;

import esercizi.utility.Tastiera;

public class BootStrap {
    public static void main(String[] args) {
        Classe classe = new Classe(10);
        int cnt = 0;
        String input = "";
        while (!input.equalsIgnoreCase("exit") && count < 10) {
            Studente studente = setDatiStudente();
            classe.aggiungiStudente(studente);
            cnt++;
            input = Tastiera.chiediStringa("Inserire 'exit' per terminare l'inserimento studenti, altrimenti premere un tasto qualsiasi per continuare:");
        }
        String nomeOEmail = Tastiera.chiediStringa("Inserisci il nome o l'email dello studente da cercare:");
        System.out.println();
        Studente studenteCercato = classe.cercaStudente(nomeOEmail);
        if (studenteCercato != null) {
            System.out.println("Studente trovato: " + studenteCercato);
        } else {
            System.out.println("Studente non trovato.");
        }
        float mediaVoti = classe.calcolaMediaVoti();
        System.out.println("Media voti: " + mediaVoti);
    }

    public static Studente setDatiStudente() {
        String nuovoNome = Tastiera.chiediStringa("Inserisci il nome dello studente:");
        int nuovaEta = Tastiera.chiediIntero("Inserisci l'età dello studente:");
        float nuovoVotoMedio = Tastiera.chiediFloat("Inserisci il voto dello studente:");      
        String nuovaEmail = Tastiera.chiediStringa("Inserisci l'email dello studente:");        

        Studente studente = new Studente(nuovoNome, nuovaEta, nuovoVotoMedio, nuovaEmail);

        return studente;
    }
}



