package Main.PokerData;

public enum Suit {
    CLUB(0x8000, "C", "club"),
    DIAMOND(0x4000, "D", "diamond"),
    HEART(0x2000, "H", "heart"),
    SPADE(0x1000, "S", "spade");

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

    public static Suit fromStringToSuit(String s) {
        Suit[] faces = Suit.values();

        for (Suit suit : faces) {
            if (s.equals(suit.toString())) {
                return suit;
            }
        }

        return null;
    }
}
