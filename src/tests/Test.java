package tests;

import kz.mathncode.baizhumanovalisher.poker.Hand;
import kz.mathncode.baizhumanovalisher.poker.card.Card;
import kz.mathncode.baizhumanovalisher.poker.card.Face;
import kz.mathncode.baizhumanovalisher.poker.card.HandRank;
import kz.mathncode.baizhumanovalisher.poker.card.Suit;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();

        test.testAllClassicHandRank();
    }

    //Вместо number лучше использовать String -- описание теста
    private void testClassicHandRank(int testNumber, HandRank rank, Card c1, Card c2, Card c3, Card c4, Card c5) {
        Hand hand = new Hand();

        hand.add(c1);
        hand.add(c2);
        hand.add(c3);
        hand.add(c4);
        hand.add(c5);

        boolean result = hand.evaluate().equals(rank);

        String test = String.format("Test %d - %s", testNumber, result ? "PASSED" : "FAILED");

        System.out.println(test);
    }

    //Только позитивные кейсы, не хватает отрицательных
    private void testAllClassicHandRank() {
        testClassicHandRank(1, HandRank.STRAIGHT_FLUSH,
                new Card(Face.ACE, Suit.CLUB),
                new Card(Face.KING, Suit.CLUB),
                new Card(Face.QUEEN, Suit.CLUB),
                new Card(Face.JACK, Suit.CLUB),
                new Card(Face.TEN, Suit.CLUB));

        testClassicHandRank(2, HandRank.FOUR_OF_A_KIND,
                new Card(Face.ACE, Suit.CLUB),
                new Card(Face.ACE, Suit.SPADE),
                new Card(Face.ACE, Suit.DIAMOND),
                new Card(Face.ACE, Suit.HEART),
                new Card(Face.DEUCE, Suit.DIAMOND));

        testClassicHandRank(3, HandRank.FULL_HOUSE,
                new Card(Face.ACE, Suit.CLUB),
                new Card(Face.ACE, Suit.SPADE),
                new Card(Face.ACE, Suit.DIAMOND),
                new Card(Face.DEUCE, Suit.HEART),
                new Card(Face.DEUCE, Suit.DIAMOND));

        testClassicHandRank(4, HandRank.FLUSH,
                new Card(Face.ACE, Suit.CLUB),
                new Card(Face.TEN, Suit.CLUB),
                new Card(Face.FIVE, Suit.CLUB),
                new Card(Face.JACK, Suit.CLUB),
                new Card(Face.DEUCE, Suit.CLUB));

        testClassicHandRank(5, HandRank.STRAIGHT,
                new Card(Face.ACE, Suit.CLUB),
                new Card(Face.KING, Suit.CLUB),
                new Card(Face.QUEEN, Suit.SPADE),
                new Card(Face.JACK, Suit.SPADE),
                new Card(Face.TEN, Suit.CLUB));

        testClassicHandRank(6, HandRank.THREE_OF_A_KIND,
                new Card(Face.ACE, Suit.CLUB),
                new Card(Face.ACE, Suit.SPADE),
                new Card(Face.ACE, Suit.DIAMOND),
                new Card(Face.DEUCE, Suit.HEART),
                new Card(Face.TEN, Suit.DIAMOND));

        testClassicHandRank(7, HandRank.TWO_PAIR,
                new Card(Face.TEN, Suit.CLUB),
                new Card(Face.ACE, Suit.SPADE),
                new Card(Face.ACE, Suit.DIAMOND),
                new Card(Face.DEUCE, Suit.HEART),
                new Card(Face.DEUCE, Suit.DIAMOND));

        testClassicHandRank(8, HandRank.ONE_PAIR,
                new Card(Face.ACE, Suit.CLUB),
                new Card(Face.JACK, Suit.SPADE),
                new Card(Face.TEN, Suit.DIAMOND),
                new Card(Face.DEUCE, Suit.HEART),
                new Card(Face.DEUCE, Suit.DIAMOND));

        testClassicHandRank(9, HandRank.HIGH_CARD,
                new Card(Face.ACE, Suit.CLUB),
                new Card(Face.JACK, Suit.SPADE),
                new Card(Face.TEN, Suit.DIAMOND),
                new Card(Face.FOUR, Suit.HEART),
                new Card(Face.DEUCE, Suit.DIAMOND));

    }
}
