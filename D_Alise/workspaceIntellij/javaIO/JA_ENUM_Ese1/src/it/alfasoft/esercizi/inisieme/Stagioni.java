package it.alfasoft.esercizi.inisieme;

public enum Stagioni {
    INVERNO(5, 7,"21/12", "19/03"),PRIMAVERA(22,10,"20/3","20/06"),ESTATE(35,16,"21/06","23/09"),AUTUNNO(16,9,"24/09","20/12");

    private final int temperatura;
    private final int durataGiorno;
    private final String inizio;
    private final String fine;

    Stagioni(int temperatura, int durataGiorno, String inizio, String fine) {
        this.temperatura=temperatura;
        this.durataGiorno = durataGiorno;
        this.inizio = inizio;
        this.fine = fine;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public int getDurataGiorno() {
        return durataGiorno;
    }

    public String getInizio() {
        return inizio;
    }

    public String getFine() {
        return fine;
    }
}
