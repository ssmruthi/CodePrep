package Tree;

import java.util.Stack;

public class CommonAncestor {

	private void inorder(TreeNode root){
		
		if(root==null)
			return;
		
		inorder(root.left);
		System.out.println(root.data);
		inorder(root.right);
	}
	public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		Stack<TreeNode> p1 = new Stack<TreeNode>();
		Stack<TreeNode> p2 = new Stack<TreeNode>();
		TreeNode ancestor = null;

		if (dfs(root, p, p1) && dfs(root, q, p2)) {
			
			/*
			 * Parents are stored top down d the recursion would reverse it
			 * pop stacks until there is a mismatch
			 */
			while (!p1.isEmpty() && !p2.isEmpty() && (p1.peek()==p2.peek())){	
				ancestor=p1.pop();
				p2.pop();
			
			}
		}

		return ancestor;

	}

	private boolean dfs(TreeNode node, TreeNode end, Stack<TreeNode> parent) {

		if(node==null)
			return false;
		
		if(node==end)
			return true;
				
		if(dfs(node.left,end,parent) || dfs(node.right,end,parent)){
			parent.push(node);
			return true;
		}
		
		return false;
	}

	
	public static void main(String[] args){
		
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		
		n1.left=n2;
		n1.right=n7;
		n2.left=n3;
		n2.right=n4;
		n4.left=n5;
		n4.right=n6;
		n7.right=n8;
		
		CommonAncestor ca= new CommonAncestor();
		ca.inorder(n1);
		
		TreeNode n11=ca.commonAncestor(n1, n6,n4);
		
		System.out.println("********");
		System.out.println(n11==null?null:n11.data);
	}
	
}
