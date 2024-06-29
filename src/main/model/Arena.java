package src.main.model;

import java.util.Random;

public class Arena {
    private Player player1;
    private Player player2;
    private Random random;

    public Arena(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.random = new Random();
    }

    // TODO: Refactor fight method into smaller methods - takeTurns and fight
    public void fight() {
        Player attacker = (player1.getHealth() <= player2.getHealth()) ? player1 : player2;
        Player defender = (attacker == player1) ? player2 : player1;

        while(!isGameOver()) {
            int attackRoll = rollDie();
            int defenseRoll = rollDie();

            int attackDamage = attacker.getAttack() * attackRoll;
            int defenseStrength = defender.getStrength() * defenseRoll;

            int damage = Math.max(0, attackDamage - defenseStrength);
            defender.setHealth(defender.getHealth() - damage);

            System.out.println(attacker.getName() + " attacks " + defender.getName() +
                    " with roll " + attackRoll + ", causing " + attackDamage + " damage.");
            System.out.println(defender.getName() + " defends with roll " + defenseRoll +
                    ", reducing damage by " + defenseStrength + ".");
            System.out.println("Overall Damage on " + defender.getName() + ": " + damage);
            System.out.println(defender.getName() + "'s health: " + defender.getHealth());
            System.out.println();

            // Swap roles for next round
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }
    }

    public boolean isGameOver() {

        return player1.getHealth() <= 0 || player2.getHealth() <= 0;
    }

    // TODO: Refactor die rolling into separate Dice class
    private int rollDie() {
        // Six sided die with values from 1 to 6
        return random.nextInt(6) + 1;
    }

    // TODO: add method to determine winner


}














