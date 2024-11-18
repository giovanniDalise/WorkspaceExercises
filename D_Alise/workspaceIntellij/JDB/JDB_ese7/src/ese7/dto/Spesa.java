package ese7.dto;

public class Spesa {
    private String data;
    private String tipo;
    private String luogo;
    private double importo;
    private String note;

    public Spesa(String data, String tipo, String luogo, double importo, String note) {
        this.data = data;
        this.tipo = tipo;
        this.luogo = luogo;
        this.importo = importo;
        this.note = note;
    }

    public String getData() {
        return data;
    }

    public String getTipo() {
        return tipo;
    }

    public String getLuogo() {
        return luogo;
    }

    public double getImporto() {
        return importo;
    }

    public String getNote() {
        return note;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public void setImporto(double importo) {
        this.importo = importo;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Spesa{" +
                "data='" + data + '\'' +
                ", tipo='" + tipo + '\'' +
                ", luogo='" + luogo + '\'' +
                ", importo=" + importo +
                ", note='" + note + '\'' +
                '}';
    }
}

