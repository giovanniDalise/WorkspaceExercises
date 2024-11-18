package esercizi.array;
import java.util.Arrays;

public class MergeSort{
	public static void main(String[] input){
		
	int[] array = ToolsVettore.caricaVettore(20);
	ToolsVettore.stampaVettore(array, "Il vettore caricato e' pari a: ");
	sort(array, 0, array.length-1); //gli do "in pasto" i parametri dichiarati all'interno del metodo che stiamo andando a richiamare, in questo caso [sort]
	ToolsVettore.stampaVettore(array, "Il vettore ordinato e' pari a: ");
	
	}
	
	public static void sort(int array[], int indiceSinistro, int indiceDestro){
		if(indiceSinistro < indiceDestro){
			int indiceMedio = indiceSinistro + (indiceDestro-indiceSinistro) / 2;//scritta cosi perchè ad esempio nel primo array avremo indice 0 e 4 ma nella seconda chiamata per l'altro array avremo indice 5 e 9 
			sort(array, indiceSinistro, indiceMedio);//in questo caso la ricorsione crea un ciclo con la condizione dell'if facendo in modo di chiamare il metodo sort tante volte fino a che non avremo array di singoli nuemeri
			sort(array, indiceMedio+1, indiceDestro);
			merge(array, indiceSinistro, indiceMedio, indiceDestro);//per riunire i singoli numeri in nuovi array
		}
	}
	public static void merge(int arrayOriginale[], int indiceSinistro, int indiceMedio, int indiceDestro){
		//creo due array
		int[] arraySinistra = creaArray(arrayOriginale,indiceSinistro,indiceMedio +1);//qui sto ricreando l'array di sinistra e di destra per poi ordinarli
		int[] arrayDestra= creaArray(arrayOriginale,indiceMedio+1,indiceDestro +1);//I due array ricreati saranno comunque disordinati ma il mergesort comunque +
		                                                                           //richiede la scomposizione fino al singolo elemento per considerare gli elemnenti ordinati quindi i sort precedenti erano necessario
		                                                                           //anche se abbiamo riunito gli elementi in maniera disordinata.
		
		int posizioneSinistra = 0;//indice iniziale del sottoarray sui cui stai lavorando[0]
		int posizioneDestra = 0;///indice iniziale del sottoarray sui cui stai lavorando ossia il primo indice dopo la metà dell'array ad esempio[4] in un array da 8
		int posizioneOriginale = indiceSinistro;
		while(posizioneSinistra < arraySinistra.length && posizioneDestra < arrayDestra.length){
			if(arraySinistra[posizioneSinistra] < arrayDestra[posizioneDestra]){  
				arrayOriginale[posizioneOriginale] = arraySinistra[posizioneSinistra];
				posizioneSinistra++;
			}else{
				arrayOriginale[posizioneOriginale] = arrayDestra[posizioneDestra];
				posizioneDestra++;
			}
			posizioneOriginale++;
		}
		/*posizioneOriginale sarebbe il primo indice del nuovo array ordinato che stiamo creando(ossia i due che stiamo unendo, 
		ma sarà sempre richiamato come array o array originale quindi in realtà non ne creaiamo uno nuovo ma ordiniamo 
		il nostro vecchio array ceh abbiamo scomposto). poi in pratica confrontiamo i primi due indici (posizione sinistra e posizione destra) dei due sottoarray e li assegnamo a 
        posizioneOriginale(abiamo detto l'indice dell'array ordinato) e cosi andiamo avanti con l'indice posizioneOriginale++ per riempire tutto l'array
        Pensa all'esempio di due mazzi di carte che confrontati i due valori si aggiungono le carte ad un terzo mazzo in ordine creascente*/ 
        
		posizioneOriginale = caricaRestanti(arrayOriginale, posizioneOriginale, arraySinistra, posizioneSinistra);
		posizioneOriginale = caricaRestanti(arrayOriginale, posizioneOriginale, arrayDestra, posizioneDestra );
		/*Il metodo caricaRestanti serve per copiare gli elementi rimanenti dei sotto-array di sinistra e di destra in caso uno dei due sia già completamente copiato nell'array finale. 
		Questo è necessario perché dopo che uno dei due sotto-array è stato completamente copiato nell'array finale, l'altro sotto-array può ancora contenere elementi non ancora copiati.
		Ad esempio, supponiamo di avere due sotto-array già ordinati: A = [1, 3, 5] e B = [2, 4, 6, 7]. 
		Durante la fase di unione (merge), copiamo i valori più piccoli tra A e B nell'array risultante, partendo dalle rispettive posizioni iniziali. 
		Quando abbiamo copiato tutti gli elementi di A nell'array risultante, abbiamo ancora elementi in B che devono essere copiati. In questo caso, il metodo caricaRestanti viene utilizzato per copiare i restanti elementi di B nell'array risultante.
		In sintesi, il metodo caricaRestanti serve per copiare gli elementi rimanenti di un sotto-array nell'array finale quando l'altro sotto-array è già stato completamente copiato.*/
	}
	private static int[] creaArray(int[] array, int indiceStart, int indiceEnd){
		int[] result= new int[indiceEnd-indiceStart]; //stesso discorso del sort più o meno
		for(int i=0; i< result.length; i++){
			result[i]=array[indiceStart + i];
		}
 		return result;
	}
	private static int caricaRestanti(int[] arrayOriginale, int posizioneOriginale, int[] array, int posizione){
		while(posizione < array.length){
			arrayOriginale[posizioneOriginale] = array[posizione];
			posizione++;
			posizioneOriginale++;
		}
		return posizioneOriginale;
	}
	
}