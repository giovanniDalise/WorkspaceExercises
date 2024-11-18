package esercizi.oo.carteNapoletane;
public class Card {
    private String suit;
    private int number;
    
    public Card(String suit, int number) {
        this.suit = suit;
        this.number = number;
    }
    
    public String getSuit() {
        return this.suit;
    }
    
    public int getNumber() {
        return this.number;
    }
    
    public String toString() {
        return this.number + " of " + this.suit;
    }
}