package Main;

import Main.PokerData.Face;
import Main.PokerData.Suit;
import Main.PokerData.Tables;

public class Card {
    private final int value;
    private final Face face;
    private final Suit suit;

    public Card(Face face, Suit suit) {
        if (face == null || suit == null) {
            throw new IllegalArgumentException("Arguments are empty.");
        }

        this.face = face;
        this.suit = suit;

        int rank = face.getRank();
        value = (1 << (rank + 16)) | suit.getRank() | (rank << 8) | Tables.getPrimesAt(rank);
    }

    public String toString() {
        return face.toString() + suit.toString();
    }

    public String getFullName(){
        return face.getFullName() + " " + suit.getFullName();
    }

    public int getValue() {
        return value;
    }
}
