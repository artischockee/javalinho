import java.util.Vector;

public class Player implements CardPlayer {
    private static int _playerIndex;
    private Vector<Card> _cardDeck;
    private String _playerName;
    private boolean _isDealer;

    static {
        _playerIndex = 0;
    }

    Player() {
        _cardDeck = new Vector<>();
        _playerName = "Player " + ++_playerIndex;
        _isDealer = false;
    }

    public int getPlayerIndex() {
        return _playerIndex;
    }

    @Override
    public boolean isDealer() {
        return _isDealer;
    }

    @Override
    public void setDealer(boolean state) {
        _isDealer = state;
    }

    @Override
    public String getPlayerName() {
        return _playerName;
    }

    @Override
    public int getPointsAmount() {
        int pointsAmount = 0;
        for (Card card : _cardDeck)
            pointsAmount += card.getCardWeight();

        return pointsAmount;
    }

    @Override
    public void getCard(Card card) {
        _cardDeck.add(card);
    }
}
