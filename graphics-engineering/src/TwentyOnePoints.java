import java.util.Vector;

public class TwentyOnePoints {
    public static final int DECK_SIZE = 36;
    private Vector<Card> _cardDeck;

    TwentyOnePoints() throws Exception {
        _cardDeck = CardDeckCreator.createDeck(DECK_SIZE);
    }

    public void displayDeck() {
        for (Card card : _cardDeck)
            card.show();
    }
}
