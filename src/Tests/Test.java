package Tests;

import Main.Hand;
import Main.Card;
import Main.PokerData.Face;
import Main.PokerData.HandRank;
import Main.PokerData.Suit;

public class Test {
    public void test1() {
        Hand hand = new Hand();

        Card c1 = new Card(Face.ACE, Suit.CLUB);
        Card c2 = new Card(Face.KING, Suit.CLUB);
        Card c3 = new Card(Face.QUEEN, Suit.CLUB);
        Card c4 = new Card(Face.JACK, Suit.CLUB);
        Card c5 = new Card(Face.TEN, Suit.CLUB);

        hand.add(c1);
        hand.add(c2);
        hand.add(c3);
        hand.add(c4);
        hand.add(c5);

        String result = hand.evaluate().toString();
        String answer = HandRank.STRAIGHT_FLUSH;

        String test = "Test 1: ";

        if (result.equals(answer)) {
            test = test + "passed";
        } else {
            test = test + "failed";
        }

        System.out.println(test);
    }

    public void test2() {
        Hand hand = new Hand();

        Card c1 = new Card(Face.JACK, Suit.SPADE);
        Card c2 = new Card(Face.JACK, Suit.DIAMOND);
        Card c3 = new Card(Face.JACK, Suit.HEART);
        Card c4 = new Card(Face.SIX, Suit.DIAMOND);
        Card c5 = new Card(Face.SIX, Suit.CLUB);

        hand.add(c1);
        hand.add(c2);
        hand.add(c3);
        hand.add(c4);
        hand.add(c5);

        String result = hand.evaluate().toString();
        String answer = HandRank.FULL_HOUSE;

        String test = "Test 2: ";

        if (result.equals(answer)) {
            test = test + "passed";
        } else {
            test = test + "failed";
        }

        System.out.println(test);
    }

    public void test3() {
        Hand hand = new Hand();

        Card c1 = new Card(Face.JACK, Suit.SPADE);
        Card c2 = new Card(Face.JACK, Suit.HEART);
        Card c3 = new Card(Face.EIGHT, Suit.CLUB);
        Card c4 = new Card(Face.SIX, Suit.DIAMOND);
        Card c5 = new Card(Face.DEUCE, Suit.SPADE);

        hand.add(c1);
        hand.add(c2);
        hand.add(c3);
        hand.add(c4);
        hand.add(c5);

        String result = hand.evaluate().toString();
        String answer = HandRank.ONE_PAIR;

        String test = "Test 3: ";

        if (result.equals(answer)) {
            test = test + "passed";
        } else {
            test = test + "failed";
        }

        System.out.println(test);
    }
}
