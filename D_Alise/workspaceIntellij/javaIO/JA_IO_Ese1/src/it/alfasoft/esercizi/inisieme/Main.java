package it.alfasoft.esercizi.inisieme;

import java.io.*;

public class Main {

    /**
     * args contiene i parametri passati al programma da terminale.
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        if(args!=null && args.length >0){
            String nomeFile = args[0];
            System.out.println("FIS--------------------");
            stampareTramiteFIS(nomeFile);
            System.out.println("BR---------------------");
            stampareTramiteBR(nomeFile);
        }else{
            System.out.println("Attenzione indicare il nome del file da leggere.");
        }
    }

    private static void stampareTramiteBR(String nomeFile) throws Exception {
        try(BufferedReader br = new BufferedReader(new FileReader(nomeFile))){
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new Exception("Nome file sbagliato!");
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("Nome file illeggibile!");
        }
    }

    private static void stampareTramiteFIS(String nomeFile) throws Exception {
        try(FileInputStream in = new FileInputStream(nomeFile)){
            int c;
            while ((c = in.read()) != -1) {
                System.out.print((char) c);
            }
            System.out.println("");
        } catch (FileNotFoundException e) {
            throw new Exception("Attenzione il file indicato non esiste.");
        } catch (IOException e) {
            throw new Exception("Attenzione il file è illegibile.");
        }
    }
}
