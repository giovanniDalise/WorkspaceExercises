package esercizi.ereditarieta.corso.objectoriented.ereditarieta;
public class EreditarietaMain{

	private static Animale []animali = new Animale [6];

	public static void main(String[] args){
		Gatto gatto1 = new Gatto();
		Gatto gatto2 = new Gatto();
		GattoPersiano gattoPersiano1 = new GattoPersiano();
		GattoPersiano gattoPersiano2 = new GattoPersiano();
		Mucca mucca1 = new Mucca();
		Mucca mucca2 = new Mucca();
		animali[0]= gatto1;
        animali[1]= gatto2;		
        animali[2]= gattoPersiano1;	
        animali[3]= gattoPersiano2;	
        animali[4]= mucca1;	        
        animali[5]= mucca2;	
        versi();        
	}
	public static void versi(){
		for(int i=0; i<animali.length;i++){
			System.out.println(animali[i].faiVerso());
		}
	}
}