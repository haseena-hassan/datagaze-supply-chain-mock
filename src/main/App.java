package src.main;

import src.main.model.Arena;
import src.main.model.Player;

public class App {
    public static void main(String[] args) {

        // TODO: User to be able to input the player information

        Player player1 = new Player("Alice", 50, 10, 8);
        Player player2 = new Player("Bob", 100, 5, 12);

        Arena arena = new Arena(player1, player2);
        System.out.println("Starting the Magical Arena Game!");

        System.out.println("Player 1: " + player1.toString());
        System.out.println("Player 2: " + player2.toString());

        arena.fight();
        if(arena.isGameOver()) {
            String winner = (player1.getHealth() <= 0) ? player2.getName() : player1.getName();
            System.out.println("Game Over! " + winner + " wins!");
        }
    }
}