package Main;

import Main.PokerData.HandRank;
import Main.PokerData.Tables;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {
    private final List<Card> hand;

    public Hand() {
        this.hand = new ArrayList<>();
    }

    public HandRank evaluate() {
        if (hasDuplicates(hand)) {
            throw new IllegalArgumentException("The hand has duplicates.");
        }

        if (hand.size() != 5) {
            throw new IllegalArgumentException("Incorrect hand size.");
        }

        Card c1 = hand.get(0);
        Card c2 = hand.get(1);
        Card c3 = hand.get(2);
        Card c4 = hand.get(3);
        Card c5 = hand.get(4);

        int result = getNumberRank(c1, c2, c3, c4, c5);

        return new HandRank(result);
    }

    private static boolean hasDuplicates(List<Card> hand) {
        List<Integer> array = new ArrayList<>();

        for (Card card : hand) {
            array.add(card.getValue());
        }

        Collections.sort(array);

        for (int i = 0; i < array.size() - 1; i++) {
            if (array.get(i).equals(array.get(i + 1))) {
                return true;
            }
        }

        return false;
    }

    private int getNumberRank(Card c1, Card c2, Card c3, Card c4, Card c5) {
        int v1 = c1.getValue();
        int v2 = c2.getValue();
        int v3 = c3.getValue();
        int v4 = c4.getValue();
        int v5 = c5.getValue();

        int index = (v1 | v2 | v3 | v4 | v5) >> 16;

        if ((v1 & v2 & v3 & v4 & v5 & 0xF000) != 0) {
            return Tables.getFlushesAt(index);
        }

        int value = Tables.getUniqueAt(index);

        if (value != 0) {
            return value;
        }

        int product = (v1 & 0xFF) * (v2 & 0xFF) * (v3 & 0xFF) * (v4 & 0xFF) * (v5 & 0xFF);

        return Tables.getValuesAt(hash(product));
    }

    public String toString() {
        return hand.toString();
    }

    public String getFullName() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < hand.size(); i++) {
            result.append(i + 1);
            result.append(" card -- ");
            String card = hand.get(i).getFullName();
            result.append(card);
            result.append("\n");
        }

        return result.toString().strip();
    }

    public void add(Card c) {
        if (c != null) {
            hand.add(c);
        } else {
            throw new IllegalArgumentException("Card is null.");
        }
    }

    public void add(List<Card> cards) {
        for (Card card : cards) {
            if (card != null) {
                hand.add(card);
            } else {
                throw new IllegalArgumentException("Card is null.");
            }
        }
    }

    public void clear() {
        hand.clear();
    }

    public int size() {
        return hand.size();
    }

    private static int hash(int key) {
        key += 0xE91AAA35;
        key ^= key >>> 16;
        key += key << 8;
        key ^= key >>> 4;
        return ((key + (key << 2)) >>> 19) ^ Tables.getAdjustAt((key >>> 8) & 0x1FF);
    }
}
