package com.example;

/**
 * GameBoard class to manage the state of the Tic-TacToe board
 * 
 * @author Oumaima KAMMAH
 * 
 *         Methods:
 *         - getCell(int row, int col) : return the value of the cell at (row,
 *         col)
 *         - setCell(int row, int col, String value) : set the value of the cell
 *         at (row, col)
 *         - resetBoard() : reset the board to its initial state
 *         - isCellEmpty(int row, int col) : check if the cell at (row, col) is
 *         empty
 *         - isCellFull(int row, int col) : check if the cell at (row, col) is
 *         full
 *         - isBoardFull() : check if the board is full
 */
class GameBoard {
    private final String[][] board = new String[3][3];

    public GameBoard() {
        resetBoard();
    }

    public String getCell(int row, int col) {
        return board[row][col];
    }

    public void setCell(int row, int col, String value) {
        this.board[row][col] = value;
    }

    public void resetBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = "";
            }
        }
    }

    public boolean isCellEmpty(int row, int col) {
        return board[row][col].isEmpty();
    }

    public boolean isCellFull(int row, int col) {
        return !isCellEmpty(row, col);
    }

    public boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (isCellEmpty(row, col)) {
                    return false;
                }
            }
        }
        return true;
    }

}