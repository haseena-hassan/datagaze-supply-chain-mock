package src.test.service;

import src.main.model.Player;
import src.main.service.RandomPlayerFactory;
import src.test.utils.TestUtils;


// Unit tests for RandomPlayerFactory
public class RandomPlayerFactoryTest {

    public static void main(String[] args) {
        TestUtils.runTest("testCreatePlayerWithValidAttributes", RandomPlayerFactoryTest::testCreatePlayerWithValidAttributes);
    }

    // Test that the created player has valid and non-empty attributes
    private static void testCreatePlayerWithValidAttributes() {
        RandomPlayerFactory randomPlayerFactory = new RandomPlayerFactory();

        Player player = randomPlayerFactory.createPlayer();

        // Validate that the player's name is not null or empty
        assert player.getName() != null && !player.getName().trim().isEmpty() : "Player name should not be null or empty";

        // Validate that the player's health, strength, and attack are greater than zero
        assert player.getHealth() > 0 : "Player health should be greater than zero";
        assert player.getStrength() > 0 : "Player strength should be greater than zero";
        assert player.getAttack() > 0 : "Player attack should be greater than zero";
    }
}
