package test.ide.scritto.vecio;

import java.util.List;

public class Vecio {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Piatto p1 = new Piatto(3,"Spaghetti aglio olio e peperoncino");
        Piatto p2 = new Piatto(5,"fettina di pollo ai ferri");
        Piatto p3 = new Piatto(1.5,"patate arrosto");
        menu.aggiungiPiatto(p1);
        menu.aggiungiPiatto(p2);
        menu.aggiungiPiatto(p3);
        stampa(menu.getMenu());

    }

    private static void stampa(List<Piatto> piatti) {
        System.out.println("Menu della settimana");
        for (int i = 0; i < piatti.size(); i++) {
            System.out.println("Piatto:" + piatti.get(i) );
        }
    }
}
