package esercizi.interfacce.potenziamento.veicolo;

public class Posizione{
	private int x;
	private int y;

	public Posizione(int x,int y){
        this.x=x;
        this.y=y;
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	public void setX(int incremento){
		x=incremento;
	}
	public void setY(int incremento){
		y=incremento;
	}	

}