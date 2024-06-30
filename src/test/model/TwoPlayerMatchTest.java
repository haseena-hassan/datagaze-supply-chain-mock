package src.test.model;

import src.main.model.Arena;
import src.main.model.Player;
import src.main.model.TwoPlayerMatch;
import src.main.service.Dice;
import src.main.service.SixSidedDice;
import src.test.utils.TestUtils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPlayerMatchTest {
    private static final PrintStream originalOut = System.out;

    public static void main(String[] args) {
        TestUtils.runTest("testStartGameWithValidPlayers", TwoPlayerMatchTest::testStartGameWithValidPlayers);
        TestUtils.runTest("testStartGameWithInsufficientPlayers", TwoPlayerMatchTest::testStartGameWithInsufficientPlayers);
        TestUtils.runTest("testStartGameAttackerBasedOnHealth", TwoPlayerMatchTest::testStartGameAttackerBasedOnHealth);
    }

    // Test to ensure startGame works with valid players
    private static void testStartGameWithValidPlayers() {
        Player player1 = new Player("Alice", 30, 10, 8);  // Lower health, should attack first
        Player player2 = new Player("Bob", 20, 4, 7);
        Arena arena = new Arena(new SixSidedDice());
        List<Player> players = Arrays.asList(player1, player2);

        TwoPlayerMatch match = new TwoPlayerMatch(arena, players);

        // redirecting output stream to mask the game logs
        ByteArrayOutputStream mockOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(mockOutput));

        match.startGame();
        // Revert to Original System Output
        System.setOut(originalOut);
    }

    // Test to ensure startGame throws exception with insufficient players
    private static void testStartGameWithInsufficientPlayers() {
        Player player1 = new Player("Alice", 60, 10, 8);
        Arena arena = new Arena(new MockDice());
        List<Player> players = new ArrayList<>();
        players.add(player1);

        TwoPlayerMatch match = new TwoPlayerMatch(arena, players);

        // redirecting output stream to mask the game logs
        ByteArrayOutputStream mockOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(mockOutput));

        try {
            match.startGame();
            throw new AssertionError("Expected an exception for insufficient players but none was thrown.");
        } catch (IllegalArgumentException e) {
            // Expected exception, test passes
        } finally {
            // Revert to Original System Output
            System.setOut(originalOut);
        }
    }

    // Test to ensure the correct player starts as the attacker based on health
    private static void testStartGameAttackerBasedOnHealth() {
        Player player1 = new Player("Alice", 30, 10, 8);  // Lower health, should attack first
        Player player2 = new Player("Bob", 20, 4, 7);
        Arena arena = new Arena(new MockDice());
        List<Player> players = Arrays.asList(player1, player2);

        TwoPlayerMatch match = new TwoPlayerMatch(arena, players);

        // redirecting output stream to mask the game logs
        ByteArrayOutputStream mockOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(mockOutput));

        match.startGame();
        // Revert to Original System Output
        System.setOut(originalOut);

        assert player1.isAlive() : "Winner should be Alice, but Alice is not alive.";
        assert !player2.isAlive() : "Bob should be defeated but Bob is alive.";
    }

    // Mock Dice class to avoid randomness in tests
    static class MockDice implements Dice {
        @Override
        public int roll() {
            return 5;  // Return a fixed value to simplify testing
        }
    }
}
