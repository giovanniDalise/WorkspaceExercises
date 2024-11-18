package esercizio;

class Bicicletta extends Veicolo {
    private int numeroMarce;
    private int velocitaAttuale;

    public Bicicletta(int numeroMarce) {
        this.numeroMarce = numeroMarce;
        this.velocitaAttuale = 0;
    }

    public void accellerare() {
        velocitaAttuale += numeroMarce * 10;
        System.out.println("Bicicletta: accelerazione - Velocità attuale: " + velocitaAttuale);
    }

    public void frenare() {
        velocitaAttuale = 0;
        System.out.println("Bicicletta: frenata - Velocità attuale: " + velocitaAttuale);
    }
}