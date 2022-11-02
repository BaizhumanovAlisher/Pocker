package kz.mathncode.baizhumanovalisher.poker.card;

public enum Face {
    DEUCE(0, "2"),
    TREY(1, "3"),
    FOUR(2, "4"),
    FIVE(3, "5"),
    SIX(4, "6"),
    SEVEN(5, "7"),
    EIGHT(6, "8"),
    NINE(7, "9"),
    TEN(8, "T"),
    JACK(9, "J"),
    QUEEN(10, "Q"),
    KING(11, "K"),
    ACE(12, "A");

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
