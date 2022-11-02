package tests;

public class Test {
    public static final String FAILED;
    public static final String PASSED;

    static {
        String ansiReset = "\u001B[0m";
        String ansiGreen = "\u001B[32m";
        String ansiRed = "\u001B[31m";

        FAILED = ansiRed + "FAILED" + ansiReset;
        PASSED = ansiGreen + "PASSED" + ansiReset;
    }
    public static void main(String[] args) {
        TestHandRank.testAllClassicHandRank();
        TestHandComparison.testAllHandsComparison();
    }
}
