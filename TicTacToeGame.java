package com.capgemini.tictactoe_game;

import java.util.Scanner;

public class TicTacToeGame {
	private static Scanner userinput = new Scanner(System.in);
	private static final int HEAD = 1;
	private char currentPlayerMark;

	public void createBoard() {
		char board[][] = new char[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}
	}

	public static char chooseLetter() {
		System.out.println("Enter User letter O or X");
		char user = userinput.next().charAt(0);
		System.out.println(user);
		if (user == 'O' || user == 'o') {
			System.out.println("computers letter selection is: 
X");
		} else {
			System.out.println("computers letter selection is: O");
		}
		return user;
	}

	public static void displayBoard(char board[][]) {
		System.out.println("\n " + board[0][0] + " |" + board[0][1] + " |" + board[0][2]);
		System.out.println("____________");
		System.out.println("\n " + board[1][0] + " |" + board[1][1] + " |" + board[1][2]);
		System.out.println("____________");
		System.out.println("\n " + board[2][0] + " |" + board[2][1] + " |" + board[2][2]);
	}



	public static void main(String[] args) {
		char board[][] = new char[3][3];
		TicTacToeGame game = new TicTacToeGame();
		game.createBoard();
		chooseLetter();
		displayBoard( board);
	}
}
