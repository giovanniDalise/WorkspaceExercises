package esercizi.interfacce.potenziamento.automobile;
import java.util.Comparator;

public class ComparatorModello implements Comparator<Automobile>{
	public ComparatorModello(){		
	}
	public int compare(Automobile a,Automobile b){
		String c = a.getModello();
		String d = b.getModello();
		return c.compareToIgnoreCase(d);
	}
}