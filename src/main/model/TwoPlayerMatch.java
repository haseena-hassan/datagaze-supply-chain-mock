package src.main.model;

import java.util.List;

public class TwoPlayerMatch extends Match{
    private final Arena arena;

    public TwoPlayerMatch(Arena arena, List<Player> players) {
        super(players);
        this.arena = arena;
    }

    @Override
    public void startGame() {
        if(players.size() < 2)  {
            throw new IllegalArgumentException("One-on-one match requires at least two players.");
        }
        // TODO: invoke Arena.fight() by passing in the first attacker and defender as parameters.
    }
}
