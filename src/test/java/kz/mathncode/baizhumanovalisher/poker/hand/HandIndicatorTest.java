package kz.mathncode.baizhumanovalisher.poker.hand;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandIndicatorTest {
    @Test
    void testNullRankShouldReturnNullPointerException() {
        Exception e = assertThrows(NullPointerException.class, () -> new HandIndicator(null, 0));
        assertEquals("Rank is null.", e.getMessage());
    }

    @Test
    void testNegativeValueShouldReturnIllegalArgumentException() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new HandIndicator(HandRank.HIGH_CARD, -1));
        assertEquals("Value is negative.", e.getMessage());
    }
}
