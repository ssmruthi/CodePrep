package Tree;

import java.util.ArrayList;
import java.util.List;

public class ValidateBST {	
	
	
	/*
	 * Optimal O(N) time and O(logN) space logn for recursion stack else O(1) for min and max
	 */
	public boolean validateBST(TreeNode root){
		return validateBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	private boolean validateBST(TreeNode root, int min, int max){

    if(root==null)
      return true;

    if(root.data<min || root.data >max)
      return false;

    return (validateBST(root.left,min,root.data)  &&   
            validateBST(root.right,root.data,max));
    
	}
	
	/*
	 * BRUTE FORCE
	 * Inorder traversal and check arraylist for asce order
	 * O(N) time and O(N+logN) space. logN for recursion stack
	 */
	private void inorder(TreeNode root,List<Integer> a){

	      if(root==null)
	      return;
	      
	      inorder(root.left,a);
	      	a.add(root.data);
	      inorder(root.right,a);
	 }
	
	private boolean inorder(TreeNode root){
		
		List<Integer> a=new ArrayList<Integer>();
		inorder(root,a);
		
		for(int i=0;i<a.size()-1;i++){
			if(a.get(i) >=a.get(i+1))
				return false;
		}
		return true;
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

		
		n4.left = n2;
		n4.right = n3;
		n2.left=n1;
		n2.right=n3;

		ValidateBST d = new ValidateBST();
		System.out.println(d.validateBST(n4));
		
	}

}