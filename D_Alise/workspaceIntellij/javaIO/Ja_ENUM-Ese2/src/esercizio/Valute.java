package esercizio;
public enum Valute {
    EURO(1.0), DOLLARO(1.22), STERLINA(0.86), FRANCO_SVIZZERO(1.08), YEN(131.43);
    private final double tassoDiCambio;
    Valute(double tassoDiCambio) {
        this.tassoDiCambio = tassoDiCambio;
    }
    public double getTassoDiCambio(){
        return tassoDiCambio;
    }
}
