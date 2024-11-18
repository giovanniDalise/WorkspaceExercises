package esercizi.array;
import java.io.*;

public class OrdinaParole {
    public static void main(String[] args) {
        try {
            // Apri il file di testo in input
            System.out.println("path corrente: " + System.getProperty("user.dir"));
            BufferedReader br = new BufferedReader(new FileReader("./array/Beatles.txt"));
            String inputLine;
            String[] parole = new String[100];
            int numParole = 0;

            // Leggi il contenuto del file e dividi in parole
            while ((inputLine = br.readLine()) != null) {
                String[] paroleLinea = inputLine.split(" ");
                for (int i = 0; i < paroleLinea.length; i++) {
                    parole[numParole] = paroleLinea[i];
                    numParole++;
                }
            }
            br.close();

            // Ordina le parole in ordine lessicografico 
            for (int i = 0; i < numParole - 1; i++) {
                int min = i;
                for (int j = i + 1; j < numParole; j++) {
                    if (parole[j].compareTo(parole[min]) < 0) {
                        min = j;
                    }
                }
                if (i != min) {
                    String temp = parole[i];
                    parole[i] = parole[min];
                    parole[min] = temp;
                }
            }

            // Scrivi le parole ordinate in un nuovo file di testo
            BufferedWriter bw = new BufferedWriter(new FileWriter("./array/BeatlesOut.txt"));
            for (int i = 0; i < numParole; i++) {
                bw.write(parole[i] + " ");
            }
            bw.close();

            System.out.println("Elenco parole ordinate salvato nel file 'output.txt'.");
        } catch (IOException e) {
            System.err.println("Errore durante l'elaborazione del file: " + e);
        }
    }
}
