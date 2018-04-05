public interface CardPlayer {
    // get/set for dealer statement:
    boolean isDealer();
    void setDealer(boolean state);

    void getCard(Card card);
    String getPlayerName();

    int getPointsAmount();
}