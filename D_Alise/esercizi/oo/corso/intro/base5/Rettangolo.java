package esercizi.oo.corso.intro.base5;
/*
LEGGI Info.txt che mi sa fai prima
Il metodo equals è un metodo della classe Object che viene ereditato da tutte le classi Java. 
Esso è utilizzato per confrontare due oggetti e restituire true se gli oggetti hanno gli stessi valori degli attributi e false in caso contrario.
Nella classe Rettangolo, si è deciso di implementare una versione personalizzata del metodo equals che confronta gli attributi altezza e lunghezza di due oggetti di tipo Rettangolo.
Per fare ciò, si parte dalla prima condizione if (this == obj) che controlla se l'oggetto passato come parametro obj è lo stesso oggetto su cui si sta chiamando il metodo. 
In tal caso, si può assumere che gli oggetti siano uguali e restituire direttamente il valore true.
In caso contrario, si procede a verificare se l'oggetto obj è un'istanza della classe Rettangolo, mediante la seconda condizione if (!(obj instanceof Rettangolo)). 
Se obj non è un'istanza di Rettangolo, il confronto non ha senso e si restituisce false.
Se invece obj è un'istanza di Rettangolo, si può effettuare il casting dell'oggetto a Rettangolo e confrontare gli attributi altezza e lunghezza di this e obj.
Se gli attributi sono uguali, si restituisce true, altrimenti false.

In questo modo, il metodo equals implementato nella classe Rettangolo permette di confrontare due oggetti di tipo Rettangolo in base ai loro attributi, fornendo un criterio personalizzato di uguaglianza per questa classe.
L'override del metodo equals nella classe Rettangolo serve per confrontare le istanze di Rettangolo nella classe BootStrap,
 o in qualsiasi altra classe in cui si voglia confrontare oggetti di tipo Rettangolo.
Senza l'override del metodo equals, il confronto tra due oggetti di tipo Rettangolo verrebbe effettuato per riferimento,
 ovvero verrebbe confrontato il loro indirizzo di memoria anziché il loro stato.
Grazie all'override del metodo equals, invece, è possibile definire una logica di confronto personalizzata che consideri 
due oggetti di tipo Rettangolo uguali se hanno gli stessi valori di altezza e lunghezza. In questo modo, il confronto tra due oggetti 
di tipo Rettangolo verificherà il loro stato anziché il loro indirizzo di memoria.
*/

public class Rettangolo{
    private int altezza;
    private int lunghezza;

    public Rettangolo(int altezza,int lunghezza){
        this.altezza = altezza;
        this.lunghezza = lunghezza;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj){//La condizione if (this == obj) confronta se l'oggetto su cui è stato chiamato il metodo (this) è lo stesso oggetto passato come parametro (obj). In altre parole, questa condizione controlla 
            return true;  //se obj si riferisce alla stessa istanza di Rettangolo su cui è stato chiamato il metodo equals(). Se questo è vero, allora i due oggetti sono uguali (ovvero hanno lo stesso riferimento in memoria) e il metodo restituisce true immediatamente. 
        }
        if (!(obj instanceof Rettangolo)){//Se invece obj non si riferisce alla stessa istanza di Rettangolo, il controllo continua con la seconda condizione if (!(obj instanceof Rettangolo)), che controlla se obj è effettivamente un'istanza di Rettangolo.
            return false; 
        }     
        Rettangolo rettangolo3 = (Rettangolo) obj;
        return this.altezza== rettangolo3.altezza && this.lunghezza == rettangolo3.lunghezza; 
    }    
}

/*Se facessi il casting Rettangolo rettangolo3 = (Rettangolo) obj senza le precedenti condizioni if (this == obj) e if (!(obj instanceof Rettangolo)), 
il codice potrebbe generare un'eccezione ClassCastException se l'oggetto passato come parametro non fosse un'istanza di Rettangolo.
Infatti, il casting di un oggetto a una classe incompatibile con il suo tipo di riferimento può causare un'eccezione. 
In questo caso, se il parametro obj non fosse un'istanza di Rettangolo, il tentativo di effettuare il casting genererebbe un'eccezione.
Per questo motivo, prima di effettuare il casting, è necessario verificare se l'oggetto passato come parametro è effettivamente un'istanza della classe Rettangolo. 
Inoltre, per migliorare le prestazioni del codice, si può prima verificare se l'oggetto passato come parametro è la stessa istanza di this, 
ovvero se si sta cercando di confrontare un oggetto con se stesso. In questo caso, il confronto è sempre vero e non è necessario effettuare alcun altro controllo.
*/
