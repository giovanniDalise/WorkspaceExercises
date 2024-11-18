package esercizi.interfacce.potenziamento.contoCorrente;

public class ContoCorrente implements Cloneable{
	private int saldo;
	private Test test;
    private String numeroConto; //ho dovuto mettere il tipo String perchè oltre le 19 cifre è troppo grande per il long

	public ContoCorrente(int saldo,String numeroConto){
		this.test = new Test();
		this.saldo=saldo;
		this.numeroConto=numeroConto;
	}
	public String toString(){
		return "Saldo:"+ saldo + ", Numero Conto Corrente:" + numeroConto + " test size: " + test.getStato().size();
	}
	public ContoCorrente clone() {//da gestire sempre quando si utilizza il clone oppure da propagare fino al main con il throws
        try { 
            return (ContoCorrente) super.clone();
        } catch (CloneNotSupportedException e) {
            // Questa eccezione dovrebbe essere gestita in modo appropriato
            e.printStackTrace();
            return null;
        }
    }
    public Test getTest(){
    	return this.test;
    }
    /*Esercizio sbagliato perchè in realtà stiamo copiando il riferimento di istanza di contocorrente e non sto copiando il contocorrente
    in una nuova istanza. Per fare ciò dovrò clonare il contocorrente costruendo un nuovo contocorrente riproponendogli 
    anche i parametri del contocorrente
    originale (guarda esercizio sportelli ambulatorio come dimostrazione).
}