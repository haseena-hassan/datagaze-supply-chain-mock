package src.main;

import src.main.model.Arena;
import src.main.model.Player;
import src.main.service.PlayerFactory;
import src.main.service.RandomPlayerFactory;
import src.main.service.UserInputPlayerFactory;
import src.main.service.Dice;
import src.main.service.SixSidedDice;

import java.util.Scanner;

public class App {

    private static PlayerFactory getPlayerFactory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to set player attributes or use random values? (type 'set' or 'random'):");
        String choice = scanner.nextLine().trim().toLowerCase();
        boolean setAttributes = choice.equals("set");

        if(setAttributes) {
            return new UserInputPlayerFactory();
        }
        else {
            return new RandomPlayerFactory();
        }
    }

    public static void main(String[] args) {

        /*
         TODO: Use TwoPlayerMatch class to instantiate a Match with List of 2 Players
          (can be be extended for different type of matches)
        */

        PlayerFactory playerFactory = getPlayerFactory();
        Player player1 = playerFactory.createPlayer();
        Player player2 = playerFactory.createPlayer();

        Dice dice = new SixSidedDice();
        Arena arena = new Arena(player1, player2, dice);

        System.out.println("\nStarting the Magical Arena Game!");
        System.out.println("Player 1: " + player1);
        System.out.println("Player 2: " + player2);

        arena.startGame();
        arena.determineWinner();
    }
}