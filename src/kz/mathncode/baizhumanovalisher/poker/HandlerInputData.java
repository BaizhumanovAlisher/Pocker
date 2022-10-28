package kz.mathncode.baizhumanovalisher.poker;

import kz.mathncode.baizhumanovalisher.poker.card.Card;
import kz.mathncode.baizhumanovalisher.poker.card.Face;
import kz.mathncode.baizhumanovalisher.poker.card.Suit;

// Неудачное название класса, непонятно из названия что он делает, дает ложное впечатление, что работает c IO
// Тогда уж CardUtils какой-нибудь был бы лучше
public class HandlerInputData {
    private HandlerInputData() {}

    public static Card fromStringToCard(String s) {
        // Магическая константа
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
