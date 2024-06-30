package src.test.service;

import src.main.model.Player;
import src.main.service.UserInputPlayerFactory;
import src.test.utils.TestUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class UserInputPlayerFactoryTest {
    private static InputStream originalIn = System.in;
    private static PrintStream originalOut = System.out;

    public static void main(String[] args) {
        TestUtils.runTest("testCreatePlayerWithValidInput", UserInputPlayerFactoryTest::testCreatePlayerWithValidInput);
        TestUtils.runTest("testCreatePlayerWithInvalidInput", UserInputPlayerFactoryTest::testCreatePlayerWithInvalidInput);
        TestUtils.runTest("testPromptMessagesForUserInput", UserInputPlayerFactoryTest::testPromptMessagesForUserInput);
    }

    // Test if a player is created with valid input
    private static void testCreatePlayerWithValidInput() {
        // Simulating the user input with mock input
        String simulatedInput = "Alice\n100\n10\n15\n";
        ByteArrayInputStream mockInput = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(mockInput);

        // Simulating the command line output with mock output
        ByteArrayOutputStream mockOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(mockOutput));

        try {
            UserInputPlayerFactory factory = new UserInputPlayerFactory();
            Player player = factory.createPlayer();

            assert "Alice".equals(player.getName()) : "Expected name: Alice, but got: " + player.getName();
            assert player.getHealth() == 100 : "Expected health: 100, but got: " + player.getHealth();
            assert player.getStrength() == 10 : "Expected strength: 10, but got: " + player.getStrength();
            assert player.getAttack() == 15 : "Expected attack: 15, but got: " + player.getAttack();
        } finally {
            // Revert to Original System Input and Output
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }

    // Test if a player is creater with invalid inputs or thrown exception
    private static void testCreatePlayerWithInvalidInput() {
        // Simulating the user input with mock input
        String simulatedInput = "Bob\n-50\ninvalid\n5\n";
        ByteArrayInputStream mockInput = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(mockInput);

        // Simulating the command line output with mock output
        ByteArrayOutputStream mockOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(mockOutput));

        try {
            UserInputPlayerFactory factory = new UserInputPlayerFactory();
            Player player = factory.createPlayer();
            throw new AssertionError("Failed: testCreatePlayerWithInvalidInput, Reason: No exception thrown for invalid input");
        } catch (Exception ignored) {
            // Expected behavior, test passes
        } finally {
            // Revert to Original System Input and Output
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }

    // Test whether promt messages for the inputs are printed and in correct order
    private static void testPromptMessagesForUserInput() {
        // Simulating the user input with mock input
        String simulatedInput = "Bob\n50\n20\n5\n";
        ByteArrayInputStream mockInput = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(mockInput);

        // Simulating the command line output with mock output
        ByteArrayOutputStream mockOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(mockOutput));

        try {
            UserInputPlayerFactory factory = new UserInputPlayerFactory();
            Player player = factory.createPlayer();

            String output = mockOutput.toString();
            assert output.contains("Enter health for Bob (give positive integer):") : "Expected prompt for health input";
        } finally {
            // Revert to Original System Input and Output
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }

}

