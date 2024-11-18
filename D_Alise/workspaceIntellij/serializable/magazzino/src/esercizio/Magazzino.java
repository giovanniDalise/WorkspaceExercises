package esercizio;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
public class Magazzino {
    public static final String DATI_MAGAZZINO_SER = "datiMagazzino.ser";
    private List<Prodotto> prodotti;

    public Magazzino() {
        this.prodotti = new ArrayList<Prodotto>();
    }
    public void aggiungiProdotto(Prodotto prodotto){
        prodotti.add(prodotto);
    }
    public void ricercaProdotto(String codice){
        for(int i = 0; i<prodotti.size(); i++){
            if(prodotti.get(i).getCodice().equals(codice)){
                System.out.println("Prodotto trovato: " + prodotti.get(i).toString());
            }else{
                System.out.println("Prodotto non trovato");
            }
        }
    }
    public void cancellaProdotto(String codice){
        for(int i = 0; i<prodotti.size(); i++){
            if(prodotti.get(i).getCodice().equals(codice)){
                prodotti.remove(prodotti.get(i));
            }
        }
    }
    public void visualizzaProdotti(){
        for(int i = 0; i<prodotti.size(); i++) {
            System.out.println("Prodotto presenti:" + prodotti.get(i).toString() + " ");
        }
    }
    public void caricaFile() throws DeserializationException {
        try(FileInputStream fileInput = new FileInputStream(DATI_MAGAZZINO_SER)){
            ObjectInputStream inputStream = new ObjectInputStream(fileInput);
            this.prodotti = (List<Prodotto>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new DeserializationException("Attenzione stai cercando di deserializzare un oggetto con classi non previste.");
        }
    }

    public void salvaFile() throws SalvataggioException {
        try(FileOutputStream fileOutput = new FileOutputStream(DATI_MAGAZZINO_SER)){
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
            outputStream.writeObject(this.prodotti);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new SalvataggioException();
        } catch (IOException e) {
            e.printStackTrace();
            throw new SalvataggioException();
        }
    }
}
