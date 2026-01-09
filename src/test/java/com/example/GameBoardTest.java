package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameBoardTest {

    @Test
    void testSetAndGetCell() {
        GameBoard board = new GameBoard();
        board.setCell(0, 0, "X");

        assertEquals("X", board.getCell(0, 0));
    }

    @Test
    void testBoardIsInitiallyEmpty() {
        GameBoard board = new GameBoard();

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                assertEquals("", board.getCell(r, c));
            }
        }
    }

    @Test
    void testBoardFull() {
        GameBoard board = new GameBoard();

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board.setCell(r, c, "X");
            }
        }

        assertTrue(board.isBoardFull());
    }

    @Test
    void testResetBoard() {
        GameBoard board = new GameBoard();
        board.setCell(1, 1, "O");

        board.resetBoard();

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                assertEquals("", board.getCell(r, c));
            }
        }
    }
}
