import java.util.ArrayList;

public abstract class Player {
    /**
     * The list of cards in a PLayer Object's hand
     */
    protected ArrayList<Card> cardsInHand;

    /**
     * Class constructor
     * Assigns the Player Object a hand, an empty list of cards
     * the PLayer object plays with
     */
    public Player() {
        cardsInHand = new ArrayList<Card>();
    }

    /**
     * Adds the list oof cards being distributed into the Player Object's hand
     *
     * @param dealtCards The cards being distributed
     */
    public void addToHand(ArrayList<Card> dealtCards) {
        for (Card card : dealtCards) {
            card.flipCard();
            cardsInHand.add(card);
        }
    }

    /**
     * Adds the card into the Player Object's hand
     *
     * @param card The card being distributed
     */
    public void addToHand(Card card) {
        cardsInHand.add(card);
    }

    /**
     * Gets how many cards are in the Player Object's hand
     * @return An integer
     */
    public int getHandCount() {
        return cardsInHand.size();
    }

    public boolean canPlayCard(DiscardDeck discardDeck, Card card) {
        if (card.equals(discardDeck.getTopOfDeck())) {
            String pType;
            if (isHuman()) {
                pType = "You played";
            } else {
                pType = "Played";
            }
            System.out.printf("%s a %s card\n", pType, card);
            discardDeck.addToDeck(card);
            return true;
        } else {
            addToHand(card);
            return false;
        }
    }

    public abstract Card makeMove(PlayingDeck playingDeck, DiscardDeck discardDeck);

    /**
     * How the Player Object will display their hand
     * @return The Player Objects hand as a string. If the Player is a Human
     *      Object the cards in their hand will be facing up. If the Player is
     *      a Computer Object the cards in their hand will being facing down
     */
    public abstract String displayHand();

    /**
     * How the Player Object responds to a game over
     */
    public abstract void gameOverAction();

    /**
     * Is the Player Object of the Human subclass
     * @return A boolean representing if the Player Object is a human (true)
     *      or not (false)
     */
    public abstract boolean isHuman();
}