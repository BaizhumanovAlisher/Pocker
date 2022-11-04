package kz.mathncode.baizhumanovalisher.poker.hand.evaluate;

import kz.mathncode.baizhumanovalisher.poker.card.Card;
import kz.mathncode.baizhumanovalisher.poker.hand.HandIndicator;
import kz.mathncode.baizhumanovalisher.poker.hand.HandRank;

import java.util.*;

public class HandEvaluate {

    private static final Comparator<Card> comparator;

    static {
        comparator = Comparator.comparing(obj -> obj.face().getRank() * (-1));
    }

    public static HandIndicator getHandIndicator(List<Card> hand) {
        Validation.handValidation(hand);

        hand.sort(comparator);

        HandRank rank = Rank.getRank(hand);
        int value = Value.getValue(hand, rank);

        return new HandIndicator(rank, value);
    }
}
