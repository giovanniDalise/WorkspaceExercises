/*creare un'interfaccia che rappresenta tutte azioni di un veicolo, per esempio:
    - vaiAvanti
    - vaiIndietro
    - svoltaASinistra
    - svoltaADestra
    - etc...
    Poi creare un programma che permette di muovere un veicolo all'interno di un piano cartesiano con `x` e `y` che vanno da 0 a 100, fornendo la possibilità di indicare a quale cordinate
    si trova il veicolo.*/
package esercizi.interfacce.potenziamento.veicolo;
import esercizi.utility.Tastiera;

public class Programma{
	public static void main(String [] args){
        Posizione posizione = new Posizione(0,0);
        Veicolo veicolo = new Veicolo(posizione);  
        int incremento;  
        int numero = 0;
        do{
            System.out.println("Inserisci un numero per indicare l'azione del veicolo:");
            System.out.println("1. Vai Avanti");
            System.out.println("2. Vai Indietro");
            System.out.println("3. Svolta a Sinistra");
            System.out.println("4. Svolta a Destra");
            System.out.println("0. Esci");  
            numero = Tastiera.chiediIntero("");
            switch (numero) {
                case 1: 
                    incremento = Tastiera.chiediInteroPositivo("Inserisce il numero corrispondente all'incremento:");                                       
                    veicolo.vaiAvanti(incremento);                
                    System.out.println("Posizione:"+ veicolo.toString());   
                    break;
                case 2:
                    incremento = Tastiera.chiediInteroPositivo("Inserisce il numero corrispondente all'incremento:");                        
                    veicolo.vaiIndietro(incremento);
                    System.out.println("Posizione:"+ veicolo.toString());                                    
                    break;
                case 3:
                    incremento = Tastiera.chiediInteroPositivo("Inserisce il numero corrispondente all'incremento:");                        
                    veicolo.svoltaADestra(incremento);
                    System.out.println("Posizione:"+ veicolo.toString());                   
                    break;
                case 4:
                    incremento = Tastiera.chiediInteroPositivo("Inserisce il numero corrispondente all'incremento:");
                    veicolo.svoltaASinistra(incremento);                                        
                    System.out.println("Posizione:"+ veicolo.toString());   
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Inserire uno dei numeri elencati:");
                    break;
            }
        } while (numero != 0);
    }              
}