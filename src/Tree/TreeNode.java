package Tree;

public class TreeNode {

	public TreeNode(int i) {

	this.data=i;
		
	}
	
	public TreeNode left;
	public int data;
	public TreeNode right;

	
	//Iterative
	public TreeNode inorderIT(TreeNode root,int val){
		
		TreeNode node=root;
		TreeNode parent=null;
		TreeNode newNode=new TreeNode(val);
		
		if(root==null)
			return newNode;
		
	
		while(node!=null){
			parent=node;
			if(val<node.data)
				node=node.left;
			else
				node=node.right;
			
		}
			
		if(val<parent.data)
			parent.left=newNode;
		else
			parent.right=newNode;
		
		return root;
		
	}
	
	//Recursive
	public  TreeNode inorder(TreeNode root, int val){
		
		if(root==null){
			root=new TreeNode(val);
			return root;
		}
		
		if(val<root.data)
			return inorder(root.left,val);
		else
			return inorder(root.right,val);
			
	}
	
}
