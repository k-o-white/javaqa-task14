package ru.netology;

import java.util.HashMap;

public class Game {
    private HashMap<String, Player> registeredPlayers = new HashMap<>();

    public void register(Player player) {
        registeredPlayers.put(player.getName(), player);
    }

    private Player findPlayerByName(String playerName) {
        for (String key : registeredPlayers.keySet()) {
            if (key.equals(playerName)) {
                return (registeredPlayers.get(key));
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = this.findPlayerByName(playerName1);
        Player player2 = this.findPlayerByName(playerName2);
        if (player1 == null) {
            throw new NotRegisteredException("Player " + playerName1 + " isn't registered.");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Player " + playerName2 + " isn't registered.");
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;
    }
}
