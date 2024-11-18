package esercizi.interfacce.libreria;

import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GestoreFile implements Storage{
	
	public void write(Libro[] libri){
		try{
			Esporta esp = new Esporta();
			BufferedWriter writer = new BufferedWriter(new FileWriter("./esercizi/interfacce/libreria/libri.txt"));
			for(int i = 0; i < libri.length; i++){
				writer.write(esp.esporta(libri[i]) + "\n");
			}
			writer.close();
		} catch(FileNotFoundException file_not_found){
			System.out.println("\nFILE_NON_TROVATO" + file_not_found.getMessage());
			file_not_found.printStackTrace();
		} catch(IOException io_exception){
			System.out.println("\nERRORE_NON_GESTITO" + io_exception.getMessage());
			io_exception.printStackTrace();
		}
	}
	
	public Libro[] read(){
		Libro[] libri = new Libro[0];
		try{
			Libro temp = new Libro();
			Esporta esp = new Esporta();
			BufferedReader reader = new BufferedReader(new FileReader("./esercizi/interfacce/libreria/libri.txt"));
			String text;
			while ((text = reader.readLine()) != null){
				temp = esp.importa(text);
				libri = Arrays.copyOf(libri, libri.length + 1);
				libri[libri.length - 1] = temp;
			}
			reader.close();
		} catch(FileNotFoundException file_not_found){
			System.out.println("\nFILE_NON_TROVATO" + file_not_found.getMessage());
			file_not_found.printStackTrace();
		} catch(IOException io_exception){
			System.out.println("\nERRORE_NON_GESTITO" + io_exception.getMessage());
			io_exception.printStackTrace();
		}
		return libri;
	}
}