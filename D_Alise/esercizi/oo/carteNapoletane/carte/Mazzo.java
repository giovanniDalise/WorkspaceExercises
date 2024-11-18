package esercizi.oo.carteNapoletane.carte;
import java.util.Random;
import java.util.Arrays;
import carte.tools.Tools;

public class Mazzo
{
	private String valori[]={"2","3","4","5","6","7","Donna","Cavallo","Re","Asso"};
	private String semi[]={"Coppe","Denari","Spade","Bastoni"};

	public Carta[] carte;
	
	public Mazzo(){
		this.carte=new Carta[40];

			for(int k=0;k<4;k++){
				for(int i=0;i<10;i++){
					this.carte[i+10*k]=new Carta(this.valori[i],this.semi[k]);
				}
			}	

		}
	
	public void stampaMazzo(){
		for(int i=0; i<this.carte.length;i++){
			System.out.println(this.carte[i].toString());
		}
	}
	
	public void mischia(){
		Random rnd=new Random();
		int L=this.carte.length;
		Carta temp=null;
		int x;
		for(int i=0;i<L;i++){
			x=rnd.nextInt(L);
			temp=this.carte[i];
			this.carte[i]=this.carte[x];
			this.carte[x]=temp;
		}
	}

	public Carta pesca(){
		Random rnd=new Random();
		int numeroCasuale=rnd.nextInt(this.carte.length);
		Carta cartaPescata=null;
		if(!this.carte[numeroCasuale].pescata){
			cartaPescata=this.carte[numeroCasuale];
			this.carte[numeroCasuale].pescata=true;
		}else{
			cartaPescata=this.pesca();
		} 
		return cartaPescata;
	}
	
	public Carta[] pesca(int N){
		int L=this.carte.length;
		if(N>=L) return this.carte;
		this.mischia();
		Carta[] pescata=new Carta[N];
 		for(int i=0;i<N && i<L;i++){
			if(!this.carte[i].pescata){
				pescata[i]=this.carte[i];
				this.carte[i].pescata=true;
			}
		}
		return pescata;
	}	/*
	public static Carta[] pesca(int N,Carta[] mazzo){
		int L=mazzo.length;
		if(N>=L) return mazzo;
		Carta.mischia(mazzo);
		Carta[] mano=new Carta[N];
 		for(int i=0;i<N && i<L;i++){
			mano[i]=mazzo[i];
		}
		return mano;
	}

	public static Carta pesca(Carta[] mazzo,int cima){
		return mazzo[cima];
	}
	
	public static Carta[] pesca(int N,Carta[] mazzo,int cima){
		int L=mazzo.length;
		Carta[] mano=new Carta[Math.min(N,L-cima)];
		for(int i=0;i<mano.length;i++){
			mano[i]=mazzo[cima+i];
		}
		return mano;
	}*/
	
}

