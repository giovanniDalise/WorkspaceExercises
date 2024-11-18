package esercizi.oo.corso.intro.base1;

public class BootStrap {
    public static void main(String[] args) {
        Tavolo tavolo = new Tavolo("Ciao sono un tavolo!"); //viene creata una variabile tavolo che contiene l'instanza della classe Tavolo
        tavolo.stampaMessaggio();//si richiama il metodo stampa messaggio della classe Tavolo
    }
}