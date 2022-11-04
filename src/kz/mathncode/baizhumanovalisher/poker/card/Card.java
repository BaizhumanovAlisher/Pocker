package kz.mathncode.baizhumanovalisher.poker.card;

public record Card(Face face, Suit suit) {
    public Card {
        if (face == null) {
            throw new IllegalArgumentException("Face is null.");
        }

        if (suit == null) {
            throw new IllegalArgumentException("Suit is null.");
        }

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
}
