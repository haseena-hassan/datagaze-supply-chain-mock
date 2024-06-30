package src.main;

import src.main.model.Arena;
import src.main.model.Dice;
import src.main.model.Player;

import java.util.Random;
import java.util.Scanner;

public class App {

    // TODO: create a PlayerFactory interface for player creation
    public static Player createPlayer(String name, boolean setAttributes) {
        if(setAttributes) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("\nEnter name of the player: ");
            name = scanner.nextLine().trim();
            System.out.print("Enter health for " + name + " (give positive integer): ");
            int health = scanner.nextInt();
            System.out.print("Enter strength for " + name + " (give positive integer): ");
            int strength = scanner.nextInt();
            System.out.print("Enter attack for " + name + " (give positive integer): ");
            int attack = scanner.nextInt();
            return new Player(name, health, strength, attack);
        }
        else {
            Random rand = new Random();
            int health = rand.nextInt(50) + 50; // Random health between 50-100
            int strength = rand.nextInt(5) + 5; // Random strength between 5-10
            int attack = rand.nextInt(10) + 5;  // Random attack between 5-15
            return new Player(name, health, strength, attack);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you want to set player attributes or use random values? (type 'set' or 'random'):");
        String choice = scanner.nextLine().trim().toLowerCase();
        boolean setAttributes = choice.equals("set");

        Player player1 = createPlayer("Player 1", setAttributes);
        Player player2 = createPlayer("Player 2", setAttributes);
        Dice dice = new Dice(6);

        Arena arena = new Arena(player1, player2, dice);
        System.out.println("\nStarting the Magical Arena Game!");

        System.out.println("Player 1: " + player1);
        System.out.println("Player 2: " + player2);

        arena.startGame();
        arena.determineWinner();
    }
}