package com.capgemini.tictactoe_game;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeGame {
	private static Scanner userinput = new Scanner(System.in);
	private static final int TAIL = 0;
	private static final int HEAD = 1;
	private static char usersChoice;
	private static char computer;
	private static char[] board;

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
			checkWinner(toss);
		} else {
			System.out.println("computer starts game");
			checkWinner(toss);
		}
	}

	// Check who is Winner or game is Tie
	private static void checkWinner(int toss) {

		if (toss == HEAD) {
			makeMove(board, usersChoice);
		} else if (toss == TAIL) {
			makeMove(board, computer);
		}

		if ((board[1] == board[2] && board[2] == board[3] && board[1] != ' ')
				|| (board[4] == board[5] && board[5] == board[6] && board[6] != ' ')
				|| (board[7] == board[8] && board[8] == board[9] && board[9] != ' ')
				|| (board[1] == board[4] && board[4] == board[7] && board[7] != ' ')
				|| (board[2] == board[5] && board[5] == board[8] && board[8] != ' ')
				|| (board[3] == board[6] && board[6] == board[9] && board[9] != ' ')
				|| (board[1] == board[5] && board[5] == board[9] && board[9] != ' ')
				|| (board[3] == board[5] && board[5] == board[7] && board[7] != ' ')) {
			if (toss == HEAD)
				System.out.println("Winner is User");
			if (toss == TAIL)
				System.out.println("Winner is Computer");
			System.exit(0);
		} else {
			if (board[1] != ' ' && board[2] != ' ' && board[3] != ' ' && board[4] != ' ' && board[5] != ' '
					&& board[6] != ' ' && board[7] != ' ' && board[8] != ' ' && board[9] != ' ') {
				System.out.println("Game is Tie");
				System.exit(0);
			} else {
				if (toss == HEAD) {
					toss--;
					checkWinner(toss);
				} else if (toss == TAIL) {
					toss++;
					checkWinner(toss);
				}
			}
		}
		displayBoard(board);
	}

	public static int computerPlaysWithBrain(char[] board, char choice) {
		int index = 0;
		while (index == 0) {
			int i = (int) (Math.floor((Math.random() * 10) % 9) + 1);
			if (spaceFree(board, i))
				index = i;
		}
		if (choice == computer) {
			if (((board[1] == board[2] && board[1] == computer) || (board[5] == board[7] && board[5] == computer)
					|| (board[6] == board[9] && board[6] == computer)) && board[3] == ' ') {
				index = 3;
			} else if (((board[4] == board[5] && board[4] == computer)
					|| (board[3] == board[9] && board[3] == computer)) && board[6] == ' ') {
				index = 6;
			} else if (((board[5] == board[1] && board[1] == computer) || (board[8] == board[7] && board[7] == computer)
					|| (board[6] == board[3] && board[6] == computer)) && board[9] == ' ') {
				index = 9;
			} else if (((board[3] == board[2] && board[3] == computer) || (board[4] == board[7] && board[4] == computer)
					|| (board[5] == board[9] && board[5] == computer)) && board[1] == ' ') {
				index = 1;
			} else if (((board[1] == board[7] && board[1] == computer)
					|| (board[5] == board[6] && board[5] == computer)) && board[4] == ' ') {
				index = 4;
			} else if (((board[1] == board[4] && board[1] == computer) || (board[5] == board[3] && board[5] == computer)
					|| (board[8] == board[9] && board[8] == computer)) && board[7] == ' ') {
				index = 7;
			} else if (((board[1] == board[3] && board[1] == computer)
					|| (board[5] == board[8] && board[5] == computer)) && board[2] == ' ') {
				index = 2;
			} else if (((board[5] == board[2] && board[5] == computer)
					|| (board[7] == board[9] && board[7] == computer)) && board[8] == ' ') {
				index = 8;
			} else if (((board[1] == board[9] && board[1] == computer) || (board[3] == board[7] && board[3] == computer)
					|| (board[6] == board[4] && board[6] == computer)) && board[5] == ' ') {
				index = 5;
			} else if (((board[1] == board[2] && board[1] == usersChoice)
					|| (board[5] == board[7] && board[5] == usersChoice)
					|| (board[6] == board[9] && board[6] == usersChoice)) && board[3] == ' ') {
				index = 3;
			} else if (((board[4] == board[5] && board[4] == usersChoice)
					|| (board[3] == board[9] && board[3] == usersChoice)) && board[6] == ' ') {
				index = 6;
			} else if (((board[5] == board[1] && board[1] == usersChoice)
					|| (board[8] == board[7] && board[7] == usersChoice)
					|| (board[6] == board[3] && board[6] == usersChoice)) && board[9] == ' ') {
				index = 9;
			} else if (((board[3] == board[2] && board[3] == usersChoice)
					|| (board[4] == board[7] && board[4] == usersChoice)
					|| (board[5] == board[9] && board[5] == usersChoice)) && board[1] == ' ') {
				index = 1;
			} else if (((board[1] == board[7] && board[1] == usersChoice)
					|| (board[5] == board[6] && board[5] == usersChoice)) && board[4] == ' ') {
				index = 4;
			} else if (((board[1] == board[4] && board[1] == usersChoice)
					|| (board[5] == board[3] && board[5] == usersChoice)
					|| (board[8] == board[9] && board[8] == usersChoice)) && board[7] == ' ') {
				index = 7;
			} else if (((board[1] == board[3] && board[1] == usersChoice)
					|| (board[5] == board[8] && board[5] == usersChoice)) && board[2] == ' ') {
				index = 2;
			} else if (((board[5] == board[2] && board[5] == usersChoice)
					|| (board[7] == board[9] && board[7] == usersChoice)) && board[8] == ' ') {
				index = 8;
			} else if (((board[1] == board[9] && board[1] == usersChoice)
					|| (board[3] == board[7] && board[3] == usersChoice)
					|| (board[6] == board[4] && board[6] == usersChoice)) && board[5] == ' ') {
				index = 5;
			} else if (board[1] == ' ' && board[2] != ' ' && board[3] != ' ' && board[4] != ' ' && board[5] != ' '
					&& board[6] != ' ' && board[7] != ' ' && board[8] != ' ' && board[9] != ' ') {
				index = 1;
			} else if (board[3] == ' ' && board[1] != ' ' && board[2] != ' ' && board[4] != ' ' && board[5] != ' '
					&& board[6] != ' ' && board[7] != ' ' && board[8] != ' ' && board[9] != ' ') {
				index = 3;
			} else if (board[7] == ' ' && board[1] != ' ' && board[2] != ' ' && board[3] != ' ' && board[4] != ' '
					&& board[5] != ' ' && board[6] != ' ' && board[8] != ' ' && board[9] != ' ') {
				index = 7;
			} else if (board[9] == ' ' && board[1] != ' ' && board[2] != ' ' && board[3] != ' ' && board[4] != ' '
					&& board[5] != ' ' && board[6] != ' ' && board[7] != ' ' && board[8] != ' ') {
				index = 9;
			} else if (board[5] == ' ' && board[1] != ' ' && board[2] != ' ' && board[3] != ' ' && board[4] != ' '
					&& board[6] != ' ' && board[7] != ' ' && board[8] != ' ' && board[9] != ' ') {
				index = 5;
			} else if (board[2] == ' ' && board[1] != ' ' && board[3] != ' ' && board[4] != ' ' && board[5] != ' '
					&& board[6] != ' ' && board[7] != ' ' && board[8] != ' ' && board[9] != ' ') {
				index = 2;
			} else if (board[4] == ' ' && board[1] != ' ' && board[2] != ' ' && board[3] != ' ' && board[5] != ' '
					&& board[6] != ' ' && board[7] != ' ' && board[8] != ' ' && board[9] != ' ') {
				index = 4;
			} else if (board[6] == ' ' && board[1] != ' ' && board[2] != ' ' && board[3] != ' ' && board[4] != ' '
					&& board[5] != ' ' && board[7] != ' ' && board[8] != ' ' && board[9] != ' ') {
				index = 6;
			} else if (board[8] == ' ' && board[1] != ' ' && board[2] != ' ' && board[3] != ' ' && board[4] != ' '
					&& board[5] != ' ' && board[6] != ' ' && board[7] != ' ' && board[9] != ' ') {
				index = 8;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		char board[] = new char[10];
		TicTacToeGame game = new TicTacToeGame();
		game.createBoard();
		usersChoice = chooseLetter();
		TicTacToeGame.displayBoard(board);
		int userMove = locationSelection(board);
		makeMove(board, usersChoice);
		game.checkToss();
	}
}
