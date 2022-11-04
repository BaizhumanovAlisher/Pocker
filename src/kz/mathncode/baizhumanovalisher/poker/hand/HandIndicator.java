package kz.mathncode.baizhumanovalisher.poker.hand;

public record HandIndicator(HandRank rank, int value) {
    public String toString() {
        return rank.toString();
    }
}
