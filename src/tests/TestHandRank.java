package tests;

import kz.mathncode.baizhumanovalisher.poker.Hand.Hand;
import kz.mathncode.baizhumanovalisher.poker.Hand.HandRank;
import kz.mathncode.baizhumanovalisher.poker.card.Card;
import kz.mathncode.baizhumanovalisher.poker.card.Face;
import kz.mathncode.baizhumanovalisher.poker.card.Suit;

import static tests.Test.FAILED;
import static tests.Test.PASSED;

public class TestHandRank {
    private static void testClassicHandRank(HandRank rank, Card c1, Card c2, Card c3, Card c4, Card c5) {
        Hand hand = new Hand();

        hand.add(c1);
        hand.add(c2);
        hand.add(c3);
        hand.add(c4);
        hand.add(c5);

        boolean result = hand.evaluate().getRank() == rank;

        String test = String.format("Test %-15s - %s", rank.toString(), result ? PASSED : FAILED);

        System.out.println(test);
    }

    public static void testAllClassicHandRank() {
        System.out.println("Test hand rank");

        testClassicHandRank(HandRank.STRAIGHT_FLUSH,
                new Card(Face.ACE, Suit.CLUB),
                new Card(Face.KING, Suit.CLUB),
                new Card(Face.QUEEN, Suit.CLUB),
                new Card(Face.JACK, Suit.CLUB),
                new Card(Face.TEN, Suit.CLUB));

        testClassicHandRank(HandRank.FOUR_OF_A_KIND,
                new Card(Face.ACE, Suit.CLUB),
                new Card(Face.ACE, Suit.SPADE),
                new Card(Face.ACE, Suit.DIAMOND),
                new Card(Face.ACE, Suit.HEART),
                new Card(Face.DEUCE, Suit.DIAMOND));

        testClassicHandRank(HandRank.FULL_HOUSE,
                new Card(Face.ACE, Suit.CLUB),
                new Card(Face.ACE, Suit.SPADE),
                new Card(Face.ACE, Suit.DIAMOND),
                new Card(Face.DEUCE, Suit.HEART),
                new Card(Face.DEUCE, Suit.DIAMOND));

        testClassicHandRank(HandRank.FLUSH,
                new Card(Face.ACE, Suit.CLUB),
                new Card(Face.TEN, Suit.CLUB),
                new Card(Face.FIVE, Suit.CLUB),
                new Card(Face.JACK, Suit.CLUB),
                new Card(Face.DEUCE, Suit.CLUB));

        testClassicHandRank(HandRank.STRAIGHT,
                new Card(Face.ACE, Suit.CLUB),
                new Card(Face.KING, Suit.CLUB),
                new Card(Face.QUEEN, Suit.SPADE),
                new Card(Face.JACK, Suit.SPADE),
                new Card(Face.TEN, Suit.CLUB));

        testClassicHandRank(HandRank.THREE_OF_A_KIND,
                new Card(Face.ACE, Suit.CLUB),
                new Card(Face.ACE, Suit.SPADE),
                new Card(Face.ACE, Suit.DIAMOND),
                new Card(Face.DEUCE, Suit.HEART),
                new Card(Face.TEN, Suit.DIAMOND));

        testClassicHandRank(HandRank.TWO_PAIR,
                new Card(Face.TEN, Suit.CLUB),
                new Card(Face.ACE, Suit.SPADE),
                new Card(Face.ACE, Suit.DIAMOND),
                new Card(Face.DEUCE, Suit.HEART),
                new Card(Face.DEUCE, Suit.DIAMOND));

        testClassicHandRank(HandRank.ONE_PAIR,
                new Card(Face.ACE, Suit.CLUB),
                new Card(Face.JACK, Suit.SPADE),
                new Card(Face.TEN, Suit.DIAMOND),
                new Card(Face.DEUCE, Suit.HEART),
                new Card(Face.DEUCE, Suit.DIAMOND));

        testClassicHandRank(HandRank.HIGH_CARD,
                new Card(Face.ACE, Suit.CLUB),
                new Card(Face.JACK, Suit.SPADE),
                new Card(Face.TEN, Suit.DIAMOND),
                new Card(Face.FOUR, Suit.HEART),
                new Card(Face.DEUCE, Suit.DIAMOND));

        System.out.println("=============================\n");
    }
}
