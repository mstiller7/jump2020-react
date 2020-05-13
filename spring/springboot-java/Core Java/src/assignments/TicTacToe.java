package assignments;

import java.util.Scanner;

public class TicTacToe {

	static char[][] board;
	// if the amount of turns is above 9, game over
	static int turns;

	public static void main(String[] args) {

//		Create a Tic-tac-toe game. The game should accept two players and print a new
//		board to the screen each time a player adds an X or O to the board. 
//		Once the game is complete and a winner is declared, give the option to restart the game. 
//		BONUS: Each new player can give a username and each win the player gets is logged to a high score board.

		// board format:
		//   | 1 | 2 | 3 |
		// a |   |   |   |
		// b |   |   |   |
		// c |   |   |   |

		// order-of-operations:
		// 1) instantiate/clean any necessary variables.
		// 2) blank board is printed; "player 1, enter coordinate. (e.g. a2)"
		// 3) if the coordinate has no value (is null or empty string), place an 'x'
		// into the array.
		// 4) test if there is any correct sequence on the board, based on the modified
		// arrays. if there is, break and display win
		// 5) swap the character to be placed to 'o'. print "player 2, enter coordinate.
		// (e.g. c1)"
		// 6) continue until (4) happens.

		setup();

	}

	public static void setup() {

		board = new char[3][3];
		turns = 0;

		run();

	}

	// possibly later, track amount of turns before a player wins and use this as
	// the scoring mechanic.
	public static void run() {

		// which column/row we're currently in.
		int index_row = 0;
		int index_col = 0;

		// which player is active.
		boolean player1 = true;

		// whether the game has been won.
		boolean won = false;

		Scanner input = new Scanner(System.in);

		// =====================================================
		// Begin the game.
		// =====================================================

		do {
			
			// print out the board.
			printBoard();

			// get the user input.
			System.out.println("Player " + (player1 ? '1' : '2') + ", enter coordinate. (e.g. 'a2')");
			char[] coord = input.nextLine().toLowerCase().trim().toCharArray();

			// =====================================================
			// convert the input to letter-number form.
			// =====================================================

			// transform the row letter into an array index.
			switch (coord[0]) {
			case 'a':
				index_row = 0;
				break;
			case 'b':
				index_row = 1;
				break;
			case 'c':
				index_row = 2;
				break;
			}

			// obtain the number, the second character.
			index_col = Character.getNumericValue(coord[1])-1;

			// =====================================================
			// check whether a char exists there.
			// =====================================================

			char c = board[index_row][index_col];
			if (c != 0) {
				// there's already a char there. try again.
				System.out.println("Spot already taken. Try again elsewhere.");
				continue;

			} else {
				// place the character.
				board[index_row][index_col] = player1 ? 'x' : 'o';
			}
			
			// =====================================================
			// check if the game has been won or lost.
			// =====================================================
			
			// need to check:
			// 1) horizontal row
			// 2) vertical row
			// 3) possible diagonals, for the middle or corner spots.
			// 4) whether all arrays are full (contain non-zero values)
			
			char[] row = board[index_row];
			char[] col = {board[0][index_col], board[1][index_col], board[2][index_col]};
			char[] dlr = {board[0][0], board[1][1], board[2][2]};
			char[] drl = {board[0][2], board[1][1], board[2][0]};
			
			won = validate(row);
			if (won) break;
			won = validate(col);
			if (won) break;
			won = validate(dlr);
			if (won) break;
			won = validate(drl);
			if (won) break;

			// next player's turn.
			turns++;
//			System.out.println(turns);
			player1 = !player1;
					    

		} while (!won && turns < 9);
		
		// scoring for when the game ends.
		
		printBoard();
		if (turns == 9) {
			System.out.println("Tied match.");
		} else {
			System.out.println("Game over! Player " + (player1 ? "1" : "2") + " is the winner!");
		}
		System.out.println("Play again? [yes to confirm] ");
		String confirm = input.nextLine().toLowerCase().trim();
		if (confirm.equals("yes")) setup();
		else input.close();
		
	}
	
	public static void printBoard() {
		
		System.out.println("   | 1 | 2 | 3 |");
		System.out.println(" a | " + board[0][0] + " | " + board[0][1] + " | " + board [0][2] + " |");
		System.out.println(" b | " + board[1][0] + " | " + board[1][1] + " | " + board [1][2] + " |");
		System.out.println(" c | " + board[2][0] + " | " + board[2][1] + " | " + board [2][2] + " |");
		System.out.println();
		
	}
	
	public static boolean validate(char[] a) {
		
		// if any value is null, return false.
		if (a[0] == 0 || a[1] == 0 || a[2] == 0) {
			return false;
		}
		
		// otherwise, test the values against each other.
		if (a[0] == a[1] && a[0] == a[2]) {
			return true;
		}
		
		// fallback if something went wrong.
		return false;
		
	}

}
