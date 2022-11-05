package kz.mathncode.baizhumanovalisher.poker.hand;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandRankTest {
    @Test
    void testHandRankStraightFlush() {
        HandRank h = HandRank.STRAIGHT_FLUSH;
        assertEquals("straight flush", h.toString());
        assertEquals(9000, h.getValue());
    }

    @Test
    void testHandRankFourOfAKind() {
        HandRank h = HandRank.FOUR_OF_A_KIND;
        assertEquals("four of a kind", h.toString());
        assertEquals(8000, h.getValue());
    }

    @Test
    void testHandRankFullHouse() {
        HandRank h = HandRank.FULL_HOUSE;
        assertEquals("full house", h.toString());
        assertEquals(7000, h.getValue());
    }

    @Test
    void testHandRankFlush() {
        HandRank h = HandRank.FLUSH;
        assertEquals("flush", h.toString());
        assertEquals(6000, h.getValue());
    }

    @Test
    void testHandRankStraight() {
        HandRank h = HandRank.STRAIGHT;
        assertEquals("straight", h.toString());
        assertEquals(5000, h.getValue());
    }

    @Test
    void testHandRankThreeOfAKind() {
        HandRank h = HandRank.THREE_OF_A_KIND;
        assertEquals("three of a kind", h.toString());
        assertEquals(4000, h.getValue());
    }

    @Test
    void testHandRankTwoPair() {
        HandRank h = HandRank.TWO_PAIR;
        assertEquals("two pair", h.toString());
        assertEquals(3000, h.getValue());
    }

    @Test
    void testHandRankOnePair() {
        HandRank h = HandRank.ONE_PAIR;
        assertEquals("one pair", h.toString());
        assertEquals(2000, h.getValue());
    }

    @Test
    void testHandRankHighCard() {
        HandRank h = HandRank.HIGH_CARD;
        assertEquals("high card", h.toString());
        assertEquals(1000, h.getValue());
    }

}