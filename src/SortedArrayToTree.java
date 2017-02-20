
public class SortedArrayToTree {

	public static TreeNode toBinaryTree(int[] arr){
		return toBinaryTree(arr,0,arr.length-1);
	}
	
	private static TreeNode toBinaryTree(int[] arr, int start, int end){
		
		if(arr.length==0 || start >end)
			return null;
		
		if(start==end){
			return new TreeNode(arr[start]);
		}
		
		int mid=(start+end) /2;
		TreeNode root= new TreeNode(arr[mid]);
		root.left=toBinaryTree(arr,start,mid-1);
		root.right=toBinaryTree(arr,mid+1, end);
				
		return root;
	}
}
