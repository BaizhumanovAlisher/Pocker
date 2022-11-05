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

}
