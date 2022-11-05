package kz.mathncode.baizhumanovalisher.poker.card;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuitTest {
    @Test
    void testSuitClub() {
        assertEquals("C", Suit.CLUB.toString());
    }

    @Test
    void testSuitDiamond() {
        assertEquals("D", Suit.DIAMOND.toString());
    }

    @Test
    void testSuitHeart() {
        assertEquals("H", Suit.HEART.toString());
    }

    @Test
    void testSuitSpade() {
        assertEquals("S", Suit.SPADE.toString());
    }
}