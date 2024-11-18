package esercizi.oo.carteNapoletane;

import java.util.*;

public class Player {
    private String name;
    private Card[] hand;
    
    public Player(String name) {
        this.name = name;
        this.hand = new Card[2];//due carte per mano
    }
    
    public void setCard(Card card, int index) { //questo metodo permette di aggiungere una carta alla mano del giocatore:prende due argomenti: l'oggetto Card da aggiungere alla mano del giocatore e l'indice dell'array hand in cui inserire la carta.
        this.hand[index] = card;//All'interno del metodo, assegniamo alla posizione dell'array hand indicata dall'argomento index la carta card passata come argomento.
    }
    
    public boolean hasPair() {//Questo metodo restituisce true se le due carte nella mano del giocatore hanno lo stesso valore numerico (ovvero, se il giocatore ha una coppia).
        return this.hand[0].getNumber() == this.hand[1].getNumber();
    }
    
    public String getName() {//Questo metodo restituisce il nome del giocatore.
        return this.name;
    }
    //Questo metodo stampa a schermo la mano del giocatore. All'interno del metodo, stampiamo il nome del giocatore seguito da "s hand:".
    public void printHand() {//Poi, utilizziamo un ciclo for-each per iterare su tutte le carte dell'array hand del giocatore e stampare a schermo il valore e il seme di ciascuna carta utilizzando il metodo toString() della classe Card.
        System.out.println(this.name + "'s hand:");
        for (Card card : this.hand) {
            System.out.println(card.toString());
        }
    }
}