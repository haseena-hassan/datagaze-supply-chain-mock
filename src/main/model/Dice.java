package src.main.model;

import java.util.Random;

public class Dice {
    private final int sides;
    private final Random random;

    public Dice(int sides) {
        if(sides <= 0)  throw new IllegalArgumentException("Number of sides must be greater than zero.");
        this.sides = sides;
        this.random = new Random();
    }

    public int roll() {
        return random.nextInt(sides) + 1;
    }
}
