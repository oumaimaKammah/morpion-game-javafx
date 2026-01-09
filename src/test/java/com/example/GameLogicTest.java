package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GameLogicTest {

    @Test
    void testWinRow() {
        GameBoard board = new GameBoard();
        GameLogic logic = new GameLogic(board);

        board.setCell(0, 0, "X");
        board.setCell(0, 1, "X");
        board.setCell(0, 2, "X");

        assertTrue(logic.checkWin("X"));
    }

    @Test
    void testWinColumn() {
        GameBoard board = new GameBoard();
        GameLogic logic = new GameLogic(board);

        board.setCell(0, 1, "O");
        board.setCell(1, 1, "O");
        board.setCell(2, 1, "O");

        assertTrue(logic.checkWin("O"));
    }

    @Test
    void testWinDiagonal() {
        GameBoard board = new GameBoard();
        GameLogic logic = new GameLogic(board);

        board.setCell(0, 0, "X");
        board.setCell(1, 1, "X");
        board.setCell(2, 2, "X");

        assertTrue(logic.checkWin("X"));
    }

    @Test
    void testNoWin() {
        GameBoard board = new GameBoard();
        GameLogic logic = new GameLogic(board);

        board.setCell(0, 0, "X");
        board.setCell(0, 1, "O");
        board.setCell(0, 2, "X");

        assertFalse(logic.checkWin("X"));
    }

    @Test
    void testAIPlaysValidMove() {
        GameBoard board = new GameBoard();
        GameLogic logic = new GameLogic(board);

        logic.playAI();

        boolean foundMove = false;

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (!board.getCell(r, c).isEmpty()) {
                    foundMove = true;
                }
            }
        }

        assertTrue(foundMove);
    }
}
