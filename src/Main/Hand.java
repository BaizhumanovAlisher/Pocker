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

        int result = Tables.getNumberRank(c1, c2, c3, c4, c5);

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
}
