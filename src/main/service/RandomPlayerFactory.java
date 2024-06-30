package src.main.service;

import src.main.model.Player;

import java.util.Random;

public class RandomPlayerFactory implements PlayerFactory {
    Random random = new Random();

    @Override
    public Player createPlayer() {
        String name = "Player" + random.nextInt(1000);     // Random player name
        int health = random.nextInt(50) + 50;   // Random health between 50-100
        int strength = random.nextInt(5) + 5;   // Random strength between 5-10
        int attack = random.nextInt(10) + 5;    // Random attack between 5-15

        return new Player(name, health, strength, attack);
    }
}
