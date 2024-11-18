package esercizi.interfacce.libreria;
public interface Storage{
	void write(Libro[] libri);
	Libro[] read();
}