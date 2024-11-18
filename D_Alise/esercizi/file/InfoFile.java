package esercizi.file;
import java.io.File;

public class InfoFile{
    public static void main(String[] args){

        File directory = new File("/Users/giovannidalise/Desktop/WORKSPACE/esercizi/geometria"); 
        System.out.println("PATH CORRENTE:\n" + System.getProperty("user.dir"));
        System.out.println("PATH ASSOLUTO:\n"+ directory.getAbsolutePath());
        System.out.println("NOME:\n" + directory.getName());
        System.out.println("PARENT DIRECTORY:\n" + directory.getParent());
        System.out.println("ESEGUIBILE:\n" + directory.canExecute());
        System.out.println("LEGGIBILE:\n" + directory.canRead());
        System.out.println("SCRIVIBILE:\n" + directory.canWrite());

    }
}