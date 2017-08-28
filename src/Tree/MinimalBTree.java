package Tree;


public class MinimalBTree {
	
	public TreeNode  createTree(int[] a){
		
		return (a!=null)?createTree(a,0,a.length-1):null;
	}
	
	
	private TreeNode createTree(int[] a,int start,int end){
		
		if(start>end)
			return null;
		
		int mid=(start+end)/2;
		TreeNode parent= new TreeNode(a[mid]);
		
		parent.left=createTree(a,start,mid-1);
		parent.right=createTree(a,mid+1,end);
		
		return parent;
		
	}

	public void inorder(TreeNode a){
		
		if(a==null)
			return;
		
		inorder(a.left);
		System.out.println(a.data);
		inorder(a.right);
	}
	
	public static void main(String[] args) {
		
		int[] a ={8};
		MinimalBTree m= new MinimalBTree();
		TreeNode x=m.createTree(null);
		m.inorder(x);
	}
}

