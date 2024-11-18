package esercizi.interfacce.film;
import java.util.Comparator;
public class ComparatorG implements Comparator<Film> {
	public ComparatorG(){}
	public int compare(Film a, Film b) {
		String c = a.getGenere();
		String d = b.getGenere();
        return c.compareToIgnoreCase(d);
    }
}