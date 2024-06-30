package src.main.service;

import java.util.Random;

// SixSidedDice provide specific dice configurations with 6 sides.
public class SixSidedDice implements Dice {
    private final Random random;

    public SixSidedDice() {
        this.random = new Random();
    }

    // returns a randow integer from 1 to 6
    @Override
    public int roll() {
        return random.nextInt(6) + 1;
    }
}
