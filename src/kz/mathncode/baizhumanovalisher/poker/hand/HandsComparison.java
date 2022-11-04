package kz.mathncode.baizhumanovalisher.poker.hand;

import kz.mathncode.baizhumanovalisher.poker.exceptions.HandHasDuplicatesException;
import kz.mathncode.baizhumanovalisher.poker.card.Card;

import java.util.*;

public class HandsComparison {
    protected static Hand chooseStrongHand(Hand hand1, Hand hand2) {
        if (hand1 == null || hand2 == null) {
            throw new IllegalArgumentException("Hand is null.");
        }

        if (handsHaveDuplicates(hand1, hand2)) {
            throw new HandHasDuplicatesException();
        }

        HandIndicator handIndicator1 = hand1.evaluate();
        HandIndicator handIndicator2 = hand2.evaluate();

        int handRank1 = handIndicator1.rank().getValue();
        int handRank2 = handIndicator2.rank().getValue();

        if (handRank1 > handRank2) {
            return hand1;
        } else if (handRank1 < handRank2) {
            return hand2;
        } else {
            int handValue1 = handIndicator1.value();
            int handValue2 = handIndicator2.value();

            if (handValue1 > handValue2) {
                return hand1;
            } else if (handValue1 < handValue2) {
                return hand2;
            }
        }

        return null;
    }

    private static boolean handsHaveDuplicates(Hand hand1, Hand hand2) {
        List<Card> overallListCards = new ArrayList<>();

        overallListCards.addAll(hand1.getList());
        overallListCards.addAll(hand2.getList());

        Set<Card> overallSetCards = new HashSet<>(overallListCards);

        return overallSetCards.size() != overallListCards.size();
    }
}
