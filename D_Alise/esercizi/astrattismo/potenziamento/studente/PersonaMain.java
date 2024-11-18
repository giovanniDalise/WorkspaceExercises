/*Crea un programma che rappresenta la classe "Persona" con attributi come "nome" e "cognome" e una classe figlia "Studente" 
con attributi specifici come "matricola" e "corso di studi". Nel main, crea un'istanza di Studente e stampa il suo nome completo.*/
package esercizi.astrattismo.potenziamento.studente;

public class PersonaMain{
	public static void main(String[] args){
		Studente studente = new Studente();		
		studente.setNome("Luca");
		studente.setCognome("Rossi");
		studente.setMatricola(14);
		studente.setCorsoStudi("Filosofia");				
		System.out.println(studente.getNome()+" "+studente.getCognome()+" "+ studente.getMatricola()+" "+studente.getCorsoStudi());
	}
}