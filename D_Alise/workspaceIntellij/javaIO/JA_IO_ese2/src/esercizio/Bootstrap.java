package esercizio;
import java.util.Scanner;
import java.io.*;

public class Bootstrap {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Inserisci il nome del file:");
        String nomeFileInput = input.nextLine();
        String nomeFileOutput = nomeFileInput + ".copied";

        try (FileInputStream inputStream = new FileInputStream(nomeFileInput);
             FileOutputStream outputStream = new FileOutputStream(nomeFileOutput)) {
            int c;
            while ((c= inputStream.read()) != -1) {
                outputStream.write(c);
            }
            System.out.println("File copiato con successo");
        }catch(IOException e){
            System.out.println("Si è verificato un errore durante la copia del file: " + e.getMessage());
        }
    }
}