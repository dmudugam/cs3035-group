package com.cs3035.cs3035group;

public class GameController {
    private char currentPlayer = 'O';

    private char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    public boolean placeMark(int row, int col) {
        if (row >= 0 && col >= 0 && row < 3 && col < 3) {
            if (board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                return true;
            }
        }

        return false;
    }

    public char checkForWinner() {
        for (int i = 0; i < 3; i++) {
            if (checkRow(i) != ' ' || checkColumn(i) != ' ') {
                return board[i][0];
            }
        }

        if (checkDiagonal() != ' ') {
            return board[1][1];
        }

        return ' ';
    }

    private char checkRow(int row) {
        if (board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
            return board[row][0];
        }

        return ' ';
    }

    private char checkColumn(int col) {
        if (board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
            return board[0][col];
        }

        return ' ';
    }

    private char checkDiagonal() {
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0];
        }

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][2];
        }

        return ' ';
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    };
}