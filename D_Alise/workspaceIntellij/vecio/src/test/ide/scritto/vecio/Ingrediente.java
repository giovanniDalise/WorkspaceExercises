package test.ide.scritto.vecio;

public class Ingrediente {
    private String nome;
    private int calorie;

    public Ingrediente(String nome, int calorie) {
        this.nome = nome;
        this.calorie = calorie;
    }

    public String getNome() {
        return nome;
    }

    public int getCalorie() {
        return calorie;
    }
}
