package kz.mathncode.baizhumanovalisher.poker.hand.evaluate;

import kz.mathncode.baizhumanovalisher.poker.card.Card;
import kz.mathncode.baizhumanovalisher.poker.card.Face;
import kz.mathncode.baizhumanovalisher.poker.card.Suit;
import kz.mathncode.baizhumanovalisher.poker.hand.Hand;
import org.junit.jupiter.api.Test;

import static kz.mathncode.baizhumanovalisher.poker.hand.evaluate.Value.separator;
import static org.junit.jupiter.api.Assertions.*;

class ValueTest {
    static void testClassicHandValue(int value, Card c1, Card c2, Card c3, Card c4, Card c5) {
        Hand hand = new Hand();

        hand.add(c1);
        hand.add(c2);
        hand.add(c3);
        hand.add(c4);
        hand.add(c5);

        assertEquals(value, hand.evaluate().getValue());
    }

    @Test
    void testHandValueHighCard() {
        Card c1 = new Card(Face.KING, Suit.CLUB);
        Card c2 = new Card(Face.QUEEN, Suit.CLUB);
        Card c3 = new Card(Face.JACK, Suit.CLUB);
        Card c4 = new Card(Face.FIVE, Suit.CLUB);
        Card c5 = new Card(Face.DEUCE, Suit.DIAMOND);

        int value = (int) (c1.getFace().getRank() * Math.pow(separator, 4) +
                c2.getFace().getRank() * Math.pow(separator, 3) +
                c3.getFace().getRank() * Math.pow(separator, 2) +
                c4.getFace().getRank() * Math.pow(separator, 1) +
                c5.getFace().getRank() * Math.pow(separator, 0));

        testClassicHandValue(value, c1, c2, c3, c4, c5);
    }

    @Test
    void testHandValueOnePair() {
        Card c1 = new Card(Face.KING, Suit.CLUB);
        Card c2 = new Card(Face.KING, Suit.DIAMOND);
        Card c3 = new Card(Face.JACK, Suit.CLUB);
        Card c4 = new Card(Face.FIVE, Suit.CLUB);
        Card c5 = new Card(Face.DEUCE, Suit.CLUB);

        int value = (int) (c1.getFace().getRank() * Math.pow(separator, 3) +
                c3.getFace().getRank() * Math.pow(separator, 2) +
                c4.getFace().getRank() * Math.pow(separator, 1) +
                c5.getFace().getRank() * Math.pow(separator, 0));

        testClassicHandValue(value, c1, c2, c3, c4, c5);
    }

    @Test
    void testHandValueTwoPair() {
        Card c1 = new Card(Face.KING, Suit.CLUB);
        Card c2 = new Card(Face.KING, Suit.DIAMOND);
        Card c3 = new Card(Face.JACK, Suit.CLUB);
        Card c4 = new Card(Face.JACK, Suit.DIAMOND);
        Card c5 = new Card(Face.DEUCE, Suit.CLUB);

        int value = (int) (c1.getFace().getRank() * Math.pow(separator, 2) +
                c3.getFace().getRank() * Math.pow(separator, 1) +
                c5.getFace().getRank() * Math.pow(separator, 0));

        testClassicHandValue(value, c1, c2, c3, c4, c5);
    }


    @Test
    void testHandValueThreeOfAKind() {
        Card c1 = new Card(Face.KING, Suit.CLUB);
        Card c2 = new Card(Face.KING, Suit.DIAMOND);
        Card c3 = new Card(Face.KING, Suit.HEART);
        Card c4 = new Card(Face.FIVE, Suit.CLUB);
        Card c5 = new Card(Face.DEUCE, Suit.CLUB);

        int value = (int) (c1.getFace().getRank() * Math.pow(separator, 2) +
                c4.getFace().getRank() * Math.pow(separator, 1) +
                c5.getFace().getRank() * Math.pow(separator, 0));

        testClassicHandValue(value, c1, c2, c3, c4, c5);
    }

    @Test
    void testHandValueStraight() {
        Card c1 = new Card(Face.KING, Suit.CLUB);
        Card c2 = new Card(Face.QUEEN, Suit.CLUB);
        Card c3 = new Card(Face.JACK, Suit.CLUB);
        Card c4 = new Card(Face.TEN, Suit.CLUB);
        Card c5 = new Card(Face.NINE, Suit.DIAMOND);

        int value = (int) (c1.getFace().getRank() * Math.pow(separator, 0));

        testClassicHandValue(value, c1, c2, c3, c4, c5);
    }

    @Test
    void testHandValueFlush() {
        Card c1 = new Card(Face.KING, Suit.CLUB);
        Card c2 = new Card(Face.QUEEN, Suit.CLUB);
        Card c3 = new Card(Face.JACK, Suit.CLUB);
        Card c4 = new Card(Face.TEN, Suit.CLUB);
        Card c5 = new Card(Face.EIGHT, Suit.CLUB);

        int value = (int) (c1.getFace().getRank() * Math.pow(separator, 4) +
                c2.getFace().getRank() * Math.pow(separator, 3) +
                c3.getFace().getRank() * Math.pow(separator, 2) +
                c4.getFace().getRank() * Math.pow(separator, 1) +
                c5.getFace().getRank() * Math.pow(separator, 0));

        testClassicHandValue(value, c1, c2, c3, c4, c5);
    }

    @Test
    void testHandValueFullHouse() {
        Card c1 = new Card(Face.KING, Suit.CLUB);
        Card c2 = new Card(Face.KING, Suit.DIAMOND);
        Card c3 = new Card(Face.KING, Suit.SPADE);
        Card c4 = new Card(Face.EIGHT, Suit.DIAMOND);
        Card c5 = new Card(Face.EIGHT, Suit.SPADE);

        int value = (int) (c1.getFace().getRank() * Math.pow(separator, 1) +
                c5.getFace().getRank() * Math.pow(separator, 0));

        testClassicHandValue(value, c1, c2, c3, c4, c5);
    }

    @Test
    void testHandValueFourOfAKind() {
        Card c1 = new Card(Face.KING, Suit.CLUB);
        Card c2 = new Card(Face.KING, Suit.DIAMOND);
        Card c3 = new Card(Face.KING, Suit.SPADE);
        Card c4 = new Card(Face.KING, Suit.HEART);
        Card c5 = new Card(Face.EIGHT, Suit.SPADE);

        int value = (int) (c1.getFace().getRank() * Math.pow(separator, 1) +
                c5.getFace().getRank() * Math.pow(separator, 0));

        testClassicHandValue(value, c1, c2, c3, c4, c5);
    }

    @Test
    void testHandValueStraightFlush() {
        Card c1 = new Card(Face.KING, Suit.CLUB);
        Card c2 = new Card(Face.QUEEN, Suit.CLUB);
        Card c3 = new Card(Face.JACK, Suit.CLUB);
        Card c4 = new Card(Face.TEN, Suit.CLUB);
        Card c5 = new Card(Face.NINE, Suit.CLUB);

        int value = (int) (c1.getFace().getRank() * Math.pow(separator, 0));

        testClassicHandValue(value, c1, c2, c3, c4, c5);
    }
}