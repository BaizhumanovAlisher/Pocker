package kz.mathncode.baizhumanovalisher.poker.hand;

import kz.mathncode.baizhumanovalisher.poker.card.Card;

import java.util.*;

public class Hand {
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
        return HandEvaluate.getHandIndicator(hand);
    }

    protected List<Card> getList() {
        return hand;
    }

    public String toString() {
        return hand.toString();
    }

    public void add(Card c) {
        if (c != null) {
            hand.add(c);
        } else {
            throw new IllegalArgumentException("Card is null.");
        }
    }

    public static Hand chooseStrongHand(Hand hand1, Hand hand2) {
        return HandsComparison.chooseStrongHand(hand1, hand2);
    }
}

