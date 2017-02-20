import java.util.ArrayList;
import java.util.List;

public class ValidateBST{

	List<Integer> al= new ArrayList<Integer>();
	
	public  boolean validate(TreeNode root){
		chkInOrder(root,root.data);
		
		for(int i=0;i<al.size()-1;i++){
			if(al.get(i)>al.get(i+1))
				return false;
		}
		return true;
	}
	public  void chkInOrder(TreeNode root,int a){
		
			
		if(root!=null){
					
			if(root.left!=null);
				chkInOrder(root.left,root.data);
					
			if(a<=root.data)
				al.add(root.data);
			
			if(root.right!=null)
				chkInOrder(root.right,root.data);
		}
	}
	 
}
