package src.main.model;

public class Player {
    private final String name;
    private int health;
    private final int strength;
    private final int attack;

    public Player(String name, int health, int strength, int attack) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.attack = attack;
        validatePlayer();
    }

    private void validatePlayer() {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (health <= 0) {
            throw new IllegalArgumentException("Health must be greater than zero");
        }
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getAttack() {
        return attack;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    @Override
    public String toString() {
        return  name + "\t[ Health = " + health + ", Strength = " + strength + ", Attack = " + attack + "]";
    }
}
