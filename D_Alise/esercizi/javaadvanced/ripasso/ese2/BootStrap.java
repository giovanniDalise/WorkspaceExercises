/*2 (ese2) Utilizzare l'ereditarietà e le liste (ArrayList e List)
Creare un programma con le seguenti classi:
    - BootStrap: che rappresenta il punto di partenza del programma con il metodo main
    - Persona: (importare la classe dal package esercizi.javaadvanced.ripasso.ese1)
    - Studente: Classe che rappresenta uno studente ed estende Persona. Avrà i seguenti attributi aggiuntivi:
        - matricola(identificativo)
        - sezione: la sezione della classe (esempio: A, B, C)
        - classe: la classe dello studente (esempio: 1, 2, 3)
        - voti: una lista di Integer che rappresenta i voti dello studente
        ed i seguenti metodi aggiuntivi:
        - get*
        - getMediaVoti: che calcolerà e restituirà la media dei voti dello studente
        - getVotoMigliore: che restituirà il voto più alto ottenuto
        - getVotoPeggiore: che restituirà il voto più basso
        - aggiungiVoto: metodo che aggiunge un voto alla lista dei voti
    - Insegnante: Classe che rappresenta un insegnante ed estende Persona ed avrà i seguenti attributi aggiuntivi:
        - materia: una stringa che rappresenta la materia insegnata
        - sezione: una stringa che rappresenta la sezione delle classi su cui sta insegnando (esempio: C ovvero insegna nella 1C, 2C, 3C etc...)
    - Scuola: Classe che rappresenta la scuola. Avrà i seguenti attributi:
        - studenti: Una lista di Studenti
        - insegnanti: Una lista di Insegnanti
        ed i seguenti metodi
        - get*
        - getMediaVotiSezione: avrà in input la sezione e restituirà la media dei voti degli studenti di quella sezione
        - getMediaVotiClasse: avrà in input sezione e classe e restituirà la media dei voti degli studenti di quella classe 
    
Il programma dovrà eseguire i seguenti passi:
    - creare un oggetto Insegnante ed associarlo alla sezione A
    - creare un oggetto Insegnante ed associarlo alla sezione B
    - creare un oggetto Insegnante ed associarlo alla sezione C
    - creare 5 studenti da assegnare alla sezione A
    - creare 5 studenti da assegnare alla sezione B
    - creare 5 studenti da assegnare alla sezione C 
    - inserire 10 voti casuali ad ogni studente
    - per ogni professore stampare
        - qual'è la media dei voti dei propri studenti (voti della sezione)
        - qual'è il voto più alto raggiunto dagli studenti delle sue classi ()
        - qual'è il voto più basso degli studenti delle sue classi
    - stampare la lista degli studenti in ordine di Cognome, Nome
    */

package esercizi.javaadvanced.ripasso.ese2;
import esercizi.javaadvanced.ripasso.ese1.Persona;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Comparator;


public class BootStrap{
    public static void main(String[] args){
        Random rnd = new Random();
        
        Insegnante insegnante1 = new Insegnante("Luca","Rossi",null,"Matematica","A");
        Insegnante insegnante2 = new Insegnante("Giovanni","Verdi",null,"Geografia","B"); 
        Insegnante insegnante3 = new Insegnante("Anna","Bianchi",null,"Italiano","C");    
        Scuola scuola = new Scuola();
        scuola.getInsegnanti().add(insegnante1);
        scuola.getInsegnanti().add(insegnante2);
        scuola.getInsegnanti().add(insegnante3);  

        String []nomi = {"Giacomo","Giovanni","Aldo","Luca","Marco","Davide","Kostantin","Alessio","Daniel","Eleonora","Iacopo","Alessandro","Alessandro","Alessio","Giuseppe"};
        String []cognomi = {"Rossi","Gialli","Verdi","Blu","Colorato","Grigio","Asfalti","Dirupi","Gri","Lione","Liane","Di Fretta","Rispetta","Ginetta","Finito"};
        int matricola=0;
        String[]sezioni={"A","A","A","A","A","B","B","B","B","B","C","C","C","C","C"};
        int[] classi={1,2,3,1,2,3,1,2,3,1,2,3,1,2,3};
        for(int i=0;i<15;i++){
            scuola.getStudenti().add(new Studente(nomi[i],cognomi[i],null,i,sezioni[i],classi[i]));
        }
        for(int i=0;i<scuola.getStudenti().size();i++){
            for(int j=0;j<10; j++){
                 scuola.getStudenti().get(i).aggiungiVoto(rnd.nextInt(11));
            }
        }
        int votoPeggiore=100;
        int votoMigliore=0;
        for(int i = 0;i<scuola.getInsegnanti().size();i++){
            System.out.println("La media degli alunni del professore "+ scuola.getInsegnanti().get(i).getNome()+ " è " + scuola.getMediaVotiSezione(scuola.getInsegnanti().get(i).getSezione()));
            for(int j =0;j<scuola.getStudenti().size();j++){
                if(scuola.getInsegnanti().get(i).getSezione().equals(scuola.getStudenti().get(j).getSezione())){
                    if(votoMigliore<scuola.getStudenti().get(j).getVotoMigliore()){
                        votoMigliore =scuola.getStudenti().get(j).getVotoMigliore();
                    }
                    if(votoPeggiore>scuola.getStudenti().get(j).getVotoPeggiore()){
                        votoPeggiore =scuola.getStudenti().get(j).getVotoPeggiore();
                    }
                }
            }
            System.out.println("Il voto più alto delle classi del professore " + scuola.getInsegnanti().get(i).getNome()+ " è "+ votoMigliore);
            System.out.println("Il voto più basso delle classi del professore " + scuola.getInsegnanti().get(i).getNome()+ " è "+ votoPeggiore);       
        }
        System.out.println("Lista degli Studenti in ordine alfabetico: ");
        scuola.getStudenti().sort(Comparator.naturalOrder());
        System.out.println(scuola.getStudenti().toString());
    }
}
