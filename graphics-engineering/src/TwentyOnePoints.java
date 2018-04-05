import java.util.Collections;
import java.util.Stack;
import java.util.Vector;

public class TwentyOnePoints {
    public static final int DECK_SIZE = 36;
    private Stack<Card> _cardDeck;
    private Vector<CardPlayer> _cardPlayers;

    TwentyOnePoints() throws Exception {
        _cardDeck = CardDeckCreator.createDeck(DECK_SIZE);
        _cardPlayers = new Vector<>();
    }

    public void displayDeck() {
        for (Card card : _cardDeck)
            card.show();
    }

    private void shuffleDeck() {
        System.out.print("Shuffling the deck.. ");
        Collections.shuffle(_cardDeck);
        System.out.println("Success.");
    }

    // ..

    public void playGame() {
        System.out.println("Hello and welcome to 'Twenty One Points' game!");
        System.out.println("The deck will right now be shuffled.");
        shuffleDeck();
        System.out.println("You will be playing against computer. He (it) will be a dealer (for now).");

        _cardPlayers.add(new Computer());
        _cardPlayers.add(new Player());
        _cardPlayers.elementAt(0).setDealer(true);


//        if (computer.getClass() == Computer.class)
    }
}
