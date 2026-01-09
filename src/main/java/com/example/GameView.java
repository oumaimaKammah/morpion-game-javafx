package com.example;

import javafx.util.Duration;

import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * GameView class to manage the UI of the Tic-Tac-Toe game
 * 
 * @author Oumaima KAMMAH
 * 
 *         Methods:
 *         - handlePlayerMove(int row, int col) : handle the player's move at
 *         (row, col)
 *         - handelAiMove() : handle the AI's move
 *         - refreshUI() : refresh the UI to reflect the current state of the
 *         board
 *         - setStatusLabel(Label statusLabel) : set the status label to display
 *         messages
 *         - updateStatusLabel(String message) : update the status label with a
 *         new message
 *         - disableBoard() : disable all buttons on the game board
 *         - enableBoard() : enable all buttons on the game board
 *         - resetBoard() : reset the game board to start a new game
 */

public class GameView extends GridPane {

    private final Button[][] buttonCells = new Button[3][3];
    private Label statusLabel;
    private final GameBoard gameBoard;
    private final GameLogic gameLogic;

    public GameView() {
        this.getStyleClass().add("grid-pane");
        this.gameBoard = new GameBoard();
        this.gameLogic = new GameLogic(gameBoard);

        setAlignment(Pos.CENTER);
        setHgap(10);
        setVgap(10);

        createBoardUI();

    }

    private void createBoardUI() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button cell = new Button();
                cell.setPrefSize(200, 200);
                cell.getStyleClass().add("cell-button");
                buttonCells[row][col] = cell;
                add(cell, col, row);
                int r = row;
                int c = col;
                cell.setOnAction(e -> handlePlayerMove(r, c));
            }
        }
    }

    private void handlePlayerMove(int row, int col) {
        if (!gameBoard.isCellEmpty(row, col)) {
            return;
        }
        updateStatusLabel("Your turn!");
        gameBoard.setCell(row, col, "X");
        refreshUI();
        if (gameLogic.checkWin("X")) {
            updateStatusLabel("Player X wins!");
            disableBoard();
            return;
        }
        if (gameBoard.isBoardFull()) {
            updateStatusLabel("It's a draw!");
            disableBoard();
            return;
        }
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        updateStatusLabel("AI turn!");
        pause.setOnFinished(event -> handelAiMove());
        pause.play();
    }

    private void handelAiMove() {
        gameLogic.playAI();

        refreshUI();
        if (gameLogic.checkWin("O")) {
            updateStatusLabel("AI wins!");
            disableBoard();
            return;
        }
        if (gameBoard.isBoardFull()) {
            updateStatusLabel("It's a draw!");
            disableBoard();
            return;
        }
        updateStatusLabel("Your turn!");
    }

    private void refreshUI() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttonCells[row][col].setText(gameBoard.getCell(row, col));
                enableBoard();
            }
        }
    }

    public void setStatusLabel(Label statusLabel) {
        this.statusLabel = statusLabel;
    }

    public void updateStatusLabel(String message) {
        if (statusLabel != null) {
            statusLabel.setText(message);
        }
    }

    public Button[][] getButtonCells() {
        return buttonCells;
    }

    /**
     * Disable all buttons on the game board
     * called when the game ends
     */

    private void disableBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttonCells[row][col].setDisable(true);
            }
        }
    }

    /**
     * Enable all buttons on the game board
     * called when starting a new game
     */
    public void enableBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttonCells[row][col].setDisable(false);
            }
        }
    }

    /**
     * Reset the game board to start a new game
     */
    public void resetBoard() {
        gameBoard.resetBoard();
        refreshUI();
        updateStatusLabel("New Game! Your turn.");
    }
}
