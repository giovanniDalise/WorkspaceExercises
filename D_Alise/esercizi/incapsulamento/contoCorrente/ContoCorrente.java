package esercizi.incapsulamento.contoCorrente;

public class ContoCorrente{
	private double saldo;

    public ContoCorrente(double saldoIniziale){
    	this.saldo=saldoIniziale;
    }
    public double getSaldo(){
    	return this.saldo;
    }

    public void versa(double sommaVersata) {
        this.saldo += sommaVersata;
    }

    public void preleva(double sommaPrelevata) {
        this.saldo -= sommaPrelevata;

    }
}