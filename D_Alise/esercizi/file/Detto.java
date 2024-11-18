package esercizi.file;
import java.io.FileNotFoundException;//bisogna importare l'exception diversamente dai frutti dove creaiamo un exception custom
import java.io.File;


public class Detto{
    public static void main(String[] args) throws FileNotFoundException{
        System.out.println("path corrente: " + System.getProperty("user.dir"));
        Scanner input = new Scanner(new File("/Users/giovannidalise/Desktop/WORKSPACE/esercizi/dettoDelGiorno.txt"));
        System.out.println(input.nextLine());
        }
}