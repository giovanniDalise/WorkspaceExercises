/*Scrivi una classe che rappresenta un conto corrente bancario, con una variabile di classe che tiene traccia del tasso di 
interesse applicato ai conti correnti. 
Implementa un metodo per calcolare l'interesse maturato su un conto corrente dato.*/

package esercizi.oo.potenziamento.interestRate;
import esercizi.utility.Tastiera;

public class BootStrap{
	public static void main(String[] args){

    double enteredBalance = Tastiera.chiediDouble("Enter the opening balance:");
	BankAccount bankAccount = new BankAccount(enteredBalance);//passando il valore scritto dall'utente nel costruttore questo sarà assegnato anche alla variabile operningBalance della classe BankAccount

    double enteredInterestRate = Tastiera.chiediDouble("Enter the interest rate:");    
    bankAccount.setInterestRate(enteredInterestRate);

    double maturityDeposit = Tastiera.chiediDouble("Enter the maturity of the deposit:"); //durata del deposito monetario sul conto con cui si calcolerà l'interesse  

    double interest = bankAccount.calcolateInterest(maturityDeposit);
    System.out.println("Accrued Interest: " + interest);//Interesse maturato
    System.out.println("Balance with Interest: " + bankAccount.getBalance());//saldo corrente con l'aggiunta degli interessi
    }	
}