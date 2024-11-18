package esercizi.interfacce.libreria;
public class Esporta implements Esportabile{
	
	public String esporta(Libro libro){
		String result = libro.getTitolo() +"," + libro.getAutore()+","+ libro.getEditore();
		return result;
	}
	
	public Libro importa(String stringa){
		Libro libro = new Libro();
		String[] valori = stringa.split(",");
		libro.setTitolo(valori[0]);
		libro.setAutore(valori[1]);
		libro.setEditore(valori[2]);
		return libro;
	}
}