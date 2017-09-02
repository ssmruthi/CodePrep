package Tree;


public class CheckSubTree2 {

	  public boolean checkSubTree(TreeNode t1,TreeNode t2){

		  if(t2==null)
			  return true;
		  
		  else
			  return containsTree(t1,t2);
	  
	  
	  }
	  
	  
	  public boolean containsTree(TreeNode t1,TreeNode t2){
		  
		  if(t1==null)
			  return false;
		  
		  if(t1.data==t2.data && match(t1,t2)){
			  return true;
		  }
			  return ( containsTree(t1.left,t2) || containsTree(t1.right,t2));  
		  
	  }
	  
	  public boolean match(TreeNode t1, TreeNode t2){
		  
		  if(t1==null && t2==null)
			  return true;
		  
		  if(t1==null || t2==null)
			  return false;
		  
		  if(t1.data==t2.data){
			  return match(t1.left,t2.left) && match(t1.right,t2.right);
		  }
		  
		  return false;
	  }


	 
	  public static void main(String[] args){
		
		  TreeNode n1= new TreeNode(1);
		  TreeNode n2= new TreeNode(2);
		  TreeNode n3= new TreeNode(3);
		  TreeNode n4= new TreeNode(4);
		  TreeNode n5= new TreeNode(5);
		  TreeNode n6= new TreeNode(6);
		  TreeNode n7= new TreeNode(7);
		  
		  n4.left=n2;
		  n4.right=n3;
		  n3.left=n7;
		  n3.right=n5;
		  n5.left=n6;
		  n5.right=n1;
		  
		  
		  
		  TreeNode n11= new TreeNode(1);
		  TreeNode n12= new TreeNode(1);
		  TreeNode n13= new TreeNode(3);
		  TreeNode n15= new TreeNode(5);
		  TreeNode n16= new TreeNode(6);
		  TreeNode n17= new TreeNode(7);
		  
		  n13.left=n12;
		  n13.right=n15;
		  n15.left=n16;
		  n15.right=n11;
		  
		  System.out.println(new CheckSubTree2().checkSubTree(n4, n17));
	  }

	}