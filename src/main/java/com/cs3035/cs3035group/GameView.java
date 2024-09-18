package com.cs3035.cs3035group;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class GameView extends GridPane {
    private GameController gameController = new GameController();

    public GameView() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = new Button();
                button.setMinWidth(60);
                button.setMinHeight(60);
                int finalI = i;
                int finalJ = j;
                button.setOnAction(e -> {
                    if ("".equals(button.getText()) && gameController.placeMark(finalI, finalJ)) {
                        button.setText(String.valueOf(gameController.getCurrentPlayer()));
                        char winner = gameController.checkForWinner();
                        if (winner != ' ') {
                            System.out.println("Player " + winner + " wins!");
                        }
                    }
                });

                add(button, j, i);
            }
        }
    }
}