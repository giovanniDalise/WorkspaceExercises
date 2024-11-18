package esercizi.interfacce.potenziamento.automobile;
import java.util.Comparator;

public class ComparatorAnnoProduzione implements Comparator<Automobile>{
	public ComparatorAnnoProduzione(){		
	}
	public int compare(Automobile a, Automobile b) {
		int c = a.getAnnoProduzione();
		int d = b.getAnnoProduzione();
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