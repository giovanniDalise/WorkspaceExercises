package ese8;

import ese8.dao.DaoTimbrature;
import ese8.dao.IDao;
import ese8.dto.Timbratura;

import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class BootStrap {

    private static IDao<Timbratura> dao = new DaoTimbrature();

    public static void main (String[] args)throws IOException {
        Scanner input = new Scanner(System.in);
        int scelta = 0;

        do {
            System.out.println("Scegli un operazione:");
            System.out.println("1.Registra Timbratura");
            System.out.println("2.Visualizza Timbrature");
            System.out.println("3.Visualizza Timbrature per nome");
            System.out.println("4.Uscita");
            scelta = input.nextInt();
            input.nextLine();

            switch(scelta){
                case 1:
                    registraTimbratura(input);
                    break;
                case 2:
                    visualizzaTimbrature();
                    break;
                case 3:
                    visualizzaTimbraturePerNome(input);
                    break;
                case 0:
                    System.out.println("Arrivederci");
                    break;
                default:
                    break;
            }
        }while(scelta!=0);
    }
    public static void registraTimbratura(Scanner input)throws IOException{
        System.out.println("Inserisci il dipendente al quale annotare la timbratura:");
        System.out.println("1.Giovanni D'Alise");
        System.out.println("2.Alessio Di Stefano");
        System.out.println("3.Daniel Guidolin");
        int nuovoIdDipendente = input.nextInt();
        input.nextLine();

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        System.out.println("Inserisci il tipo di timbratura (entrata/uscita):");
        String nuovoTipo = input.nextLine();

        Timbratura nuovaTimbratura = new Timbratura(nuovoIdDipendente,timestamp,nuovoTipo);
        Timbratura timbraturaRegistrata = dao.create(nuovaTimbratura);
        System.out.println("Spesa registrata: " + timbraturaRegistrata.toString());
    }

    public static void visualizzaTimbrature()throws IOException {
        IDao<Timbratura> dao = new DaoTimbrature();
        List<Timbratura> listaTimbrature = dao.read();
        for (Timbratura timbratura : listaTimbrature) {
            System.out.println(timbratura.toString());
        }
    }
    public static void visualizzaTimbraturePerNome(Scanner input) throws IOException {
        IDao<Timbratura> dao = new DaoTimbrature();
        List<Timbratura> listaTimbrature = null;

        System.out.println("Inserire il nome del dipendente di cui vuoi visualizzare le timbrature:");
        String nuovoNome = input.nextLine();
        listaTimbrature = dao.findForName(nuovoNome);
        if (listaTimbrature.isEmpty()) {
            System.out.println("Nessuna timbratura trovata.");
        } else {
            for (Timbratura timbratura : listaTimbrature) {
                System.out.println(timbratura.toString());
            }
        }
    }
}
