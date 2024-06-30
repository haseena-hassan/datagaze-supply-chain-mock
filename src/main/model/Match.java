package src.main.model;

import java.util.List;

/*
 Match class provide flexibility to extend game for different match types
 Currently extended for match involving 2 players, in future Match can be extended for Multi-player or Tournament matches
*/
public abstract class Match {
    protected List<Player> players;

    public Match(List<Player> players) {
        this.players = players;
    }

    /* startGame() can be implemented differently based upon the match type */
    public abstract void startGame();
}
