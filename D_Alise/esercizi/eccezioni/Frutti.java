package esercizi.eccezioni;

import java.util.Scanner;

public class Frutti{
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); 
 
        String frutto = "";
        String tipoMela = "";
        
        int ananas = 0;
        int banana = 0;
        int fuji = 0;
        int renetta = 0;
        int golden = 0;
        int mele = 0;
        

        do{
            try{
                System.out.println("Inserisci il frutto che hai mangiato: ");
                frutto = input.nextLine();
        
                if (frutto.equalsIgnoreCase("mela")){
                    boolean errore=false;
                    do{
                        try{
                            errore=false;
                            mele++;
                            System.out.println("Inserisci il tipo di mela: ");
                            tipoMela = input.nextLine();
                            if (tipoMela.equalsIgnoreCase("fuji")){
                                fuji++;
                            }else if(tipoMela.equalsIgnoreCase("renetta")){
                                renetta++;
                            }else if(tipoMela.equalsIgnoreCase("golden")){
                                golden++;
                            }else{
                                errore = true;
                                throw new AppleTypeNotFound();
                            }   
		        }catch (AppleTypeNotFound tipoNonTrovato){
		            System.out.println("Errore puoi inserire solo il tipo renetta, golden, fuji");   
                        }
   		    }while(errore);
                }else if(frutto.equalsIgnoreCase("ananas")){
                    ananas++;
                }else if(frutto.equalsIgnoreCase("banana")){
                    banana++;
                }else{
                    throw new FruitNotFound();
                }
            }catch (FruitNotFound tipoNonTrovato){
                System.out.println("ATTENZIONE! Hai inserito un tipo di frutto non valido");
            }          
        }while(!frutto.equalsIgnoreCase("exit"));

        System.out.println("MELE:\n"+ mele);
        System.out.println("MELE RENETTE:\n"+ renetta);
        System.out.println("MELE GOLDEN:\n"+ golden);
        System.out.println("MELE FUJI:\n"+ fuji);
        System.out.println("ANANAS:\n" + ananas);
        System.out.println("BANANA:\n" + banana);
    }
}

        
    


    


    
    


 
    