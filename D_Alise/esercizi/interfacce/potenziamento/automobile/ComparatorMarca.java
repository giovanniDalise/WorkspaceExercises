package esercizi.interfacce.potenziamento.automobile;
import java.util.Comparator;

public class ComparatorMarca implements Comparator<Automobile>{
	public ComparatorMarca(){		
	}
	public int compare(Automobile a,Automobile b){
		String c = a.getMarca();
		String d = b.getMarca();
		return c.compareToIgnoreCase(d);
	}
}