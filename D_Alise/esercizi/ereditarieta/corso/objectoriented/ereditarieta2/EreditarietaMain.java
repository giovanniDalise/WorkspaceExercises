package esercizi.ereditarieta.corso.objectoriented.ereditarieta2;
import esercizi.utility.Tastiera;

public class EreditarietaMain {
    public static void main(String[] args) {
        Animale[] animali = new Animale[10];

        for (int i = 0; i < animali.length; i++) {
            if (i < 5) {
                animali[i] = new Mucca();
            } else {
                animali[i] = new Gatto();
            }
        }

        int scelta;
        do {
            scelta = Tastiera.chiediInteroPositivo("Cosa vuoi fare? (1 = mangia, 2 = faiVerso, 3 = esci)");

            if (scelta == 1) {
                int indice;
                do {
                    indice = Tastiera.chiediInteroPositivo("Quale animale vuoi far mangiare?Inserisci un numero tra 1-10:\nI primi 5 sono mucche mentre gli altri sono gatti.") - 1;

                    if (indice < 0 || indice >= 10) {
                        System.out.println("Indice non valido!");
                    }
                } while (indice < 0 || indice >= 10);
                int tipoCibo=0;
                while (tipoCibo != 1 && tipoCibo != 2) {
                    tipoCibo=Tastiera.chiediInteroPositivo("Che tipo di cibo vuoi dare all'animale? (1 = carne, 2 = verdura)");
                    if (tipoCibo != 1 && tipoCibo != 2)  {
                        System.out.println("Scelta errata");
                    }else{
		                try {
		                    if (tipoCibo == 1) {
		                        animali[indice].mangia(new Cibo(Cibo.CARNE));
		                    } else if (tipoCibo == 2) {
		                        animali[indice].mangia(new Cibo(Cibo.VERDURA));
		                    }
		                    if (animali[indice].getStato() == Stati.FELICE) {
		                        System.out.println("L'animale è felice!");
		                    } else if (animali[indice].getStato() == Stati.TRISTE) {
		                        System.out.println("L'animale è triste...");
		                    } else if (animali[indice].getStato() == Stati.ARRABBIATO) {
		                        System.out.println("L'animale è arrabbiato!");
		                    }
		                } catch (VomitoException e) {
		                    animali[indice].setStato(Stati.ARRABBIATO);
		                    System.out.println(e.getMessage());
		                }        
                    }
                }    
            } else if (scelta == 2) {
                int indice;
                do {
                    indice = Tastiera.chiediInteroPositivo("Che animale vuoi far fare il verso? (1-10)") - 1;

                    if (indice < 0 || indice >= 10) {
                        System.out.println("Indice non valido!");
                    }
                } while (indice < 0 || indice >= 10);

                System.out.println(animali[indice].faiVerso());
            } else if (scelta == 3) {
                System.out.println("Arrivederci!");
            } else {
                System.out.println("Scelta non valida!");
            }
        } while (scelta != 3);
    }
}
