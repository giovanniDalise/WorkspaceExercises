package esercizio;
import java.io.*;
public class Rubrica {
    private static final String RUBRICA_FILE = ".ser";

    public void salvaContatto(Contatto contatto) {
        String nomeFile = contatto.getNome() + RUBRICA_FILE;
        try {
            FileOutputStream fileOut = new FileOutputStream(nomeFile);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOut);
            outputStream.writeObject(contatto);
            System.out.println("Il contatto è stato salvato correttqamente su file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leggiContatto(String nome) {
        String nomeFile = nome + RUBRICA_FILE;
        try {
            FileInputStream fileIn = new FileInputStream(nomeFile);
            ObjectInputStream inputStream = new ObjectInputStream(fileIn);
            Contatto contatto = (Contatto) inputStream.readObject();
            contatto.stampaDati();
        } catch (FileNotFoundException e) {
            System.out.println("Il contatto '" + nome + "' non è stato trovato.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
