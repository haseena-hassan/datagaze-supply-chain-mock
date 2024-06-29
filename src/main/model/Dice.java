package src.main.model;

import java.util.Random;

public class Dice {
    private final int sides;
    private final Random random;

    public Dice(int sides) {
        this.sides = sides;
        this.random = new Random();
    }

    public int roll() {
        return random.nextInt(sides) + 1;
    }
}
