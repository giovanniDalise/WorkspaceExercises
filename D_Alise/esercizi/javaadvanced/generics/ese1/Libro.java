package esercizi.javaadvanced.generics.ese1;
public class Libro implements Comparable<Libro>{
		private String titolo;
		private String autore;
		private String editore;
		
		public Libro(String titolo, String autore, String editore){
			this.titolo = titolo;
			this.autore = autore;
			this.editore = editore;
		}
		
		public String getTitolo(){
			return this.titolo;
		}
		
		public String getAutore(){
			return this.autore;
		}
		
		public String getEditore(){
			return this.editore;
		}
		
		public int compareTo(Libro libro){
			int result = this.titolo.compareTo(libro.getTitolo());
			if(result == 0){
				result = this.autore.compareTo(libro.getAutore());
				if(result == 0){
					result = this.editore.compareTo(libro.getEditore());
				}
			}
			return result;
		}
		
		public String toString(){
			return titolo + "|||||" + autore + "!!!!!" + editore;
		}
}