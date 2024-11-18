package esercizi.interfacce.film;
import java.util.Comparator;
public class ComparatorA implements Comparator<Film> {
	public ComparatorA(){}
	public int compare(Film a, Film b) {
		int c = a.getAnnoUscita();
		int d = b.getAnnoUscita();
		int result;
        if (c < d) {
			result = -1;
		} else if (c == d) {
			result = 0;
		} else{
			result = 1;
		}
		return result;
    }
}