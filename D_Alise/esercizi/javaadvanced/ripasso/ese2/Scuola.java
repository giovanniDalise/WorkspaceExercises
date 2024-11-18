package esercizi.javaadvanced.ripasso.ese2;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class Scuola{
    private List<Studente> studenti;
    private List<Insegnante> insegnanti;   

    public Scuola(){
        this.studenti=new ArrayList<Studente>();
        this.insegnanti=new ArrayList<Insegnante>();
    }
    public List<Studente> getStudenti(){
        return this.studenti;
    }
    public List<Insegnante> getInsegnanti(){
        return this.insegnanti;
    }
    public double getMediaVotiSezione(String sezione){
        double somma=0;
        int cntStudentiSezione=0;
        for(int i =0;i<studenti.size();i++){
            if(studenti.get(i).getSezione().equals(sezione)){
                somma+=studenti.get(i).getMediaVoti();
                cntStudentiSezione++;
            }
        }
        return somma/cntStudentiSezione;
    }
    public double getMediaVotiClasse(String sezione,int classe){
        double somma=0;
        int cntStudentiClasse=0;
        for(int i =0;i<studenti.size();i++){
            if(studenti.get(i).getSezione().equals(sezione)&&studenti.get(i).getClasse()==classe){
                somma+=studenti.get(i).getMediaVoti();
                cntStudentiClasse++;
            }
        }        
        return somma/cntStudentiClasse;  
    }
    
}

