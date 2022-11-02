package kz.mathncode.baizhumanovalisher.poker.Hand;

public class HandIndicator {
    private final HandRank rank;
    private final int value;

    public HandIndicator(HandRank rank, int value) {
        this.rank = rank;
        this.value = value;
    }

    public HandRank getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return rank.toString();
    }
}
