package Tree;

import java.util.LinkedList;

public class ArrayToTree {

	public static TreeNode arraytoBTree(int[] a){
			
		if(a==null || a.length==0)
			return null;
		
		LinkedList<TreeNode> queue= new LinkedList<TreeNode>();
		
		TreeNode root=new TreeNode(a[0]);
		queue.add(root);
		
		int i=0;
		while(i<a.length){
			TreeNode node=queue.removeFirst();
			
			if(2*i+1<a.length)
			node.left=new TreeNode(a[i*2+1]);
			
			if(2*i+2<a.length)
			node.right=new TreeNode(a[i*2+2]);
			
			queue.add(node.left);
			queue.add(node.right);
			i++;
		}
		
		return root;
	}
	private static void preorder(TreeNode r){
		
		if(r==null)
			return;
		
		System.out.print(r.data+",");
		preorder(r.left);
		preorder(r.right);
		
	}
	public static void main(String[] args) {

		int[] a={7,6,5,4,9,8,77};
		
		TreeNode r=arraytoBTree(a);
		preorder(r);
	}

}
