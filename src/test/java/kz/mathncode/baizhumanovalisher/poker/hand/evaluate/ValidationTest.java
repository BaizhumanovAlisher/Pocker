package kz.mathncode.baizhumanovalisher.poker.hand.evaluate;

import kz.mathncode.baizhumanovalisher.poker.card.Card;
import kz.mathncode.baizhumanovalisher.poker.card.Face;
import kz.mathncode.baizhumanovalisher.poker.card.Suit;
import kz.mathncode.baizhumanovalisher.poker.exceptions.HandHasDuplicatesException;
import kz.mathncode.baizhumanovalisher.poker.exceptions.IncorrectHandSizeException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {
    @Test
    void testHandValidationCorrectScenario() {
        List<Card> hand = new ArrayList<>();

        hand.add(new Card(Face.DEUCE, Suit.CLUB));
        hand.add(new Card(Face.TREY, Suit.CLUB));
        hand.add(new Card(Face.FOUR, Suit.CLUB));
        hand.add(new Card(Face.FIVE, Suit.CLUB));
        hand.add(new Card(Face.SIX, Suit.CLUB));

        assertDoesNotThrow(() -> Validation.handValidation(hand));
    }

    @Test
    void testHandValidationHandHasDuplicatesException() {
        List<Card> hand = new ArrayList<>();

        hand.add(new Card(Face.DEUCE, Suit.CLUB));
        hand.add(new Card(Face.DEUCE, Suit.CLUB));
        hand.add(new Card(Face.TREY, Suit.CLUB));
        hand.add(new Card(Face.FOUR, Suit.CLUB));
        hand.add(new Card(Face.FIVE, Suit.CLUB));

        assertThrows(HandHasDuplicatesException.class, () -> Validation.handValidation(hand));
    }

    @Test
    void testHandValidationIncorrectHandSizeException4Card() {
        List<Card> hand = new ArrayList<>();

        hand.add(new Card(Face.DEUCE, Suit.CLUB));
        hand.add(new Card(Face.TREY, Suit.CLUB));
        hand.add(new Card(Face.FOUR, Suit.CLUB));
        hand.add(new Card(Face.FIVE, Suit.CLUB));

        assertThrows(IncorrectHandSizeException.class, () -> Validation.handValidation(hand));
    }

    @Test
    void testHandValidationIncorrectHandSizeException0Card() {
        assertThrows(IncorrectHandSizeException.class, () -> Validation.handValidation(new ArrayList<>()));
    }

    @Test
    void testHandValidationIncorrectHandSizeException6Card() {
        List<Card> hand = new ArrayList<>();

        hand.add(new Card(Face.DEUCE, Suit.CLUB));
        hand.add(new Card(Face.TREY, Suit.CLUB));
        hand.add(new Card(Face.FOUR, Suit.CLUB));
        hand.add(new Card(Face.FIVE, Suit.CLUB));
        hand.add(new Card(Face.SIX, Suit.CLUB));
        hand.add(new Card(Face.SEVEN, Suit.CLUB));

        assertThrows(IncorrectHandSizeException.class, () -> Validation.handValidation(hand));
    }
}