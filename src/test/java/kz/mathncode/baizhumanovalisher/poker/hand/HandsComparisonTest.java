package kz.mathncode.baizhumanovalisher.poker.hand;

import kz.mathncode.baizhumanovalisher.poker.card.Card;
import kz.mathncode.baizhumanovalisher.poker.card.Face;
import kz.mathncode.baizhumanovalisher.poker.card.Suit;
import kz.mathncode.baizhumanovalisher.poker.exceptions.HandHasDuplicatesException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandsComparisonTest {
    static void testHandsComparison(Hand winnerHand, Hand hand1, Hand hand2) {
        Hand strongerHand = HandsComparison.chooseStrongHand(hand1, hand2);
        assertEquals(winnerHand, strongerHand);
    }

    @Test
    void testHandsComparisonHandHasDuplicatesException1() {
        Hand hand1 = new Hand();

        hand1.add(new Card(Face.DEUCE, Suit.CLUB));
        hand1.add(new Card(Face.TREY, Suit.CLUB));
        hand1.add(new Card(Face.FOUR, Suit.CLUB));
        hand1.add(new Card(Face.FIVE, Suit.CLUB));
        hand1.add(new Card(Face.SIX, Suit.CLUB));

        Hand hand2 = new Hand();

        hand2.add(new Card(Face.DEUCE, Suit.CLUB));
        hand2.add(new Card(Face.TREY, Suit.DIAMOND));
        hand2.add(new Card(Face.FOUR, Suit.DIAMOND));
        hand2.add(new Card(Face.FIVE, Suit.DIAMOND));
        hand2.add(new Card(Face.SIX, Suit.DIAMOND));

        assertThrows(HandHasDuplicatesException.class, () -> HandsComparison.chooseStrongHand(hand1, hand2));
    }

    @Test
    void testHandsComparisonHandHasDuplicatesException2() {
        Hand hand1 = new Hand();

        hand1.add(new Card(Face.DEUCE, Suit.CLUB));
        hand1.add(new Card(Face.TREY, Suit.CLUB));
        hand1.add(new Card(Face.FOUR, Suit.CLUB));
        hand1.add(new Card(Face.FIVE, Suit.CLUB));
        hand1.add(new Card(Face.SIX, Suit.HEART));

        Hand hand2 = new Hand();

        hand2.add(new Card(Face.DEUCE, Suit.DIAMOND));
        hand2.add(new Card(Face.TREY, Suit.DIAMOND));
        hand2.add(new Card(Face.FOUR, Suit.DIAMOND));
        hand2.add(new Card(Face.FIVE, Suit.DIAMOND));
        hand2.add(new Card(Face.SIX, Suit.HEART));

        assertThrows(HandHasDuplicatesException.class, () -> HandsComparison.chooseStrongHand(hand1, hand2));
    }

    @Test
    void testHandsComparisonDifferentRanks() {
        Hand hand = new Hand(
                new Card(Face.KING, Suit.HEART),
                new Card(Face.KING, Suit.CLUB),
                new Card(Face.KING, Suit.DIAMOND),
                new Card(Face.KING, Suit.SPADE),
                new Card(Face.EIGHT, Suit.CLUB));

        Hand hand1 = new Hand(
                new Card(Face.QUEEN, Suit.HEART),
                new Card(Face.QUEEN, Suit.CLUB),
                new Card(Face.QUEEN, Suit.DIAMOND),
                new Card(Face.TEN, Suit.HEART),
                new Card(Face.EIGHT, Suit.HEART));

        testHandsComparison(hand, hand, hand1);
    }

    @Test
    void testHandsComparisonStraightFlush() {
        Hand hand = new Hand(
                new Card(Face.ACE, Suit.CLUB),
                new Card(Face.KING, Suit.CLUB),
                new Card(Face.QUEEN, Suit.CLUB),
                new Card(Face.JACK, Suit.CLUB),
                new Card(Face.TEN, Suit.CLUB)
        );

        Hand hand1 = new Hand(
                new Card(Face.ACE, Suit.DIAMOND),
                new Card(Face.KING, Suit.DIAMOND),
                new Card(Face.QUEEN, Suit.DIAMOND),
                new Card(Face.JACK, Suit.DIAMOND),
                new Card(Face.TEN, Suit.DIAMOND)
        );

        testHandsComparison(null, hand, hand1);

        Hand hand2 = new Hand(
                new Card(Face.KING, Suit.DIAMOND),
                new Card(Face.QUEEN, Suit.DIAMOND),
                new Card(Face.JACK, Suit.DIAMOND),
                new Card(Face.TEN, Suit.DIAMOND),
                new Card(Face.NINE, Suit.DIAMOND)
        );

        testHandsComparison(hand, hand, hand2);
    }

    @Test
    void testHandsComparisonFourOfAKind() {
        Hand hand = new Hand(
                new Card(Face.KING, Suit.HEART),
                new Card(Face.KING, Suit.CLUB),
                new Card(Face.KING, Suit.DIAMOND),
                new Card(Face.KING, Suit.SPADE),
                new Card(Face.EIGHT, Suit.CLUB));

        Hand hand1 = new Hand(
                new Card(Face.QUEEN, Suit.HEART),
                new Card(Face.QUEEN, Suit.CLUB),
                new Card(Face.QUEEN, Suit.DIAMOND),
                new Card(Face.QUEEN, Suit.SPADE),
                new Card(Face.EIGHT, Suit.HEART));

        testHandsComparison(hand, hand, hand1);
    }

    @Test
    void testHandsComparisonFullHouse() {
        Hand hand = new Hand(
                new Card(Face.KING, Suit.HEART),
                new Card(Face.KING, Suit.CLUB),
                new Card(Face.KING, Suit.DIAMOND),
                new Card(Face.EIGHT, Suit.SPADE),
                new Card(Face.EIGHT, Suit.CLUB));

        Hand hand1 = new Hand(
                new Card(Face.QUEEN, Suit.HEART),
                new Card(Face.QUEEN, Suit.CLUB),
                new Card(Face.QUEEN, Suit.DIAMOND),
                new Card(Face.EIGHT, Suit.DIAMOND),
                new Card(Face.EIGHT, Suit.HEART));

        testHandsComparison(hand, hand, hand1);
    }

    @Test
    void testHandsComparisonFlush() {
        Hand hand = new Hand(
                new Card(Face.JACK, Suit.CLUB),
                new Card(Face.TEN, Suit.CLUB),
                new Card(Face.ACE, Suit.CLUB),
                new Card(Face.EIGHT, Suit.CLUB),
                new Card(Face.SEVEN, Suit.CLUB)
        );

        Hand hand1 = new Hand(
                new Card(Face.JACK, Suit.DIAMOND),
                new Card(Face.TEN, Suit.DIAMOND),
                new Card(Face.ACE, Suit.DIAMOND),
                new Card(Face.EIGHT, Suit.DIAMOND),
                new Card(Face.SEVEN, Suit.DIAMOND)
        );

        testHandsComparison(null, hand, hand1);

        Hand hand2 = new Hand(
                new Card(Face.SIX, Suit.DIAMOND),
                new Card(Face.TEN, Suit.DIAMOND),
                new Card(Face.ACE, Suit.DIAMOND),
                new Card(Face.EIGHT, Suit.DIAMOND),
                new Card(Face.SEVEN, Suit.DIAMOND)
        );

        testHandsComparison(hand, hand, hand2);
    }

    @Test
    void testHandsComparisonStraight() {
        Hand hand = new Hand(
                new Card(Face.JACK, Suit.CLUB),
                new Card(Face.TEN, Suit.CLUB),
                new Card(Face.NINE, Suit.CLUB),
                new Card(Face.EIGHT, Suit.CLUB),
                new Card(Face.SEVEN, Suit.HEART)
        );

        Hand hand1 = new Hand(
                new Card(Face.JACK, Suit.DIAMOND),
                new Card(Face.TEN, Suit.DIAMOND),
                new Card(Face.NINE, Suit.DIAMOND),
                new Card(Face.EIGHT, Suit.DIAMOND),
                new Card(Face.SEVEN, Suit.SPADE)
        );

        testHandsComparison(null, hand, hand1);

        Hand hand2 = new Hand(
                new Card(Face.SIX, Suit.DIAMOND),
                new Card(Face.TEN, Suit.DIAMOND),
                new Card(Face.NINE, Suit.DIAMOND),
                new Card(Face.EIGHT, Suit.DIAMOND),
                new Card(Face.SEVEN, Suit.SPADE)
        );

        testHandsComparison(hand, hand, hand2);
    }

    @Test
    void testHandsComparisonThreeOfAKind() {
        Hand hand = new Hand(
                new Card(Face.KING, Suit.HEART),
                new Card(Face.KING, Suit.CLUB),
                new Card(Face.KING, Suit.DIAMOND),
                new Card(Face.TEN, Suit.CLUB),
                new Card(Face.EIGHT, Suit.CLUB));

        Hand hand1 = new Hand(
                new Card(Face.QUEEN, Suit.HEART),
                new Card(Face.QUEEN, Suit.CLUB),
                new Card(Face.QUEEN, Suit.DIAMOND),
                new Card(Face.TEN, Suit.HEART),
                new Card(Face.EIGHT, Suit.HEART));

        testHandsComparison(hand, hand, hand1);
    }

    @Test
    void testHandsComparisonTwoPair() {
        Hand hand = new Hand(
                new Card(Face.EIGHT, Suit.HEART),
                new Card(Face.EIGHT, Suit.DIAMOND),
                new Card(Face.JACK, Suit.HEART),
                new Card(Face.JACK, Suit.DIAMOND),
                new Card(Face.KING, Suit.DIAMOND)
        );

        Hand hand1 = new Hand(
                new Card(Face.EIGHT, Suit.CLUB),
                new Card(Face.EIGHT, Suit.SPADE),
                new Card(Face.JACK, Suit.SPADE),
                new Card(Face.JACK, Suit.CLUB),
                new Card(Face.KING, Suit.CLUB)
        );

        testHandsComparison(null, hand, hand1);

        Hand hand2 = new Hand(
                new Card(Face.EIGHT, Suit.CLUB),
                new Card(Face.EIGHT, Suit.SPADE),
                new Card(Face.JACK, Suit.SPADE),
                new Card(Face.JACK, Suit.CLUB),
                new Card(Face.TEN, Suit.CLUB));

        testHandsComparison(hand, hand, hand2);

        Hand hand3 = new Hand(
                new Card(Face.SEVEN, Suit.CLUB),
                new Card(Face.SEVEN, Suit.SPADE),
                new Card(Face.JACK, Suit.SPADE),
                new Card(Face.JACK, Suit.CLUB),
                new Card(Face.QUEEN, Suit.CLUB));

        testHandsComparison(hand, hand, hand3);

        Hand hand4 = new Hand(
                new Card(Face.EIGHT, Suit.CLUB),
                new Card(Face.EIGHT, Suit.SPADE),
                new Card(Face.TEN, Suit.SPADE),
                new Card(Face.TEN, Suit.CLUB),
                new Card(Face.KING, Suit.CLUB)
        );

        testHandsComparison(hand, hand, hand4);
    }

    @Test
    void testHandsComparisonOnePair() {
        Hand hand = new Hand(
                new Card(Face.KING, Suit.DIAMOND),
                new Card(Face.KING, Suit.SPADE),
                new Card(Face.TEN, Suit.HEART),
                new Card(Face.FIVE, Suit.DIAMOND),
                new Card(Face.TREY, Suit.CLUB));

        Hand hand1 = new Hand(
                new Card(Face.KING, Suit.HEART),
                new Card(Face.KING, Suit.CLUB),
                new Card(Face.TEN, Suit.DIAMOND),
                new Card(Face.FIVE, Suit.SPADE),
                new Card(Face.DEUCE, Suit.HEART));

        testHandsComparison(hand, hand, hand1);

        Hand hand2 = new Hand(
                new Card(Face.DEUCE, Suit.HEART),
                new Card(Face.EIGHT, Suit.HEART),
                new Card(Face.JACK, Suit.CLUB),
                new Card(Face.FIVE, Suit.SPADE),
                new Card(Face.JACK, Suit.DIAMOND));

        testHandsComparison(hand, hand, hand2);
    }

    @Test
    void testHandsComparisonHighCard() {
        Hand hand1 = new Hand(
                new Card(Face.KING, Suit.HEART),
                new Card(Face.TEN, Suit.HEART),
                new Card(Face.FIVE, Suit.DIAMOND),
                new Card(Face.JACK, Suit.SPADE),
                new Card(Face.TREY, Suit.CLUB));

        Hand hand2 = new Hand(
                new Card(Face.DEUCE, Suit.HEART),
                new Card(Face.EIGHT, Suit.HEART),
                new Card(Face.JACK, Suit.DIAMOND),
                new Card(Face.FIVE, Suit.SPADE),
                new Card(Face.KING, Suit.DIAMOND));

        testHandsComparison(hand1, hand1, hand2);
    }
}