package esercizi.javaadvanced.generics.ese1;
import java.util.List;
public interface IGestione <T extends Comparable<T>>{
	void inserimento(T item);
	void cancellazione(T item);
	void ordinamento();
	List<T> ricerca(String testo);
}