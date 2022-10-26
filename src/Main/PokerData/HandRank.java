package Main.PokerData;

public class HandRank {
    public static final String STRAIGHT_FLUSH = "straight flush";
    public static final String FOUR_OF_A_KIND = "four of a kind";
    public static final String FULL_HOUSE = "full house";
    public static final String FLUSH = "flush";
    public static final String STRAIGHT = "straight";
    public static final String THREE_OF_A_KIND = "three of a kind";
    public static final String TWO_PAIR = "two pair";
    public static final String ONE_PAIR = "one pair";
    public static final String HIGH_CARD = "high card";

    private final int value;

    public HandRank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        String result;

        if (value > 6185) {
            result = HIGH_CARD;
        } else if (value > 3325) {
            result = ONE_PAIR;
        } else if (value > 2467) {
            result = TWO_PAIR;
        } else if (value > 1609) {
            result = THREE_OF_A_KIND;
        } else if (value > 1599) {
            result = STRAIGHT;
        } else if (value > 322) {
            result = FLUSH;
        } else if (value > 166) {
            result = FULL_HOUSE;
        } else if (value > 10) {
            result = FOUR_OF_A_KIND;
        } else {
            result = STRAIGHT_FLUSH;
        }

        return result;
    }
}
