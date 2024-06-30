package src.test.model;

import src.main.model.Player;
import src.test.utils.TestUtils;

// Unit tests for the Player class using plain Java assertions
public class PlayerTest {

    public static void main(String[] args) {
        // Run all the test cases
        TestUtils.runTest("testValidPlayerCreation", PlayerTest::testValidPlayerCreation);
        TestUtils.runTest("testInvalidPlayerCreation", PlayerTest::testInvalidPlayerCreation);
        TestUtils.runTest("testDefaultNameWhenNullOrEmpty", PlayerTest::testDefaultNameWhenNullOrEmpty);
        TestUtils.runTest("testSetHealth", PlayerTest::testSetHealth);
        TestUtils.runTest("testIsAlive", PlayerTest::testIsAlive);
        TestUtils.runTest("testToString", PlayerTest::testToString);
    }

    // Test for valid player creation
    private static void testValidPlayerCreation() {
        Player player = new Player("TestPlayer", 100, 15, 5);

        assert "TestPlayer".equals(player.getName()) : "Player name should be 'TestPlayer'";
        assert player.getHealth() == 100 : "Player health should be 100";
        assert player.getStrength() == 15 : "Player strength should be 15";
        assert player.getAttack() == 5 : "Player attack should be 5";
    }

    // Test for invalid player creation (negative attributes)
    private static void testInvalidPlayerCreation() {
        try {
            new Player("InvalidPlayer", -10, -5, -1);
            throw new AssertionError("Expected IllegalArgumentException for negative health, strength, or attack");
        } catch (IllegalArgumentException e) {
            // Expected exception, test passes
        }
    }

    // Test default name when null or empty
    private static void testDefaultNameWhenNullOrEmpty() {
        Player nullNamePlayer = new Player(null, 100, 10, 5);
        assert "Player".equals(nullNamePlayer.getName()) : "Player name should default to 'Player' if null";

        Player emptyNamePlayer = new Player("", 100, 10, 5);
        assert "Player".equals(emptyNamePlayer.getName()) : "Player name should default to 'Player' if empty";

        Player spacesNamePlayer = new Player("   ", 100, 10, 5);
        assert "Player".equals(spacesNamePlayer.getName()) : "Player name should default to 'Player' if only spaces";
    }

    // Test the setHealth method
    private static void testSetHealth() {
        Player player = new Player("TestPlayer", 100, 10, 5);
        player.setHealth(80);
        assert player.getHealth() == 80 : "Player health should be updated to 80";

        player.setHealth(0);
        assert player.getHealth() == 0 : "Player health should be updated to 0";
    }

    // Test the isAlive method
    private static void testIsAlive() {
        Player player = new Player("TestPlayer", 100, 10, 5);
        assert player.isAlive() : "Player should be alive with health 100";

        player.setHealth(0);
        assert !player.isAlive() : "Player should not be alive with health 0";
    }

    // Test the toString method
    private static void testToString() {
        Player player = new Player("TestPlayer", 100, 10, 5);
        String expectedString = "TestPlayer\t[ Health = 100, Strength = 10, Attack = 5]";
        assert expectedString.equals(player.toString()) : "toString method did not produce expected output";
    }
}