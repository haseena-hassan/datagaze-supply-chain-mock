package src.main.service;

import src.main.model.Player;

/*
 General interface for any player object creation
 Acts as a factory allowing for different ways of player creation
*/
public interface PlayerFactory {
    Player createPlayer();
}
