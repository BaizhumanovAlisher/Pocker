package kz.mathncode.baizhumanovalisher.poker.hand.evaluate;

import kz.mathncode.baizhumanovalisher.poker.card.Card;
import kz.mathncode.baizhumanovalisher.poker.card.Face;
import kz.mathncode.baizhumanovalisher.poker.card.Suit;
import kz.mathncode.baizhumanovalisher.poker.hand.Hand;
import kz.mathncode.baizhumanovalisher.poker.hand.HandRank;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandEvaluateTest {
    static void testClassicHandEvaluate7CardHand(HandRank rank, Card c1, Card c2, Card c3, Card c4, Card c5, Card c6, Card c7) {
        Hand hand = new Hand();

        hand.add(c1);
        hand.add(c2);
        hand.add(c3);
        hand.add(c4);
        hand.add(c5);
        hand.add(c6);
        hand.add(c7);

        assertEquals(rank, hand.evaluate().getRank());
    }

    @Test
    void testHandEvaluate7CardHandStraightFlush() {
        testClassicHandEvaluate7CardHand(HandRank.STRAIGHT_FLUSH,
                new Card(Face.KING, Suit.CLUB),
                new Card(Face.QUEEN, Suit.CLUB),
                new Card(Face.JACK, Suit.CLUB),
                new Card(Face.TEN, Suit.CLUB),
                new Card(Face.NINE, Suit.CLUB),
                new Card(Face.KING, Suit.DIAMOND),
                new Card(Face.KING, Suit.HEART));
    }

    @Test
    void testHandEvaluate7CardHandFourOfAKind() {
        testClassicHandEvaluate7CardHand(HandRank.FOUR_OF_A_KIND,
                new Card(Face.KING, Suit.CLUB),
                new Card(Face.KING, Suit.SPADE),
                new Card(Face.KING, Suit.DIAMOND),
                new Card(Face.KING, Suit.HEART),
                new Card(Face.NINE, Suit.CLUB),
                new Card(Face.NINE, Suit.SPADE),
                new Card(Face.NINE, Suit.DIAMOND));
    }

    @Test
    void testHandEvaluate7CardHandFullHouse() {
        testClassicHandEvaluate7CardHand(HandRank.FULL_HOUSE,
                new Card(Face.KING, Suit.CLUB),
                new Card(Face.KING, Suit.SPADE),
                new Card(Face.KING, Suit.DIAMOND),
                new Card(Face.DEUCE, Suit.HEART),
                new Card(Face.NINE, Suit.CLUB),
                new Card(Face.NINE, Suit.SPADE),
                new Card(Face.NINE, Suit.DIAMOND));
    }

    @Test
    void testHandEvaluate7CardHandFlush() {
        testClassicHandEvaluate7CardHand(HandRank.FLUSH,
                new Card(Face.ACE, Suit.CLUB),
                new Card(Face.QUEEN, Suit.CLUB),
                new Card(Face.TEN, Suit.CLUB),
                new Card(Face.EIGHT, Suit.CLUB),
                new Card(Face.SIX, Suit.CLUB),
                new Card(Face.TEN, Suit.DIAMOND),
                new Card(Face.NINE, Suit.DIAMOND));
    }

    @Test
    void testHandEvaluate7CardHandStraight() {
        testClassicHandEvaluate7CardHand(HandRank.STRAIGHT,
                new Card(Face.ACE, Suit.HEART),
                new Card(Face.KING, Suit.CLUB),
                new Card(Face.QUEEN, Suit.CLUB),
                new Card(Face.JACK, Suit.CLUB),
                new Card(Face.TEN, Suit.CLUB),
                new Card(Face.ACE, Suit.DIAMOND),
                new Card(Face.ACE, Suit.SPADE));
    }

    @Test
    void testHandEvaluate7CardHandThreeOfAKind() {
        testClassicHandEvaluate7CardHand(HandRank.THREE_OF_A_KIND,
                new Card(Face.QUEEN, Suit.CLUB),
                new Card(Face.DEUCE, Suit.HEART),
                new Card(Face.TEN, Suit.CLUB),
                new Card(Face.EIGHT, Suit.HEART),
                new Card(Face.ACE, Suit.DIAMOND),
                new Card(Face.ACE, Suit.SPADE),
                new Card(Face.ACE, Suit.HEART));
    }


    @Test
    void testHandEvaluate7CardHandTwoPair() {
        testClassicHandEvaluate7CardHand(HandRank.TWO_PAIR,
                new Card(Face.QUEEN, Suit.CLUB),
                new Card(Face.QUEEN, Suit.HEART),
                new Card(Face.EIGHT, Suit.CLUB),
                new Card(Face.EIGHT, Suit.HEART),
                new Card(Face.DEUCE, Suit.DIAMOND),
                new Card(Face.TREY, Suit.SPADE),
                new Card(Face.ACE, Suit.HEART));
    }

    @Test
    void testHandEvaluate7CardHandOnePair() {
        testClassicHandEvaluate7CardHand(HandRank.ONE_PAIR,
                new Card(Face.QUEEN, Suit.CLUB),
                new Card(Face.QUEEN, Suit.HEART),
                new Card(Face.EIGHT, Suit.CLUB),
                new Card(Face.JACK, Suit.HEART),
                new Card(Face.DEUCE, Suit.DIAMOND),
                new Card(Face.TREY, Suit.SPADE),
                new Card(Face.ACE, Suit.HEART));
    }

    @Test
    void testHandEvaluate7CardHandHighCard() {
        testClassicHandEvaluate7CardHand(HandRank.HIGH_CARD,
                new Card(Face.QUEEN, Suit.CLUB),
                new Card(Face.FOUR, Suit.HEART),
                new Card(Face.EIGHT, Suit.CLUB),
                new Card(Face.JACK, Suit.HEART),
                new Card(Face.DEUCE, Suit.DIAMOND),
                new Card(Face.TREY, Suit.SPADE),
                new Card(Face.ACE, Suit.HEART));
    }
}
