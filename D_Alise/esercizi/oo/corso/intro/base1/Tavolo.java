package esercizi.oo.corso.intro.base1;

public class Tavolo{
    private String messaggio;//proprietà o campo o field

    public Tavolo(String messaggio){ //Questa riga di codice definisce un costruttore per la classe Tavolo. Un costruttore è un metodo speciale che viene chiamato automaticamente quando si crea una nuova istanza della classe. In questo caso, il costruttore prende in input una stringa chiamata messaggio e la assegna al campo dati messaggio.
        this.messaggio = messaggio;// Questa riga di codice assegna il valore della variabile messaggio al campo dati messaggio della classe. Il termine this si riferisce all'oggetto corrente della classe, ovvero l'istanza di Tavolo che sta eseguendo il codice.
    }
    public void stampaMessaggio() {
        System.out.println(messaggio);
        //in pratica con this.messaggio noi ci riferiamo all'istanza tavolo della classe Tavolo diciamo che la variabile messaggio dell'istanza tavolo che appartiene alla classe Tavolo è uguale alla proprietà messaggio della classe Tavolo 
    }
}
	