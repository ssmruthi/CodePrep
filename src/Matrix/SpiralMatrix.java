package Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static List<Integer> spiralMatrix(int[][] input) {

		if(input==null || input.length==0)
			return null;
			
		int top = 0;
		int bottom = input.length - 1;
		int left = 0;
		int right = input[0].length - 1;
		List<Integer> result = new ArrayList<Integer>();

		while (top <= bottom && left <= right) {

			if (top == bottom) {
				for (int i = left; i <= right; i++) {
					result.add(input[top][i]);
				}

			} else if (left == right) {
				for (int i = top; i <= bottom; i++) {
					result.add(input[i][left]);
				}

			} else {
				for (int i = left; i < right; i++) {
					result.add(input[top][i]);
				}

				for (int i = top; i < bottom; i++) {
					result.add(input[i][right]);
				}

				for (int i = right; i > left; i--) {
					result.add(input[bottom][i]);
				}

				for (int i = bottom; i > top; i--) {
					result.add(input[i][left]);
				}
			}

			top++;
			bottom--;
			left++;
			right--;
		}

		return result;

	}

}