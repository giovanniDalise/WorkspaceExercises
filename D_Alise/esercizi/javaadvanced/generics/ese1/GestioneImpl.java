package esercizi.javaadvanced.generics.ese1;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class GestioneImpl<T extends Comparable<T>> implements IGestione<T>{
	
	private List<T> items;
	
	public GestioneImpl(){
		this.items = new ArrayList<T>();
	}
	
	public void inserimento(T item){
		this.items.add(item);
		
	}
	public void cancellazione(T item){
		this.items.remove(item);
		
	}
	public void ordinamento(){
		Collections.sort(items);
		
	}
	public List<T> ricerca(String stringaDaCercare){
		List<T> result = new ArrayList<T>();
		for(int i = 0; i < items.size() ; i++){
			if(items.get(i).toString().contains(stringaDaCercare)){
				result.add(items.get(i));
			}
		}
		return result;
		
	}
	
	public List<T> getItems(){
		return this.items;
	}
}