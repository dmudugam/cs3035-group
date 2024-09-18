package com.cs3035.cs3035group.TicTacToe;

public class GameController {
    private char currentPlayer = 'X';

    private char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    public boolean placeMark(int row, int col) {
        if (row >= 0 && col >= 0 && row < 3 && col < 3) {
            if (board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                return true;
            }
        }

        return false;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public char checkForWinner() {
        for (int i = 0; i < 3; i++) {
            char rowWinner = checkRow(i);
            if (rowWinner != ' ') {
                return rowWinner;
            }

            char colWinner = checkColumn(i);
            if (colWinner != ' ') {
                return colWinner;
            }
        }

        return checkDiagonal();
    }

    private char checkRow(int row) {
        if (board[row][0] == board[row][1] && board[row][1] == board[row][2] && board[row][0] != ' ') {
            return board[row][0];
        }

        return ' ';
    }

    private char checkColumn(int col) {
        if (board[0][col] == board[1][col] && board[1][col] == board[2][col] && board[0][col] != ' ') {
            return board[0][col];
        }

        return ' ';
    }

    private char checkDiagonal() {
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
            return board[0][0];
        }

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
            return board[0][2];
        }

        return ' ';
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }
}