package src.main.model;

import java.util.List;

// Match class provide flexibility to extend game for new match types
abstract class Match {
    protected List<Player> players;

    public Match(List<Player> players) {
        this.players = players;
    }

    public abstract void startGame();
}
