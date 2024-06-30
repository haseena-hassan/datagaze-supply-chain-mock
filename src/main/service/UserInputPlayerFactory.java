package src.main.service;

import src.main.model.Player;

import java.util.Scanner;

public class UserInputPlayerFactory implements PlayerFactory {

    @Override
    public Player createPlayer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter name of the player: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter health for " + name + " (give positive integer): ");
        int health = scanner.nextInt();
        System.out.print("Enter strength for " + name + " (give positive integer): ");
        int strength = scanner.nextInt();
        System.out.print("Enter attack for " + name + " (give positive integer): ");
        int attack = scanner.nextInt();
        return new Player(name, health, strength, attack);
    }
}
