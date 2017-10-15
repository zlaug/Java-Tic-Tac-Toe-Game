// Zach Laug
// March 2017
// Tic Tac Toe Java Game

import java.util.Scanner;

public class TicTacToe {

	private char[][] board;
	public char currentPlayerMark;
	
	public TicTacToe() {
		board = new char[3][3];
		currentPlayerMark = 'X';
		initializeBoard();
	}
	
	public void initializeBoard() {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3;j++) {
				board[i][j] = '-';
			}
		}
	}
	
	public void printBoard() {
		System.out.println("-------------");
		
		for(int i=0; i<3; i++) {
			System.out.print("| ");
			for(int j=0; j<3; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}
	
	public boolean isBoardFull() {
		boolean isFull = true;
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(board[i][j] == '-') {
					isFull = false;
				}
			}
		}
		return isFull;
	}
	
	private boolean checkRowsForWin() {
		for(int i=0; i<3; i++) {
			if(checkRowCol(board[i][0], board[i][1], board[i][2]) == true) {
				return true;
			}
		}
		return false;
	}
	
	private boolean checkColumnsForWin() {
		for(int i=0; i<3; i++) {
			if(checkRowCol(board[0][i], board[1][i], board[2][i]) == true) {
				return true;
			}
		}
		return false;
	}
	
	private boolean checkDiagonalsForWin() {
		return ((checkRowCol(board[0][0], board[1][1], board[2][2]) == true) || (checkRowCol(board[0][2], board[1][1], board[2][0]) == true));
	}
	
	private boolean checkRowCol(char c1, char c2, char c3) {
		return ((c1 != '-') && (c1 == c2) && (c2 == c3));
	}
	
	public boolean checkForWin() {
		return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
	}
	
	public void changePlayer() {
		if(currentPlayerMark == 'X') {
			currentPlayerMark = 'O';
		} else {
			currentPlayerMark = 'X';
		}
	}
	
	public boolean placeMark(int a, int b) {
		int row = a;
		int col = b;
		
		if((row>0) && (row<4)) { 
			if((col >0) && (col<4)) {
				if(board[row-1][col-1] == '-') {
					board[row-1][col-1] = currentPlayerMark;
					return true;
				}
			}
		}
		return false;
	}
	
public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		
		TicTacToe game = new TicTacToe();
		System.out.println("Welcome to Tic Tac Toe! Enter moves in the form (row, column)");
		
		if(game.checkForWin()) {
			System.out.println("We have a winner!");
			System.exit(0);
		} else {
			if(game.isBoardFull()) {
				System.out.println("Tie game!");
				System.exit(0);
			}
		}
		
		while(game.isBoardFull() == false) {
			System.out.println("Player " + game.currentPlayerMark + " please enter the row of your move");
			int row = kb.nextInt();
				if(row > 3 || row == 0) {
					System.out.println("Please enter a valid row");
				}
			System.out.println("Player " + game.currentPlayerMark + " please enter the column of your move");
			int col = kb.nextInt();
				if(col > 3 || col == 0) {
					System.out.println("Please enter a valid column");
				}
			game.placeMark(row, col);
			game.printBoard();
			game.changePlayer();
			if(game.checkForWin() == true) {
				System.out.println("We have a winner!");
				System.exit(0);
			}
		}
	}

}
