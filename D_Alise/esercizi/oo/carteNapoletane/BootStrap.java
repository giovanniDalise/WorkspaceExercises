package esercizi.oo.carteNapoletane;

public class BootStrap {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        
        player1.setCard(deck.deal(), 0); //con queste righe distribuiamo due carte per i singoli giocati
        player2.setCard(deck.deal(), 0);
        player1.setCard(deck.deal(), 1);
        player2.setCard(deck.deal(), 1);
        
        player1.printHand();
        player2.printHand();
        
        if (player1.hasPair()) {
            System.out.println(player1.getName() + " has a pair!");
        } else {
            System.out.println(player1.getName() + " does not have a pair.");
        }
        
        if (player2.hasPair()) {
            System.out.println(player2.getName() + " has a pair!");
        } else {
            System.out.println(player2.getName() + " does not have a pair.");
        }
    }
}