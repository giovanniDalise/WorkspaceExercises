package ese1;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;


public class Ristorante {
    private static List<Piatto> elencoPiatti = new ArrayList<Piatto>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        List<Ingrediente> ingredientiCarbonara = new ArrayList<Ingrediente>();
        ingredientiCarbonara.add(new Ingrediente("Rigatoni", "pasta", 365, true, false, true, 120));
        ingredientiCarbonara.add(new Ingrediente("Uova", "uova", 128, true, true, false, 50));
        ingredientiCarbonara.add(new Ingrediente("Guanciale", "carne", 655, false, true, false, 100));
        ingredientiCarbonara.add(new Ingrediente("Olio EVO", "condimento", 880, true, true, true, 10));
        ingredientiCarbonara.add(new Ingrediente("Sale", "condimento", 0, true, true, true, 5));

        List<Ingrediente> ingredientiLinguinePomodorini = new ArrayList<Ingrediente>();
        ingredientiLinguinePomodorini.add(new Ingrediente("Linguine", "pasta", 365, true, false, true, 120));
        ingredientiLinguinePomodorini.add(new Ingrediente("Pomodorini", "verdura", 18, true, true, true, 70));
        ingredientiLinguinePomodorini.add(new Ingrediente("Olio EVO", "condimento", 880, true, true, true, 15));
        ingredientiLinguinePomodorini.add(new Ingrediente("Sale", "condimento", 0, true, true, true, 7));

        List<Ingrediente> ingredientiFarinata = new ArrayList<Ingrediente>();
        ingredientiFarinata.add(new Ingrediente("Farina di Ceci", "farina",355,true,true,true,300));
        ingredientiFarinata.add(new Ingrediente("Olio EVO", "condimento", 880, true, true, true, 50));
        ingredientiFarinata.add(new Ingrediente("Sale", "condimento", 0, true, true, true, 10));

        List<Ingrediente> ingredientiOrata = new ArrayList<Ingrediente>();
        ingredientiOrata.add(new Ingrediente("Orata", "pesce", 81, false, true, false, 100));
        ingredientiOrata.add(new Ingrediente("Pomodorini", "verdura", 18, true, true, true, 50));
        ingredientiOrata.add(new Ingrediente("Olio EVO", "condimento", 880, true, true, true, 10));
        ingredientiOrata.add(new Ingrediente("Sale", "condimento", 0, true, true, true, 5));

        List<Ingrediente> ingredientiInsalatona = new ArrayList<Ingrediente>();
        ingredientiInsalatona.add(new Ingrediente("Iceberg", "verdure", 21, true, true, true, 100));
        ingredientiInsalatona.add(new Ingrediente("Pomodorini", "verdura", 18, true, true, true, 50));
        ingredientiInsalatona.add(new Ingrediente("Bufala Campana", "mozzarella", 250, true, true, false, 70));
        ingredientiInsalatona.add(new Ingrediente("Sale", "condimento", 0, true, true, true, 5));
        ingredientiInsalatona.add(new Ingrediente("Olio EVO", "condimento", 880, true, true, true, 10));

        List<Ingrediente> ingredientiFagioliInsalata = new ArrayList<Ingrediente>();
        ingredientiFagioliInsalata.add(new Ingrediente("Fagioli Cannellini", "legume", 250, true, true, true, 100));
        ingredientiFagioliInsalata.add(new Ingrediente("Olio EVO", "condimento", 880, true, true, true, 10));
        ingredientiFagioliInsalata.add(new Ingrediente("Sale", "condimento", 0, true, true, true, 5));

        List<Ingrediente> ingredientiPomodoriniInsalata = new ArrayList<Ingrediente>();
        ingredientiPomodoriniInsalata.add(new Ingrediente("Pomodorini", "verdura", 18, true, true, true, 100));
        ingredientiPomodoriniInsalata.add(new Ingrediente("Olio EVO", "condimento", 880, true, true, true, 10));
        ingredientiPomodoriniInsalata.add(new Ingrediente("Sale", "condimento", 0, true, true, true, 5));

        List<Ingrediente> ingredientiCaprese = new ArrayList<Ingrediente>();
        ingredientiCaprese.add(new Ingrediente("Bufala Campana", "mozzarella", 250, true, true, false, 80));
        ingredientiCaprese.add(new Ingrediente("Pomodorini", "verdura", 18, true, true, true, 100));
        ingredientiCaprese.add(new Ingrediente("Olio EVO", "condimento", 880, true, true, true, 10));
        ingredientiCaprese.add(new Ingrediente("Sale", "condimento", 0, true, true, true, 5));

