package src.test.model;

import src.main.model.Dice;

public class DiceTest {

    public static void main(String[] args) {
        testDiceInitialization();
        testInvalidSidedDice();
        testDiceRoll();
    }

    // TODO: Add common runner utility with try-catch block

    private static void testDiceInitialization() {
        Dice dice = new Dice(9);
        try {
            assert dice.roll() >= 1 && dice.roll() <= 9 : "Dice should be 9 sided";
            System.out.println("Passed: testDiceInitialization");
        } catch (AssertionError e) {
            System.err.println("Failed: testDiceInitialization, Reason: " + e.getMessage());
        }
    }

    private static void testInvalidSidedDice() {
        try {
            Dice dice = new Dice(0);
            System.err.println("Failed: testInvalidSidedDice, Reason: Exception not thrown for invalid dice sides");
        } catch (IllegalArgumentException e) {
            // Expected behavior, test passes
            System.out.println("Passed: testInvalidPlayerCreation");
        }
    }

    private static void testDiceRoll() {
        Dice dice = new Dice(6);
        try {
            assert dice.roll() >= 1 && dice.roll() <= 6 : "Dice should give a value from 1 to 6 when rolled";
            System.out.println("Passed: testDiceRoll");
        } catch (AssertionError e) {
            System.err.println("Failed: testDiceRoll, Reason: " + e.getMessage());
        }
    }
}
