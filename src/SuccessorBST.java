import java.util.List;

public class SuccessorBST {

	 Node root;
	
	class Node {

		int data;
		Node left, right, parent;

		Node(int d) {
			data = d;
			left = right = parent = null;
		}
		
		void printInorder(){		
			
			if(left!=null)
			left.printInorder();

			System.out.print(data+",");	

			if(right!=null)
			right.printInorder();
		}
	}
	
	public  Node createBinarySearchTree(List<Integer> a){
		int i=0;
		root=null;
		while(i<a.size()){
			if(root==null)
				root= new Node(a.get(i++));
			else
				insert(root,a.get(i++));
		}
		
		System.out.print("\nIn Order :");
		root.printInorder();
		
		return root;
	}
	
	
	
	public Node insert(Node node, int data) {

			if (node == null) {
				return (new Node(data));
			} else {

				Node temp = null;

				/* 2. Otherwise, recur down the tree */
				if (data <= node.data) {
					temp = insert(node.left, data);
					node.left = temp;
					temp.parent = node;

				} else {
					temp = insert(node.right, data);
					node.right = temp;
					temp.parent = node;
				}

				/* return the (unchanged) node pointer */
				return node;
			}
		}

		public Node getSuccessor(Node root) {

			if (root == null)
				return null;

			if (root.right != null) {

				Node leftmost = root.right;
				while (leftmost.left != null) {
					leftmost = leftmost.left;
				}
				return leftmost;
			}

			Node curr = root;
			Node par = root.parent;
			while (par!=null && par.left != curr) {

				curr = par;
				par = par.parent;
			}

			return par;
		}

	

}
