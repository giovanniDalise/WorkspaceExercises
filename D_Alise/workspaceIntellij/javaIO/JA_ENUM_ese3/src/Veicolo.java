public enum Veicolo {
    AUTO(60),
    MOTO(90),
    BICICLETTA(120);

    private final int velocitaMedia;

    Veicolo(int velocitaMedia) {
        this.velocitaMedia = velocitaMedia;
    }

    public int getVelocitaMedia() {
        return velocitaMedia;
    }
}
