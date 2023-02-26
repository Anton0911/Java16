package org.example;

import org.example.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestGame {

    Game game = new Game();

    @Test
    public void ShouldOnePlayerWins() {
        Player player1 = new Player(1, "Иван", 120);
        Player player2 = new Player(2, "Алексей", 10);
        game.register(player1);
        game.register(player2);
        int expected = game.round("Иван", "Алексей");
        int actual = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void ShouldTwoPlayerWins() {
        Player player1 = new Player(1, "Иван", 120);
        Player player2 = new Player(2, "Алексей", 200);
        game.register(player1);
        game.register(player2);
        int expected = game.round("Иван", "Алексей");
        int actual = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void ShouldDraw() {
        Player player1 = new Player(1, "Иван", 200);
        Player player2 = new Player(2, "Алексей", 200);
        game.register(player1);
        game.register(player2);
        int expected = game.round("Иван", "Алексей");
        int actual = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void ShouldPlayerNotExisting() {
        Player player1 = new Player(1, "Иван", 200);
        Player player2 = new Player(2, "Алексей", 200);
        game.register(player1);
        game.register(player2);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Иван", "Василий");
        });
        assertThrows(NotRegisteredException.class, () -> {
            game.round("Петр", "Алексей");
        });
    }

}
