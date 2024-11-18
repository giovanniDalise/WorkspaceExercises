package esercizi.javaadvanced.ripasso.ese2;
import esercizi.javaadvanced.ripasso.ese1.Persona;
import java.time.LocalDate;

public class Insegnante extends Persona{
    private String materia;
    private String sezione;

    public Insegnante(String nome,String cognome,LocalDate dataDiNascita,String materia,String sezione){
        super(nome,cognome,dataDiNascita);

        this.materia=materia;
        this.sezione=sezione;
    }
    public String getMateria(){
        return this.materia;
    }
    public String getSezione(){
        return this.sezione;
    }
}    
