package esercizi.oo.carteNapoletane;
import java.util.Random;

public class Deck {
    private String type;
    private Card[] deckCards;
    private int currentIndex;//indice corrente per tenere traccia della carta pescata
    
    public Deck() {
        this.type = "Neapolitan";
        this.deckCards = new Card[40];
        this.currentIndex = 0;
        
        String[] suits = {"Cups", "Coins", "Swords", "Clubs"};
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        int i = 0;
        for (String suit : suits) {
            for (int number : numbers) {
                this.deckCards[i] = new Card(suit, number);
                i++;
            }
        }
    }
    public void shuffle() {
    Random rand = new Random();
    for (int i = 0; i < this.deckCards.length; i++) { //Per ogni carta nell'array this.deckCards, scambiamo la carta corrente con quella nell'indice casuale j. In questo modo, stiamo permutando casualmente le carte dell'array.
        int j = rand.nextInt(this.deckCards.length); //Infine, impostiamo l'indice corrente a 0, poiché stiamo ricominciando a pescare dal mazzo dall'inizio dopo aver mescolato le carte.
        Card temp = this.deckCards[i];
        this.deckCards[i] = this.deckCards[j];
        this.deckCards[j] = temp;
        }
    this.currentIndex = 0;
    }    
    public Card deal() {//pesca carta
        if (this.currentIndex == 40) {
            return null;
        }
        
        Card card = this.deckCards[this.currentIndex]; //restituisce la carta corrente
        this.currentIndex++;//incrementa l'indice per tenere traccia della carta pescata
        return card;
    }
}