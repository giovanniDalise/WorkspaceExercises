package esercizi.primiAlgoritmi;
import java.util.Scanner;

public class IrpefScomposto{
    public static void main(String[] args) {

        Scanner tastiera = new Scanner(System.in);
	System.out.println("Inserire reddito lordo");

	double tassazione = calcoloTassazione(tastiera.nextDouble()); 

//Qui stiamo dicendo che la tassazione sarà uguale al valore restituito dal metodo calcoloTassazione a cui stiamo dando un valore da tastiera ossia il reddito lordo come vediamo tra parentesi nel metodo secondorio calcolo tassazione.

	System.out.println(String.format("La tassazione e': %f ",tassazione));
    }
    
    public static double calcoloTassazione(double redditoLordo){
/*
        int primo = 3450;
        int secondo = 3250;
        int terzo = 7700;
        double differenza;
        double tassazione = 0;
        if (redditoLordo < 15000) {
            tassazione = (redditoLordo * 23) / 100;
        } else if (redditoLordo <= 28000) {
            differenza = redditoLordo - 15000;
            tassazione = ((differenza * 25) / 100) + primo;
        } else if (redditoLordo <= 50000) {
            differenza = redditoLordo - 28000;
            tassazione = ((differenza * 35) / 100) + primo + secondo;
        } else if (redditoLordo > 50000) {
            differenza = redditoLordo - 50000;
            tassazione = ((differenza * 43) / 100) + primo + secondo + terzo;
        }
*/
        double tassazione = calcolaScaglione(0,15000,23,redditoLordo);
        tassazione += calcolaScaglione(15001,28000,25,redditoLordo);
	tassazione += calcolaScaglione(28001,50000,35,redditoLordo);
	tassazione += calcolaScaglione(50001,999999999,43,redditoLordo);
        return tassazione;

    }
	
    public static double calcolaScaglione(int min, int max, int aliquota, double redditoLordo){

	double tassazione = 0;
	double imponibile = 0;

	if(redditoLordo > max){
              imponibile = max - min;
        }else{
	    imponibile = redditoLordo - min;
	}
	tassazione = imponibile * aliquota / 100;
	return tassazione;
    }
    
}
        