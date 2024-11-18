import java.io.*;
import java.util.Scanner;
public class InfoPath {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String currentDirectory = System.getProperty("user.dir");
        File currentDir = new File(currentDirectory);
        //Costruttore File(String pathname)": Crea un oggetto "File" a partire da un percorso specificato come stringa.
        System.out.println("La directory corrente è: " + currentDirectory);
        int choice=0;

        while (choice!=5) {
            System.out.println("\nScegli un'operazione:");
            System.out.println("1. Visualizza l'elenco delle directory e dei file");
            System.out.println("2. Visualizza il contenuto di un file");
            System.out.println("3. Crea un nuovo file dentro una directory");
            System.out.println("4. Aggiungi del testo a un file");
            System.out.println("5. Esci");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    elencoFileEDirectory(currentDir);
                    break;
                case 2:
                    System.out.println("Inserisci il percorso del file:");
                    String filePath = input.nextLine();
                    visualizzaContenutoFile(filePath);
                    break;
                case 3:
                    System.out.println("Inserisci il nome del nuovo file:");
                    String newFileName = input.nextLine();
                    creaNuovoFile(currentDir, newFileName);
                    break;
                case 4:
                    System.out.println("Inserisci il percorso del file:");
                    String fileToAddText = input.nextLine();
                    System.out.println("Inserisci il testo da aggiungere:");
                    String textToAdd = input.nextLine();
                    aggiungiTestoAFile(fileToAddText, textToAdd);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
                    break;
            }
        }
    }
    public static void elencoFileEDirectory(File directory) {
        File[] files = directory.listFiles();
        //Il metodo listFiles() della classe File restituisce un array di oggetti File che rappresentano i file e
        // le directory contenute all'interno di una directory specificata. Questo metodo è utile per ottenere
        // un elenco di tutti i file e le directory presenti all'interno di una directory specifica.
        System.out.println("Elenco delle directory e dei file:");

        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("[" + file.getName() + "]");
            } else {
                System.out.println(file.getName());
            }
        }
    }

    public static void visualizzaContenutoFile(String filePath) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {
            System.out.println("Contenuto del file " + filePath + ":");
            String line;
            while ((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void creaNuovoFile(File directory, String fileName) {
        File newFile = new File(directory, fileName);
        try {
            if (newFile.createNewFile()) {//viene creato un oggetto File newFile ma questo sar effetticamente creato solo
                // quando sarà chiamato il metodo createNewFile che inoltre ci restituisce un boolean(come isDirectory())
                // che però sarà false se già esiste guarda (classeFile.txt)
                System.out.println("Il file " + fileName + " è stato creato con successo.");
            } else {
                System.out.println("Il file " + fileName + " già esiste.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void aggiungiTestoAFile(String filePath, String textToAdd) {
        try (FileWriter fileWriter = new FileWriter(filePath, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(textToAdd);
            System.out.println("Il testo è stato aggiunto al file " + filePath + ".");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


