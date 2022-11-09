package kz.mathncode.baizhumanovalisher.poker.hand.evaluate;

import kz.mathncode.baizhumanovalisher.poker.card.Card;
import kz.mathncode.baizhumanovalisher.poker.exceptions.HandHasDuplicatesException;
import kz.mathncode.baizhumanovalisher.poker.exceptions.IncorrectHandSizeException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    public static final int FiveCardHandSize = 5;
    public static final int SevenCardHandSize = 7;

    public static void handValidation(List<Card> hand) {
        if (!isCorrectHandSize(hand)) {
            throw new IncorrectHandSizeException();
        }

        if (hasDuplicates(hand)) {
            throw new HandHasDuplicatesException();
        }
    }

    private static boolean isCorrectHandSize(List<Card> hand) {
        return hand.size() == FiveCardHandSize || hand.size() == SevenCardHandSize;
    }

    private static boolean hasDuplicates(List<Card> hand) {
        Set<Card> cardSet = new HashSet<>(hand);
        return cardSet.size() != hand.size();
    }

    public static void checkHandsDuplicates(List<Card> hand1, List<Card> hand2) {
        List<Card> overallListCards = new ArrayList<>();

        overallListCards.addAll(hand1);
        overallListCards.addAll(hand2);

        Set<Card> overallSetCards = new HashSet<>(overallListCards);

        if (overallSetCards.size() != overallListCards.size()) {
            throw new HandHasDuplicatesException();
        }
    }
}
