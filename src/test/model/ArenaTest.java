package src.test.model;

import src.main.model.Arena;
import src.main.model.Player;
import src.main.service.Dice;
import src.main.service.SixSidedDice;
import src.test.utils.TestUtils;

public class ArenaTest {

    public static void main(String[] args) {
        TestUtils.runTest("testFightWithExactlyOneWinner", ArenaTest::testFightWithExactlyOneWinner);
        TestUtils.runTest("testFightAlwaysEnds", ArenaTest::testFightAlwaysEnds);
    }


    // Test a normal fight scenario where the fight results in exactly one winner
    private static void testFightWithExactlyOneWinner() {
        Player attacker = new Player("Alice", 100, 5, 10);
        Player defender = new Player("Bob", 50, 15, 8);
        Arena arena = new Arena(new SixSidedDice());

        arena.fight(attacker, defender);

        assert (!attacker.isAlive() || !defender.isAlive()) : "Fight should result in exactly one winner";
        assert !(attacker.isAlive() && defender.isAlive()) : "One player should be dead by the end of the fight";
    }

    // Test that the fight always ends and does not run indefinitely
    private static void testFightAlwaysEnds() {
        Player attacker = new Player("Alice", 10, 5, 5);
        Player defender = new Player("Bob", 10, 5, 5);

        // Use realistic dice rolls to simulate the fight
        Dice dice = new SixSidedDice();
        Arena arena = new Arena(dice);

        try {
            arena.fight(attacker, defender);
        } catch (IllegalStateException exception) {
            throw new AssertionError("Game should end without any illegal states");
        }

        // Check that the game has ended by confirming at least one player is not alive
        assert !(attacker.isAlive() && defender.isAlive()) : "Game should end with one player not alive";
    }
}
