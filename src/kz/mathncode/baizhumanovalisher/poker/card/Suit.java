package kz.mathncode.baizhumanovalisher.poker.card;

public enum Suit {
    //rank?
    CLUB(400, "C"),
    DIAMOND(300, "D"),
    HEART(200, "H"),
    SPADE(100, "S");

    Suit(int rank, String shortName) {
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
