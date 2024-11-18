package esercizi.astrattismo.animali;

public abstract class Animale{
	protected String nome;
	protected int velocita;
	protected String verso;

    public Animale(String verso) {
        this.verso = verso;
    }
   
    public abstract String faiVerso();

    public  void mangia(){
        System.out.println("Sto mangiando");
    }
    public void dormi(){
        System.out.println("Sto dormendo");    	
    }
	
}