package kz.mathncode.baizhumanovalisher.poker.card;

public enum Face {
    DEUCE(2, "2"),
    TREY(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    TEN(10, "T"),
    JACK(11, "J"),
    QUEEN(12, "Q"),
    KING(13, "K"),
    ACE(14, "A");

    Face(int rank, String shortName) {
        this.rank = rank;
        this.shortName = shortName;
    }

    private final int rank;
    private final String shortName;

    public int getRank() {
        return rank;
    }

    public String toString() {
        return shortName;
    }
}
