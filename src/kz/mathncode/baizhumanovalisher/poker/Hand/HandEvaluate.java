package kz.mathncode.baizhumanovalisher.poker.Hand;

import kz.mathncode.baizhumanovalisher.poker.Exceptions.HandHasDuplicatesException;
import kz.mathncode.baizhumanovalisher.poker.Exceptions.IncorrectHandSizeException;
import kz.mathncode.baizhumanovalisher.poker.card.Card;
import kz.mathncode.baizhumanovalisher.poker.card.Face;
import kz.mathncode.baizhumanovalisher.poker.card.Suit;

import java.util.*;
import java.util.stream.Collectors;

public class HandEvaluate {
    private static final int correctHandSize = 5;

    private static final Comparator<Card> comparator;

    static {
        comparator = Comparator.comparing(obj -> obj.getFace().getRank() * (-1));
    }

    public static HandIndicator getHandIndicator(List<Card> hand) {
        Validation.handValidation(hand);

        hand.sort(comparator);

        HandRank rank = Rank.getRank(hand);
        int value = Value.getValue(hand, rank);

        return new HandIndicator(rank, value);
    }

    private static class Validation {
        private static void handValidation(List<Card> hand) {
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

    private static class Value {

        private static int getValue(List<Card> hand, HandRank rank) {
            int value = 0;

            Queue<Card> queue = getQueue(hand, rank);

            while (!queue.isEmpty()) {
                int face = queue.poll().getFace().getRank();

                value = value * 100 + face;
            }

            return value;
        }

        private static Queue<Card> getQueue(List<Card> hand, HandRank rank) {
            return switch (rank) {
                case STRAIGHT, STRAIGHT_FLUSH -> getQueueWithStraight(hand);
                case HIGH_CARD, FLUSH -> getQueueWithoutComb(hand);
                case FOUR_OF_A_KIND, THREE_OF_A_KIND, ONE_PAIR -> getQueueWithOneComb(hand);
                case TWO_PAIR -> getQueueWithTwoPair(hand);
                case FULL_HOUSE -> getQueueWithFullHouse(hand);
            };
        }

        private static Queue<Card> getQueueWithStraight(List<Card> hand) {
            Queue<Card> result = new LinkedList<>();

            Card highCard = hand.get(0);
            result.add(highCard);

            return result;
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

    private static class Rank {

        private static HandRank getRank(List<Card> hand) {
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
            List<Integer> counterHistogram = initializationList(Face.values().length);

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
}
