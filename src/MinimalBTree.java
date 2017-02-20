import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MinimalBTree{

	public TreeNode root;
class TreeNode {

	TreeNode left;
	TreeNode right;
	int data;
	
	TreeNode(int data){
		this.data=data;
	}


void printPreorder(){
	System.out.print(data+",");	
	
	if(left!=null)
	left.printPreorder();
	
	if(right!=null)
	right.printPreorder();
}

void printPostorder(){
	
	if(left!=null)
	left.printPostorder();

	if(right!=null)
	right.printPostorder();	
		
	System.out.print(data+",");	
	
}


void printInorder(){		
	
	if(left!=null)
	left.printInorder();

	System.out.print(data+",");	

	if(right!=null)
	right.printInorder();
}

}

public TreeNode constructTree(int[] arr){
	
	if(arr.length==0){
		return null;
	}
		int mid=arr[(arr.length)/2];
		TreeNode root= new TreeNode(mid);
	
		if(arr.length==1)
		return root;
	
	root.left=constructTree(Arrays.copyOfRange(arr, 0, (arr.length)/2));
	root.right=constructTree(Arrays.copyOfRange(arr, (arr.length/2)+1,arr.length));
	
	return root;
}
 
 
}
