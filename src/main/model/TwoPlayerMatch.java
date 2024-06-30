package src.main.model;

import java.util.List;

/*
  TwoPlayerMatch manages an Arena with a fight logic and List of 2 players
*/
public class TwoPlayerMatch extends Match{
    private final Arena arena;

    public TwoPlayerMatch(Arena arena, List<Player> players) {
        super(players);
        this.arena = arena;
    }

    // start game for a two-player match
    @Override
    public void startGame() {

        // Validate number of players in the list
        if(players.size() < 2)  {
            throw new IllegalArgumentException("One-on-one match requires at least two players.");
        }

        // Invoke arena.fight by passing player with lower health as attacker and other as defender.
        if(players.get(0).getHealth() <= players.get(1).getHealth()) {
            arena.fight(players.get(0), players.get(1));
        }
        else {
            arena.fight(players.get(1), players.get(0));
        }
    }
}
