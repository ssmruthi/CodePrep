package DP;

public class EightQueenMine2 {

	static int count;
	public static int waysEightQueen(int[][] b, int col,int row) {

		if(col>=b.length)
			return 0;
		
		if(row>=b.length)
			return 0;
		
		
			for(int j=col;j<b[row].length;j++)
				count=1+waysEightQueen(b, j, row+1);
		
		return count;
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
		System.out.println(EightQueenMine2.waysEightQueen(b,0,0));
		print2DMatrix(b);
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
