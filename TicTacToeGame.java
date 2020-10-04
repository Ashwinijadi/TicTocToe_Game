package com.capgemini.tictactoe_game;

public class TicTacToeGame {
	public void createBoard() {
		char board[] = new char[10];
		for (int i = 1; i < board.length; i++) {
			board[i] = '-';
		}
	}

	public static void main(String[] args) {
		TicTacToeGame game = new TicTacToeGame();
		game.createBoard();

	}
}
