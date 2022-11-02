package kz.mathncode.baizhumanovalisher.poker.Hand;

import kz.mathncode.baizhumanovalisher.poker.Exceptions.HandHasDuplicatesException;
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

        HandRank handRank1 = hand1.evaluate();
        HandRank handRank2 = hand2.evaluate();

        HandRank strongHandRank = HandRank.chooseStrongHandRank(handRank1, handRank2);

        if (strongHandRank == handRank1) {
            return hand1;
        } else if (strongHandRank == handRank2) {
            return hand2;
        } else {
            return chooseStrongHandWithSameRank(hand1, hand2, handRank1);
        }
    }

    private static boolean handsHaveDuplicates(Hand hand1, Hand hand2) {
        List<Card> overallListCards = new ArrayList<>();

        overallListCards.addAll(hand1.getList());
        overallListCards.addAll(hand2.getList());

        Set<Card> overallSetCards = new HashSet<>(overallListCards);

        return overallSetCards.size() != overallListCards.size();
    }

    private static Hand chooseStrongHandWithSameRank(Hand hand1, Hand hand2, HandRank sameRank) {
        Queue<Card> queue1 = getQueue(hand1.getList(), sameRank);
        Queue<Card> queue2 = getQueue(hand2.getList(), sameRank);

        while (!(queue1.isEmpty() || queue2.isEmpty())) {
            int face1 = queue1.poll().getFace().getRank();
            int face2 = queue2.poll().getFace().getRank();

            if (face1 > face2) {
                return hand1;
            } else if (face1 < face2) {
                return hand2;
            }
        }

        return null;
    }

    private static Queue<Card> getQueue(List<Card> listHand, HandRank rank) {
        switch (rank) {
            case STRAIGHT:
            case STRAIGHT_FLUSH:
            case HIGH_CARD:
            case FLUSH:
                return getQueueWithoutComb(listHand);
            case FOUR_OF_A_KIND:
            case THREE_OF_A_KIND:
            case ONE_PAIR:
                return getQueueWithOneComb(listHand);
            case TWO_PAIR:
                return getQueueWithTwoPair(listHand);
            case FULL_HOUSE:
                return getQueueWithFullHouse(listHand);
            default:
                return new LinkedList<>();
        }
    }

    private static Queue<Card> getQueueWithOneComb(List<Card> list) {
        Queue<Card> result = new LinkedList<>();

        List<Integer> startAndEndIndexComb = getStartAndEndIndexComb(list);

        int start = startAndEndIndexComb.get(0);
        int end = startAndEndIndexComb.get(1);

        result.add(list.get(start));

        for (int i = 0; i < start; i++) {
            Card card = list.get(i);
            result.add(card);
        }

        for (int i = end + 1; i < list.size() - 1; i++) {
            Card card = list.get(i);
            result.add(card);
        }

        return result;
    }

    private static Queue<Card> getQueueWithoutComb(List<Card> list) {
        return new LinkedList<>(list);
    }

    private static Queue<Card> getQueueWithFullHouse(List<Card> list) {
        Queue<Card> result = new LinkedList<>();

        int face1 = list.get(0).getFace().getRank();
        int face2 = list.get(1).getFace().getRank();
        int face3 = list.get(2).getFace().getRank();

        Card triple;
        Card pair;

        if (face1 == face2 && face2 == face3) {
            triple = list.get(0);
            pair = list.get(list.size() - 1);
        } else {
            triple = list.get(list.size() - 1);
            pair = list.get(0);
        }

        result.add(triple);
        result.add(pair);

        return result;
    }

    private static Queue<Card> getQueueWithTwoPair(List<Card> list) {
        Queue<Card> result = new LinkedList<>();

        boolean isPairFirst = list.get(0).getFace().getRank() == list.get(1).getFace().getRank();
        boolean isPairLast = list.get(list.size() - 1).getFace().getRank() == list.get(list.size() - 2).getFace().getRank();

        boolean isKickerFirst = !isPairFirst && isPairLast;
        boolean isKickerLast = isPairFirst && !isPairLast;

        int first = 0;
        int mid = list.size() / 2;
        int last = list.size() - 1;

        Card firstPair;
        Card secondPair;
        Card kicker;

        if (isKickerFirst) {
            firstPair = list.get(mid);
            secondPair = list.get(last);
            kicker = list.get(first);
        } else if (isKickerLast) {
            firstPair = list.get(first);
            secondPair = list.get(mid);
            kicker = list.get(last);
        } else { // kicker is mid
            firstPair = list.get(first);
            secondPair = list.get(last);
            kicker = list.get(mid);
        }

        result.add(firstPair);
        result.add(secondPair);
        result.add(kicker);

        return result;
    }

    private static List<Integer> getStartAndEndIndexComb(List<Card> list) {
        List<Integer> result = new ArrayList<>();

        int start = 0;
        int end = 0;

        for (int i = 0; i < list.size() - 1; i++) {
            int face1 = list.get(i).getFace().getRank();
            int face2 = list.get(i + 1).getFace().getRank();

            if (face1 == face2) {
                start = i;
                break;
            }
        }

        for (int i = list.size() - 1; i >= 1; i--) {
            int face1 = list.get(i).getFace().getRank();
            int face2 = list.get(i - 1).getFace().getRank();

            if (face1 == face2) {
                end = i;
                break;
            }
        }

        result.add(start);
        result.add(end);

        return result;
    }
}
