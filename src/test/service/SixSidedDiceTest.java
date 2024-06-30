package src.test.service;

import src.main.service.Dice;
import src.main.service.SixSidedDice;
import src.test.utils.TestUtils;

// Unit tests for the SixSidedDice class for range and randomness
public class SixSidedDiceTest {

    public static void main(String[] args) {
        // Run all the test cases
        TestUtils.runTest("testSixSidedDiceRollRange", SixSidedDiceTest::testSixSidedDiceRollRange);
        TestUtils.runTest("testSixSidedDiceRandomness", SixSidedDiceTest::testSixSidedDiceRandomness);
    }

    // Test to check that the roll result is within the expected range (1-6).
    private static void testSixSidedDiceRollRange() {
        Dice dice = new SixSidedDice();
        for (int i = 0; i < 100; i++) {
            int roll = dice.roll();
            assert roll >= 1 && roll <= 6 : "Roll should be between 1 and 6, but got: " + roll;
        }
    }

    // Test to check that the dice produces a variety of numbers (basic randomness check).
    private static void testSixSidedDiceRandomness() {
        Dice dice = new SixSidedDice();
        boolean[] rolledValues = new boolean[6];
        for (int i = 0; i < 100; i++) {
            int roll = dice.roll();
            rolledValues[roll - 1] = true;
        }
        for (int i = 0; i < 6; i++) {
            assert rolledValues[i] : "Value " + (i + 1) + " was not rolled.";
        }
    }
}
