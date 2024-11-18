package ese7;

import ese7.dao.DaoSpese;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import ese7.dao.IDao;
import ese7.dto.Spesa;

import java.util.List;
import java.util.Scanner;

public class BootStrap {
    private static IDao<Spesa> dao = new DaoSpese();

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int scelta = 0;

        do {
            System.out.println("Scegli un operazione:");
            System.out.println("1.Registra la spesa");
            System.out.println("2.Visualizza le spese");
            System.out.println("3.Ricerca le spese");
            System.out.println("0.Esci");

            scelta = input.nextInt();
            input.nextLine();

            switch (scelta) {
                case 1:
                    registraSpesa(input);
                    break;
                case 2:
                    visualizzaSpese();
                    break;
                case 3:
                    ricercaSpese(input);
                    break;
                case 0:
                    System.out.println("Arrivederci");
                    break;
                default:
                    System.out.println("Scelta non valida riprova!");
                    break;
            }
        } while (scelta != 0);
    }

    public static void registraSpesa(Scanner input) throws IOException {
        System.out.println("Inserisci la data:");
        String data = input.nextLine();
        System.out.println("Inserisci il tipo:");
        String tipo = input.nextLine();
        System.out.println("Inserisci il luogo:");
        String luogo = input.nextLine();
        System.out.println("Inserisci l'importo:");
        double importo = input.nextDouble();
        input.nextLine();
        System.out.println("Inserisci le note:");
        String note = input.nextLine();

        Spesa nuovaSpesa = new Spesa(data, tipo, luogo, importo, note);
        Spesa spesaRegistrata = dao.create(nuovaSpesa);
        System.out.println("Spesa registrata: " + spesaRegistrata.toString());
    }

    public static void visualizzaSpese() throws IOException {
        IDao<Spesa> dao = new DaoSpese();
        List<Spesa> listaSpese = dao.read();
        for (Spesa spesa : listaSpese) {
            System.out.println(spesa.getData());
            System.out.println(spesa.getTipo());
            System.out.println(spesa.getLuogo());
            System.out.println(spesa.getImporto());
            System.out.println(spesa.getNote());
        }
    }

    public static void ricercaSpese(Scanner input) throws IOException {
        IDao<Spesa> dao = new DaoSpese();
        List<Spesa> listaSpese = null;

        System.out.println("Selezionare il parametro di ricerca:");
        System.out.println("1.Tipo");
        System.out.println("2.Luogo");

        int scelta = input.nextInt();
        input.nextLine();

        switch (scelta) {
            case 1:
                System.out.println("Inserisci il tipo di spesa:");
                String tipoRicerca = input.nextLine();
                listaSpese = dao.findForType(tipoRicerca);
                break;
            case 2:
                System.out.println("Inserisci il luogo della spesa:");
                String luogoRicerca = input.nextLine();
                listaSpese = dao.findForLocation(luogoRicerca);
                break;
            default:
                System.out.println("Scelta non valida.");
                return;
        }

        if (listaSpese.isEmpty()) {
            System.out.println("Nessuna spesa trovata.");
        } else {
            for (Spesa spesa : listaSpese) {
                System.out.println(spesa.getData());
                System.out.println(spesa.getTipo());
                System.out.println(spesa.getLuogo());
                System.out.println(spesa.getImporto());
                System.out.println(spesa.getNote());
            }
        }
    }
}