package kz.mathncode.baizhumanovalisher.poker.card;

public enum Suit {
    //rank?
    CLUB(400, "C", "club"),
    DIAMOND(300, "D", "diamond"),
    HEART(200, "H", "heart"),
    SPADE(100, "S", "spade");

    Suit(int rank, String shortName, String fullName) {
        this.rank = rank;
        this.shortName = shortName;
        this.fullName = fullName;
    }

    private final int rank;
    private final String shortName;
    private final String fullName;

    public int getRank() {
        return rank;
    }

    public String toString() {
        return shortName;
    }

    public String getFullName() {
        return fullName;
    }


    //fromStringToSuit --> fromString(String s)
    //В целом эту функцию можно не писать и воспользоваться valueOf в Enum
    public static Suit fromStringToSuit(String s) {
        // return Suit.valueOf(s); полностью заменяет эту функцию
        Suit[] faces = Suit.values();

        for (Suit suit : faces) {
            if (s.equals(suit.toString())) {
                return suit;
            }
        }

        return null;
    }
}
