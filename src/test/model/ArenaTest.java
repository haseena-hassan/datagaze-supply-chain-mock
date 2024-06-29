package src.test.model;

import src.main.model.Arena;
import src.main.model.Dice;
import src.main.model.Player;

public class ArenaTest {

    public static void main(String[] args) {
        testArenaInitialization();
        testArenaFight();
        testFightEndsWithWinner();
    }

    // TODO: Add common runner utility with try-catch block

    private static void testArenaInitialization() {
        // Create 2 players and initialize Arena
        Player player1 = new Player("Alice", 50, 10, 8);
        Player player2 = new Player("Bob", 100, 5, 12);
        Dice dice = new Dice(6);
        Arena arena = new Arena(player1, player2, dice);

        try {
            // Test if Arena initialized correctly
            assert arena != null : "Arena should be initialized";
            assert player1.getHealth() == 50 : "Player1 health should be 50";
            assert player2.getHealth() == 100 : "Player2 health should be 100";
            System.out.println("Passed: testArenaInitialization");
        } catch (AssertionError e) {
            System.err.println("Failed: testValidPlayerCreation, Reason: " + e.getMessage());
        }
    }

    private static void testArenaFight() {
        // Create two players, initialize Arena and start fight
        Player player1 = new Player("Alice", 50, 10, 8);
        Player player2 = new Player("Bob", 100, 5, 12);
        Dice dice = new Dice(6);
        Arena arena = new Arena(player1, player2, dice);
        arena.fight();

        try {
            // Check if the game ends correctly
            assert arena.isGameOver() : "Game should be over when one player's health reaches 0";
            assert player1.getHealth() <= 0 || player2.getHealth() <= 0 : "One of the players should be dead";
            System.out.println("Passed: testArenaFight");
        } catch (AssertionError e) {
            System.err.println("Failed: testValidPlayerCreation, Reason: " + e.getMessage());
        }
    }


    private static void testFightEndsWithWinner() {
        Player player1 = new Player("Alice", 50, 10, 8);
        Player player2 = new Player("Bob", 100, 5, 12);
        Dice dice = new Dice(6);
        Arena arena = new Arena(player1, player2, dice);
        arena.fight();

        String winner = arena.isGameOver() ? ((player1.getHealth() <= 0) ? player2.getName() : player1.getName()) : null;

        try {
            assert winner != null : "The game should have a winner.";
            System.out.println("Passed: testFightEndsWithWinner");
        } catch (AssertionError e) {
            System.err.println("Failed: testValidPlayerCreation, Reason: " + e.getMessage());
        }
    }

    // TODO: test for die roll
}
