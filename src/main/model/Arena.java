package src.main.model;

import src.main.service.Dice;

/*
  Arena Class manages dice attribute and fight logic between an attacker and a defender
*/
public class Arena {
    private final Dice dice;

    public Arena(Dice dice) {
        this.dice = dice;
    }

    // fight function between any 2 players, which is attacker and defender
    public void fight(Player attacker, Player defender) {

        // Fight goes on until any player's health reaches 0
        while(attacker.isAlive() && defender.isAlive()) {
            takeTurns(attacker, defender);

            // Swap roles for next round
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }
        determineWinner(attacker, defender);
    }

    // Attack and defence logic in any particular turn in the fight
    private void takeTurns(Player attacker, Player defender) {
        int attackRoll = dice.roll();
        int defenseRoll = dice.roll();

        int attackDamage = attacker.getAttack() * attackRoll;
        int defenseStrength = defender.getStrength() * defenseRoll;

        // Whatever damage created by attacker which is in excess of the damage defended by the defender will reduce the “health” of the defender
        int damage = Math.max(0, attackDamage - defenseStrength);
        defender.setHealth(defender.getHealth() - damage);

        // Logs the current turn status
        System.out.println(attacker.getName() + " attacks with roll " + attackRoll + ", causing a damage of " + attackDamage + ".");
        System.out.println(defender.getName() + " defends with roll " + defenseRoll + ", reducing damage by " + defenseStrength + ".");
        System.out.println(defender.getName() + "'s health: " + defender.getHealth());
        System.out.println();
    }

    private void determineWinner(Player player1, Player player2) {

        // If player1 is not Alive, then player 2 is the winner
        if(!player1.isAlive()) {
            System.out.println("Game Over! " + player2.getName() + " wins!");
        }
        // If player 2 is not Alive, then player 1 is the winner
        else if(!player2.isAlive()) {
            System.out.println("Game Over! " + player1.getName() + " wins!");
        }
        // If both players are still alive (this case should not occur in the current setup)
        else {
            throw new IllegalStateException("The game is not over yet. Cannot determine the winner.");
        }
    }
}














