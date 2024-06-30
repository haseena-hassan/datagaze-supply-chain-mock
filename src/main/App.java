package src.main;

import src.main.model.Arena;
import src.main.model.Match;
import src.main.model.Player;
import src.main.model.TwoPlayerMatch;
import src.main.service.PlayerFactory;
import src.main.service.RandomPlayerFactory;
import src.main.service.UserInputPlayerFactory;
import src.main.service.SixSidedDice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    // Inject the PlayerFactory implementation based on user's choice, i.e. user input or random
    private static PlayerFactory getPlayerFactory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to set player attributes or use random values? (type 'set' or 'random'):");
        String choice = scanner.nextLine().trim().toLowerCase();
        boolean setAttributes = choice.equals("set");

        // If user opts to set attributes, return an object of UserInputPlayerFactory, else RandomPlayerFactory Class.
        if(setAttributes) {
            return new UserInputPlayerFactory();
        }
        else {
            return new RandomPlayerFactory();
        }
    }

    public static void main(String[] args) {

        // dynamically creation of players: From user input or random.
        PlayerFactory playerFactory = getPlayerFactory();
        Player player1 = playerFactory.createPlayer();
        Player player2 = playerFactory.createPlayer();

        // create list of players
        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        // Instantiate current game arena with six-sided die
        Arena arena = new Arena(new SixSidedDice());
        // Instantiate a two-player match with arena and list of 2 players
        Match match = new TwoPlayerMatch(arena, players);

        System.out.println("\nStarting the Magical Arena Game!");
        System.out.println("Player 1: " + player1);
        System.out.println("Player 2: " + player2);

        // Start the game
        match.startGame();
    }
}