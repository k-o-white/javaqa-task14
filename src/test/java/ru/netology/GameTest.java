package ru.netology;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class GameTest {

    public Game createGame() {
        Game result = new Game();
        Player p1 = new Player(1, "Ezio", 80);
        Player p2 = new Player(3, "Altair", 70);
        Player p3 = new Player(5, "Connor", 60);
        Player p4 = new Player(7, "Arno", 80);
        Player p5 = new Player(9, "Edward", 75);
        result.register(p1);
        result.register(p2);
        result.register(p3);
        result.register(p4);
        result.register(p5);
        return result;
    }

    @Test
    public void TestPlayer1IsNotRegistered() {
        Game game = createGame();
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Haytham", "Connor");
        });
    }

    @Test
    public void TestPlayer2IsNotRegistered() {
        Game game = createGame();
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Ezio", "Jacob");
        });
    }

    @Test
    public void TestPlayer1WonRound() {
        Game game = createGame();
        int expected = 1;
        int actual = game.round("Ezio", "Altair");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestPlayer2WonRound() {
        Game game = createGame();
        int expected = 2;
        int actual = game.round("Connor", "Edward");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestTieRound() {
        Game game = createGame();
        int expected = 0;
        int actual = game.round("Arno", "Ezio");
        Assertions.assertEquals(expected, actual);
    }
}
