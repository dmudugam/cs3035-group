package com.cs3035.cs3035group.TicTacToe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameControllerTest {

    private GameController gameController;

    @BeforeEach
    public void setUp() {
        gameController = new GameController();
    }

    @Test
    public void testInitialCurrentPlayer() {
        assertEquals('X', gameController.getCurrentPlayer(), "Initial player should be X");
    }

    @Test
    public void testPlaceMark() {
        assertTrue(gameController.placeMark(0, 0), "Should be able to place mark at (0, 0)");
        assertEquals('X', gameController.getCurrentPlayer(), "Current player should still be X after placing mark");
        assertFalse(gameController.placeMark(0, 0), "Should not be able to place mark at (0, 0) again");
    }

    @Test
    public void testSwitchPlayer() {
        gameController.placeMark(0, 0);
        gameController.switchPlayer();
        assertEquals('O', gameController.getCurrentPlayer(), "Current player should be O after switching");
    }

    @Test
    public void testCheckForWinner_Row() {
        gameController.placeMark(0, 0);
        gameController.switchPlayer();
        gameController.placeMark(1, 0);
        gameController.switchPlayer();
        gameController.placeMark(0, 1);
        gameController.switchPlayer();
        gameController.placeMark(1, 1);
        gameController.switchPlayer();
        gameController.placeMark(0, 2);
        assertEquals('X', gameController.checkForWinner(), "Player X should win with a row");
    }

    @Test
    public void testCheckForWinner_Column() {
        gameController.placeMark(0, 0);
        gameController.switchPlayer();
        gameController.placeMark(0, 1);
        gameController.switchPlayer();
        gameController.placeMark(1, 0);
        gameController.switchPlayer();
        gameController.placeMark(1, 1);
        gameController.switchPlayer();
        gameController.placeMark(2, 0);
        assertEquals('X', gameController.checkForWinner(), "Player X should win with a column");
    }

    @Test
    public void testCheckForWinner_Diagonal() {
        gameController.placeMark(0, 0);
        gameController.switchPlayer();
        gameController.placeMark(0, 1);
        gameController.switchPlayer();
        gameController.placeMark(1, 1);
        gameController.switchPlayer();
        gameController.placeMark(1, 2);
        gameController.switchPlayer();
        gameController.placeMark(2, 2);
        assertEquals('X', gameController.checkForWinner(), "Player X should win with a diagonal");
    }

    @Test
    public void testResetGame() {
        gameController.placeMark(0, 0);
        gameController.switchPlayer();
        gameController.placeMark(0, 1);
        gameController.resetGame();
        assertEquals('X', gameController.getCurrentPlayer(), "Current player should be reset to X");
        assertEquals(' ', gameController.checkForWinner(), "There should be no winner after reset");
        assertTrue(gameController.placeMark(0, 0), "Should be able to place mark at (0, 0) after reset");
    }
}