package kz.mathncode.baizhumanovalisher.poker.hand.evaluate;

import kz.mathncode.baizhumanovalisher.poker.card.Card;
import kz.mathncode.baizhumanovalisher.poker.hand.HandIndicator;
import kz.mathncode.baizhumanovalisher.poker.hand.HandRank;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HandEvaluate {
    private static final Comparator<Card> comparator;

    static {
        comparator = Comparator.comparing(obj -> obj.getFace().getRank() * (-1));
    }

    public static HandIndicator evaluate(List<Card> hand) {
        Validation.handValidation(hand);

        hand.sort(comparator);

        if (hand.size() == Validation.FiveCardHandSize) {
            return evaluate5CardHand(hand);
        } else if (hand.size() == Validation.SevenCardHandSize) {
            List<List<Card>> hands = get5CardHands(hand);
            List<HandIndicator> handIndicators = getHandIndicators(hands);
            return getStrongestHandIndicatorFromHands(handIndicators);
        }

        return new HandIndicator(HandRank.HIGH_CARD, 0);
    }

    private static List<HandIndicator> getHandIndicators(List<List<Card>> hands) {
        List<HandIndicator> handIndicators = new ArrayList<>();

        for (List<Card> hand : hands) {
            HandIndicator indicator = evaluate5CardHand(hand);
            handIndicators.add(indicator);
        }

        return handIndicators;
    }

    private static HandIndicator evaluate5CardHand(List<Card> hand) {
        HandRank rank = Rank.getRank(hand);
        int value = Value.getValue(hand, rank);

        return new HandIndicator(rank, value);
    }

    private static List<List<Card>> get5CardHands(List<Card> hand) {
        List<List<Card>> result = new ArrayList<>();

        for (int i = 0; i < hand.size() - 1; i++) {
            for (int j = i + 1; j < hand.size(); j++) {
                List<Card> newHand = newHandWithoutParametricIndexes(hand, i, j);
                result.add(newHand);
            }
        }

        return result;
    }

    private static List<Card> newHandWithoutParametricIndexes(List<Card> hand, int i, int j) {
        List<Card> newHand = new ArrayList<>();

        for (int m = 0; m < hand.size(); m++) {
            if (m != i && m != j) {
                Card card = hand.get(m);
                newHand.add(card);
            }
        }

        return newHand;
    }

    private static HandIndicator getStrongestHandIndicatorFromHands(List<HandIndicator> handIndicators) {
        HandIndicator strongerIndicator = handIndicators.get(0);

        for (HandIndicator indicator : handIndicators) {
            if (HandIndicator.compare(indicator, strongerIndicator) > 0) {
                strongerIndicator = indicator;
            }
        }

        return strongerIndicator;
    }
}
