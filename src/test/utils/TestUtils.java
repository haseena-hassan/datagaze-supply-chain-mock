package src.test.utils;

// Common class to house any common utility functions for testing
public class TestUtils {

    /*
     Individual test methods can focus solely on their assertions while
     runTest method takes care of the test execution logic without adding repetition.
    */
    public static void runTest(String testName, Runnable testMethod) {
        try {
            testMethod.run();
            System.out.println("Passed: " + testName);
        } catch (AssertionError e) {
            System.err.println("Failed: " + testName + ", Reason: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Failed: " + testName + ", Reason: Unexpected exception: " + e);
        }
    }
}
