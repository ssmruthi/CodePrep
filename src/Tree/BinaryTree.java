package Tree;


public class BinaryTree {
	
	public  TreeNode createBinaryTree(int[] a) {
		
		return createBinaryTree(a,0,a.length-1);
	}
	
	public  TreeNode createBinaryTree(int[] a,int start,int end) {
		
		TreeNode node=null;
		if(start<=end){

			int mid=(start+end)/2;
			node=new TreeNode(a[mid]);
			node.left=createBinaryTree(a,start,mid-1);
			node.right=createBinaryTree(a,mid+1,end);
		}
		
		return node;
		
		
	}
	
	
	public String inorder(TreeNode node) {

		StringBuilder result = new StringBuilder();
		result = inorder(node, result);
		return result.toString();
	}
	
	
	public String preorder(TreeNode node){
	
		StringBuilder result = new StringBuilder();
		result = preorder(node, result);
		return result.toString();
	}
	
	public String postorder(TreeNode node){
		
		StringBuilder result = new StringBuilder();
		result = postorder(node, result);
		return result.toString();
		}


	private StringBuilder inorder(TreeNode node, StringBuilder result) {
		
		if (node != null) {
			result = inorder(node.left, result);
			result.append(node.data);
			result = inorder(node.right, result);
		}
		return result;
	}
	
	private StringBuilder postorder(TreeNode node,StringBuilder result){
		
		if(node!=null){
			
			result=postorder(node.left,result);
			result=postorder(node.right,result);
			result.append(node.data);
		}
		
		return result;
	}
	
	private StringBuilder preorder(TreeNode node, StringBuilder result){
		
		if(node!=null){
			result.append(node.data);
			System.out.print(node.data+"*");
			result=preorder(node.left,result);
			result=preorder(node.right,result);
		}
		return result;
	}

}
