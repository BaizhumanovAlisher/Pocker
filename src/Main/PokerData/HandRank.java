package Main.PokerData;

public enum HandRank {
    STRAIGHT_FLUSH("straight flush", 9000),
    FOUR_OF_A_KIND("four of a kind", 8000),
    FULL_HOUSE("full house", 7000),
    FLUSH("flush", 6000),
    STRAIGHT("straight", 5000),
    THREE_OF_A_KIND("three of a kind", 4000),
    TWO_PAIR("two pair", 3000),
    ONE_PAIR("one pair", 2000),
    HIGH_CARD("high card", 1000);

    private final int value;
    private final String rank;

    HandRank(String rank, int value) {
        this.rank = rank;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return rank;
    }
}
