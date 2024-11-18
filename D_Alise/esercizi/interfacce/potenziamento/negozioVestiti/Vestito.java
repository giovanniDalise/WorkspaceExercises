package esercizi.interfacce.potenziamento.negozioVestiti;

public class Vestito {
    private String tipo;
    private String colore;
    private String taglia;

    public Vestito(String tipo, String colore, String taglia) {
        this.tipo = tipo;
        this.colore = colore;
        this.taglia = taglia;
    }

    @Override
    public String toString() {
        return tipo + ", " + colore + ", " + taglia;
    }       
    //tieni presente che qui hai messo Object "o" ma in realta stai semplicemente dando un un nome ad una variabile di input del metodo 
    //diversa come sempre dalla chiamata del metodo in questo caso noi stiamo condrontando un oggetto Vestito, quindi è come se 
    //nella chiamata avessimo scritto Vestito vestito che qua ha cambiato nome in Object o ma sempre dell'oggetto Vestito stiamo parlando
    //e su questo oggetto faremo le dovute valutazioni per l'override del metodo equals   
    @Override    //sovrascivo il metodo equals di string dalla superclasse Object per confrontare due oggetti Vestito
    public boolean equals(Object o) {  //controllo se l'oggetto da comparare è uguale a se stesso come classe ossia ha lo stesso rigermento di memoria
        if (o == this) {
            return true;    //se è cosi torna true
        }

        if (!(o instanceof Vestito)) {  //controllo che l'oggetto sia un istanza diversa da vestito in quel caso ritorna false
            return false;
        }

        Vestito vestito = (Vestito) o; //dopo aver analizzato le casistiche precedenti faccio casting dell'oggetto in analisi in tipo Vestito
    //cosi paragono che tutti gli attributi di Vestito siano uguali all'oggetto nuovo da confrontare e se ce ne sarà anche uno diverso restituirà false
        return this.tipo.equals(vestito.tipo) &&
               this.colore.equals(vestito.colore)&&
               this.taglia.equals(vestito.taglia);
    }
    //ricordati che ci torna il valore booleano proprio per confrontare due oggetti quindi stiamo sovrascrivendo il fuznionamento del metodo equals di toString(override)


}
