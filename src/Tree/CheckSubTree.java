package Tree;


public class CheckSubTree {

	  public boolean checkSubTree(TreeNode t1,TreeNode t2){

	    String s1=preorder(t1,new StringBuilder()).toString();
	    String s2=preorder(t2,new StringBuilder()).toString();

	    System.out.println(s1.toString());
	    System.out.println(s2.toString());
	    
	    if(s1.indexOf(s2)>0){
	      return true;
	    }
	    return false;
	  }


	  public StringBuilder preorder(TreeNode node, StringBuilder s){

	    if(node==null){
	      s.append('x');
	      return s;
	    }

	    s.append(node.data);
	    preorder(node.left,s);
	    preorder(node.right,s);

	    return s;
	    
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
		  
		  System.out.println(new CheckSubTree().checkSubTree(n4, n13));
	  }

	}