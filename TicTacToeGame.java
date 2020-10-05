package com.capgemini.tictactoe_game;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeGame {
	private static Scanner userinput = new Scanner(System.in);
	private static final int HEAD = 1;
	private static char usersChoice;;

	public void createBoard() {
		char[] board = new char[10];
		for (int i = 1; i < board.length; i++) {
			board[i] = ' ';
		}
	}

	public static char chooseLetter() {
		System.out.println("Enter User letter O or X");
		char user = userinput.next().charAt(0);
		System.out.println(user);
		if (user == 'O' || user == 'o') {
			System.out.println("computers letter selection is: X");
		} else {
			System.out.println("computers letter selection is: O");
		}
		return user;
	}

	public static void displayBoard(char board[]) {
		System.out.println("\n" + board[1] + "|" + board[2] + "|" + board[3]);
		System.out.println("____________");
		System.out.println("\n" + board[4] + "|" + board[5] + "|" + board[6]);
		System.out.println("____________");
		System.out.println("\n" + board[7] + "|" + board[8] + "|" + board[9]);
	}

	private static int locationSelection(char board[]) {
		Scanner sc = new Scanner(System.in);
		boolean available = false;
		int index = 0;
		Integer[] validCells = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		do {
			System.out.println("Choose a index on Board from 1 to 9 where to move:");
			index = sc.nextInt();
			if (spaceFree(board, index) && Arrays.asList(validCells).contains(index))
				available = true;
		} while (available == false);
		return index;
	}

	public static boolean spaceFree(char board[], int index) {
		return board[index] == ' ';
	}

	private static void makeMove(char[] board, char choice) {
		if (choice == usersChoice) {
			int index = locationSelection(board);
			board[index] = choice;
		}
		displayBoard(board);
	}

	public void checkToss() {
		int toss = (int) (Math.floor(Math.random() * 10) % 2);
		if (toss == HEAD) {
			System.out.println("player starts game");
		} else {
			System.out.println("computer starts game");
		}
	}

	public static void main(String[] args) {
		char board[] = new char[10];
		TicTacToeGame game = new TicTacToeGame();
		game.createBoard();
		char userLetter = chooseLetter();
		TicTacToeGame.displayBoard(board);
		int userMove = locationSelection(board);
		makeMove(board, userLetter);
	}
}
