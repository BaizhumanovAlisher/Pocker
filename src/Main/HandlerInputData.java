package Main;

import Main.PokerData.Face;
import Main.PokerData.Suit;

public class HandlerInputData {
    private HandlerInputData() {}

    public static Card fromStringToCard(String s) {
        if (s.length() != 2) {
            throw new IllegalArgumentException("Incorrect string length.");
        }

        Face face = Face.fromStringToFace(String.valueOf(s.charAt(0)));
        Suit suit = Suit.fromStringToSuit(String.valueOf(s.charAt(1)));

        return new Card(face, suit);
    }

    public static Hand fromStringToHand(String str) {
        String[] strArray = str.split(" ");

        Hand hand = new Hand();

        for (String s : strArray) {
            Card card = fromStringToCard(s);
            hand.add(card);
        }

        return hand;
    }
}
