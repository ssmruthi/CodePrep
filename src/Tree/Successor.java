package Tree;

class TrNode{
	TrNode left;
	TrNode right;
	TrNode parent;
	int data;
	
	TrNode(int i){
		this.data=i;
	}


}
public class Successor {

	public void inorder(TrNode root){
		
		if(root==null)
			return;
		
		inorder(root.left);
		System.out.print(" "+root.data);
		inorder(root.right);
	}
	
	
	public TrNode successor(TrNode node){
		
		if(node==null)
			return null;
		if(node.right!=null){
			node=node.right;
			
			while(node.left!=null){
				node=node.left;
			}
			
			return node;
		}
		
		while(node.parent!=null && node.parent.right==node){
			node=node.parent;
		}
		return node.parent;
		
	}
	
	public static void main(String[] args) {
		int[] a = { 6, 2, 1, 4, 3, 5 };
		
		TrNode n1 = new TrNode(1);
		TrNode n2 = new TrNode(2);
		TrNode n3 = new TrNode(3);
		TrNode n4 = new TrNode(4);
		TrNode n5 = new TrNode(5);
		TrNode n6 = new TrNode(6);
		TrNode n7 = new TrNode(6);

		
		n1.left=n2;
		//n1.right=n2;
		n2.left=n3;
		//n2.right=n3;
		
		n1.parent=null;
		n2.parent=n1;
		n3.parent=n2;
		//n4.parent=n3;
		//n5.parent=n3;
		
		Successor d = new Successor();
		d.inorder(n1);
		System.out.println("---");
		
		System.out.println(d.successor(n1));
		

	}

}