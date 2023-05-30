import java.util.Scanner;
import java.lang.Thread;

public class Human extends Player {

    private static Scanner kb;


    public Human() {
        super();
        kb = new Scanner(System.in);
    }

    private void movingTime() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private Card discardFromHand(String card) {
        Card played = null;

        // Find the card the user wants to play
        for (int i = 0; i < cardsInHand.size(); i++) {
            if (cardsInHand.get(i).displayCard().equals(card)) {
                played = cardsInHand.remove(i);
                break;
            }
        }
        return played;
    }

    private String drawFromPlayingDeck(PlayingDeck playingDeck, String move) {
        System.out.println("Drawing card from deck...");
        movingTime();
        Card drawn = playingDeck.drawCard();
        drawn.flipCard();
        addToHand(drawn);
        move = drawn.displayCard();
        System.out.print("You drew a " + drawn + " card, ");
        return move;
    }

    private static void printHelpText() {
        System.out.println("""
                ------------------------------------------------------------------------
                To play a card, type the card you would like to play.
                For example, if you have the card 'b+2', when it is your turn to play,
                type 'b+2' to play the card.

                If you do not have a playable card, type 'draw' to draw from the deck.

                When it is your turn, type 'help' to see this message text again.
                -------------------------------------------------------------------------
                """);
    }


    private Card pickCard(PlayingDeck playingDeck, String move) {
        if (move.equals("help")) {
            printHelpText();
            System.out.println("The cards in your hand are: " + displayHand());
            System.out.print("Make a move: ");
            move = kb.nextLine();
            pickCard(playingDeck, move);
        } else if (move.equals("draw")) {
            move = drawFromPlayingDeck(playingDeck, move);
        }

        Card card = discardFromHand(move);
        return card;
    }


//    private void changeSpecialCardColor(DiscardDeck discardDeck) {
//        System.out.println("What color would you like change it too");
//        System.out.println("(r)ed, (b)lue, (g)reen, (y)ellow");
//        String color = kb.nextLine();
//        Card lastPlayedCard = discardDeck.getTopOfDeck();
//        movingTime();
//        System.out.print("Changing the color to ");
//        switch (color.charAt(0)) {
//            case 'r':
//                System.out.println("\033[31;1mred\033[0m");
//                break;
//            case 'b':
//                System.out.println("\033[34;1mblue\033[0m");
//                break;
//            case 'g':
//                System.out.println("\033[32;1mgreen\033[0m");
//                break;
//            case 'y':
//                System.out.println("\033[33;1myellow\033[0m");
//                break;
//        }
//        lastPlayedCard.changeColor(color);
//    }

//    @Override
//    public Card makeMove(PlayingDeck playingDeck, DiscardDeck discardDeck) {
//        Card playedCard = null;
//        String move = "";
//        do {
//            move = kb.nextLine();
//
//            playedCard = this.pickCard(playingDeck, move);
//            if (playedCard == null) {
//                System.out.println("You don't have that card");
//            } else if (!canPlayCard(discardDeck, playedCard)) {
//                System.out.println("You can't play that card");
//            } else {
//                movingTime();
//                // If User plays a card that can change color
//                if (discardDeck.getTopOfDeck().getValue() > 12) {
//                    changeSpecialCardColor(discardDeck);
//                }
//                break; // end loop and return playedCard now
//            }
//
//            // otherwise print a try again prompt
//            if (!move.equals("draw"))
//                System.out.print("Play a different Card: ");
//            else // or return nothing which means the user had no playable cards
//                return null;
//        } while (!move.equals("draw"));
//        return playedCard;
//    }

    @Override
    public boolean isHuman() {
        return true;
    }


    @Override
    public void gameOverAction() {
        kb.close();
    }


    @Override
    public String displayHand() {
        String output = "";
        for (Card card : cardsInHand) {
            output += card;
            output += " ";
        }
        return output;
    }
}
