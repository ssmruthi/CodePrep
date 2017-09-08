package Tree;

/*
 * This is specifically for tree like below
 *           1
 *         /   \
 *        2     3
 *       /       \
 *      4         5
 *      
 *       in which case height of both is the same but its not balanced, so we need to recursively check if subtrees are balanced as well
 *       HEnce time complexity might be O(n^2) in case of right skewed tree
 */

public class CheckBalancedTree {	
	
	public boolean checkBalancedTree(TreeNode root){
		
		if(root==null)
			return true;
		int h1=getHeight(root.left);
		int h2=getHeight(root.right);
		
		int h= (Math.abs(h2-h1));
		
		if(h>1)
			return false;
		else
			
			return checkBalancedTree(root.left) && checkBalancedTree(root.right);
	}
	
	private int getHeight(TreeNode node){
		
		if(node==null)
			return 0;
		
		int h1=getHeight(node.left)+1;
		int h2=getHeight(node.right)+1;
		
		return Math.max(h1, h2);
	}
	
	
	
	public boolean checkBalanced(TreeNode root){
			return (checkBalance(root)!=-1);
	}
	
	private int checkBalance(TreeNode node){
		
		if(node==null)
			return 0;
		
		int h1=checkBalance(node.left);
		int h2=checkBalance(node.right);
		
		if(h1==-1 || h2==-1 || Math.abs(h2-h1)>1)
			return -1;

		else
		return Math.max(h1, h2)+1;
		
	}
	
	public static void main(String[] args) {
		int[] a = { 6, 2, 1, 4, 3, 5 };
		
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(6);

		
		n1.left = n2;
		n2.left = n4;
		n1.right=n3;
		n3.right=n5;
		n4.left=n6;
		n5.right=n7;

		CheckBalancedTree d = new CheckBalancedTree();
		System.out.println(d.checkBalanced(n1));
		System.out.println(d.checkBalancedTree(n1));

		
	}

}