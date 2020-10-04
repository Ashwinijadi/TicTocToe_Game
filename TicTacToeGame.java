package com.capgemini.tictactoe_game;

import java.util.Scanner;

public class TicTacToeGame {
	public void createBoard() {
		char board[] = new char[10];
		for (int i = 1; i < board.length; i++) {
			board[i] = '-';
		}
	}
	public static void chooseLetter() {
		System.out.println("Enter User letter O or X");
		Scanner userinput = new Scanner(System.in);
		char user = userinput.next().charAt(0);
		System.out.println(user);
		if (user == 'O' || user =='o') {
			System.out.println("computers X");
		} else {
			System.out.println("computers O");
		}
	}
	public static void main(String[] args) {
		TicTacToeGame game = new TicTacToeGame();
		game.createBoard();
		chooseLetter();	}
}
