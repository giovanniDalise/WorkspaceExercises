package esercizio;

public class Contatto {
    private String nome;
    private long numero;
    private String email;

    public Contatto(String nome, long numero, String email) {
        this.nome = nome;
        this.numero = numero;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public long getNumero() {
        return numero;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contatto{" +
                "nome='" + nome + '\'' +
                ", numero=" + numero +
                ", email='" + email + '\'' +
                '}';
    }
}
