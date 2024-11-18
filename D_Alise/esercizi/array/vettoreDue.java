package array;
public class esercizi.vettoreDue{
	public static void main(String[] input){
		
		int[] vettore = ToolsVettore.caricaVettore(100);
	
		ToolsVettore.stampaVettore(vettore,"Array prima dello scambio");
		
        for (int i = 0; i < vettore.length ; i += 2) {
            int salvaNumero = vettore[i];
            vettore[i] = vettore[i + 1];
            vettore[i + 1] = salvaNumero;
        }
         System.out.println("----------------------------");
		 
		ToolsVettore.stampaVettore(vettore,"Array dopo lo scambio");
	}
}