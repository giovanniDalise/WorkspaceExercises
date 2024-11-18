package esercizi.incapsulamento.contoCorrente;
import esercizi.utility.Tastiera;

public class IncapsulamentoMain{
	public static void main(String[] args){

	ContoCorrente contoCorrente = new ContoCorrente(100.0);
 
    contoCorrente.versa(10.0); 
    contoCorrente.preleva(40.0);

    System.out.println("Saldo: " + contoCorrente.getSaldo());
    }	
}