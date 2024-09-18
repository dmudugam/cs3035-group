package com.cs3035.cs3035group;

import com.cs3035.cs3035group.TicTacToe.GameView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    private void handlePlayButtonAction(ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Tic Tac Toe");
        alert.setHeaderText(null);
        alert.setContentText("Starting Tic Tac Toe game...");
        alert.showAndWait();
        
        // Create a new stage for the Tic Tac Toe game
        Stage gameStage = new Stage();
        gameStage.setTitle("Tic Tac Toe");

        // Create an instance of GameView
        GameView gameView = new GameView();

        // Set the scene with the GameView
        Scene scene = new Scene(gameView, 200, 200);
        gameStage.setScene(scene);

        // Show the game stage
        gameStage.show();
    }
}