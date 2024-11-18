package esercizi.ereditarieta.potenziamento.impiegato;

public class Manager extends Impiegato {
	protected int bonus = 500;//variabile di istanza 

	public Manager(){
		super();//costruttore della superclasse Impiegato
	}
	public String toString(){
		return this.nome + this.stipendio + this.bonus; 
	}
	
}
/*Le variabili di istanza sono definite all'interno di una classe, ma all'esterno di qualsiasi metodo.
Sono differenti dalle variabili di classe cha hanno la keyword static.

In sintesi, le variabili di istanza vengono utilizzate per conservare dati specifici per ogni istanza della classe, 
mentre le variabili di classe vengono utilizzate per conservare dati condivisi da tutte le istanze della classe.

Il costruttore di una classe è un metodo speciale che viene chiamato quando si crea una nuova istanza della classe. 
Il suo compito principale è di inizializzare le variabili di istanza dell'oggetto.
Anche se puoi dichiarare le variabili di istanza con un valore di default quando le definisci, come ad esempio int myVar = 0;, 
spesso è necessario assegnare valori diversi a queste variabili per ogni istanza della classe. 
In questo caso, il costruttore viene utilizzato per inizializzare queste variabili di istanza.
Quindi, in generale, il costruttore è spesso necessario quando si lavora con variabili di istanza, 
anche se può essere vuoto se le variabili di istanza sono inizializzate con un valore di default e 
non è necessario eseguire ulteriori operazioni all'interno del costruttore.

Il this non è necessario serve solo a distinguere una variabile di istanza corrente da una preimpostata
In una classe, possono esistere variabili di istanza, variabili di classe e variabili locali,
e spesso è necessario distinguere tra di esse in modo esplicito.
Quando si utilizza this per riferirsi a una variabile di istanza, 
si specifica in modo inequivocabile che si sta facendo riferimento alla variabile dell'istanza corrente della classe.
Questo è particolarmente utile quando si lavora con classi complesse che hanno molte variabili di istanza o quando si utilizzano 
nomi di variabili che possono essere ambigui o difficili da capire senza un contesto chiaro.
*/

