package src.test;

import src.test.model.ArenaTest;
import src.test.model.PlayerTest;
import src.test.model.TwoPlayerMatchTest;
import src.test.service.RandomPlayerFactoryTest;
import src.test.service.SixSidedDiceTest;
import src.test.service.UserInputPlayerFactoryTest;

// Test runner utility which executes all the unit test files in one go.
public class TestRunner {

    public static void main(String[] args) {
        System.out.println("Running all Unit Tests...");

        System.out.println("\nRunning PlayerTest --> ");
        PlayerTest.main(args);

        System.out.println("\nRunning ArenaTest --> ");
        ArenaTest.main(args);

        System.out.println("\nRunning SixSidedDiceTest --> ");
        SixSidedDiceTest.main(args);

        System.out.println("\nRunning TwoPlayerMatchTest --> ");
        TwoPlayerMatchTest.main(args);

        System.out.println("\nRunning RandomPlayerFactoryTest --> ");
        RandomPlayerFactoryTest.main(args);

        System.out.println("\nRunning UserInputPlayerFactoryTest --> ");
        UserInputPlayerFactoryTest.main(args);
    }
}
