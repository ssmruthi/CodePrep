import java.util.ArrayList;
import java.util.List;

public class TreeDepth {

	private List<Node> m = new ArrayList<Node>();
	TreeNode head;

	public List<Node> getListDepth(TreeNode n) {
		head= n;
		getDepth(n);
		return m;
	}

	private Node getDepth(TreeNode root) {
		
				
		if (root == null)
			return null;
	
		else{
			
			Node n = new Node(root.data);
			Node n1 = new Node(root.data);
				
			if (root.left != null) {
				n.next = getDepth(root.left);				
			}
	
			if (root.right != null) {			
				n1.next = getDepth(root.right);
			}
			
			if(root==head){
				m.add(n);
				m.add(n1);
			}
				return n;
			
			
		}
			
	}

}
