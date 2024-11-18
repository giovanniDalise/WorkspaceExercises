/* Il metodo random della classe math ci restituisce un double 
che va da 0.0 a a 0.9999 periodico quindi se faccio *10 avrò un 
range che fa fino a 10 ad esempio ho generato 0.23 * 10 avrò 2.3 
che verra troncato successivamente convertendolo in int si trasformera
 in 2(troncata la parte decimale)Ma a questo punto metto * 11 perchè se 
 metto 10 ariverò fino a 9.9999 periodico che troncando mi darà 9 invece 
 con 11 avrò 10). Nel caso di un range da 1 a 10 devo semplicemente sommare
  +1 in modo da saltare i numeri fino a 1(che poi sarebbero stati troncati), 
  per il 10 invece non dovrò più mettere 11 ma basta il 10 dato che partiremo 
  dal numero 1(1+10=11 che ci darà 10.9999 e quindi 10). Il round invece accetta
   float e double e ci restituisce un long. Vediamo che siccome nella traccia è 
   stato richiesto un numero intero subito dopo il random io trasformo N1 e N2 in 
   int e successivamente faccio il casting di somma,differenza.... in int per assicurare
    al programma che il risultato non sia un long tranne nella divisione dove invece lascio 
    il double che poi arrotonderò con metodo round di math.
*/

package esercizi.primiAlgoritmi;

public class random{
    public static void main(String[] input){

        double N1 = Math.random()*11;
        System.out.println("N1: " + N1);
        System.out.println("");

        double N2 = Math.random()*10+1;
        System.out.println("N2: " + N2);
        System.out.println("");

        N1=(int)N1;
        N2=(int)N2;

        int somma = (int) (N1 + N2);
        int differenza = (int) (N1 - N2);
        int modulo =(int) (N1%N2);
        int moltiplicazione =(int) (N1*N2);
        double divisione =(double) N1/N2;
 
        divisione = Math.round(divisione*100.0)/100.0;

        System.out.println("Somma: " + somma);
        System.out.println("");
        System.out.println("Differenza: " + differenza);
        System.out.println("");
        System.out.println("Modulo: "+ modulo);
        System.out.println("");
        System.out.println("Moltiplicazione: " + moltiplicazione);
        System.out.println("");
        System.out.println("Divisione: " + divisione);
        System.out.println("");
    }
}

