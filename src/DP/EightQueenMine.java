package DP;

public class EightQueenMine {

	static int count;
	public static boolean waysEightQueen(int[][] b, int col) {

		if (col >= b[0].length) {
			return true;
		}

		for (int row = 0; row < b.length; row++) {

			if (isValid(row,col, b)) {
				b[row][col] = 1;
				if (waysEightQueen(b, col + 1)) {
					return true;
				} else {
					b[row][col] = 0;
				}
			}

		}
		
		return false;
	}

	private static boolean isValid(int row, int col, int[][] board) {

		//row
		for(int i=0;i<col;i++)
			if(board[row][i]==1)
				return false;
		
		//top left diagonal
		int i=row-1;
		int j=col-1;
		while(i>=0 && j>=0){
			if(board[i][j]==1)
				return false;
			i--;
			j--;
		}
		
		// bottom left diagonal
		i=row+1;
		j=col-1;
		while(i<board.length && j>=0){
			if(board[i][j]==1)
				return false;
			i++;
			j--;
		}
			
			
		
		
		return true;

	}

	public static void main(String[] args) {

		int[][] b= new int[8][8];
		System.out.println(EightQueenMine.waysEightQueen(b,0));
	}

	private static void print2DMatrix(int[][] inp) {
		for (int[] a : inp)
			printMatrix(a);

		System.out.println("-------------------");

	}

	private static void printMatrix(int[] inp) {
		for (int a : inp) {
			System.out.print(a + ",");
		}
		System.out.println();
	}

}
