package tests;

import kz.mathncode.baizhumanovalisher.poker.hand.Hand;
import kz.mathncode.baizhumanovalisher.poker.card.Card;
import kz.mathncode.baizhumanovalisher.poker.card.Face;
import kz.mathncode.baizhumanovalisher.poker.card.Suit;

import static tests.Test.FAILED;
import static tests.Test.PASSED;

public class TestHandComparison {
    public static void testAllHandsComparison() {
        System.out.println("Test hand comparison");

        testHandsComparisonDifferentRanks();
        testHandsComparisonHighCard();
        testHandsComparisonOnePair();
        testHandsComparisonTwoPair();
        testHandsComparisonThreeOfAKind();
        testHandsComparisonStraight();
        testHandsComparisonFlush();
        testHandsComparisonFullHouse();
        testHandsComparisonFourOfAKind();
        testHandsComparisonStraightFlush();

        System.out.println("=============================\n");
    }

    private static void testHandsComparisonDifferentRanks() {
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

        testHandsComparison("different ranks", hand, hand, hand1);
        System.out.println();
    }

    private static void testHandsComparisonStraightFlush() {
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

        testHandsComparison("straight flush 1", null, hand, hand1);

        Hand hand2 = new Hand(
                new Card(Face.NINE, Suit.DIAMOND),
                new Card(Face.KING, Suit.DIAMOND),
                new Card(Face.QUEEN, Suit.DIAMOND),
                new Card(Face.JACK, Suit.DIAMOND),
                new Card(Face.TEN, Suit.DIAMOND)
        );

        testHandsComparison("straight flush 2", hand, hand, hand2);
    }

    private static void testHandsComparisonFourOfAKind() {
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

        testHandsComparison("four of a kind", hand, hand, hand1);
        System.out.println();
    }

    private static void testHandsComparisonFullHouse() {
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

        testHandsComparison("full house", hand, hand, hand1);
        System.out.println();
    }

    private static void testHandsComparisonFlush() {
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

        testHandsComparison("flush 1", null, hand, hand1);

        Hand hand2 = new Hand(
                new Card(Face.SIX, Suit.DIAMOND),
                new Card(Face.TEN, Suit.DIAMOND),
                new Card(Face.ACE, Suit.DIAMOND),
                new Card(Face.EIGHT, Suit.DIAMOND),
                new Card(Face.SEVEN, Suit.DIAMOND)
        );

        testHandsComparison("flush 2", hand, hand, hand2);
        System.out.println();
    }

    private static void testHandsComparisonStraight() {
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

        testHandsComparison("straight 1", null, hand, hand1);

        Hand hand2 = new Hand(
                new Card(Face.SIX, Suit.DIAMOND),
                new Card(Face.TEN, Suit.DIAMOND),
                new Card(Face.NINE, Suit.DIAMOND),
                new Card(Face.EIGHT, Suit.DIAMOND),
                new Card(Face.SEVEN, Suit.SPADE)
        );

        testHandsComparison("straight 2", hand, hand, hand2);
        System.out.println();
    }

    private static void testHandsComparisonThreeOfAKind() {
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

        testHandsComparison("three of a kind", hand, hand, hand1);
        System.out.println();
    }

    private static void testHandsComparisonTwoPair() {
        Hand hand1 = new Hand(
                new Card(Face.EIGHT, Suit.HEART),
                new Card(Face.EIGHT, Suit.DIAMOND),
                new Card(Face.JACK, Suit.HEART),
                new Card(Face.JACK, Suit.DIAMOND),
                new Card(Face.KING, Suit.DIAMOND)
        );

        Hand hand2 = new Hand(
                new Card(Face.EIGHT, Suit.CLUB),
                new Card(Face.EIGHT, Suit.SPADE),
                new Card(Face.JACK, Suit.SPADE),
                new Card(Face.JACK, Suit.CLUB),
                new Card(Face.KING, Suit.CLUB)
        );
        
        testHandsComparison("two pair 1", null, hand1, hand2);

        Hand hand3 = new Hand(
                new Card(Face.EIGHT, Suit.CLUB),
                new Card(Face.EIGHT, Suit.SPADE),
                new Card(Face.JACK, Suit.SPADE),
                new Card(Face.JACK, Suit.CLUB),
                new Card(Face.TEN, Suit.CLUB));

        testHandsComparison("two pair 2", hand1, hand1, hand3);

        Hand hand4 = new Hand(
                new Card(Face.SEVEN, Suit.CLUB),
                new Card(Face.SEVEN, Suit.SPADE),
                new Card(Face.JACK, Suit.SPADE),
                new Card(Face.JACK, Suit.CLUB),
                new Card(Face.QUEEN, Suit.CLUB));

        testHandsComparison("two pair 3", hand1, hand1, hand4);

        Hand hand5 = new Hand(
                new Card(Face.EIGHT, Suit.CLUB),
                new Card(Face.EIGHT, Suit.SPADE),
                new Card(Face.TEN, Suit.SPADE),
                new Card(Face.TEN, Suit.CLUB),
                new Card(Face.KING, Suit.CLUB)
        );

        testHandsComparison("two pair 4", hand1, hand1, hand5);
        System.out.println();
    }

    private static void testHandsComparisonOnePair() {
        Hand hand1 = new Hand(
                new Card(Face.KING, Suit.DIAMOND),
                new Card(Face.TEN, Suit.HEART),
                new Card(Face.FIVE, Suit.DIAMOND),
                new Card(Face.KING, Suit.SPADE),
                new Card(Face.TREY, Suit.CLUB));

        Hand hand2 = new Hand(
                new Card(Face.DEUCE, Suit.HEART),
                new Card(Face.EIGHT, Suit.HEART),
                new Card(Face.KING, Suit.CLUB),
                new Card(Face.FIVE, Suit.SPADE),
                new Card(Face.KING, Suit.HEART));

        testHandsComparison("one pair 1", hand1, hand1, hand2);

        Hand hand11 = new Hand(
                new Card(Face.KING, Suit.DIAMOND),
                new Card(Face.TEN, Suit.HEART),
                new Card(Face.FIVE, Suit.DIAMOND),
                new Card(Face.KING, Suit.SPADE),
                new Card(Face.TREY, Suit.CLUB));

        Hand hand12 = new Hand(
                new Card(Face.DEUCE, Suit.HEART),
                new Card(Face.EIGHT, Suit.HEART),
                new Card(Face.JACK, Suit.CLUB),
                new Card(Face.FIVE, Suit.SPADE),
                new Card(Face.JACK, Suit.DIAMOND));

        testHandsComparison("one pair 2", hand11, hand11, hand12);
        System.out.println();
    }

    private static void testHandsComparisonHighCard() {
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

        testHandsComparison("high card", hand1, hand1, hand2);
        System.out.println();
    }

    private static void testHandsComparison(String testInfo, Hand winnerHand, Hand hand1, Hand hand2) {
        boolean result = Hand.chooseStrongHand(hand1, hand2) == winnerHand;

        String test = String.format("Test %-15s - %s", testInfo, result ? PASSED : FAILED);

        System.out.println(test);
    }
}
