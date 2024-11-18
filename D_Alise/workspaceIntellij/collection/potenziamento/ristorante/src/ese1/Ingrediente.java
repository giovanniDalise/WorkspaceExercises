package ese1;
public class Ingrediente {
    private String nome;
    private String tipo;
    private int calorie;//intero che rappresenta le calorie per 100g di ingrediente
    private int grammi;
    private boolean vegetariano;
    private boolean celiaco;
    private boolean vegano;

    public Ingrediente(String nome, String tipo, int calorie, boolean vegetariano, boolean celiaco, boolean vegano,int grammi) {
        this.nome = nome;
        this.tipo = tipo;
        this.calorie = calorie;
        this.vegetariano = vegetariano;
        this.celiaco = celiaco;
        this.vegano = vegano;
        this.grammi = grammi;
    }
    public int getGrammi() {

        return grammi;
    }

    public String getNome() {

        return nome;
    }

    public String getTipo() {

        return tipo;
    }

    public int getCalorie() {

        return calorie;
    }

    public boolean isVegetariano() {

        return vegetariano;
    }

    public boolean isCeliaco() {

        return celiaco;
    }
    public boolean isVegano() {
        return vegano;
    }

    @Override
    public String toString() {
        return "Ingrediente{" +
                "nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", calorie=" + calorie +
                ", grammi=" + grammi +
                ", vegetariano=" + vegetariano +
                ", celiaco=" + celiaco +
                ", vegano=" + vegano +
                '}';
    }
}
