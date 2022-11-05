package kz.mathncode.baizhumanovalisher.poker.hand.evaluate;

import kz.mathncode.baizhumanovalisher.poker.card.Card;
import kz.mathncode.baizhumanovalisher.poker.card.Face;
import kz.mathncode.baizhumanovalisher.poker.card.Suit;
import kz.mathncode.baizhumanovalisher.poker.hand.Hand;
import kz.mathncode.baizhumanovalisher.poker.hand.HandRank;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RankTest {
    static void testClassicHandRank(HandRank rank, Card c1, Card c2, Card c3, Card c4, Card c5) {
        Hand hand = new Hand();

        hand.add(c1);
        hand.add(c2);
        hand.add(c3);
        hand.add(c4);
        hand.add(c5);

        assertEquals(rank, hand.evaluate().getRank());
    }

    @Test
    void testHandRankStraightFlush() {
        testClassicHandRank(HandRank.STRAIGHT_FLUSH,
                new Card(Face.ACE, Suit.CLUB),
                new Card(Face.KING, Suit.CLUB),
                new Card(Face.QUEEN, Suit.CLUB),
                new Card(Face.JACK, Suit.CLUB),
                new Card(Face.TEN, Suit.CLUB));
    }

    @Test
    void testHandRankFourOfAKind() {
        testClassicHandRank(HandRank.FOUR_OF_A_KIND,
            new Card(Face.ACE, Suit.CLUB),
            new Card(Face.ACE, Suit.SPADE),
            new Card(Face.ACE, Suit.DIAMOND),
            new Card(Face.ACE, Suit.HEART),
            new Card(Face.DEUCE, Suit.DIAMOND));
    }

    @Test
    void testHandRankFullHouse() {
        testClassicHandRank(HandRank.FULL_HOUSE,
                new Card(Face.ACE, Suit.CLUB),
                new Card(Face.ACE, Suit.SPADE),
                new Card(Face.ACE, Suit.DIAMOND),
                new Card(Face.DEUCE, Suit.HEART),
                new Card(Face.DEUCE, Suit.DIAMOND));
    }

    @Test
    void testHandRankFlush() {
        testClassicHandRank(HandRank.FLUSH,
                new Card(Face.ACE, Suit.CLUB),
                new Card(Face.TEN, Suit.CLUB),
                new Card(Face.FIVE, Suit.CLUB),
                new Card(Face.JACK, Suit.CLUB),
                new Card(Face.DEUCE, Suit.CLUB));
    }

    @Test
    void testHandRankStraight() {
        testClassicHandRank(HandRank.STRAIGHT,
                new Card(Face.ACE, Suit.CLUB),
                new Card(Face.KING, Suit.CLUB),
                new Card(Face.QUEEN, Suit.SPADE),
                new Card(Face.JACK, Suit.SPADE),
                new Card(Face.TEN, Suit.CLUB));
    }

    @Test
    void testHandRankThreeOfAKind() {
        testClassicHandRank(HandRank.THREE_OF_A_KIND,
                new Card(Face.ACE, Suit.CLUB),
                new Card(Face.ACE, Suit.SPADE),
                new Card(Face.ACE, Suit.DIAMOND),
                new Card(Face.DEUCE, Suit.HEART),
                new Card(Face.TEN, Suit.DIAMOND));
    }

    @Test
    void testHandRankTwoPair() {
        testClassicHandRank(HandRank.TWO_PAIR,
                new Card(Face.TEN, Suit.CLUB),
                new Card(Face.ACE, Suit.SPADE),
                new Card(Face.ACE, Suit.DIAMOND),
                new Card(Face.DEUCE, Suit.HEART),
                new Card(Face.DEUCE, Suit.DIAMOND));
    }

    @Test
    void testHandRankOnePair() {
        testClassicHandRank(HandRank.ONE_PAIR,
                new Card(Face.ACE, Suit.CLUB),
                new Card(Face.JACK, Suit.SPADE),
                new Card(Face.TEN, Suit.DIAMOND),
                new Card(Face.DEUCE, Suit.HEART),
                new Card(Face.DEUCE, Suit.DIAMOND));
    }

    @Test
    void testHadRankHighCard() {
        testClassicHandRank(HandRank.HIGH_CARD,
                new Card(Face.ACE, Suit.CLUB),
                new Card(Face.JACK, Suit.SPADE),
                new Card(Face.TEN, Suit.DIAMOND),
                new Card(Face.FOUR, Suit.HEART),
                new Card(Face.DEUCE, Suit.DIAMOND));
    }
}