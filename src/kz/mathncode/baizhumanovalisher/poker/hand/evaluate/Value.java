package kz.mathncode.baizhumanovalisher.poker.hand.evaluate;

import kz.mathncode.baizhumanovalisher.poker.card.Card;
import kz.mathncode.baizhumanovalisher.poker.hand.HandRank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Value {
    public static int getValue(List<Card> hand, HandRank rank) {
        int value = 0;

        Queue<Card> queue = getQueue(hand, rank);

        while (!queue.isEmpty()) {
            int face = queue.poll().face().getRank();

            value = value * 100 + face;
        }

        return value;
    }

    private static Queue<Card> getQueue(List<Card> hand, HandRank rank) {
        Queue<Card> result = new LinkedList<>();

        switch (rank) {
            case STRAIGHT, STRAIGHT_FLUSH -> getQueueWithStraight(hand, result);
            case HIGH_CARD, FLUSH -> getQueueWithoutComb(hand, result);
            case FOUR_OF_A_KIND, THREE_OF_A_KIND, ONE_PAIR -> getQueueWithOneComb(hand, result);
            case TWO_PAIR -> getQueueWithTwoPair(hand, result);
            case FULL_HOUSE -> getQueueWithFullHouse(hand, result);
        }

        return result;
    }

    private static void getQueueWithStraight(List<Card> hand, Queue<Card> result) {
        Card highCard = hand.get(0);
        result.add(highCard);
    }

    private static void getQueueWithOneComb(List<Card> list, Queue<Card> result) {
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
    }

    private static void getQueueWithoutComb(List<Card> list, Queue<Card> result) {
        result.addAll(list);
    }

    private static void getQueueWithFullHouse(List<Card> list, Queue<Card> result) {
        int face1 = list.get(0).face().getRank();
        int face2 = list.get(1).face().getRank();
        int face3 = list.get(2).face().getRank();

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
    }

    private static void getQueueWithTwoPair(List<Card> list, Queue<Card> result) {
        boolean isPairFirst = list.get(0).face().getRank() == list.get(1).face().getRank();
        boolean isPairLast = list.get(list.size() - 1).face().getRank() == list.get(list.size() - 2).face().getRank();

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
    }

    private static List<Integer> getStartAndEndIndexComb(List<Card> list) {
        List<Integer> result = new ArrayList<>();

        int start = 0;
        int end = 0;

        for (int i = 0; i < list.size() - 1; i++) {
            int face1 = list.get(i).face().getRank();
            int face2 = list.get(i + 1).face().getRank();

            if (face1 == face2) {
                start = i;
                break;
            }
        }

        for (int i = list.size() - 1; i >= 1; i--) {
            int face1 = list.get(i).face().getRank();
            int face2 = list.get(i - 1).face().getRank();

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
