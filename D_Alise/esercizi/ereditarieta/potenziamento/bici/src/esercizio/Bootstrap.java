package esercizio;

public class Bootstrap {
    public static void main(String[] args) {
        Veicolo[] veicoli = new Veicolo[3];
        veicoli[0] = new Bicicletta(5);
        veicoli[1] = new Bicicletta(3);
        veicoli[2] = new Bicicletta(4);

        System.out.println("Prima accellerata:");
        for (Veicolo veicolo : veicoli) {
            veicolo.accellerare();
        }
        System.out.println("Seconda accellerata:");
        for (Veicolo veicolo : veicoli) {
            veicolo.accellerare();
        }
        System.out.println("Frenata:");
        for (Veicolo veicolo : veicoli) {
            veicolo.frenare();
        }
        System.out.println("Altra accellerata:");
        for (Veicolo veicolo : veicoli) {
            veicolo.accellerare();
        }
    }
}