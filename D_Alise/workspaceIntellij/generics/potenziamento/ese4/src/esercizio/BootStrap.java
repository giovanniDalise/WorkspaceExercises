package esercizio;

public class BootStrap {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Mario","Rossi", 35);
        Persona persona2 = new Persona("Anna", "Bianchi",23);

        Confronta confronta = new Confronta();
        Persona maggiore = confronta.max(persona1, persona2);

        System.out.println("Il più grande tra i due è: " + maggiore.getNome() + " " + maggiore.getCognome());
    }
}