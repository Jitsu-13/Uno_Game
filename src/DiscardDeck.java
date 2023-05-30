import java.util.ArrayList;

public class DiscardDeck {
    /**
     * The deck cards are discarded into
     */
    private ArrayList<Card> discardDeck;

    /**
     * The Class Constructor.
     * Starts the discard pile
     */
    public DiscardDeck(PlayingDeck playingDeck) {
        discardDeck = new ArrayList<Card>();
        createDiscardPile(playingDeck);
    }

    private void createDiscardPile(PlayingDeck playingDeck) {
        discardDeck.add(playingDeck.drawCard());
        discardDeck.get(discardDeck.size() - 1).flipCard();

        if (getTopOfDeck().getValue() > 9) {
            createDiscardPile(playingDeck);
        }
    }


    public Card getTopOfDeck() {
        return discardDeck.get(discardDeck.size() - 1);
    }

    /**
     * Adds a card to the discard deck
     *
     * @param card The card being added to the discard deck
     */
    public void addToDeck(Card card) {
        discardDeck.add(card);
    }

    /**
     * Removes the card at the top of the discardd deck
     */
    public void removeTopCard() {
        discardDeck.remove(discardDeck.size() - 1);
    }

    /**
     * Gets the current size of the discard Deck
     *
     * @return An integer
     */
    public int deckSize() {
        return discardDeck.size();
    }
}