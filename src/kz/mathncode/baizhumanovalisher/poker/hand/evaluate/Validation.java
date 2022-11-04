package kz.mathncode.baizhumanovalisher.poker.hand.evaluate;

import kz.mathncode.baizhumanovalisher.poker.card.Card;
import kz.mathncode.baizhumanovalisher.poker.exceptions.HandHasDuplicatesException;
import kz.mathncode.baizhumanovalisher.poker.exceptions.IncorrectHandSizeException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {

    private static final int correctHandSize = 5;

    public static void handValidation(List<Card> hand) {
        if (hasDuplicates(hand)) {
            throw new HandHasDuplicatesException();
        }

        if (!isCorrectHandSize(hand)) {
            throw new IncorrectHandSizeException();
        }
    }

    private static boolean isCorrectHandSize(List<Card> hand) {
        return hand.size() == correctHandSize;
    }

    private static boolean hasDuplicates(List<Card> hand) {
        Set<Card> cardSet = new HashSet<>(hand);
        return cardSet.size() != hand.size();
    }
}
