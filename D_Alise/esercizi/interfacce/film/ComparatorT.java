package esercizi.interfacce.film;
import java.util.Comparator;
public class ComparatorT implements Comparator<Film> {
	public int compare(Film a, Film b) {
		String c = a.getTitolo();
		String d = b.getTitolo();
        return c.compareToIgnoreCase(d);
    }
}