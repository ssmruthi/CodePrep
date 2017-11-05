package DP;

public class PaintFill {

	private static int[][] paintfill(int[][] image, int row, int col, int color) {

		int oldColor = image[row][col];

		paintFill(image, row, col, oldColor, color);

		return image;

	}

	private static void paintFill(int[][] image, int row, int col, int old, int newColor) {

		if (row < 0 || col < 0 || row > image.length-1 || col > image[row].length-1)
			return;

		if (image[row][col] == old) {

			image[row][col] = newColor;

			paintFill(image, row - 1, col, old, newColor);
			paintFill(image, row + 1, col, old, newColor);
			paintFill(image, row, col - 1, old, newColor);
			paintFill(image, row, col + 1, old, newColor);

		}

		return;

	}
	
	public static void main(String[] args) {
		int[][] img= {{1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
                };
		
		print2DMatrix(img);
		
		paintfill(img, 4, 4, 3);
		
		print2DMatrix(img);
	}
	
	private static void print2DMatrix(int[][] inp){
		for(int[]a:inp)
			printMatrix(a);
		
		System.out.println("-------------------");

	}
	
	private static void printMatrix(int[] inp){
		for(int a: inp){
			System.out.print(a+",");
		}
		System.out.println();
	}
}