package kz.mathncode.baizhumanovalisher.poker.card;

public enum Suit {
    CLUB("C"),
    DIAMOND("D"),
    HEART("H"),
    SPADE("S");

    Suit(String shortName) {
        this.shortName = shortName;
    }
    private final String shortName;

    public String toString() {
        return shortName;
    }
}
