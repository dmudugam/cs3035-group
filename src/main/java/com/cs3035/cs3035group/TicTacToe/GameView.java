package com.cs3035.cs3035group.TicTacToe;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class GameView extends GridPane {
    private GameController gameController = new GameController();
    private boolean gameEnded = false;

    public GameView() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = new Button();
                button.setMinWidth(60);
                button.setMinHeight(60);
                int finalI = i;
                int finalJ = j;
                button.setOnAction(e -> {
                    if (!gameEnded && "".equals(button.getText()) && gameController.placeMark(finalI, finalJ)) {
                        button.setText(String.valueOf(gameController.getCurrentPlayer()));
                        char winner = gameController.checkForWinner();
                        if (winner != ' ') {
                            gameEnded = true;
                            showWinnerAlert(winner);
                        } else {
                            gameController.switchPlayer();
                        }
                    }
                });

                add(button, j, i);
            }
        }
    }

    private void showWinnerAlert(char winner) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.setContentText("Player " + winner + " wins!");
        alert.showAndWait();
    }
}