package kz.mathncode.baizhumanovalisher.poker.hand.evaluate;

import kz.mathncode.baizhumanovalisher.poker.card.Card;
import kz.mathncode.baizhumanovalisher.poker.card.Face;
import kz.mathncode.baizhumanovalisher.poker.card.Suit;
import kz.mathncode.baizhumanovalisher.poker.hand.HandRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Rank {
    public static HandRank getRank(List<Card> hand) {
        boolean isFlush = checkFlush(hand);
        boolean isStraight = checkStraight(hand);

        if (isStraight && isFlush) {
            return HandRank.STRAIGHT_FLUSH;
        }

        HandRank rank = checkOtherCombination(hand);

        if (rank.getValue() > HandRank.FLUSH.getValue()) {
            return rank;
        }

        if (isFlush) {
            return HandRank.FLUSH;
        }

        if (isStraight) {
            return HandRank.STRAIGHT;
        }

        return rank;
    }

    private static boolean checkStraight(List<Card> hand) {
        for (int i = 0; i < hand.size() - 1; i++) {
            int face1 = hand.get(i).getFace().getRank();
            int face2 = hand.get(i + 1).getFace().getRank();

            if (face1 - 1 != face2) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkFlush(List<Card> hand) {
        Set<Suit> suits = hand.stream().map(Card::getSuit).collect(Collectors.toSet());
        return suits.size() == 1;
    }

    private static HandRank checkOtherCombination(List<Card> hand) {
        List<Integer> listHistogram = getHandHistogram(hand);

        int counter1 = listHistogram.get(0);
        int counter2 = listHistogram.get(1);

        int fourOfAKind = 4;
        int threeOfAKind = 3;
        int pair = 2;

        if (counter1 == fourOfAKind) {
            return HandRank.FOUR_OF_A_KIND;
        }

        if (counter1 == threeOfAKind && counter2 == pair) {
            return HandRank.FULL_HOUSE;
        }

        if (counter1 == threeOfAKind) {
            return HandRank.THREE_OF_A_KIND;
        }

        if (counter1 == pair && counter2 == pair) {
            return HandRank.TWO_PAIR;
        }

        if (counter1 == pair) {
            return HandRank.ONE_PAIR;
        }

        return HandRank.HIGH_CARD;
    }

    private static List<Integer> getHandHistogram(List<Card> hand) {
        List<Integer> counterHistogram = initializationList(Face.ACE.getRank() + 1);

        for (Card card : hand) {
            int index = card.getFace().getRank();
            int newValue = counterHistogram.get(index) + 1;
            counterHistogram.set(index, newValue);
        }

        Collections.sort(counterHistogram);
        Collections.reverse(counterHistogram);

        return counterHistogram;
    }

    private static List<Integer> initializationList(int arrayLength) {
        List<Integer> l = new ArrayList<>(arrayLength);

        for (int i = 0; i < arrayLength; i++) {
            l.add(0);
        }

        return l;
    }
}
