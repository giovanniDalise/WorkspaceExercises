package esercizi.utility;

import java.util.Scanner;

public class Menu{
	private Scanner sc = new Scanner(System.in);
	private String[] messaggi;
	private int scelta;
	
	public Menu(){
	}
	
	public Menu(String messaggi, int scelta){
		this.messaggi = messaggi.split("!");
		this.scelta = scelta;
	}
	
	public void setMessaggi(String messaggi){
		this.messaggi = messaggi.split("!");
	}
	
	public void setScelta(int scelta){
		this.scelta = scelta;
	}
	
	public int getScelta(){
		return this.scelta;
	}
	
	public void stampaMessaggi(){
		for(int i = 0; i < this.messaggi.length; i++){
			System.out.println(this.messaggi[i]);
		}
	}
	
	public void stampaMessaggiRicevuti(String ricevuti){
		String[] temp = ricevuti.split("!");
		for(int i = 0; i < temp.length; i++){
			System.out.println(temp[i]);
		}
	}
	
	public int sceltaUtenteCM(String messaggi){
		stampaMessaggiRicevuti(messaggi);
		this.scelta = sc.nextInt();
		sc.nextLine();
		return this.scelta;
	}
	
	public int sceltaUtenteSM(){
		stampaMessaggi();
		this.scelta = sc.nextInt();
		sc.nextLine();
		return this.scelta;
	}
}