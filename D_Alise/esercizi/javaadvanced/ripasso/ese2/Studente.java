package esercizi.javaadvanced.ripasso.ese2;
import esercizi.javaadvanced.ripasso.ese1.Persona;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

    public class Studente extends Persona implements Comparable<Studente>{
        private int matricola;
        private String sezione;
        private int classe;
        private List<Integer> voti;

        public Studente(String nome,String cognome,LocalDate dataDiNascita,int matricola,String sezione,int classe){
            super(nome,cognome,dataDiNascita);

            this.matricola=matricola;
            this.sezione=sezione;
            this.classe=classe;
            this.voti= new ArrayList<Integer>();


        }
        public int getMatricola(){
            return this.matricola;
        }
        public String getSezione(){
            return this.sezione;
        }
        public int getClasse(){
            return this.classe;
        }
        public List<Integer> getVoti(){
            return this.voti;
        }
        public double getMediaVoti(){
            int numeroVoti = this.voti.size();
            double somma=0.0;
            for(int i =0; i<this.voti.size();i++){
                somma+=this.voti.get(i);
            }
           return somma/numeroVoti; 

        }
        public int getVotoMigliore(){
            int votoMigliore=0;
            for(int i =0; i<this.voti.size();i++){
                if(this.voti.get(i)>votoMigliore){
                    votoMigliore=this.voti.get(i);
                }
            }   
            return votoMigliore; 

        }
        public int getVotoPeggiore(){
            int votoPeggiore=100;
            for(int i =0; i<this.voti.size();i++){
                if(this.voti.get(i)<votoPeggiore){
                    votoPeggiore=this.voti.get(i);
                }
            }   
            return votoPeggiore;             

        }
        public void aggiungiVoto(int voto){
            this.voti.add(voto);

        }
        public int compareTo(Studente studente){
            int result=this.cognome.compareTo(studente.cognome);
            if(result==0){
                result=this.nome.compareTo(studente.nome);
                if(result==0){
                    result=this.matricola-studente.matricola;//non devo avere per forza -1,0 e +1 perciò facciamo la sottrazione se avrò un numero negativo allora il primo sarà piu piccolo 0 saranno uguali 1 il secondo sarà più grande.
                }
            }
            return result;
        }
        public String toString(){
            return this.nome + " " +  this.cognome + " " + this.matricola; 
        }

    }
