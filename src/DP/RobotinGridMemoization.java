package DP;

import java.util.ArrayList;
import java.util.List;

public class RobotinGridMemoization {

	public List<String>  findPath(int[][] arr){
		
		List<String> path=new ArrayList<String>();
		
		findPath(arr, 0, 0,path);
		
		return path;
	}

	private boolean findPath(int[][] arr, int row, int col, List<String> path) {

		if (row >= arr.length || col >= arr[row].length)
			return false;

		if (row == arr.length - 1 && col == arr[row].length - 1 && arr[row][col] != 0) {
			path.add(row + "," + col);
			return true;
		}

		if (arr[row][col] == 0)
			return false;
		else
			path.add(row + "," + col);

		return findPath(arr, row + 1, col, path) || findPath(arr, row, col + 1, path);
	}

	public static void main(String[] args) {

		int[][] ar = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 0, 1 } };
		System.out.println(new RobotinGridMemoization().findPath(ar));

	}

}
