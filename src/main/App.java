package src.main;

import src.main.model.Arena;
import src.main.model.Dice;
import src.main.model.Player;

import java.util.Scanner;

public class App {

    // TODO: implement dynamic player creation based on user choice

    public static Player createPlayer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter name of the player: ");
        String name = scanner.next();
        System.out.print("Enter health for " + name + " (give positive integer): ");
        int health = scanner.nextInt();
        System.out.print("Enter strength for " + name + " (give positive integer): ");
        int strength = scanner.nextInt();
        System.out.print("Enter attack for " + name + " (give positive integer): ");
        int attack = scanner.nextInt();
        return new Player(name, health, strength, attack);
    }

    public static void main(String[] args) {

        Player player1 = createPlayer();
        Player player2 = createPlayer();
        Dice dice = new Dice(6);

        Arena arena = new Arena(player1, player2, dice);
        System.out.println("\nStarting the Magical Arena Game!");

        System.out.println("Player 1: " + player1);
        System.out.println("Player 2: " + player2);

        arena.startGame();
        arena.determineWinner();
    }
}