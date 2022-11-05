package kz.mathncode.baizhumanovalisher.poker.hand;

import kz.mathncode.baizhumanovalisher.poker.card.Card;
import kz.mathncode.baizhumanovalisher.poker.hand.evaluate.Rank;
import kz.mathncode.baizhumanovalisher.poker.hand.evaluate.Validation;
import kz.mathncode.baizhumanovalisher.poker.hand.evaluate.Value;

import java.util.*;

public class Hand {
    private static final Comparator<Card> comparator;

    static {
        comparator = Comparator.comparing(obj -> obj.getFace().getRank() * (-1));
    }
    private final List<Card> hand;

    public Hand() {
        this.hand = new ArrayList<>();
    }

    public Hand(Card c1, Card c2, Card c3, Card c4, Card c5) {
        this.hand = new ArrayList<>();

        hand.add(c1);
        hand.add(c2);
        hand.add(c3);
        hand.add(c4);
        hand.add(c5);
    }

    public HandIndicator evaluate() {
        Validation.handValidation(hand);

        hand.sort(comparator);

        HandRank rank = Rank.getRank(hand);
        int value = Value.getValue(hand, rank);

        return new HandIndicator(rank, value);
    }

    public List<Card> getList() {
        return hand;
    }

    public String toString() {
        return hand.toString();
    }

    public void add(Card c) {
        hand.add(c);
    }
}

