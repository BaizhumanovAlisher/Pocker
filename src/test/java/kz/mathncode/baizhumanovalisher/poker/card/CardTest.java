package kz.mathncode.baizhumanovalisher.poker.card;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    @Test
    void testNullSuitShouldReturnNullPointerException() {
        Exception e = assertThrows(NullPointerException.class, () -> new Card(Face.DEUCE, null));
        assertEquals("Suit is null.", e.getMessage());
    }

    @Test
    void testNullFaceShouldReturnNullPointerException() {
        Exception e = assertThrows(NullPointerException.class, () -> new Card(null, Suit.CLUB));
        assertEquals("Face is null.", e.getMessage());
    }

    @Test
    void testEqualsIdenticalCards() {
        Card card1 = new Card(Face.DEUCE, Suit.CLUB);
        Card card2 = new Card(Face.DEUCE, Suit.CLUB);

        assertEquals(card1.toString(), card2.toString());
        assertEquals(card1.hashCode(), card2.hashCode());
        assertEquals(card1, card2);
    }
}