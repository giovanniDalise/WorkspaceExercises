package esercizi.oo.potenziamento.interestRate;

public class BankAccount{
	private static double interestRate; // variabile di classe come è definito nella traccia in questo modo cambiando il tasso lo cambieremo per tutte le istanze di bankAccount(conto corrente)
	private double openingBalance;//saldo iniziale

    public BankAccount(double openingBalance){//interestRate non viene specificata nel metodo costruttore perchè è un valore predefinito e uguale per tutti i contocorrenti che possiamo sempre cambiare ma non c'è bisogno di specificarlo nella creazione dell'istanza
    	this.openingBalance=openingBalance;
    }
    public double getBalance(){
    	return openingBalance;
    }
    public void setInterestRate(double enteredInterestRate){
    	interestRate = enteredInterestRate;
    }
    public double calcolateInterest(double maturityDeposit){
    	double interest = (openingBalance*interestRate*maturityDeposit)/365;
    	openingBalance += interest;
    	return interest;
    }

	
}