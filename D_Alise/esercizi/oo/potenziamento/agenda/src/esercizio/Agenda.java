package esercizio;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    List<Contatto> contatti;

    public Agenda() {
        this.contatti = new ArrayList<>();
    }
    public void setContatto(String nome,long numero,String email){
        Contatto nuovoContatto = new Contatto(nome,numero,email);
        this.contatti.add(nuovoContatto);
    }
    public List<Contatto> ricercaContattiPerNome(String nome){
        List<Contatto> contattiTrovati = new ArrayList<Contatto>();
        for(Contatto contatto: contatti){
            if(contatto.getNome().equals(nome)){
                contattiTrovati.add(contatto);
            }
        }
        return contattiTrovati;
    }
    public Contatto ricercaContattiPerNumero(long numero){
        Contatto contattoTrovato = null;
        for(Contatto contatto: contatti){
            if(contatto.getNumero()==numero){
                contattoTrovato = contatto;
            }
        }
        return contattoTrovato;
    }
    public void eliminaContatto(long numero){
        Contatto contattoDaEliminare = ricercaContattiPerNumero(numero);
        contatti.remove(contattoDaEliminare);
        System.out.println("Contatto eliminato.");
    }
    public void visualizzaContatti(){
        for(Contatto contatto:contatti){
            System.out.println(contatto.toString());
        }
    }

}
