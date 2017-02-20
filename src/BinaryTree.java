import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

	static TreeNode root;

	public static TreeNode createBinaryTree(List<Integer> a) {
		int i = 0;
		root = null;
		while (i < a.size()) {
			if (root == null)
				root = new TreeNode(a.get(i++));
			else
				root.insert(a.get(i++));
		}

		System.out.print("\nIn Order :");
		root.printInorder();

		System.out.print("\nPre Order :");
		root.printPreorder();

		System.out.print("\nPost Order :");
		root.printPostorder();

		return root;
	}

	public static void search(int value, TreeNode root) {
		System.out.println("Depth first");
		root.depthFirstSearch(value);
	}

}

class TreeNode {

	TreeNode left;
	TreeNode right;
	int data;

	TreeNode(int data) {
		this.data = data;
	}

	void printPreorder() {
		System.out.print(data + ",");

		if (left != null)
			left.printPreorder();

		if (right != null)
			right.printPreorder();
	}

	void printPostorder() {

		if (left != null)
			left.printPostorder();

		if (right != null)
			right.printPostorder();

		System.out.print(data + ",");

	}

	void printInorder() {

		if (left != null)
			left.printInorder();

		System.out.print(data + ",");

		if (right != null)
			right.printInorder();
	}

	void insert(int value) {
		if (value <= data) {
			if (left == null) {
				left = new TreeNode(value);
			} else {
				left.insert(value);
			}
		} else {
			if (right == null) {
				right = new TreeNode(value);
			} else {
				right.insert(value);
			}
		}
	}

	public void printleafnodes() {

		if (this.left == null)
			System.out.println(data);
		else {
			left.printleafnodes();
		}

		if (this.right == null)
			System.out.println(data);
		else {
			left.printleafnodes();
		}

	}

	boolean depthFirstSearch(int value) {
		System.out.print(data + "-->");

		if (value == data) {
			return true;
		} else if (value < data) {
			if (left == null)
				return false;
			else {
				return left.depthFirstSearch(value);
			}
		} else {
			if (right == null)
				return false;
			else {
				return right.depthFirstSearch(value);
			}

		}

	}

	boolean dfs(int value, TreeNode root) {

		if (root == null)
			return false;

		if (root.data == value)
			return true;

		if (root.left != null && value < root.data) {
			return dfs(value, root.left);
		}

		if (root.right != null && value > root.data) {
			return dfs(value, root.right);
		}

		return false;

	}

	public boolean bfs(int value, TreeNode node) {

		if (node == null)
			return false;

		List<TreeNode> child = new ArrayList<TreeNode>();
		List<TreeNode> visited= new ArrayList<TreeNode>();

		child.add(node);

		int i = 0;
		while (!child.isEmpty()) {

			TreeNode root = child.get(i);
			if (root.data == value)
				return true;
			
			if(!visited.contains(root)){
				visited.add(root);

				if (root.left != null)
					child.add(root.left);
	
				if (root.right != null)
					child.add(root.right);
				
				/*
				 * 
				 * 
				 */
			}
			
			child.remove(root);
			
			i++;

		}
		return false;

	}

}
