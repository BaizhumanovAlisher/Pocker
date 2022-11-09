package kz.mathncode.baizhumanovalisher.poker.hand;

import java.util.Objects;

public final class HandIndicator {
    private final HandRank rank;
    private final int value;

    public HandIndicator(HandRank rank, int value) {
        if (rank == null) {
            throw new NullPointerException("Rank is null.");
        }

        if (value < 0) {
            throw new IllegalArgumentException("Value is negative.");
        }
        this.rank = rank;
        this.value = value;
    }

    public String toString() {
        return rank.toString();
    }

    public HandRank getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (HandIndicator) obj;
        return Objects.equals(this.rank, that.rank) &&
                this.value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, value);
    }

    public static int compare(HandIndicator h1, HandIndicator h2) {
        int handRank1 = h1.getRank().getValue();
        int handRank2 = h2.getRank().getValue();

        if (handRank1 > handRank2) {
            return 1;
        } else if (handRank1 < handRank2) {
            return -1;
        } else {
            int handValue1 = h1.getValue();
            int handValue2 = h2.getValue();

            if (handValue1 > handValue2) {
                return 1;
            } else if (handValue1 < handValue2) {
                return -1;
            }
        }

        return 0;
    }
}
