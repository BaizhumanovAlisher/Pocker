package Main;

import Main.PokerData.Face;
import Main.PokerData.Suit;

import java.util.*;

public class DeckCards {
    public static final Card[] DECK_CARDS;

    static {
        Face[] faces = Face.values();
        Suit[] suits = Suit.values();

        DECK_CARDS = new Card[faces.length * suits.length];

        int counter = 0;

        for (Face face : faces) {
            for (Suit suit : suits) {
                DECK_CARDS[counter++] = new Card(face, suit);
            }
        }
    }

    private Queue<Card> deck;

    public DeckCards() {
        List<Card> deck = new ArrayList<>(List.of(DECK_CARDS));

        Collections.shuffle(deck);

        this.deck = new LinkedList<>(deck);
    }

    public void clear() {
        deck.clear();
    }

    public void add(Card c) {
        deck.add(c);
    }

    public Card poll() {
        return deck.poll();
    }

    public boolean isEmpty() {
        return deck.isEmpty();
    }

    public void clearAndFill() {
        this.deck.clear();

        List<Card> deck = new ArrayList<>(List.of(DECK_CARDS));

        Collections.shuffle(deck);

        this.deck = new LinkedList<>(deck);
    }
}
