package DP;

import java.util.HashSet;
import java.util.Set;

class Sudoku {

	static Set<Character> getCandidates(char[][] board, int row, int col) {
		Set<Character> candidate = new HashSet<Character>();

		for (int x = 49; x < 57; x++) {
			char c = (char) x;
			boolean collision = false;
			for (int i = 0; i < 8; i++) {
				if (board[row][i] == c || board[i][col] == c
						|| board[row - row % 3 + i / 3][col - col % 3 + i % 3] == c)
					collision = true;

			}
			if (!collision)
				candidate.add(c);
		}

		return candidate;
	}

	static boolean sudokuSolve(char[][] board) {

		Set<Character> candidates = null;
		Set<Character> newCandidates = null;

		boolean flag=false;
		int row = -1, col = -1;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {

					newCandidates = getCandidates(board, i, j);
					candidates = newCandidates;
					row = i;
					col = j;
					
					if(newCandidates.isEmpty())
						return false;
					
					flag=true;
					break;

				}

			}
			if(flag)
				break;
		}

		if (candidates == null)
			return true;
		
		for (Character c : candidates) {
			board[row][col] = c;
			if (sudokuSolve(board))
				return true;

			board[row][col] = '.';
		}

		return false;
	}

	public static void main(String[] args) {
		char[][] b = { { '.', '2', '3', '4', '5', '6', '7', '8', '9' }, { '1', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' } };
		
		
		char[][] c = { { '.', '.', '.', '7', '.', '.', '3', '.', '1' }, { '3', '.', '.', '9', '.', '.', '.', '.', '.' },
				{ '.', '4', '.', '3', '1', '.', '2', '.', '.' }, { '.', '6', '.', '4', '.', '.', '5', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '1', '.', '.', '8', '.', '4', '.' },
				{ '.', '.', '6', '.', '2', '1', '.', '5', '.' }, { '.', '.', '.', '.', '.', '9', '.', '.', '8' },
				{ '8', '.', '5', '.', '.', '4', '.', '.', '.' } };
		
		char[][] d={{'.','.','4','.','.','.','6','3','.'}, 
				 {'.','.','.','.','.','.','.','.','.'}, 
				 {'5','.','.','.','.','.','.','9','.'}, 
				 {'.','.','.','5','6','.','.','.','.'}, 
				 {'4','.','3','.','.','.','.','.','1'}, 
				 {'.','.','.','7','.','.','.','.','.'}, 
				 {'.','.','.','5','.','.','.','.','.'}, 
				 {'.','.','.','.','.','.','.','.','.'}, 
				 {'.','.','.','.','.','.','.','.','.'}};

		System.out.println(sudokuSolve(d));
		

	}

}