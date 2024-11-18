package esercizi.astrattismo.figureGeometriche;

public abstract class FiguraGeometrica{
	private String nome;
	
	public FiguraGeometrica(){
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public abstract double calcolaArea();
	public abstract double calcolaPerimetro();
}