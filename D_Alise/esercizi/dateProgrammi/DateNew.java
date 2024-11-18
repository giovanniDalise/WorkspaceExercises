/*
Scrivi una programma che utilizzando le classi java.time chieda:
- la data odierna
- il calcolo del numero di giorni tra due date inserite dall'utente
- che verifichi se una data è valida.
- che verifichi se un anno è bisestile.
- che calcoli il giorno della settimana di una data specifica inserita dall'utente
- che calcoli la differenza tra due date in ore, minuti e secondi.
-  che converta un oggetto Date in una stringa nel formato "dd/MM/yyyy".
-  che stampi l'ora attuale in un formato personalizzato, ad esempio "HH:mm:ss".
-  che calcoli la differenza di età tra due persone in base alla data di nascita inserita dall'utente.
-  che calcoli la data di scadenza di un contratto a partire dalla data di inizio e dalla durata in mesi inserite dall'utente.
*/
package esercizi.dateProgrammi;
import java.util.Scanner;

public class DateNew {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
 
        System.out.println("");

        // Data Corrente
        System.out.println("Data corrente: " + DateUtilsNew.dataCorrente());
  
        // DifferenzaGiorni
        System.out.println("");
        System.out.println("Differenza tra due date");
        System.out.print("Inserisci la prima data (formato AAAA-MM-GG): ");
        String data1Str = input.nextLine();
        System.out.print("Inserisci la seconda data (formato AAAA-MM-GG): ");
        String data2Str = input.nextLine();
        long differenzaGiorni = DateUtilsNew.differenzaGiorni(data1Str, data2Str);
        System.out.println("Differenza in giorni tra " + data1Str + " e " + data2Str + ":\n" + differenzaGiorni + " giorni.");

       
        // Data Valida
        System.out.println("");
        System.out.println("Validità data");
        System.out.print("Inserisci l'anno: ");
        int anno = input.nextInt();

        System.out.print("Inserisci il mese: ");
        int mese = input.nextInt();

        System.out.print("Inserisci il giorno: ");
        int giorno = input.nextInt();

        boolean valida = DateUtilsNew.dataValida(anno, mese, giorno);
        if (valida) {
            System.out.println(anno + "-" + mese + "-" + giorno + " è una data valida");
        } else {
            System.out.println(anno + "-" + mese + "-" + giorno + " non è una data valida");
        }

 
        // Anno Bisestile
        System.out.println("");
        System.out.println("Anno Bisestile");
        System.out.print("Inserisci l'anno: ");
        int annoBisestile = input.nextInt();
        String esito = DateUtilsNew.annoBisestile(annoBisestile);
        System.out.println(esito);
        

        // Giorno della Settimana
        System.out.println("");
        System.out.println("Giorno della settimana");
        System.out.print("Inserisci la data (formato AAAA-MM-GG): ");
        String dataStr = input.nextLine();
        String giornoSettimana = DateUtilsNew.giornoSettimana(dataStr);
        System.out.println("Il " + dataStr + " cade di " + giornoSettimana);



        // Differenza Tempo
        System.out.println("");
        System.out.println("Differenza Tempo");        
        System.out.println("Inserisci la prima data (AAAA-MM-GG HH:mm:ss):");
        String data1 = input.nextLine();
        System.out.println("Inserisci la seconda data (AAAA-MM-GG HH:mm:ss):");
        String data2 = input.nextLine();

        String differenza = DateUtilsNew.differenzaTempo(data1, data2);
        System.out.println("La differenza tra le due date è: " + differenza);


        // Data in Formato "dd/MM/yyyy"
        System.out.println("");
        System.out.println("Data in Formato dd/MM/yyyy");        
        System.out.println("Inserisci la data (AAAA-MM-GG):");
        String data = input.nextLine();
        String dataFormattata = DateUtilsNew.formattaData(data);
        System.out.println("Data formattata: " + dataFormattata);
            
        // Ora corrente "HH:mm:ss"
        System.out.println("");
        String oraFormattata = DateUtilsNew.formattaOraCorrente();
        System.out.println("Ora corrente in HH:mm:ss: " + oraFormattata);

           
        // Differenza Eta
        System.out.println("");
        System.out.println("Differenza età");
        System.out.println("Inserisci la data di nascita della prima persona (formato: AAAA-MM-GG):");
        String dataPrimo = input.nextLine();
        
        System.out.println("Inserisci la data di nascita della seconda persona (formato: AAAA-MM-GG):");
        String dataSecondo = input.nextLine();

        System.out.println("La differenza di età tra le due persone è di " + DateUtilsNew.calcolaDifferenzaEta(dataPrimo, dataSecondo));
 
        // Scadenza Contratto
        System.out.println("");
        System.out.println("Scadenza Contratto");
        System.out.print("Inserisci la data di inizio del contratto (formato YYYY-MM-DD): ");
        String dataInizio = input.nextLine();
        System.out.print("Inserisci la durata in mesi del contratto: ");
        int durata = input.nextInt();
        input.nextLine(); // Consuma il newline rimasto nel buffer di input
        String dataScadenza = DateUtilsNew.dataScadenzaContratto(dataInizio, durata);
        System.out.println("La data di scadenza del contratto è: " + dataScadenza);
        input.close();
    }
}