        elencoPiatti.add(new Piatto("Carbonara", "primo", ingredientiCarbonara, 7, "Carbonara Romana rivisitata"));
        elencoPiatti.add(new Piatto("Linguine con pomodorini", "primo", ingredientiLinguinePomodorini, 6, "Linguine con pomodorini a km 0"));
        elencoPiatti.add(new Piatto("Farinata di ceci", "secondo", ingredientiFarinata, 5, "Farinata piemontese"));
        elencoPiatti.add(new Piatto("Orata al Cartoccio", "secondo", ingredientiOrata, 8, "Orata al cartoccio"));
        elencoPiatti.add(new Piatto("Insalatona", "insalata", ingredientiInsalatona, 6, "Insalatona tricolore"));
        elencoPiatti.add(new Piatto("Fagioli all'insalata", "contorno", ingredientiFagioliInsalata, 4, "Contorno di Fagioli"));
        elencoPiatti.add(new Piatto("Pomodorini all'insalata", "contorno", ingredientiPomodoriniInsalata, 4, "Contorno di pomodorini"));
        elencoPiatti.add(new Piatto("Caprese", "secondo", ingredientiCaprese, 7, "Caprese estiva"));

        int scelta;
        do {
            System.out.println("Scegli tra le seguenti opzioni:");
            System.out.println("1.Aggiungere un piatto all'elenco dei piatti del ristorante.");
            System.out.println("2.Aggiungere un ingrediente all'elenco degli ingredienti del ristorante.");
            System.out.println("3.Visualizzare il menu del pranzo.");
            System.out.println("4.Visualizzare il menu della cena.");
            System.out.println("5.Visualizzare tutti i piatti in ordine di prezzo.");
            System.out.println("6.Visualizzare tutti i piatti in ordine di calorie.");
            System.out.println("7.Visualizzare tutti i piatti per celiaci.");
            System.out.println("8.Visualizzare tutti i piatti per vegetariani.");
            System.out.println("9.Visualizzare tutti i piatti per vegani.");
            System.out.println("0.Esci dal menu.");
            scelta = input.nextInt();
            input.nextLine();
            switch (scelta) {
                case 1:
                    Piatto nuovoPiatto = aggiungiPiatto();
                    elencoPiatti.add(nuovoPiatto);
                    visualizzaPiattiPerPrezzo();
                    break;
                case 2:
                    aggiungiIngrediente();
                    visualizzaIngredienti();
                    break;
                case 3:
                    visualizzaMenuPranzo();
                    break;
                case 4:
                    visualizzaMenuCena();
                    break;
                case 5:
                    visualizzaPiattiPerPrezzo();
                    break;
                case 6:
                    visualizzaPiattiPerCalorie();
                    break;
                case 7:
                    visualizzaPiattiCeliaci();
                    break;
                case 9:
                    visualizzaPiattiVegetariani();
                    break;
                case 10:
                    visualizzaPiattiVegani();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Inserire un numero valido");
                    break;
            }
        } while (scelta != 0);
    }

    public static Piatto aggiungiPiatto() {
        System.out.println("Inserisci il nome del piatto:");
        String nome = input.nextLine();
        System.out.println("Inserisci il tipo di piatto (primo,secondo,contorno):");
        String tipo = input.nextLine();
        System.out.println("Inserimento ingredienti del piatto.");
        List<Ingrediente> ingredienti = new ArrayList<Ingrediente>();
        ingredienti = aggiungiIngrediente();
        System.out.println("Inserisci il prezzo del piatto:");
        double prezzo = input.nextDouble();
        input.nextLine();
        System.out.println("Inserisci il procedimento del piatto:");
        String procedimento = input.nextLine();
        Piatto piattoDaInserire = new Piatto(nome, tipo, ingredienti, prezzo, procedimento);
        return piattoDaInserire;
    }

    public static ArrayList<Ingrediente> aggiungiIngrediente() {
        ArrayList<Ingrediente> ingredienti = new ArrayList<Ingrediente>();
        System.out.println("Inserisci il nome dell'ingrediente:");
        String nome = input.nextLine();
        System.out.println("Inserisci il tipo dell'ingrediente(pesce,carne,verdura..):");
        String tipo = input.nextLine();
        System.out.println("Inserisci le calorie dell'ingrediente:");
        int calorie = input.nextInt();
        input.nextLine();
        System.out.println("Inserisci i grammi dell'ingrediente:");
        int grammi = input.nextInt();
        input.nextLine();
        boolean vegetariano = false;
        boolean vegano = false;
        boolean celiaco = false;
        if (tipo.equalsIgnoreCase("carne") || tipo.equalsIgnoreCase("pesce")) {
             vegetariano = false;
             vegano = false;
        } else if (tipo.equalsIgnoreCase("uova") || tipo.equalsIgnoreCase("mozzarella")) {
             vegano = false;
        } else if (tipo.equalsIgnoreCase("pasta")) {
             celiaco = false;
        }
        Ingrediente nuovoIngrediente = new Ingrediente(nome, tipo, calorie, vegetariano, celiaco, vegano, grammi);
        ingredienti.add(nuovoIngrediente);
        System.out.println("Vuoi aggiungere un altro ingrediente?(SI/NO):");
        String risposta = input.nextLine();
        if (risposta.equalsIgnoreCase("SI")) {
            ingredienti.addAll(aggiungiIngrediente());
        }
        return ingredienti;
    }

    public static void visualizzaPiattiPerPrezzo() {
        elencoPiatti.sort(Comparator.naturalOrder());
        for (int i = 0; i < elencoPiatti.size(); i++)
            System.out.println(elencoPiatti.get(i).toString());
    }

    public static void visualizzaIngredienti() {
        for (int i = 0; i < elencoPiatti.size(); i++) {
            System.out.println(elencoPiatti.get(i).getIngredienti().toString());
        }
    }

    public static void visualizzaMenuPranzo() {
        System.out.println("Primi Piatti:");
        for (int i = 0; i < elencoPiatti.size(); i++) {
            if (elencoPiatti.get(i).getNome().equals("Linguine con pomodorini")) {
                System.out.println(elencoPiatti.get(i).getNome());
            }
        }
        System.out.println("Secondi Piatti:");
        for (int i = 0; i < elencoPiatti.size(); i++) {
            if (elencoPiatti.get(i).getNome().equals("Orata al Cartoccio")) {
                System.out.println(elencoPiatti.get(i).getNome());
            }
        }
        System.out.println("Insalate:");
        for (int i = 0; i < elencoPiatti.size(); i++) {
            if (elencoPiatti.get(i).getNome().equals("Insalatona")) {
                System.out.println(elencoPiatti.get(i).getNome());
            }
        }
        System.out.println("Contorni");
        for (int i = 0; i < elencoPiatti.size(); i++) {
            if (elencoPiatti.get(i).getNome().equals("Fagioli all'insalata")) {
                System.out.println(elencoPiatti.get(i).getNome());
            }
        }
    }

    public static void visualizzaMenuCena() {
        System.out.println("Primi Piatti:");
        for (int i = 0; i < elencoPiatti.size(); i++) {
            if (elencoPiatti.get(i).getTipo().equals("primo")) {
                System.out.println(elencoPiatti.get(i).getNome());
            }
        }
        System.out.println("Secondi Piatti:");
        for (int i = 0; i < elencoPiatti.size(); i++) {
            if (elencoPiatti.get(i).getTipo().equals("secondo")) {
                System.out.println(elencoPiatti.get(i).getNome());
            }
        }
        System.out.println("Insalata:");
        for (int i = 0; i < elencoPiatti.size(); i++) {
            if (elencoPiatti.get(i).getTipo().equals("insalata")) {
                System.out.println(elencoPiatti.get(i).getNome());
            }
        }
        System.out.println("Contorni:");
        for (int i = 0; i < elencoPiatti.size(); i++) {
            if (elencoPiatti.get(i).getTipo().equals("contorno")) {
                System.out.println(elencoPiatti.get(i).getNome());
            }
        }
    }
    public static void visualizzaPiattiPerCalorie() {
        Collections.sort(elencoPiatti, new ComparatoreCalorie());
        for (int i = 0; i < elencoPiatti.size(); i++) {
            System.out.println(elencoPiatti.get(i).toString());
        }
    }
    public static void visualizzaPiattiCeliaci() {
        boolean piattoCeliaco = false;
        List<Piatto> piattiCeliaci = new ArrayList<Piatto>();
        for (int i = 0; i < elencoPiatti.size(); i++) {
            for (int j = 0; j < elencoPiatti.get(i).getIngredienti().size() && elencoPiatti.get(i).getIngredienti().get(i).isCeliaco(); j++) {
                if (elencoPiatti.get(i).getIngredienti().get(i).isCeliaco()) {
                    piattoCeliaco = true;
                }
            }
            if (piattoCeliaco == true) {
                piattiCeliaci.add(elencoPiatti.get(i));
            }
        }
        for (int i = 0; i < piattiCeliaci.size(); i++) {
            System.out.println(piattiCeliaci.get(i).toString());
        }
    }
    public static void visualizzaPiattiVegetariani() {
        boolean piattoVegetariano = false;
        List<Piatto> piattiVegetariani = new ArrayList<Piatto>();
        for (int i = 0; i < elencoPiatti.size(); i++) {
            for (int j = 0; j < elencoPiatti.get(i).getIngredienti().size() && elencoPiatti.get(i).getIngredienti().get(i).isVegetariano(); j++) {
                if (elencoPiatti.get(i).getIngredienti().get(i).isVegetariano()) {
                    piattoVegetariano = true;
                }
            }
            if (piattoVegetariano == true) {
                piattiVegetariani.add(elencoPiatti.get(i));
            }
        }
        for (int i = 0; i < piattiVegetariani.size(); i++) {
            System.out.println(piattiVegetariani.get(i).toString());
        }
    }
    public static void visualizzaPiattiVegani() {
        boolean piattoVegano = false;
        List<Piatto> piattiVegani = new ArrayList<Piatto>();
        for (int i = 0; i < elencoPiatti.size(); i++) {
            for (int j = 0; j < elencoPiatti.get(i).getIngredienti().size() && elencoPiatti.get(i).getIngredienti().get(i).isVegano(); j++) {
                if (elencoPiatti.get(i).getIngredienti().get(i).isVegano()) {
                    piattoVegano = true;
                }
            }
            if (piattoVegano == true) {
                piattiVegani.add(elencoPiatti.get(i));
            }
        }
        for (int i = 0; i < piattiVegani.size(); i++) {
            System.out.println(piattiVegani.get(i).toString());
        }
    }
}
