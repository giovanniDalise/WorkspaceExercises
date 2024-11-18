package esercizi.interfacce.libreria;
import java.util.Comparator;
public class CompAutore implements Comparator<Libro>{

	public CompAutore(){
	}

	public int compare(Libro primo, Libro secondo){
		String a1 = primo.getAutore();
		String a2 = secondo.getAutore();
		return a1.compareToIgnoreCase(a2);
	}
}