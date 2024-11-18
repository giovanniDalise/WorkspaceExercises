package esercizi.file;

//eccezioni
import java.io.IOException;
import java.io.FileNotFoundException;

//gestione_dei_file
import java.io.FileReader;
import java.io.BufferedReader;

//utilities
import java.util.Random;
import java.util.Scanner;

public class ProverbiIacopo{
	public static void main(String[] input){
		
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		
		String userDec; //scelta
	
		do{
			
			try{
				BufferedReader br = new BufferedReader(new FileReader("./esercizi/proverbi.txt"));
				int rndNum = random.nextInt(2200);
				System.out.println("Il numero generato e' pari a: " + rndNum);
				String rigaRandom;
				
				for(int cont = 1; cont <= rndNum; cont++){
					br.readLine();
				}
				rigaRandom = br.readLine();
				System.out.println(rigaRandom);
				br.close();
			}
			catch(FileNotFoundException file_not_found){
				System.out.println("\nFILE_NON_TROVATO " + file_not_found.getMessage());
				file_not_found.printStackTrace();
			}
			catch(IOException io_exception){
				System.out.println("\nERRORE_NON_GESTITO " + io_exception.getMessage());
				io_exception.printStackTrace();
			}
			
			System.out.println("Proverbio generato, digita [ok] per generare casualmente un altro proverbio.");
			userDec = sc.nextLine();
			
		}while(userDec.equalsIgnoreCase("ok"));
		
	}
}