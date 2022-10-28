package kz.mathncode.baizhumanovalisher.poker;

import kz.mathncode.baizhumanovalisher.poker.card.Card;
import kz.mathncode.baizhumanovalisher.poker.card.HandRank;
import kz.mathncode.baizhumanovalisher.poker.card.Suit;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class HandEvaluate {
    //Может проще здесь принимать List и валидировать его?
    public static HandRank getRank(Card c1, Card c2, Card c3, Card c4, Card c5) {
        // Тем более аргумент в пользу листа
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
        // Наверное здесь стоит проверить на дубликаты, но ты делаешь это до этого
        // В целом --- нормальная практика, но можно перестраховаться
        Comparator<Card> comparator = Comparator.comparing(obj -> obj.getFace().getRank());

        hand.sort(comparator);

        int smallCard = hand.get(0).getValue();
        // Магическая константа
        int bigCard = hand.get(4).getValue();
        // И здесь
        return bigCard - smallCard == 4;
    }

    private static boolean checkFlush(List<Card> hand) {
        // Set<Suit> suits = hand.stream().map(Card::getSuit).collect(Collectors.toSet());
        // return suits.size() == 1;

        for (int i = 0; i < hand.size() - 1; i++) {
            Suit suit1 = hand.get(i).getSuit();
            Suit suit2 = hand.get(i + 1).getSuit();

            //Енамы могут сравниваться по ссылке
            // if suit1 != suit2 --> Валидное сравнение
            if (!Objects.equals(suit1, suit2)) {
                return false;
            }
        }

        return true;
    }

    // Магические константы повсюду
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

    // Неочевидное название
    private static int[] getListInteger(List<Card> hand) {
        int[] counterHistogram = new int[13];

        for (Card card : hand) {
            int index = card.getFace().getRank();
            counterHistogram[index]++;
        }

        Arrays.sort(counterHistogram);

        return  counterHistogram;
    }
}
