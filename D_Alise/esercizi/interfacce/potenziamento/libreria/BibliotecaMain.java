package esercizi.interfacce.libreria;

import java.util.Scanner;
import java.util.Arrays;

public class BibliotecaMain{
	public static Libro[] libri = new Libro[0];
	public static Scanner input = new Scanner(System.in);
	public static void main(String[] args){
		int menu;
		GestoreFile gf = new GestoreFile();
		do{
			System.out.println("Inserire il numero equivalente:");
			System.out.println("1. Inserisci libro.");
			System.out.println("2. Cancella libro.");
			System.out.println("3. Modifica o Aggiungi editore.");
			System.out.println("4. Visualizza libri.");
			System.out.println("5. Ordina libri.");
			System.out.println("6. Salva lista.");
			System.out.println("7. Carica lista.");
			System.out.println("0. Esci.");
			menu = input.nextInt();
			input.nextLine();
			switch (menu){
				case 1:
					inserisciLibro();
					break;
				case 2:
					if(libri.length > 0){
						stampaLibri();
						cancellaLibro();
					} else{
						System.out.println("Nessun libro inserito nella biblioteca.");
					}
					break;
				case 3:
					if(libri.length > 0){
						stampaLibri();
						modifica();
					} else{
						System.out.println("Nessun libro inserito nella biblioteca.");
					}
					break;
				case 4:
					if(libri.length > 0){
						stampaLibri();
					} else{
						System.out.println("Nessun libro inserito nella biblioteca.");
					}
					break;
				case 5:
					if(libri.length > 0){
						ordinaLibri();
					} else{
						System.out.println("Nessun libro inserito nella biblioteca.");
					}
					break;
				case 6:
					if(libri.length > 0){
						gf.write(libri);
					} else{
						System.out.println("Nessun libro da salvare.");
					}
					break;
				case 7:
					libri = gf.read();;
					break;
				case 0:
					break;
				default:
					System.out.println("Inserire uno dei numeri elencati.");
					break;
			}
		} while (menu != 0);
	}
	
	public static void inserisciLibro(){
		System.out.println("Inserire titolo libro");
		String titolo = input.nextLine();
		System.out.println("Inserire autore libro");
		String autore = input.nextLine();
		Libro l = new Libro(titolo, autore);
		if(libri.length < 1){
			libri = Arrays.copyOf(libri, libri.length + 1);
			libri[0] = l;
		} else{
			boolean check = controllaLibro(l);
			if (!check){
				libri = Arrays.copyOf(libri, libri.length + 1);
				libri[libri.length - 1] = l;
			} else{
				System.out.println("Libro gia esistente.");
			}
		}
	}
	
	public static boolean controllaLibro(Libro l){
		boolean result = false;
		for (int i = 0; i < libri.length; i++){
			String temp = libri[i].toString();
			if(temp.equals(l.toString())){
				result = true;
			}
		}
		return result;
	}
	
	public static void cancellaLibro(){
		Libro[] temp = new Libro[(libri.length - 1)];
		System.out.println("Inserire titolo libro:");
		String titolo = input.nextLine();
		System.out.println("Inserire autore libro:");
		String autore = input.nextLine();
		Libro l = new Libro(titolo, autore);
		boolean check = controllaLibro(l);
		boolean trovato = false;
		if(check){
			for(int i = 0; i < libri.length; i++){
				String t = libri[i].toString();
				if(t.equals(l.toString())){
					trovato = true;
				} else if (trovato){
					temp[i - 1] = libri[i];
				} else{
					temp[i] = libri[i];
				}
			}
		} else {
			System.out.println("Libro non esistente.");
		}
	}
	
	public static void modifica(){
		System.out.println("Inserire titolo libro:");
		String titolo = input.nextLine();
		System.out.println("Inserire autore libro:");
		String autore = input.nextLine();
		Libro l = new Libro(titolo, autore);
		boolean check = controllaLibro(l);
		if(check == true){
			System.out.println("Inserire editore del libro:");
			String editore = input.nextLine();
			for(int j = 0; j < libri.length; j++){
				String temp = libri[j].toString();
				if(temp.equals(l.toString())){
					libri[j].setEditore(editore);
				}
			}
		} else {
			System.out.println("Libro non esistente.");
		}
	}
	
	public static void stampaLibri(){
		System.out.println("Lista libri attualmente nella biblioteca:");
		for (int i = 0; i < libri.length; i++){
			System.out.println("Titolo: " + libri[i].getTitolo() + ", Autore: " + libri[i].getAutore() + ", Editore: " + libri[i].getEditore());
		}
	}
	
	public static void ordinaLibri(){
		Scanner input = new Scanner(System.in);
		System.out.println("Inserire il numero equivalente:");
		System.out.println("1. Ordina per titolo.");
		System.out.println("2. Ordina per autore.");
		System.out.println("3. Ordina per editore.");
		int menu = input.nextInt();
		input.nextLine();
		switch (menu){
			case 1:
				CompTitolo ct = new CompTitolo();
				Arrays.sort(libri, ct);
				break;
			case 2:
				CompAutore ca = new CompAutore();
				Arrays.sort(libri, ca);
				break;
			case 3:
				CompEditore ce = new CompEditore();
				Arrays.sort(libri, ce);
				break;
			default:
				System.out.println("Inserire uno dei numeri elencati.");
				break;
		}
	}
}