package esercizi.oo.corso.intro.base6;
import java.util.Random;

public class BootStrap {
    public static void main(String[] args) {
     
        //Creazione di un array richiamando il metodo popolaArray e dandogli in input 10(numero di istanze rettangolo)
        Rettangolo[] rettangoli = popolaArray(10);

        //Confronto tra due rettagoli dell'array per il metodo equals
        for(int i = 0; i < rettangoli.length; i++) {
            for(int j = i + 1; j < rettangoli.length; j++) {
                if(rettangoli[i].equals(rettangoli[j])) {
                    System.out.println("Il rettangolo " + i + " è uguale al rettangolo " + j);
                } else {
                    System.out.println("Il rettangolo " + i + " è diverso dal rettangolo " + j);
                }
            }
        }

        for(int i=0; i<rettangoli.length; i++){
            double perimetro = rettangoli[i].calcolaPerimetro();
            double area = rettangoli[i].calcolaArea();
            System.out.println("Rettangolo " + i + ": perimetro=" + perimetro + ", area=" + area);
        }     
    }
    public static Rettangolo[] popolaArray(int n) {
    Random rand = new Random();
    Rettangolo[] rettangoli = new Rettangolo[n]; //creazione di un array di tipo Rettangolo formato da 10 istanze rettangoli
    for (int i = 0; i < n; i++) {
        int altezza = rand.nextInt(20) + 1;
        int lunghezza = rand.nextInt(20) + 1;
        rettangoli[i] = new Rettangolo(altezza, lunghezza);//costruttore delle istanze
    }
    return rettangoli;
    }
}