package com.example;

public class GameLogic {
    private GameBoard gameBoard;

    public GameLogic(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    /**
     * Verify if a player has won the game
     * 
     * @param player the player symbol ("X" or "O")
     * @return true if the player has won, false otherwise
     */
    protected boolean checkWin(String player) {
        for (int row = 0; row < 3; row++) {
            if (gameBoard.getCell(row, 0).equals(player) &&
                    gameBoard.getCell(row, 1).equals(player) &&
                    gameBoard.getCell(row, 2).equals(player)) {
                return true;
            }
        }
        for (int col = 0; col < 3; col++) {
            if (gameBoard.getCell(0, col).equals(player) &&
                    gameBoard.getCell(1, col).equals(player) &&
                    gameBoard.getCell(2, col).equals(player)) {
                return true;
            }

        }
        if (gameBoard.getCell(0, 0).equals(player) &&
                gameBoard.getCell(1, 1).equals(player) &&
                gameBoard.getCell(2, 2).equals(player)) {
            return true;
        }
        if (gameBoard.getCell(0, 2).equals(player) &&
                gameBoard.getCell(1, 1).equals(player) &&
                gameBoard.getCell(2, 0).equals(player)) {
            return true;
        }
        return false;

    }

    protected void playAI() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (gameBoard.isCellEmpty(row, col)) {
                    gameBoard.setCell(row, col, "O");
                    return;
                }
            }
        }
    }
}
