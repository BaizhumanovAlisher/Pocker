package kz.mathncode.baizhumanovalisher.poker.card;

import java.util.Objects;

public class Card {
    private final Face face;
    private final Suit suit;

    public Card(Face face, Suit suit) {
        if (face == null) {
            throw new NullPointerException("Face is null.");
        }

        if (suit == null) {
            throw new NullPointerException("Suit is null.");
        }
        this.face = face;
        this.suit = suit;
    }

    public String toString() {
        return face.toString() + suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return this.face == card.face && this.suit == card.suit;
    }

    public int hashCode() {
        return Objects.hash(face, suit);
    }

    public Face getFace() {
        return face;
    }

    public Suit getSuit() {
        return suit;
    }

}
