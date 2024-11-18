package esercizi.interfacce.libreria;
import java.util.Comparator;

public class CompTitolo implements Comparator<Libro>{
	public int compare(Libro primo, Libro secondo){
		String t1 = primo.getTitolo();
		String t2 = secondo.getTitolo();
		return t1.compareToIgnoreCase(t2);
	}
}