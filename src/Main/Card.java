package Main;

import Main.PokerData.Face;
import Main.PokerData.Suit;

public class Card {
    private final Face face;
    private final Suit suit;
    private final int value;

    public Card(Face face, Suit suit) {
        if (face == null || suit == null) {
            throw new IllegalArgumentException("Arguments are empty.");
        }

        this.face = face;
        this.suit = suit;

        this.value = face.getRank() + suit.getRank();
    }

    public String toString() {
        return face.toString() + suit.toString();
    }

    public String getFullName(){
        return face.getFullName() + " " + suit.getFullName();
    }

    public Face getFace() {
        return face;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }
}
