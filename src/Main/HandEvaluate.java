package Main;

import Main.PokerData.HandRank;
import Main.PokerData.Suit;

import java.util.*;
import java.util.List;

public class HandEvaluate {
    public static HandRank getRank(Card c1, Card c2, Card c3, Card c4, Card c5) {
        List<Card> hand = new ArrayList<>(List.of(new Card[]{c1, c2, c3, c4, c5}));

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
        Comparator<Card> comparator = Comparator.comparing(obj -> obj.getFace().getRank());

        hand.sort(comparator);

        int smallCard = hand.get(0).getValue();
        int bigCard = hand.get(4).getValue();

        return bigCard - smallCard == 4;
    }

    private static boolean checkFlush(List<Card> hand) {
        for (int i = 0; i < hand.size() - 1; i++) {
            Suit suit1 = hand.get(i).getSuit();
            Suit suit2 = hand.get(i + 1).getSuit();

            if (!Objects.equals(suit1, suit2)) {
                return false;
            }
        }

        return true;
    }

    private static HandRank checkOtherCombination(List<Card> hand) {
        int[] listHistogram = getListInteger(hand);

        int counter1 = listHistogram[listHistogram.length - 1];
        int counter2 = listHistogram[listHistogram.length - 2];

        if (counter1 == 4) {
            return HandRank.FOUR_OF_A_KIND;
        }

        if (counter1 == 3 && counter2 == 2) {
            return HandRank.FULL_HOUSE;
        }

        if (counter1 == 3) {
            return HandRank.THREE_OF_A_KIND;
        }

        if (counter1 == 2 && counter2 == 2) {
            return HandRank.TWO_PAIR;
        }

        if (counter1 == 2) {
            return HandRank.ONE_PAIR;
        }

        return HandRank.HIGH_CARD;
    }

    private static int[] getListInteger(List<Card> hand) {
        int[] counterHistogram = new int[13];

        for (Card card : hand) {
            int index = card.getFace().getRank();
            counterHistogram[index]++;
        }

        Arrays.sort(counterHistogram);

        return counterHistogram;
    }
}
