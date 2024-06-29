package src.test.model;

import src.main.model.Player;

public class PlayerTest {

    public static void main(String[] args) {
        testValidPlayerCreation();
        testPlayerHealthReduction();
    }

    // TODO: Add common runner utility with try-catch block


    // TODO: use isString() to check for valid printing

    // TODO: refactor test as testAttributeGetters
    private static void testValidPlayerCreation() {
        Player player = new Player("TestPlayer", 100, 10, 15);

        try {
            assert "TestPlayer".equals(player.getName()) : "Player name should be 'TestPlayer'";
            assert player.getHealth() == 100 : "Player health should be 100";
            assert player.getStrength() == 10 : "Player strength should be 10";
            assert player.getAttack() == 15 : "Player attack should be 15";
            System.out.println("Passed: testValidPlayerCreation");
        } catch (AssertionError e) {
            System.err.println("Failed: testValidPlayerCreation, Reason: " + e.getMessage());
        }
    }

    private static void testPlayerHealthReduction() {
        // Create a new player and reduce health
        Player player = new Player("TestPlayer", 100, 10, 15);
        player.setHealth(80);

        try {
            // Deliberate wrong assertion to test
            assert player.getHealth() != 100 : "Player health should be not be 100 but 80";  // This should fail
            assert player.getHealth() == 80 : "Player health should be reduced to 80";
            System.out.println("Passed: testPlayerHealthReduction");
        } catch (AssertionError e) {
            System.err.println("Failed: testValidPlayerCreation, Reason: " + e.getMessage());
        }
    }


    // TODO: test for invalid player creation
}
