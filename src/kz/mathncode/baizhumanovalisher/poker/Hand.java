package kz.mathncode.baizhumanovalisher.poker;

import kz.mathncode.baizhumanovalisher.poker.card.Card;
import kz.mathncode.baizhumanovalisher.poker.card.HandRank;

import java.util.*;

public class Hand {

    //Why final?
    private final List<Card> hand;

    public Hand() {
        this.hand = new ArrayList<>();
    }

    public HandRank evaluate() {
        if (hasDuplicates(hand)) {
            //Здесь есть смысл создать свой Exception и использовать его
            throw new IllegalArgumentException("The hand has duplicates.");
        }

        //Магическая константа
        //https://ru.wikipedia.org/wiki/Магическое_число_(программирование)
        if (hand.size() != 5) {
            throw new IllegalArgumentException("Incorrect hand size.");
        }

        //Почему здесь не цикл?
        Card c1 = hand.get(0);
        Card c2 = hand.get(1);
        Card c3 = hand.get(2);
        Card c4 = hand.get(3);
        Card c5 = hand.get(4);

        return HandEvaluate.getRank(c1, c2, c3, c4, c5);
    }

    private static boolean hasDuplicates(List<Card> hand) {
//        Можно упростить, если будет equals и hashcode в карте
//        Set<Card> cardSet = new HashSet<>(hand);
//        return cardSet.size() == hand.size();

        List<Integer> array = new ArrayList<>();

        for (Card card : hand) {
            array.add(card.getValue());
        }

        Collections.sort(array);

        for (int i = 0; i < array.size() - 1; i++) {
            if (array.get(i).equals(array.get(i + 1))) {
                return true;
            }
        }

        return false;
    }


    public String toString() {
        return hand.toString();
    }

    //Неиспользуемый код
    public String getFullName() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < hand.size(); i++) {
            result.append(i + 1);
            result.append(" card -- ");
            String card = hand.get(i).getFullName();
            result.append(card);
            result.append("\n");
        }

        return result.toString().strip();
    }


    //Зачем? Чтобы не передали null?
    public void add(Card c) {
        if (c != null) {
            hand.add(c);
        } else {
            throw new IllegalArgumentException("Card is null.");
        }
    }

    //Странный метод, не используется и суть его не очень ясна
    public void add(List<Card> cards) {
        for (Card card : cards) {
            if (card != null) {
                hand.add(card);
            } else {
                throw new IllegalArgumentException("Card is null.");
            }
        }
    }

    // Ненужные методы, нарушают инкапсуляцию
    public void clear() {
        hand.clear();
    }

    public int size() {
        return hand.size();
    }
}
