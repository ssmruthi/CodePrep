package Tree;

import java.util.Random;

class Node {
	Node left;
	Node right;
	int data;
	int size;

	Node(int d) {
		this.data = d;
		this.size = 1;
	}

}

class Tree {

	Node root;

	public Node inorderTree(Node node, int val) {

		Node newNode = new Node(val);

		if (null == node)
			return newNode;

		node.size++;

		if (val < node.data) {
			node.left = inorderTree(node.left, val);
		} else {
			node.right = inorderTree(node.right, val);
		}

		return node;
	}

	public void printInorder(Node node) {

		if (node == null)
			return;

		printInorder(node.left);
		System.out.print(node.data + "[" + node.size + "],");
		printInorder(node.right);
	}
}

public class RandomNode {

	public static void main(String[] args) {

		int[] ar = { 6, 4, 5, 9, 1, 3, 7,2,8 ,0};
		Node root = null;
		Tree t = new Tree();

		for (int val : ar) {
			root = t.inorderTree(root, val);
		}

		t.printInorder(root);
		int[] count = new int[10];

		for (int i = 0; i < 10; i++) {
			Node r = getRandomNode(root);
			count[r.data]++;
		}

		for(int x:count)
			System.out.println(x);
	}

	public static Node getRandomNode(Node root) {

		if (root == null)
			return null;

		return getRandomNode(root, new Random().nextInt(root.size));

	}

	public static Node getRandomNode(Node root, int i) {

		int lsize = root.left == null ? 0 : root.left.size;

		if (i == lsize)
			return root;
		else if (i < lsize)
			return getRandomNode(root.left, i);
		else
			return getRandomNode(root.right, (i - (lsize + 1)));
	}

}
