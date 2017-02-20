public class Htree {

	private static void drawLine(int xOne, int yOne, int xTwo, int yTwo) {
		return;
	}

	// draws line, assume implementation available

	public static void drawHTree(int x, int y, int length, int depth) {

		if (depth == 0)
			return;

		int x0 = x - length / 2;
		int x1 = x + length / 2;
		int y0 = y - length / 2;
		int y1 = y + length / 2;

		// draw the 3 line segments of the H-Tree

		drawLine(x0, y0, x0, y1);
		drawLine(x1, y0, x1, y1);
		drawLine(x0, y, x1, y);
		int newLength = (int) (length / Math.sqrt(2));

		drawHTree(x0, y0, newLength, depth - 1); // lower left H-tree
		drawHTree(x0, y1, newLength, depth - 1); // upper left H-tree
		drawHTree(x1, y0, newLength, depth - 1); // lower right H-tree
		drawHTree(x1, y1, newLength, depth - 1); // upper right H-tree
	}
	
}