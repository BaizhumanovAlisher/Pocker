package kz.mathncode.baizhumanovalisher.poker.hand.evaluate;

import kz.mathncode.baizhumanovalisher.poker.card.Card;
import kz.mathncode.baizhumanovalisher.poker.card.Face;
import kz.mathncode.baizhumanovalisher.poker.card.Suit;
import kz.mathncode.baizhumanovalisher.poker.hand.HandRank;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HandEvaluateTest {
    @Test
    void testHandEvaluate7CardHandStraightFlush() {
        List<Card> hand = new ArrayList<>();

        hand.add(new Card(Face.KING, Suit.CLUB));
        hand.add(new Card(Face.QUEEN, Suit.CLUB));
        hand.add(new Card(Face.JACK, Suit.CLUB));
        hand.add(new Card(Face.TEN, Suit.CLUB));
        hand.add(new Card(Face.NINE, Suit.CLUB));
        hand.add(new Card(Face.KING, Suit.DIAMOND));
        hand.add(new Card(Face.KING, Suit.HEART));

        HandRank result = HandEvaluate.evaluate(hand).getRank();

        assertEquals(HandRank.STRAIGHT_FLUSH, result);
    }

    @Test
    void testHandEvaluate7CardHandFourOfAKind() {
        List<Card> hand = new ArrayList<>();

        hand.add(new Card(Face.KING, Suit.CLUB));
        hand.add(new Card(Face.KING, Suit.SPADE));
        hand.add(new Card(Face.KING, Suit.DIAMOND));
        hand.add(new Card(Face.KING, Suit.HEART));
        hand.add(new Card(Face.NINE, Suit.CLUB));
        hand.add(new Card(Face.NINE, Suit.SPADE));
        hand.add(new Card(Face.NINE, Suit.DIAMOND));

        HandRank result = HandEvaluate.evaluate(hand).getRank();

        assertEquals(HandRank.FOUR_OF_A_KIND, result);
    }

    @Test
    void testHandEvaluate7CardHandFullHouse() {
        List<Card> hand = new ArrayList<>();

        hand.add(new Card(Face.KING, Suit.CLUB));
        hand.add(new Card(Face.KING, Suit.SPADE));
        hand.add(new Card(Face.KING, Suit.DIAMOND));
        hand.add(new Card(Face.DEUCE, Suit.HEART));
        hand.add(new Card(Face.NINE, Suit.CLUB));
        hand.add(new Card(Face.NINE, Suit.SPADE));
        hand.add(new Card(Face.NINE, Suit.DIAMOND));

        HandRank result = HandEvaluate.evaluate(hand).getRank();

        assertEquals(HandRank.FULL_HOUSE, result);
    }
}
