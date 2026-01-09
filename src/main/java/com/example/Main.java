package com.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * JavaFX Morpion Game Application
 * 
 * @author Oumaima KAMMAH
 */

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        GameView gameView = new GameView();

        Label statusLabel = new Label("Welcome to Tic-Tac-Toe! Your turn.");
        gameView.setStatusLabel(statusLabel);
        statusLabel.getStyleClass().add("status-label");

        Button resetButton = new Button("Reset Game");
        resetButton.getStyleClass().add("reset-button");

        resetButton.setOnAction(e -> gameView.resetBoard());

        HBox bottomBox = new HBox(10, statusLabel, resetButton);
        bottomBox.setAlignment(Pos.CENTER);

        BorderPane root = new BorderPane();
        root.getStyleClass().add("root-pane");
        root.setCenter(gameView);
        root.setBottom(bottomBox);

        Scene scene = new Scene(root, 650, 700);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        primaryStage.setTitle("Tic-Tac-Toe Game");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
