package kz.mathncode.baizhumanovalisher.poker.card;

import kz.mathncode.baizhumanovalisher.poker.card.Face;
import kz.mathncode.baizhumanovalisher.poker.card.Suit;

import java.util.Objects;

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

//    Не хватает equals и hashCode для валидного сравнивания
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Card card = (Card) o;
//        return value == card.value && face == card.face && suit == card.suit;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(face, suit, value);
//    }
}
