package esercizi.astrattismo.animali;

public class Fattoria {
	public static void main(String[] args){
        Animale []animali = new Animale [3];		
		GattoPersiano gattoPersiano = new GattoPersiano();
		Cane cane = new Cane();
		Uccello uccello = new Uccello();
		animali[0]= gattoPersiano;	
        animali[1]= cane;	
        animali[2]= uccello;	
        versi(animali);
	}
    public static void versi(Animale[]animali){
		for(int i=0; i<animali.length;i++){
			System.out.println(animali[i].faiVerso());
		}
    }
}