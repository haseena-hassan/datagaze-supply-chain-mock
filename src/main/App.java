package src.main;

import src.main.model.Arena;
import src.main.model.Dice;
import src.main.model.Player;

public class App {
    public static void main(String[] args) {

        // TODO: User to be able to input the player information

        Player player1 = new Player("Alice", 40, 2, 6);
        Player player2 = new Player("Bob", 50, 4, 4);
        Dice dice = new Dice(6);

        Arena arena = new Arena(player1, player2, dice);
        System.out.println("Starting the Magical Arena Game!");

        System.out.println("Player 1: " + player1);
        System.out.println("Player 2: " + player2);

        arena.startGame();
        arena.determineWinner();
    }
}