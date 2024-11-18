package esercizi.file;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
public class Ordina
{
	public static void main(String[] input)
	{
		try{
			BufferedReader r1=new BufferedReader(new FileReader("./esercizi/filetest/File1.txt"));
			BufferedReader r2=new BufferedReader(new FileReader("./esercizi/filetest/File2.txt"));
			BufferedWriter w=new BufferedWriter(new FileWriter("./esercizi/filetest/FileOrd.txt"));	
			String riga1=r1.readLine();
			String riga2=r2.readLine();
			while(ordineAlfabetico(riga1, riga2)!=0){
				if(ordineAlfabetico(riga1, riga2)==1){
					w.write(riga1+"\n");
					riga1=r1.readLine();
					
				}else if(ordineAlfabetico(riga1, riga2)==-1){
					w.write(riga2+"\n");
					riga2=r2.readLine();
				}
			}
			r1.close();
			r2.close();
			w.close();
		}catch(FileNotFoundException e)
		{
			System.out.println("Errore FileNotFound");
		}catch(IOException e)
		{
			System.out.println("Errore IO");
		}

	}
	public static int ordineAlfabetico(String s1, String s2)
	{
		if(s1==null && s2==null){
			return 0;
		}else if(s1==null){
			return -1;
		}else if(s2==null){
			return 1;
		}else{
			if(s1.compareTo(s2)<=0){
				return 1;
			}else{
				return -1;
			}
		}
	}
}
