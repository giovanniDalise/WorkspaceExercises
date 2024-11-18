package esercizi.interfacce.animali;

import java.util.Scanner;
public class Programma{
	private static Animale[] animali = new Animale[4];
	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args){
		Posizione inziale = new Posizione(0,0);
		animali[0]= new Tigre(inziale);
		animali[1]= new Falco(inziale);
		animali[2]= new Falco(inziale);
		animali[3]= new Tigre(inziale);
		primoMenu();
	}
	
	public static void primoMenu(){
		int menu;
		do{
			System.out.println("Inserire il numero equivalente alla azione:");
			System.out.println("1. Visualizza animali.");
			System.out.println("2. Seleziona animali.");
			System.out.println("0. Esci.");
			menu = input.nextInt();
			switch (menu){
				case 1:
					stampaAnimali();
					break;
				case 2:
					stampaAnimali();
					secondoMenu();
					break;
				case 0:
					break;
				default:
					System.out.println("Inserire uno dei numeri elencati.");
					break;
			}
		} while (menu != 0);
	}
	
	public static void secondoMenu(){
		int menu;
		int animale;
		System.out.println("Inserire numero animale scelto:");
		animale = input.nextInt();
		System.out.println("Inserire il numero equivalente alla azione:");
		System.out.println("1. Nutri.");
		System.out.println("2. Muovi.");
		System.out.println("3. Fai verso.");
		System.out.println("0. Esci.");
		menu = input.nextInt();
		switch (menu){
			case 1:
				if(animali[animale].isAffamato()){
					animali[animale].mangia();
				} else {
					System.out.println("Animale non affamato");
				}
				break;
			case 2:
				System.out.println("Inserire primo numero nuova posizione:");
				int x = input.nextInt();
				System.out.println("Inserire secondo numero nuova posizione:");
				int y = input.nextInt();
				Posizione posizione = new Posizione(x, y);
				animali[animale].muoviti(posizione);
				break;
			case 3:
				System.out.println(animali[animale].faiIlVerso());
				break;
			case 0:
				break;
			default:
				System.out.println("Inserire uno dei numeri elencati.");
				break;
		}
	}
	
	public static void stampaAnimali(){
		for(int i =  0; i < animali.length ; i++){
			System.out.println(i + ". " + animali[i].toString());
		}
	}
}