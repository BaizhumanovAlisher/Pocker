package kz.mathncode.baizhumanovalisher.poker.card;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FaceTest {
    @Test
    void testFaceDeuce() {
        Face deuce = Face.DEUCE;
        assertEquals(2, deuce.getRank());
        assertEquals("2", deuce.toString());
    }

    @Test
    void testFaceTrey() {
        Face trey = Face.TREY;
        assertEquals(3, trey.getRank());
        assertEquals("3", trey.toString());
    }

    @Test
    void testFaceFour() {
        Face four = Face.FOUR;
        assertEquals(4, four.getRank());
        assertEquals("4", four.toString());
    }

    @Test
    void testFaceFive() {
        Face five = Face.FIVE;
        assertEquals(5, five.getRank());
        assertEquals("5", five.toString());
    }

    @Test
    void testFaceSix() {
        Face six = Face.SIX;
        assertEquals(6, six.getRank());
        assertEquals("6", six.toString());
    }

    @Test
    void testFaceSeven() {
        Face seven = Face.SEVEN;
        assertEquals(7, seven.getRank());
        assertEquals("7", seven.toString());
    }

    @Test
    void testFaceEight() {
        Face eight = Face.EIGHT;
        assertEquals(8, eight.getRank());
        assertEquals("8", eight.toString());
    }

    @Test
    void testFaceNine() {
        Face nine = Face.NINE;
        assertEquals(9, nine.getRank());
        assertEquals("9", nine.toString());
    }

    @Test
    void testFaceTen() {
        Face ten = Face.TEN;
        assertEquals(10, ten.getRank());
        assertEquals("T", ten.toString());
    }

    @Test
    void testFaceJack() {
        Face jack = Face.JACK;
        assertEquals(11, jack.getRank());
        assertEquals("J", jack.toString());
    }

    @Test
    void testFaceQueen() {
        Face queen = Face.QUEEN;
        assertEquals(12, queen.getRank());
        assertEquals("Q", queen.toString());
    }

    @Test
    void testFaceKing() {
        Face king = Face.KING;
        assertEquals(13, king.getRank());
        assertEquals("K", king.toString());
    }

    @Test
    void testFaceAce() {
        Face ace = Face.ACE;
        assertEquals(14, ace.getRank());
        assertEquals("A", ace.toString());
    }
}