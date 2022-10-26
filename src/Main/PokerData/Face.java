package Main.PokerData;

public enum Face {
    DEUCE(0, "2", "2"),
    TREY(1, "3", "3"),
    FOUR(2, "4", "4"),
    FIVE(3, "5", "5"),
    SIX(4, "6", "6"),
    SEVEN(5, "7", "7"),
    EIGHT(6, "8", "8"),
    NINE(7, "9", "9"),
    TEN(8, "T", "10"),
    JACK(9, "J", "jack"),
    QUEEN(10, "Q", "queen"),
    KING(11, "K", "king"),
    ACE(12, "A", "ace");

    Face(int rank, String shortName, String fullName) {
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

    public static Face fromStringToFace(String s) {
        Face[] faces = Face.values();

        for (Face face : faces) {
            if (s.equals(face.toString())) {
                return face;
            }
        }

        return null;
    }
}
