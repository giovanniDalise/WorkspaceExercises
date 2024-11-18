package esercizi.interfacce.libreria;
import java.util.Comparator;

public class CompEditore implements Comparator<Libro>{
	public int compare(Libro primo, Libro secondo){
		String e1 = primo.getEditore();
		String e2 = secondo.getEditore();
		return e1.compareToIgnoreCase(e2);
	}
}